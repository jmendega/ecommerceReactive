package com.springboot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.Product;
import com.springboot.repositories.ProductRepository;
import com.springboot.services.ProductService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;

  @Override
  public Mono<Product> create(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Mono<Product> update(String id, Product product) {
    return productRepository.findById(id)
    .switchIfEmpty(Mono.error(new Throwable("No se encontró el id "+ id)))
    .doOnSuccess(findProduct -> {
      findProduct.setCategory(product.getCategory());
      findProduct.setAmount(product.getAmount());
      findProduct.setName(product.getName());
      productRepository.save(findProduct).doOnError(error -> {
        log.error("Error ejecutando la función update {}", error);
        Mono.error(new Throwable("Error ejecutando la función update " + error));
      }).subscribe();
    }).doOnError(error -> {
      log.error("No existe el id {}", id);
      Mono.error(new Throwable("No existe el id " + id));
    });
  }

  @Override
  public Mono<Void> delete(String id) {
    return productRepository.deleteById(id)
        .switchIfEmpty(Mono.error(new Throwable("No se encontró el id "+ id)))
        .doOnError(error -> {
          log.error("Error ejecutando la función delete {}", error);
          Mono.error(new Throwable("Error ejecutando la función delete " + error));
        });
  }

  @Override
  public Mono<Product> findById(String id) {
    // TODO Auto-generated method stub
    return productRepository.findById(id);
  }

  @Override
  public Mono<Product> findByName(String name) {
    // TODO Auto-generated method stub
    return productRepository.findByName(name);
  }

  @Override
  public Flux<Product> findByCategory(String category) {
    // TODO Auto-generated method stub
    return productRepository.findByCategory(category);
  }

  @Override
  public Flux<Product> findAll() {
    // TODO Auto-generated method stub
    return productRepository.findAll();
  }

}
