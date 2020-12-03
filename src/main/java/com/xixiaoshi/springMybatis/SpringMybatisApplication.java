package com.xixiaoshi.springMybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.xixiaoshi.springMybatis.mapper")
public class SpringMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMybatisApplication.class, args);
	}

}
