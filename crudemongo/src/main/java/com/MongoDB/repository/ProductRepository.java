package com.MongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MongoDB.model.ProductModel;
@Repository
public interface ProductRepository extends MongoRepository< ProductModel, String> {

}
 