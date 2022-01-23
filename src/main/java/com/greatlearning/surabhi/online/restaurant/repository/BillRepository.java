package com.greatlearning.surabhi.online.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greatlearning.surabhi.online.restaurant.entity.Bills;
import com.greatlearning.surabhi.online.restaurant.entity.View_all_order;


@Repository
public interface BillRepository extends JpaRepository<Bills, Integer> {
	
	@Query("select sum(totalBill) from Bills where date=:date group by date")
	public double calculateTotalBillByDate(@Param("date") String date);
	
	@Query("select sum(totalBill) from Bills where date like :month")
	public double calculateTotalBillByMonth(@Param("month") String month);
	//
	@Query("select new com.greatlearning.surabhi.online.restaurant.entity.View_all_order(ord.orderId,ord.selectedItemsWithQty,bill.billSeq,bill.date,bill.totalBill)"
			+"from Orders ord, Bills bill "
			+"where ord.orderId=bill.orderId "
			+"order by ord.orderId desc")
	public List<View_all_order> viewAllOrders();
	
/*	@Query(value="select date ,bill_amount,orderId,List_Of_Items,bill_id from VIEW_ORDER_BY_DATE",nativeQuery = true)
	public double viewAllOrdersByDate();
	
	@Query(value="select date,orderId, List_Of_Items, bill_id ,TOTAL  from VIEW_ORDERS_BY_PRICE",nativeQuery = true)
	public double viewAllOrdersByPrice();
	
	//@Query("select  place,total,NO_OF_ORDERS from VIEW_ORDERS_BY_PLACE")
	public double viewAllOrdersByPlace();
	
	//@Query("select * from VIEW_MAX_ORDERS_IN_A_MONTH")
	public double viewMaximumOrdersByMonth();
	
	//@Query("select * from VIEW_MAX_ORDERS_IN_A_YEAR")
	public double viewMaximumOrdersByYear();
*/}
