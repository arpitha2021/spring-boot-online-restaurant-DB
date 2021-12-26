package com.greatlearning.surabhi.online.restaurant.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Bills {
	@Id		
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billSeq;
	private int orderId;
	private String date;
	private double totalBill;
}
