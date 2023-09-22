package com.example.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestConsulApplication {

	public static void main(String[] args) {

		//SpringApplication.from(ConsulApplication::main).with(TestConsulApplication.class).run(args);
	}

}
