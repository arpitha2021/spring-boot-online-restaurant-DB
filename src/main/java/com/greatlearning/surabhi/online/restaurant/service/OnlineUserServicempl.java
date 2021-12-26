package com.greatlearning.surabhi.online.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.surabhi.online.restaurant.entity.OnlineUser;
import com.greatlearning.surabhi.online.restaurant.repository.OnlineUserRepository;

@Service
public class OnlineUserServicempl implements OnlineUserService {

	@Autowired
	OnlineUserRepository userRepository;
	
	

	@Override
	public void addOnlineUser(OnlineUser onlineUser) {
		userRepository.saveAndFlush(onlineUser);
	}
	
	

	@Override
	public void updateUser(OnlineUser onlineUser) {
		boolean exist = userRepository.existsById(onlineUser.getUserName());
		if (exist) {
			userRepository.saveAndFlush(onlineUser);
		} else {
			throw new RuntimeException("There is not employee with id " + onlineUser.getUserName());
		}
	}

	@Override
	public Optional<OnlineUser> getUserById(String uname) {
		return userRepository.findById(uname);
	}

	@Override
	public String deleteUserById(String uname) {
		userRepository.deleteById(uname);
		return "Deleted User Successfully";
	}

	@Override
	public List<OnlineUser> displayAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public String validateLogin(String name, String pwd){
		String loginStatus;
		if(userRepository.existsById(name) && pwd.equals(userRepository.findById(name).get().getPassword())){
			loginStatus= "Login Successfull";
		} else {
			loginStatus= "Login Failed"; 
		}
		return loginStatus;
	}
}
