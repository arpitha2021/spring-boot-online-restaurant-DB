package com.greatlearning.surabhi.online.restaurant.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.surabhi.online.restaurant.entity.Bills;
import com.greatlearning.surabhi.online.restaurant.entity.OrderDetails;
import com.greatlearning.surabhi.online.restaurant.entity.Orders;
import com.greatlearning.surabhi.online.restaurant.entity.View_all_order;
import com.greatlearning.surabhi.online.restaurant.repository.BillRepository;
import com.greatlearning.surabhi.online.restaurant.repository.OrderDetailsRepository;
import com.greatlearning.surabhi.online.restaurant.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	BillRepository billRepository;
	
	@Override
	public String selectAndOrderItems(int orderId, String itemsList) {
		Orders order = Orders.builder().selectedItemsWithQty(itemsList).orderId(orderId).build();
		orderRepository.saveAndFlush(order);
		OrderDetails orderDetails = new OrderDetails();
		//String listOfItems = order.getSelectedItemsWithQty();
		String listOfItems = "2,4|3,8";
		String[] tokens = listOfItems.split("\\|");
		for(String s:tokens){
			String[] itemsValues = s.split("\\,");
			 orderDetails.pk.itemName=itemsValues[0];
			 orderDetails.quantity=Integer.parseInt(itemsValues[1]);
		}
		orderDetailsRepository.saveAndFlush(orderDetails);
		return "Successfully selected and placed order";
	}
	
	@Override
	public String generateBill(int orderId) {
		boolean exist = orderRepository.existsById(orderId);
		OrderDetails orderPlaced = orderDetailsRepository.orderPlacedExist(orderId);
		if (exist&&orderPlaced!=null) {
			log.info("generate the bill for the order->{}",orderId);
			/*Optional<Orders> order =orderRepository.findById(orderId);
			String listOfItems = order.get().getSelectedItemsWithQty();*/
			
			
			Double totalByOrder = orderDetailsRepository.calculateTotalBillByOrder(orderId);
			String billDate = LocalDate.now().toString();
			Bills generatedBill = Bills.builder().date(billDate).orderId(orderId).totalBill(totalByOrder).build();
			billRepository.saveAndFlush(generatedBill);
			return "Bill Generated successfully";
		} else {
			throw new RuntimeException("There is no order with id to generate Bill" + orderId);
		}
	}

	@Override
	public String generateBillByDate(String date) {
		return "Total Bill of date="+date+"is"+billRepository.calculateTotalBillByDate(date);
	}

	@Override
	public String generateBillByMonth(String month) {
		// TODO Auto-generated method stub
		return "Total Bill of Month = "+month+" is "+billRepository.calculateTotalBillByMonth(month);
	}
	
	@Override
	public List<View_all_order> viewAllOrders() {
		// TODO Auto-generated method stub
		return billRepository.viewAllOrders();
	}
	
	/*@Override
	public String viewAllOrdersByDate() {
		// TODO Auto-generated method stub
		return "All Orders By Date are ->" +billRepository.viewAllOrdersByDate();
	}*/
	
	/*@Override
	public String viewAllOrdersByPlace() {
		// TODO Auto-generated method stub
		return "All Orders By Date are ->" +billRepository.viewAllOrdersByPlace();
	}
	
	@Override
	public String viewAllOrdersByPrice() {
		// TODO Auto-generated method stub
		return "All Orders By Date are ->" +billRepository.viewAllOrdersByPrice();
	}
	
	@Override
	public String viewMaxSaleByMonth() {
		// TODO Auto-generated method stub
		return "All Orders By Date are ->" +billRepository.viewMaximumOrdersByMonth();
	}
	
	@Override
	public String viewMaxSaleByYear() {
		// TODO Auto-generated method stub
		return "All Orders By Date are ->" +billRepository.viewMaximumOrdersByYear();
	}
*/
}
