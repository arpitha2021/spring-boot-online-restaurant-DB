package com.greatlearning.surabhi.online.restaurant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.surabhi.online.restaurant.entity.OnlineUser;
import com.greatlearning.surabhi.online.restaurant.service.OnlineUserService;

@RequestMapping("/surabhi/userCrudOperations")
@RestController
public class OnlineUserController {

	@Autowired
	OnlineUserService onlineUserService;

	@PostMapping("/addOnlineUser")
	public String addOnlineUser(OnlineUser onlineUser) {
		onlineUserService.addOnlineUser(onlineUser);
		return "OnlineUser Added";
	}

	@PutMapping("/updateOnlineUser")
	public String updateEmployee(OnlineUser onlineUser) {
		onlineUserService.updateUser(onlineUser);
		return "User Updated";
	}

	@GetMapping("/getOnlineUserById")
	public Optional<OnlineUser> getOnlineUserById(String name) {
		return onlineUserService.getUserById(name);
	}

	@DeleteMapping("/deleteOnlineUserByid")
	public String deleteOnlineUserByid(String name) {
		onlineUserService.deleteUserById(name);
		return "Deleted User Successfully";
	}

	@GetMapping("/displayAllUsers")
	public List<OnlineUser> displayAllUsers() {
		return onlineUserService.displayAllUsers();
	}
}
