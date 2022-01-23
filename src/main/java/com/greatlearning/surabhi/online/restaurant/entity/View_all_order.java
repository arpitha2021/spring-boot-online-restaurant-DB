package com.greatlearning.surabhi.online.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.Immutable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class View_all_order {
//orderId , List_Of_Items,bill_id ,date,TOTAL
	@Id
	Integer orderId;
	String listOfItems;
	Integer billId;
	String date;
	double total;
}
