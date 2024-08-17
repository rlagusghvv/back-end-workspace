package com.kh.upload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mapper") // 놓치는 부분 !!
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
