package com.Polsoftex.Product.models;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue()
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String category;

    @Column
    private Integer quantity;

    @Column
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
