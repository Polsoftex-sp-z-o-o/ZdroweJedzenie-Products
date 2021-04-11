package com.Polsoftex.Product.service;

import com.Polsoftex.Product.models.Product;
import com.Polsoftex.Product.models.dto.ProductDto;
import com.Polsoftex.Product.repositiories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(long id)
    {
        return productRepository.findById(id);
    }

    @Override
    public Boolean createProduct(ProductDto productDto)
    {
        try {
            Product product = new Product();
            product.setDescription(productDto.getDescription());
            product.setName(productDto.getName());
            product.setPrice(product.getPrice());
            product.setQuantity(productDto.getQuantity());

            productRepository.save(product);
        }
        catch (DataIntegrityViolationException exception)
        {
            return false;
        }

        return true;
    }

    @Override
    public Boolean modifyProduct(ProductDto productDto, long id)
    {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(!optionalProduct.isPresent()) return false;

        Product product = optionalProduct.get();
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(product.getPrice());
        product.setQuantity(productDto.getQuantity());

        try
        {
            productRepository.save(product);
        }
        catch (DataIntegrityViolationException exception)
        {
            return  false;
        }

        return true;
    }

    @Override
    public Boolean deleteProduct(long id)
    {
        try
        {
            productRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException exception)
        {
            return false;
        }
        return true;
    }
}
