package com.Polsoftex.Product.service;

import com.Polsoftex.Product.models.Product;
import com.Polsoftex.Product.models.dto.ProductDto;
import com.Polsoftex.Product.repositiories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts()
    {
        //TODO Implement getAllProduct
        return new ArrayList<>();
    }

    @Override
    public Product getProcduct(long id)
    {
        //TODO Implement getting single product
        return new Product();
    }

    @Override
    public Boolean createProduct(ProductDto productDto)
    {
        //TODO Implement adding new product
        return true;
    }

    @Override
    public Boolean modifyProduct(ProductDto productDto, long id)
    {
        //TODO Implement product edition
        return true;
    }

    @Override
    public Boolean deleteProduct(long id)
    {
        //TODO Implement product deletion
        return true;
    }
}
