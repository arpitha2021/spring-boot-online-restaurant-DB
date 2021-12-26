package com.greatlearning.surabhi.online.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.surabhi.online.restaurant.entity.OnlineUser;
import com.greatlearning.surabhi.online.restaurant.service.OnlineUserService;

@RestController
public class HomeController {

	@Autowired
	OnlineUserService onlineUserService;

	@GetMapping("/home")
	private String welcome() {
		return "<h1>Welcome to Surabhi Online Restaurant<h1>";

	}

	@GetMapping("/")
	public String home() {
		return ("<h1> Surabhi Online Restaurant</h1>");
	}

	@GetMapping("/login")
	public String login(String name, String pwd) {
		return onlineUserService.validateLogin(name, pwd);
	}

	@GetMapping("/logout")
	public String logout() {
		return ("<h1> Successfully Logged out of Surabhi Online Restaurant</h1>");
	}

	@PostMapping("/register")
	private String registerUser(String name, String pwd) {
		OnlineUser user = OnlineUser.builder().userName(name).password(pwd).build();
		onlineUserService.addOnlineUser(user);
		return "Successfully registered user in Surabhi Online Restaurant";

	}
}
