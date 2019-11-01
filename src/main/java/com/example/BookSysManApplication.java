package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 修改方法
 * 分页
 * 上传文件
 * redis
 */
@SpringBootApplication
@MapperScan("com.example.mapper")
public class BookSysManApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookSysManApplication.class, args);
	}

}
