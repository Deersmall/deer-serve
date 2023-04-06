package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.SysUser;

public interface IUserService extends IService<SysUser> {
    SysUser getUserCode(String username);
}
