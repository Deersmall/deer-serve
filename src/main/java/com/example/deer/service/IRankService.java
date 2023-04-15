package com.example.deer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.deer.entity.surf.Users;

import java.util.Map;

public interface IRankService extends IService<Users> {

    IPage<Users> queryRanks(Page<Users> page , Map<String,Object> where);

}
