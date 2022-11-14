package com.api.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.products.model.Products;
import com.api.products.repository.ProductsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	@Autowired
	private ProductsRepository productsRepository;
	
	public void save (Products products) {
		productsRepository.save(products);
	}
	
	public List<Products> findAll(){
		return productsRepository.findAll();
	}
	
	public Optional<Products> findById(String id) {
		return productsRepository.findById(id);
		
	}
	
	public void deleteById(String id) {
		productsRepository.deleteById(id);
	}

}
