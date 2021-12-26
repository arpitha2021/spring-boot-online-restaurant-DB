package com.greatlearning.surabhi.online.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greatlearning.surabhi.online.restaurant.entity.OrderDetails;


@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
	
	@Query("select sum(totalPriceOnQty) from OrderDetails  where order_id=:orderId group by order_id")
	public Double calculateTotalBillByOrder(@Param("orderId") Integer orderId);
	
	@Query("select o from OrderDetails o where order_id=:orderId")
	public OrderDetails orderPlacedExist(@Param("orderId") Integer orderId);
}
