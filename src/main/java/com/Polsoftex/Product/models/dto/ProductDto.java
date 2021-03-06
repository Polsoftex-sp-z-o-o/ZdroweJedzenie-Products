package com.Polsoftex.Product.models.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDto {

    private UUID id;
    private String name;
    private String description;
    private String category;
    private Integer quantity;
    private BigDecimal price;

    public UUID getId(){ return id; }
    public void setId(UUID id){ this.id = id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getQuantity(){ return quantity; }
    public void setQuantity(Integer quantity){ this.quantity = quantity; }

    public BigDecimal getPrice(){ return price; }
    public void setPrice(BigDecimal price){ this.price = price; }
}
