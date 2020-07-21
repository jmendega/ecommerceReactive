package com.springboot.models;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Document(collection = "cart")
public class Cart {
  
  @Size(max = 50)
  @NotNull(message = "El campo clientName no puede ser nulo")
  @NotEmpty(message = "El campo clientName no puede ser vacio")
  private String clientName;
  
  private List<Product> product;
}
