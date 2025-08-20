package com.microservices.productservice.service;

import java.util.List;

import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.dto.ProductResponse;

public interface ProductService {

	ProductResponse createProduct(ProductRequest productRequest);
	List<ProductResponse> getAllroducts();
}
