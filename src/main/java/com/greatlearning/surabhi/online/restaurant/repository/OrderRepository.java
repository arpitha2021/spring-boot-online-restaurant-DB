package com.greatlearning.surabhi.online.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.surabhi.online.restaurant.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

	//@Query("select sum(TOTAL_price_on_qTY) from Order_details where ORDER_ID=:orderId")
	//public double calculateTotalBillByOrder(@Param("orderId") int orderId);
	
	
}
