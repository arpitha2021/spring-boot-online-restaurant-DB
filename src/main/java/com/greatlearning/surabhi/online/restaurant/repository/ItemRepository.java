package com.greatlearning.surabhi.online.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.surabhi.online.restaurant.entity.Items;


@Repository
public interface ItemRepository extends JpaRepository<Items, Integer> {
	
	
}
