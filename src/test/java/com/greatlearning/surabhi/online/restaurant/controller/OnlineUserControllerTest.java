package com.greatlearning.surabhi.online.restaurant.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.surabhi.online.restaurant.entity.OnlineUser;
import com.greatlearning.surabhi.online.restaurant.repository.OnlineUserRepository;
import com.greatlearning.surabhi.online.restaurant.service.OnlineUserServicempl;

@RunWith(MockitoJUnitRunner.class)
public class OnlineUserControllerTest {

	@Autowired
	private OnlineUserServicempl userService;
	
	@MockBean
	private OnlineUserRepository onlineUserRepository;
	@Test
	private void shouldTestViewAllUsers(){
		OnlineUser user = new OnlineUser("abhi","abhi");
		OnlineUser user1 = new OnlineUser("arun","arun");
		List<OnlineUser> list = new ArrayList<>();
		list.add(user);
		list.add(user1);
		Mockito.when(onlineUserRepository.findAll()).thenReturn(list);
		Assert.assertEquals(2, userService.displayAllUsers().size());
		
	}
	

	@Test
	public void shouldTestAddOnlineUser() {
		OnlineUser user = new OnlineUser("abhi","abhi");
		Assert.assertEquals(Mockito.verify(onlineUserRepository.saveAndFlush(user)), user);
	}
}
