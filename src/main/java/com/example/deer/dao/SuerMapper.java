package com.example.deer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.deer.entity.Suer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuerMapper extends BaseMapper<Suer> {
    List<Suer> selectAll();
}
