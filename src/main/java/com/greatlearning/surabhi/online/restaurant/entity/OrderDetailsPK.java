package com.greatlearning.surabhi.online.restaurant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Embeddable
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderDetailsPK implements Serializable{
	 @Column(name = "order_id")
	public int orderId;
	 @Column(name = "item_name")
	public String itemName;
	 

	
}