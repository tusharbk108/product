package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.product;
import com.example.demo.service.productService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class productController {

	@Autowired
	private productService service;
	
	@GetMapping("/products")
	public List<product> getAllProduct() {
		return service.getProducts();
	}
	
	@PostMapping("/products")
	public product addProduct(@RequestBody product product) {
		return service.saveProduct(product);
	}
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<product> getProductById(@PathVariable int id) {
		return service.productById(id);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<product> updateProduct(@PathVariable int id,@RequestBody product product) {
		return service.updateProduct(id,product);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable int id){
		return service.deleteProduct(id);
	}
}
