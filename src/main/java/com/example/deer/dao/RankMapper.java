package com.example.deer.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.deer.entity.surf.Users;
import org.apache.ibatis.annotations.Param;

public interface RankMapper extends BaseMapper<Users> {
    IPage<Users> queryRanks(Page<Users> page ,
                            @Param("ew") LambdaQueryWrapper<Users> where ,
                            @Param("surfServer") String surfServer);

}
