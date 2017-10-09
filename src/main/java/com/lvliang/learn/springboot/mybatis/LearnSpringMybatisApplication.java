package com.lvliang.learn.springboot.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.lvliang.learn.springboot.mybatis")
@EnableAutoConfiguration
@SpringBootApplication
public class LearnSpringMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringMybatisApplication.class, args);
	}
}
