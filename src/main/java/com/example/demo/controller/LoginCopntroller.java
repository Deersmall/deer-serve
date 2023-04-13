package com.example.demo.controller;

import com.example.demo.entity.SysUser;
import com.example.demo.entity.result.CommonResult;
import com.example.demo.service.IUserService;
import com.example.demo.util.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController("LoginCopntroller")
@RequestMapping("/deerLogin")
public class LoginCopntroller extends BaseController {

    /**
     * 用户登录
     * @param sysUser
     * @return
     */
    @PostMapping("login")
    public CommonResult userLogin(@RequestBody SysUser sysUser , HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUserCode(), sysUser.getUserPsd());

        SysUser user = ref(IUserService.class).getUserCode(sysUser.getUserCode());

        try {
            subject.login(token);
            // 在session中保存用户信息
            request.getSession().setAttribute("token",token);
            return CommonResult.ok(null);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.no(null);
        }
    }


    /**
     * 游客登录
     * @return
     */
    @PostMapping("visitorLogin")
    public CommonResult<SysUser> visitorLogin(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("visitorLogin", "858414");

        SysUser user = ref(IUserService.class).getUserCode("visitorLogin");

        try {
            subject.login(token);
            request.getSession().setAttribute("token",token);
            return CommonResult.ok(null);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.no(null);
        }
    }

    /**
     * 确认Token
     * @param request
     * @return
     */
    @PostMapping("affirmToken")
    public CommonResult affirmToken(HttpServletRequest request){
        Object token = request.getSession().getAttribute("token");
        if (ObjectUtils.isEmpty(token)){
            return CommonResult.no(null);
        }else {
            return CommonResult.ok(token);
        }
    }

    /**
     * 用户注册
     * @param sysUser
     * @return
     */
    @PostMapping("register")
    public CommonResult<SysUser> register(@RequestBody SysUser sysUser){
        SysUser user = ref(IUserService.class).addUser(sysUser);
        return CommonResult.ok(user);
    }

    /**
     * 注销登录
     */
    @PostMapping("logout")
    public void userLogout(HttpServletRequest request){
        request.getSession().removeAttribute("token");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

}
