package com.basket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basket.dto.ProductDto;
import com.basket.entity.ProductEntity;
import com.basket.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	// Upload Product
    @PostMapping("/upload")
    public String uploadProduct(@RequestBody ProductDto productDto)
    {
        return productService.uploadProduct(productDto);
    }
    
 // Get All Products
    @GetMapping
    public List<ProductEntity> getAllProducts()
    {
        return productService.getAllProducts();
    }

    // Get Product By Name
    @GetMapping("/{productName}")
    public ProductEntity getProductByName(@PathVariable String productName)
    {

        return productService.getProductByName(productName);
    }
    
    // Update Product
    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable Long productId,@RequestBody ProductDto productDto)
    {

        return productService.updateProduct(productId, productDto);
    }
    
 // Delete Product
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId)
    {

        return productService.deleteProduct(productId);
    }
}

