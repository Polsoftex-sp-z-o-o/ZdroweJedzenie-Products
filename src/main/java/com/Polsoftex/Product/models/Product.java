package com.Polsoftex.Product.models;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal price;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }

    public Integer getQuantity(){ return quantity; }
    public void setQuantity(Integer quantity){ this.quantity = quantity; }

    public BigDecimal getPrice(){ return price; }
    public void setPrice(BigDecimal price){ this.price = price; }
}
