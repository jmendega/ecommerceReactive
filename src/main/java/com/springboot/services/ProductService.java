package com.springboot.services;

import com.springboot.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

	public Mono<Product> create(Product product);

	public Mono<Product> update(String id, Product product);

	public Mono<Void> delete(String id);

	public Mono<Product> findById(String id);

	public Mono<Product> findByName(String name);

	public Flux<Product> findByCategory(String category);

	public Flux<Product> findAll();

}
