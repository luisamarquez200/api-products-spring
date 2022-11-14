package com.api.products.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "Products")
@Data
public class Products {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String type;
	@NotBlank
	private String name;
	private String description;
	private Integer price;
	
	
	public Products(String type, String name, String description, Integer price) {
		super();
		this.type = type;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	
	
}
