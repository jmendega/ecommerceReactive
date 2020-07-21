package com.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.Cart;
import com.springboot.models.Product;
import com.springboot.services.impl.CartServiceImpl;
import com.springboot.services.impl.ProductServiceImpl;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@Slf4j
public class EcommerceController {
  
  /* Product */
  @Autowired
  private ProductServiceImpl productService;
  
  @RequestMapping(value = "/product", method = RequestMethod.POST, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public Mono<Product> createProduct(@Valid @RequestBody Product product) {
    log.info("createProduct -> {} ", product);
    return productService.create(product);
  }
  
  @RequestMapping(value = "/product/id/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public Mono<Product> findById(@PathVariable String id) {
    log.info("findById -> {} ", id);
    return productService.findById(id);
  }
  
  @RequestMapping(value = "/product/name/{name}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public Mono<Product> findByName(@PathVariable String name) {
    log.info("findByName -> {} ", name);
    return productService.findByName(name);
  }
  
  @RequestMapping(value = "/product", method = RequestMethod.GET, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public Flux<Product> findByCategory(@RequestParam(defaultValue = "") String category) {
    log.info("findByCategory -> {} ", category);
    return productService.findByCategory(category);
  }
  
  @RequestMapping(value = "/product/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public Flux<Product> getAllProducts() {
    return productService.findAll();
  }
  
  @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public Mono<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
    return productService.update(id, product);
  }
  
  @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public Mono<Void> deleteProduct(@PathVariable String id) {
    return productService.delete(id);
  }
  
  /* Cart */
  @Autowired
  private CartServiceImpl cartService;
  
  @RequestMapping(value = "/cart", method = RequestMethod.POST, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public Mono<Cart> createCart(@Valid @RequestBody Cart cart) {
    log.info("createCart -> {} ", cart);
    return cartService.create(cart);
  }
  
  @RequestMapping(value = "/cart", method = RequestMethod.GET, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public Flux<Cart> findByClientName(@RequestParam(defaultValue = "") String clientName) {
    log.info("findByClientName -> {} ", clientName);
    return cartService.findByClientName(clientName);
  }
  
  @RequestMapping(value = "/cart/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public Flux<Cart> getAllCarts() {
    return cartService.findAll();
  }
}
