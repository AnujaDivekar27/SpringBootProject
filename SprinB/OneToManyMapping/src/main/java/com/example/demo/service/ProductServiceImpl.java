package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void addProduct(Product product) {
     System.out.println("Product in Service Layer:"+" "+product);
	 productRepository.save(product);	
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

}
