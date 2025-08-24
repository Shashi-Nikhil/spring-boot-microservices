package com.microservices.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory", url = "${inventory.service.url}")
public interface InventoryClient {
	
	@GetMapping("/api/inventory")
	public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
