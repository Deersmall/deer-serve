package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "suer")
@Data
public class Suer {
    @TableId(value = "suer",type = IdType.AUTO)
    private Integer id;
    @TableField
    private String name;
    @TableField
    private Integer age;
}
