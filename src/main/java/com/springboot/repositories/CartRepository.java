package com.springboot.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.models.Cart;

import reactor.core.publisher.Flux;

@Repository
public interface CartRepository extends ReactiveMongoRepository<Cart, String>  {
  
  Flux<Cart>findByClientName(String clientName);
}
