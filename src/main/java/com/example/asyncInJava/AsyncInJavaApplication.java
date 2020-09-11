package com.example.asyncInJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsyncInJavaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AsyncInJavaApplication.class, args).close();
	}
}
