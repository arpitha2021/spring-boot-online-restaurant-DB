package com.greatlearning.surabhi.online.restaurant.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.surabhi.online.restaurant.entity.OnlineUser;

public interface OnlineUserService {

	void addOnlineUser(OnlineUser onlineUser);

	void updateUser(OnlineUser onlineUser);

	Optional<OnlineUser> getUserById(String uname);

	String deleteUserById(String uname);

	List<OnlineUser> displayAllUsers();

	String validateLogin(String name, String pwd);

}