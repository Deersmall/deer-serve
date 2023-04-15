package com.example.deer.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName
@Data
public class SysUser {
    private String id;
    private String userCode;
    private String userName;
    private String userPsd;
    private String salt;
    private Integer locked;

    @TableField(exist = false)
    private String rid;
}
