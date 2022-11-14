package com.api.products.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.products.message.Message;
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
	public ResponseEntity<?> save(@Valid @RequestBody Products products) {
		


		if(StringUtils.isBlank(products.getName()))
			return new ResponseEntity(new Message("The name field is required"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(products.getType()))
			return new ResponseEntity(new Message("The type field is required"), HttpStatus.BAD_REQUEST);

		if(products.getPrice()<0 || (Integer) products.getPrice() == null)
			return new ResponseEntity(new Message("The price of the product must be greater than zero"), HttpStatus.BAD_REQUEST);


		Products product = new Products(products.getType(), products.getName(), products.getDescription(), products.getPrice());
        productService.save(product);
        return new ResponseEntity(new Message("Product created"), HttpStatus.OK);		
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
