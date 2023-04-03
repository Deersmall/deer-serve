package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.SuerMapper;
import com.example.demo.entity.Suer;
import com.example.demo.service.ISuerService;
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
