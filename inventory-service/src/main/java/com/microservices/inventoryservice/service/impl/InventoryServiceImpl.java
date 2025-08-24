package com.microservices.inventoryservice.service.impl;

import org.springframework.stereotype.Service;

import com.microservices.inventoryservice.repository.InventoryRepository;
import com.microservices.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

	private final InventoryRepository inventoryRepository;

	@Override
	public boolean isInStock(String skuCode, Integer quantity) {
		return inventoryRepository.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);
	}

}
