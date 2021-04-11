package com.Polsoftex.Product.service;

import com.Polsoftex.Product.models.Product;
import com.Polsoftex.Product.models.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProduct(long id);
    Boolean createProduct(ProductDto productDto);
    Boolean modifyProduct(ProductDto productDto, long id);
    Boolean deleteProduct(long id);
}
