package com.MongoDB.service;

import java.util.List;

import com.MongoDB.model.ProductModel;

public interface ProductService {
	List<ProductModel> findAll();

	ProductModel createProduct(ProductModel productModel);

	ProductModel save(ProductModel productModel);

	ProductModel getProductById(String id);

	ProductModel update(ProductModel productModel);

	void delete(String id);
}
