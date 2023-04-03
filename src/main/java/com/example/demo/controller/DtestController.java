package com.example.demo.controller;

import com.example.demo.entity.Suer;
import com.example.demo.service.ISuerService;
import com.example.demo.util.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("dtestController")
@RequestMapping("/dtest")
public class DtestController extends BaseController {

//    @Autowired private ISuerService iSuerService;

    @PostMapping("ds")
    public void ds(){
        System.out.println("进入方法");
        ISuerService iSuerService = ref(ISuerService.class);
        List<Suer> add = iSuerService.add();
        System.out.println(add);
    }
}
