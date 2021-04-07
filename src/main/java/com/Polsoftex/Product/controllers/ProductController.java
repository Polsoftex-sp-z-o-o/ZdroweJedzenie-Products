package com.Polsoftex.Product.controllers;


import com.Polsoftex.Product.models.Product;
import com.Polsoftex.Product.models.dto.ProductDto;
import com.Polsoftex.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    Iterable<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id)
    {
        return productService.getProcduct(id);
    }

    @PutMapping("/{id}")
    public Boolean modifyProduct(@RequestBody ProductDto productDto, @PathVariable long id)
    {
        return productService.modifyProduct(productDto, id);
    }

    @PostMapping("")
    public Boolean createProduct(@RequestBody ProductDto productDto)
    {
        return productService.createProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteProduct(@PathVariable long id)
    {
        return productService.deleteProduct(id);
    }
}
