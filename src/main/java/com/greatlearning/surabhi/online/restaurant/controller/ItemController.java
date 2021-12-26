package com.greatlearning.surabhi.online.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.surabhi.online.restaurant.entity.Items;
import com.greatlearning.surabhi.online.restaurant.service.ItemService;

@RequestMapping("/surabhi")
@RestController
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@GetMapping("/viewAllItems")
	private List<Items> viewAllItems(){
		return itemService.displayAllItemsWithPrice();
		
	}
}
