package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com")
public class DemoBlog1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoBlog1Application.class, args);
	}

}
