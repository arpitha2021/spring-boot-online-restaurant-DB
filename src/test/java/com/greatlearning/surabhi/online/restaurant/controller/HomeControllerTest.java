package com.greatlearning.surabhi.online.restaurant.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.greatlearning.surabhi.online.restaurant.entity.OnlineUser;
import com.greatlearning.surabhi.online.restaurant.service.OnlineUserServicempl;

@WebMvcTest
public class HomeControllerTest {

	@Mock
	private HomeController homeController;

	@Autowired
	OnlineUserServicempl onlineUserService;

	@Test
	public void shouldTestWelcome() {
		String str = "Welcome to Surabhi";
		Mockito.when(homeController.home()).thenReturn(str);
		assertEquals(str, homeController.home());
	}

	@Test
	public void shouldTestHomePage() {
		String str = "Surabhi Online Restaurant";
		Mockito.when(homeController.home()).thenReturn(str);
		assertEquals(str, homeController.home());
	}

	@Test
	public void shouldTestUserLogin(String name, String pwd) {
		String str = "Successfull Login";
		assertEquals(Mockito.when(homeController.login("abc", "abc")).thenReturn(str),
				Mockito.when(onlineUserService.validateLogin("abc", "abc")).thenReturn(str));
	}

	@Test
	public void shouldTestUserLogout() {
		String str = "Successfull Logout";
		assertEquals(str,Mockito.when(homeController.logout()).thenReturn(str));
	}

	@Test
	private void shouldTestRegisterUser(String name, String pwd) {
		OnlineUser user = OnlineUser.builder().userName(name).password(pwd).build();
		//Mockito.doNothing().when(onlineUserService.addOnlineUser(user));

	}
}
