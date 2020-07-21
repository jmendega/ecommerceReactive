package com.springboot.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

//import lombok.Data;
import lombok.ToString;

@ToString
//@Data
@Document(collection = "product")
public class Product {
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Id
  @NotNull(message = "El campo id no puede ser nulo")
  @NotEmpty(message = "El campo id no puede ser vacio")
  public String id;

  @TextIndexed
  @Size(max = 50)
  @NotNull(message = "El campo name no puede ser nulo")
  @NotEmpty(message = "El campo name no puede ser vacio")
  private String name;
  
  @Size(max = 20)
  @NotNull(message = "El campo category no puede ser nulo")
  @NotEmpty(message = "El campo category no puede ser vacio")
  private String category;

  @NotNull(message = "El campo amount no puede ser nulo")
  private int amount;
}
