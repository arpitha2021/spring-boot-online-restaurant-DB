package com.greatlearning.surabhi.online.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.surabhi.online.restaurant.entity.Items;
import com.greatlearning.surabhi.online.restaurant.repository.ItemRepository;
import com.greatlearning.surabhi.online.restaurant.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Items> displayAllItemsWithPrice() {
		log.info("All the items with Price are ->{}", itemRepository.findAll());
		return itemRepository.findAll();
	}

}
