package com.springboot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.Cart;
import com.springboot.repositories.CartRepository;
import com.springboot.services.CartService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CartServiceImpl implements CartService{
  
  @Autowired
  private CartRepository cartRegistry;
  
  @Override
  public Mono<Cart> create(Cart cart) {
    // TODO Auto-generated method stub
    return cartRegistry.save(cart);
  }

  @Override
  public Flux<Cart> findByClientName(String clientName) {
    // TODO Auto-generated method stub
    return cartRegistry.findByClientName(clientName);
  }

  @Override
  public Flux<Cart> findAll() {
    // TODO Auto-generated method stub
    return cartRegistry.findAll();
  }

}
