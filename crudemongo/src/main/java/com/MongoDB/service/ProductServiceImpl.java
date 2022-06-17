package com.MongoDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.MongoDB.exception.ResourceNotFoundException;
import com.MongoDB.model.ProductModel;
import com.MongoDB.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productModelRepository;

	@Override
	public ProductModel createProduct(ProductModel productModel) {
		return productModelRepository.save(productModel);
	}

	@Override
	public List<ProductModel> findAll() {

		return productModelRepository.findAll();
	}

	@Override
	public ProductModel save(ProductModel productModel) {

	validate(
			productModel);
	return productModelRepository.save(productModel);
	}

	@Override
	public ProductModel getProductById(String productId) {
		Optional<ProductModel> productDb = this.productModelRepository.findById(productId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + productId);
		}
	}

	private void validate(ProductModel productModel) {
		if (productModel.getTitle() == null || productModel.getTitle().isEmpty()) {
			throw new IllegalArgumentException("Title is empty");
		}
		if (productModel.getPrice() < 1) {
			throw new IllegalArgumentException("price should be greater than zero");
		}
	}

	@Override
	public ProductModel update(ProductModel productModel) {
		productModelRepository.findById(productModel.getId())
				.orElseThrow(() -> new IllegalArgumentException("Model doesn't exist"));
		validate(productModel);
		return productModelRepository.save(productModel);
	}

	@Override
	public void delete(String id) {
		productModelRepository.deleteById(id);

	}

}
