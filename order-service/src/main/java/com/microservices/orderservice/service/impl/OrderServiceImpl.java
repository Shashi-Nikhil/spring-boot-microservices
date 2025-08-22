package com.microservices.orderservice.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservices.orderservice.dto.OrderRequest;
import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.repository.OrderRepository;
import com.microservices.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	
	@Override
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setSkuCode(orderRequest.skuCode());
		order.setPrice(orderRequest.price());
		order.setQuantity(orderRequest.quantity());
		
		orderRepository.save(order);
	}

}
