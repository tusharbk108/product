package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.product;
import com.example.demo.reposiory.ProductRepository;

@Service
public class productService {

	@Autowired
	private ProductRepository repository;

	public product saveProduct(product product1) {
		return repository.save(product1);
	}
	

	public List<product> getProducts() {
		return repository.findAll();
	}


	public ResponseEntity<product> updateProduct(int id ,product product) {
		product newproduct = repository.findById(id).orElse(new product());
		
		newproduct.setName(product.getName());
		newproduct.setPrize(product.getPrice());
		
		product updatedproduct = repository.save(newproduct);
		return ResponseEntity.ok(updatedproduct);
	}


	public ResponseEntity<product> productById(int id) {
		product pro =  repository.findById(id).orElse(null);
		return ResponseEntity.ok(pro);
	}


	public ResponseEntity<Map<String,Boolean>> deleteProduct(int id) {
		product pro = repository.findById(id).orElse(null);
		
		repository.delete(pro);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
}
