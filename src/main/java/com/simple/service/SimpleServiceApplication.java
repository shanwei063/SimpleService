package com.simple.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.simple.service.mapper")
public class SimpleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleServiceApplication.class, args);
	}
}
