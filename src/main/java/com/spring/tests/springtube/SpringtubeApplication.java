package com.spring.tests.springtube;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class SpringtubeApplication {

	public static void main(String[] args) {
		System.setProperty("aws.accessKeyId","123");
		SpringApplication.run(SpringtubeApplication.class, args);
	}

}
