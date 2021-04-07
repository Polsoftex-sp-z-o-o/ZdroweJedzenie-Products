package com.Polsoftex.Product.service;

import com.Polsoftex.Product.models.Product;
import com.Polsoftex.Product.models.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProcduct(long id);
    Boolean createProduct(ProductDto productDto);
    Boolean modifyProduct(ProductDto productDto, long id);
    Boolean deleteProduct(long id);
}
