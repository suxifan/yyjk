package com.cictec.yyjk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Async
public class YyjkApplication {
	public static void main(String[] args) {
		SpringApplication.run(YyjkApplication.class, args);
	}
}
