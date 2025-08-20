package com.microservices.productservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.dto.ProductResponse;
import com.microservices.productservice.model.Product;
import com.microservices.productservice.repository.ProductRepository;
import com.microservices.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {
		
		Product product = Product.builder()
				.name(productRequest.name())
				.description(productRequest.description())
				.price(productRequest.price())
				.build();
		
		productRepository.save(product);
		log.info("||| Product created successfully with id: {}",product.getId());
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

	@Override
	public List<ProductResponse> getAllroducts() {
		List<Product> allProducts = productRepository.findAll();
		return allProducts.stream()
				.map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
				.toList();
	}
	
}
