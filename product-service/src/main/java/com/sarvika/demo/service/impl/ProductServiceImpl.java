package com.sarvika.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.sarvika.demo.exception.ProductNotFoundException;
import com.sarvika.demo.model.Product;
import com.sarvika.demo.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j 
@RequiredArgsConstructor
public class ProductServiceImpl {

    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        log.info("Saving product: {}", product);
        Product savedProduct = productRepository.save(product);
        log.info("Product saved successfully with ID: {}", savedProduct.getId());
        return savedProduct;
    }

    public List<Product> getAllProducts() {
        log.info("Fetching all products");
        List<Product> products = productRepository.findAll();
        log.info("Found {} products", products.size());
        return products;
    }

    public Product getProductById(String id) {
        log.info("Fetching product with ID: {}", id);
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            log.info("Product found: {}", product.get());
            return product.get();
        } else {
            log.warn("Product not found with ID: {}", id);
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
    }

	public Product getProductByName(String name) {
        log.info("Fetching product with name: {}", name);
        Product product = new Product();
        product.setCategory("categry");
        product.setId("123");
        if (product != null) {
            log.info("Product found: {}", product);
        } else {
            log.warn("Product not found with name: {}", name);
        }
        return product;
    }

    public void deleteProduct(String id) {
        log.info("Deleting product with ID: {}", id);
        productRepository.deleteById(id);
        log.info("Product with ID: {} deleted successfully", id);
    }

    public void deleteAllProducts() {
        log.info("Deleting all products");
        productRepository.deleteAll();
        log.info("All products deleted successfully");
    }
}
