package com.MongoDB.model;

import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class ProductModel {
	
	@Id
	private String id;
	
	private String title;
	private Integer price;
	
	private Set<ProductPropertiesModel>properties;

}
