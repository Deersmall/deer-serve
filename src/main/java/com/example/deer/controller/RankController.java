package com.example.deer.controller;

import com.example.deer.entity.result.CommonResult;
import com.example.deer.entity.surf.Users;
import com.example.deer.entity.util.Where;
import com.example.deer.service.IRankService;
import com.example.deer.util.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("rankController")
@RequestMapping("/rank")
public class RankController extends BaseController {

    @PostMapping("queryRank")
    public CommonResult<Users> queryRank(@RequestBody Where<Users> where){
        return CommonResult.ok(ref(IRankService.class).queryRanks(where.getPage(),where.getWhere()));
    }

}
