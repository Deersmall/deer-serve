package com.example.deer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.deer.dao.SuerMapper;
import com.example.deer.entity.Suer;
import com.example.deer.service.ISuerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("suerService")
public class SuerService extends ServiceImpl<SuerMapper, Suer> implements ISuerService {
    @Override
    public List<Suer> add() {
//        List<Suer> suers = suerMapper.selectAll();
//
        List<Suer> suers = baseMapper.selectAll();
//        Suer suer = new Suer();
//        suer.setId(1);

//        List<Suer> suers = new ArrayList<>();
//        suers.add(suer);
        return suers;
    }
}
