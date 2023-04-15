package com.example.deer.shirocfg;

import com.example.deer.Enum.GeneralEnum;
import com.example.deer.entity.SysUser;
import com.example.deer.service.impl.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 从 token 获取 userCode
        String id = token.getPrincipal().toString();
        // 获取数据库 user信息
        SysUser user = userService.getUserInfo(id);

        if (user.getLocked() == GeneralEnum.LOCKED_TYPE.LOCK.intVal) { // 判断账户锁定
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo info = null;

        if (user != null){
//            String password = user.getPassword();
//            info = new SimpleAuthenticationInfo(user, password,token.getPrincipal().toString());

            info = new SimpleAuthenticationInfo(
                    token.getPrincipal(),
                    user.getUserPsd(),
                    ByteSource.Util.bytes("Deer"),
                    token.getPrincipal().toString()
            );
        }

        return info;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("——————————授权——————————");

        return null;
    }


}
