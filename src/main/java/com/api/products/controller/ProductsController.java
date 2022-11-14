package com.api.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.products.model.Products;
import com.api.products.service.ProductService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1")

@RequiredArgsConstructor

public class ProductsController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public void save(@RequestBody Products products) {
		productService.save(products);		
	}
	
	@GetMapping("/products")
	public List<Products> findAll(){
		return productService.findAll();	
	}
	
	@GetMapping("/products/{id}")
	public Products findByProducts(@PathVariable String id) {
		return productService.findById(id).get();
	}
	
	@DeleteMapping("/products/{id}")
	public void deteleById(@PathVariable String id) {
		productService.deleteById(id);
	}
	
	
	@PutMapping("/products")
		public void update(@RequestBody Products product) {
			productService.save(product);
		}
		
	
	
}
