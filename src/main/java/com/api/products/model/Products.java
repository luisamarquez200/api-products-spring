package com.api.products.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "Products")
@Data
public class Products {
	@Id
	private String id;
	private String type;
	private String name;
	private String description;
	private Float price;
}
