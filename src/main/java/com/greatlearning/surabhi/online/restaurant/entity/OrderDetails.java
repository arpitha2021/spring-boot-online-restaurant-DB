package com.greatlearning.surabhi.online.restaurant.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@Entity	
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
	//private int id;
	@EmbeddedId
	public OrderDetailsPK pk ;
	public Integer quantity;
	public double pricePerItem;
    public double totalPriceOnQty;	
	
}