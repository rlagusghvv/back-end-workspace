package com.kh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mapper")
public class ForTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForTestApplication.class, args);
	}

}
