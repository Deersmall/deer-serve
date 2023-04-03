package com.example.demo;

import com.example.demo.util.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SpringContextUtil.class})
@MapperScan(value = {
		"com.example.demo.dao.**"
}) // * 代表不同模块
public class DeerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeerApplication.class, args);
	}

}
