package com.greatlearning.surabhi.online.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.surabhi.online.restaurant.entity.View_all_order;
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
	
	@PostMapping("/viewAllOrders")
	public List<View_all_order> viewAllOrders(){
		return orderService.viewAllOrders();
	}
	
	/*@PostMapping("/viewAllSalesByDate")
	public String viewAllSalesByDate(){
		return orderService.viewAllOrdersByDate();
	}
	
	@PostMapping("/viewAllSalesByPrice")
	public String viewAllSalesByPrice(){
		return orderService.viewAllOrdersByPrice();
	}*/
	
	/*@PostMapping("/admin/viewAllSalesByPlace")
	public String viewAllSalesByPlace(){
		return orderService.viewAllOrdersByPlace();
	}
	
	@PostMapping("/admin/viewMaxSalesByMonth")
	public String viewMaxSalesByMonth(){
		return orderService.viewMaxSaleByMonth();
	}
	
	@PostMapping("/admin/viewMaxSalesByYear")
	public String viewMaxSalesByYear(){
		return orderService.viewMaxSaleByYear();
	}*/
}
