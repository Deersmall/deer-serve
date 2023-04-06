package com.example.demo.controller;

import com.example.demo.entity.SysUser;
import com.example.demo.service.IUserService;
import com.example.demo.util.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("LoginCopntroller")
@RequestMapping("/deerLogin")
public class LoginCopntroller extends BaseController {

    @PostMapping("login")
    public Object userLogin(@RequestBody SysUser sysUser){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUserCode(), sysUser.getUserPsd());

        SysUser user = ref(IUserService.class).getUserCode(sysUser.getUserCode());

        try {
            subject.login(token);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("visitorLogin")
    public Object visitorLogin(){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("visitorLogin", "858414");

        SysUser user = ref(IUserService.class).getUserCode("visitorLogin");

        try {
            subject.login(token);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("logout")
    public void userLogout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

}
