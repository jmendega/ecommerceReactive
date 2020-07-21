package com.springboot.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveMongoRepository <Product, String>{

  void save(Mono<Product> product);

  @Query("{ 'name': ?0}")
  Mono<Product> findByName(String name);
  
  @Query("{ 'category': ?0}")
  Flux<Product> findByCategory(String category);
}
