package com.Polsoftex.Product;

import com.Polsoftex.Product.controllers.ProductController;
import com.Polsoftex.Product.models.Product;
import com.Polsoftex.Product.models.dto.ProductDto;
import com.Polsoftex.Product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getAllProductsTest() throws Exception
    {
        Product firstProduct = new Product();
        firstProduct.setDescription("First product description");
        firstProduct.setName("Apple");
        firstProduct.setPrice(new BigDecimal(0.69));
        firstProduct.setQuantity(100);

        Product secondProduct = new Product();
        secondProduct.setDescription("Second product description");
        secondProduct.setName("Orange");
        secondProduct.setPrice(new BigDecimal(12.34));
        secondProduct.setQuantity(120);

        when(productService.getAllProducts()).thenReturn(Arrays.asList(firstProduct, secondProduct));

        mockMvc.perform(get("/products")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].description").value(firstProduct.getDescription()))
                .andExpect(jsonPath("$[0].name").value(firstProduct.getName()))
                .andExpect(jsonPath("$[0].price").value(firstProduct.getPrice()))
                .andExpect(jsonPath("$[0].quantity").value(firstProduct.getQuantity()))
                .andExpect(jsonPath("$[1].description").value(secondProduct.getDescription()))
                .andExpect(jsonPath("$[1].name").value(secondProduct.getName()))
                .andExpect(jsonPath("$[1].price").value(secondProduct.getPrice()))
                .andExpect(jsonPath("$[1].quantity").value(secondProduct.getQuantity()));

    }


    @Test
    public void getProductSuccessTest() throws Exception
    {
        Product product = new Product();
        product.setDescription("Product description");
        product.setName("Apple");
        product.setPrice(new BigDecimal(0.69));
        product.setQuantity(100);

        when(productService.getProduct(any(UUID.class))).thenReturn(Optional.of(product));

        mockMvc.perform(get("/products/123e4567-e89b-42d3-a456-556642440000")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value(product.getDescription()))
                .andExpect(jsonPath("$.name").value(product.getName()))
                .andExpect(jsonPath("$.price").value(product.getPrice()))
                .andExpect(jsonPath("$.quantity").value(product.getQuantity()));

    }

    @Test
    public void getProductFailTest() throws Exception
    {

        when(productService.getProduct(any(UUID.class))).thenReturn(Optional.empty());

        mockMvc.perform(get("/products/123e4567-e89b-42d3-a456-556642440000")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    public void createProductSuccessTest() throws Exception
    {

        when(productService.createProduct(any(ProductDto.class))).thenReturn(true);

        mockMvc.perform(post("/products")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new ProductDto())))
                .andExpect(status().isOk())
                .andExpect(content().string("Product created successfully"));

    }

    @Test
    public void createProductFailedTest() throws Exception
    {

        when(productService.createProduct(any(ProductDto.class))).thenReturn(false);

        mockMvc.perform(post("/products")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new ProductDto())))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product creation failed"));

    }

    @Test
    public void modifyProductFailedTest() throws Exception
    {
        when(productService.modifyProduct(any(ProductDto.class), any(UUID.class))).thenReturn(false);

        mockMvc.perform(put("/products/123e4567-e89b-42d3-a456-556642440000")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new ProductDto())))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product modification failed"));

    }

    @Test
    public void modifyProductSuccessTest() throws Exception
    {
        when(productService.modifyProduct(any(ProductDto.class), any(UUID.class))).thenReturn(true);

        mockMvc.perform(put("/products/123e4567-e89b-42d3-a456-556642440000")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new ProductDto())))
                .andExpect(status().isOk())
                .andExpect(content().string("Product modified successfully"));

    }

    @Test
    public void deleteProductFailedTest() throws Exception
    {
        when(productService.deleteProduct(any(UUID.class))).thenReturn(false);

        mockMvc.perform(delete("/products/123e4567-e89b-42d3-a456-556642440000")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product deletion failed"));

    }

    @Test
    public void deleteProductSuccessTest() throws Exception
    {
        when(productService.deleteProduct(any(UUID.class))).thenReturn(true);

        mockMvc.perform(delete("/products/123e4567-e89b-42d3-a456-556642440000")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Product deleted successfully"));


    }



}
