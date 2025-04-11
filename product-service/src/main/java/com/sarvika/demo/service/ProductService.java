package com.sarvika.demo.service;

import java.util.List;

import com.sarvika.demo.model.Product;

public interface ProductService {
	
	Product saveProduct(Product product);

	List<Product> getAllProducts();

    Product getProductById(String id);

    Product getProductByName(String name);

    void deleteProduct(String id);

    void deleteAllProducts();
}
