package com.greatlearning.surabhi.online.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
	@Id
	private Integer itemSeq;
	private String itemName;
	private String price;
}
