package com.example.deer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.deer.entity.SysUser;

public interface IUserService extends IService<SysUser> {

    SysUser getUserInfo(String username);

    SysUser addUser(SysUser sysUser);
}
