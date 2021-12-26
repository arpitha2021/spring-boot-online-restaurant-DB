package com.greatlearning.surabhi.online.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@ComponentScan
@SpringBootApplication
@Slf4j
public class SpringBootOnlineRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOnlineRestaurantApplication.class, args);
		log.info("Surabhi Online Restaurant ");
	}

}
