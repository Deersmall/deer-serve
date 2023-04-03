package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Suer;

import java.util.List;

public interface ISuerService extends IService<Suer> {
    List<Suer> add();
}
