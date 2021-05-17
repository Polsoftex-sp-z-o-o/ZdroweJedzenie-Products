package com.Polsoftex.Product.service;

import com.Polsoftex.Product.models.Product;
import com.Polsoftex.Product.models.dto.ProductDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getSelectedProducts(List<UUID> ids);
    Optional<Product> getProduct(UUID id);
    List<String> getAllCategories();
    Boolean createProduct(ProductDto productDto);
    Boolean modifyProduct(ProductDto productDto, UUID id);
    Boolean deleteProduct(UUID id);
}
