package com.greatlearning.surabhi.online.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greatlearning.surabhi.online.restaurant.entity.Bills;


@Repository
public interface BillRepository extends JpaRepository<Bills, Integer> {
	
	@Query("select sum(totalBill) from Bills where date=:date group by date")
	public double calculateTotalBillByDate(@Param("date") String date);
	
	@Query("select sum(totalBill) from Bills where date like :month")
	public double calculateTotalBillByMonth(@Param("month") String month);
}
