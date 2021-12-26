package com.greatlearning.surabhi.online.restaurant.service;

import java.util.List;
import java.util.Map;

public interface OrderService {


	String generateBill(int orderId);

	String generateBillByDate(String date);

	String generateBillByMonth(String date);

	String selectAndOrderItems(int orderId, String itemsList);

	//void calculateTotalBillByOrder(int orderId);

}