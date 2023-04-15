package com.example.deer.entity.surf;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName
@Data
public class Users {

    private Integer auth;
    private String name;            // 用户名
    private Integer ip;
    private Integer lastlogin;      // 最后登录时间
    private float points;           // pts
    private float playtime;         // 游玩时间

    @TableField(exist = false)
    private String surfServer;

}
