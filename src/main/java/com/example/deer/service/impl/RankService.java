package com.example.deer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.deer.dao.RankMapper;
import com.example.deer.entity.surf.Users;
import com.example.deer.service.IRankService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("rankService")
public class RankService  extends ServiceImpl<RankMapper, Users> implements IRankService {

    @Override
    public IPage<Users> queryRanks(Page<Users> page , Map<String,Object> where) {
        LambdaQueryWrapper<Users> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotEmpty(where.get("name").toString())) {
            lambdaQueryWrapper.eq(Users::getName,where.get("name"));
        }

        return baseMapper.queryRanks(page,lambdaQueryWrapper,where.get("surfServer").toString());
    }

}
