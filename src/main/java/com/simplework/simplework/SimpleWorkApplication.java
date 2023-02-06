package com.simplework.simplework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;

@MapperScan("com.simplework.simplework.Mapper")
@EnableOpenApi
@SpringBootApplication
public class SimpleWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWorkApplication.class, args);
		System.out.println("☆*:.｡. o(≧▽≦)o .｡.:*☆ \n");
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
		return springApplicationBuilder.sources(this.getClass());
	}
}
