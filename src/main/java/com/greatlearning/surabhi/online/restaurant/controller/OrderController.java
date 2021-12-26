package com.greatlearning.surabhi.online.restaurant.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.surabhi.online.restaurant.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	
	@PostMapping("/orderListOfItems")
	public String orderListOfItems(int orderId,String itemsIdAndQtyList){
		return orderService.selectAndOrderItems(orderId,itemsIdAndQtyList);
	}
	
	@PostMapping("/generateBillByOrder")
	public String generateBillByOrder(int orderId){
		return orderService.generateBill(orderId);
	}
	
	@PostMapping("/admin/todaysTotalGeneratedBill")
	public String generateBillByDate(String date){
		return orderService.generateBillByDate(date);
	}
	
	@PostMapping("/admin/totalGeneratedBillByMonth")
	public String generateBillByMonth(String date){
		return orderService.generateBillByMonth(date);
	}
	
}
