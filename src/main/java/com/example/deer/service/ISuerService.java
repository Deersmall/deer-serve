package com.example.deer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.deer.entity.Suer;

import java.util.List;


public interface ISuerService extends IService<Suer> {
    List<Suer> add();
}
