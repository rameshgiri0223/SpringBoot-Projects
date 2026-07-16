package com.blinkit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkit.dto.ProductRequestDto;
import com.blinkit.entity.ProductEntity;
import com.blinkit.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	// Upload Product
    public String uploadProduct(ProductRequestDto requestDto) {

        ProductEntity product = new ProductEntity();

        product.setProductName(requestDto.getProductName());
        product.setCategory(requestDto.getCategory());
        product.setPrice(requestDto.getPrice());
        product.setQuantity(requestDto.getQuantity());
        product.setStatus("ACTIVE");

        productRepository.save(product);

        return "Product uploaded successfully";
    }
	
	// Get all products
	public List<ProductEntity> getAllProducts()
	{
	    return productRepository.findAll();
	}
	

	
	

}
