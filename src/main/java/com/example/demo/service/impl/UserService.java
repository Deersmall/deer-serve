package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Enum.GeneralEnum;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.SysUser;
import com.example.demo.service.IUserService;
import com.example.demo.util.AESUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService extends ServiceImpl<UserMapper, SysUser> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser getUserCode(String userCode) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_code",userCode);
        SysUser user = baseMapper.selectOne(wrapper);
        return user;
    }

    @Override
    public SysUser addUser(SysUser sysUser) {
        // 将账号最为ID，判断唯一 key
        if (StringUtils.isNotEmpty(sysUser.getUserCode())) sysUser.setId(sysUser.getUserCode());
        SysUser user = baseMapper.selectById(sysUser.getId());

        if (user != null) try {
            throw new Exception("1111");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String userPsd = new Md5Hash(AESUtils.aesDecrypt(sysUser.getUserPsd()), "Deer", 3).toString();

        sysUser.setUserPsd(userPsd);

        // 账号名为默认用户名
        sysUser.setUserName(sysUser.getUserCode());
        sysUser.setLocked(GeneralEnum.LOCKED_TYPE.UNLOCK.intVal);

        // 添加用户
        baseMapper.insert(sysUser);

        // 返回用户信息
        return sysUser;
    }
}
