package com.springboot.services;

import com.springboot.models.Cart;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartService {
	public Mono<Cart> create(Cart cart);

	public Flux<Cart> findByClientName(String clientName);

	public Flux<Cart> findAll();
}
