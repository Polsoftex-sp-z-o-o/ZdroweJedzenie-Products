package com.Polsoftex.Product.controllers;


import com.Polsoftex.Product.models.Image;
import com.Polsoftex.Product.models.Product;
import com.Polsoftex.Product.models.dto.ImageDto;
import com.Polsoftex.Product.models.dto.ProductDto;
import com.Polsoftex.Product.service.ImageService;
import com.Polsoftex.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    ResponseEntity<Iterable<Product>> getAllProducts()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/ids")
    ResponseEntity<Iterable<Product>> GetSelectedProducts(@RequestParam List<UUID> ids)
    {
        return new ResponseEntity<>(productService.getSelectedProducts(ids), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable UUID id)
    {
        Optional<Product> product = productService.getProduct(id);

        if(product.isPresent())
        {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/products/getAllCategories")
    public ResponseEntity<Object> GetAllCategories()
    {
        return new ResponseEntity<>(productService.getAllCategories(), HttpStatus.OK);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<String> modifyProduct(@RequestBody ProductDto productDto, @PathVariable UUID id)
    {
        if(productService.modifyProduct(productDto, id))
        {
            return new ResponseEntity<>("Product modified successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Product modification failed", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto)
    {
         if(productService.createProduct(productDto))
         {
             return  new ResponseEntity<>("Product created successfully", HttpStatus.OK);
         }

         return new ResponseEntity<>("Product creation failed", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id)
    {
        if(productService.deleteProduct(id))
        {
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Product deletion failed", HttpStatus.NOT_FOUND);
    }
}
