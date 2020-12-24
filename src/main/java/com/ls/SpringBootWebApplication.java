package com.ls;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.ls.dao.interfaces")
@SpringBootApplication
public class SpringBootWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
