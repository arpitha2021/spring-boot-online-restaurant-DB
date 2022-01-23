package com.greatlearning.surabhi.online.restaurant.service;

import java.util.List;

import com.greatlearning.surabhi.online.restaurant.entity.View_all_order;

public interface OrderService {


	String generateBill(int orderId);

	String generateBillByDate(String date);

	String generateBillByMonth(String date);

	String selectAndOrderItems(int orderId, String itemsList);

	List<View_all_order> viewAllOrders();

	/*String viewAllOrdersByDate();

*/	/*String viewAllOrdersByPlace();

	String viewAllOrdersByPrice();

	String viewMaxSaleByYear();

	String viewMaxSaleByMonth();
*/
	//void calculateTotalBillByOrder(int orderId);

}