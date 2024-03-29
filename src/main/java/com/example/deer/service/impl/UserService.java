package com.example.deer.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.deer.Enum.GeneralEnum;
import com.example.deer.dao.UserMapper;
import com.example.deer.entity.SysUser;
import com.example.deer.service.IUserService;
import com.example.deer.util.AESUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService extends ServiceImpl<UserMapper, SysUser> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser getUserInfo(String id) {
//        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
//        wrapper.eq("id",id);
//        SysUser user = baseMapper.selectOne(wrapper);
        SysUser user = baseMapper.selectById(id);
        return user;
    }

    @Override
    public SysUser addUser(SysUser sysUser) {
        // 将账号最为ID，判断唯一 key
        if (StringUtils.isNotEmpty(sysUser.getId())) sysUser.setUserCode(sysUser.getId());
        SysUser user = baseMapper.selectById(sysUser.getId());

        if (user != null) try {
            throw new Exception("账号存在");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String salt = "Deer";
        String userPsd = new Md5Hash(AESUtils.aesDecrypt(sysUser.getUserPsd()), salt, 3).toString();

//        加密后密码
        sysUser.setUserPsd(userPsd);

//        密码盐
        sysUser.setSalt(salt);

        // 账号名为默认用户名
        sysUser.setUserName(sysUser.getId());
        sysUser.setLocked(GeneralEnum.LOCKED_TYPE.UNLOCK.intVal);

        // 添加用户
        baseMapper.insert(sysUser);

        // 返回用户信息
        return sysUser;
    }
}
