package com.jk.example.boot.dockerization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestDockerizationApplication {

	public static void main(String[] args) {
		SpringApplication.from(DockerizationApplication::main).with(TestDockerizationApplication.class).run(args);
	}

}
