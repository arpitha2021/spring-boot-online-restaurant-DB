package com.greatlearning.surabhi.online.restaurant.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity		
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private String selectedItemsWithQty;

}
