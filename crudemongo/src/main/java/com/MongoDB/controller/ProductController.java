package com.MongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MongoDB.model.ProductModel;
import com.MongoDB.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/findAll")
	public ResponseEntity<List<ProductModel>> findAll(){
		return ResponseEntity.ok(productService.findAll());
		
	}
	@PostMapping("/create")

	 public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel productModel) {
		return ResponseEntity.ok().body(this.productService.createProduct(productModel));
		
	}
	@PutMapping("/save")
	public ResponseEntity<ProductModel>save(@RequestBody ProductModel productModel){
		return ResponseEntity.ok(productService.save(productModel));
	}
		    
	
	@PutMapping("/update")
	public ResponseEntity<ProductModel>update(@RequestBody ProductModel productModel){
		return ResponseEntity.ok(productService.update(productModel));
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Void>delete(@RequestParam String id) {
		productService.delete(id);
		return ResponseEntity.ok().build()	;
				}
}


