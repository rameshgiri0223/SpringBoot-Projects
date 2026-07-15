package com.basket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basket.dto.ProductDto;
import com.basket.entity.CategoryEntity;
import com.basket.entity.ProductEntity;
import com.basket.repository.CategoryRepository;
import com.basket.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	// Upload Product
	public String uploadProduct(ProductDto productDto)
	{

		CategoryEntity category =
		        categoryRepository.findByCategoryName(
		                productDto.getCategoryName());
		
		if (category == null)
		{
		    category = new CategoryEntity();
		    
		    category.setCategoryName(productDto.getCategoryName());
		    
		    categoryRepository.save(category);
		}
		
		ProductEntity product = new ProductEntity();

		product.setProductName(productDto.getProductName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		product.setStatus(productDto.getStatus());
		product.setCategoryEntity(category);

		productRepository.save(product);

		return "Product uploaded successfully";
	}

	// Get All Products
	public List<ProductEntity> getAllProducts()
	{
		return productRepository.findAll();
	}

	// Get Product by name
	public ProductEntity getProductByName(String productName)
	{

		ProductEntity product = productRepository.findByProductName(productName);

		return product;
	}

	// Update Product
	public String updateProduct(Long productId, ProductDto productDto)
	{

		ProductEntity product = productRepository.findById(productId).orElse(null);

		CategoryEntity category = categoryRepository.findByCategoryName(productDto.getCategoryName());

		product.setProductName(productDto.getProductName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		product.setStatus(productDto.getStatus());
		product.setCategoryEntity(category);

		productRepository.save(product);

		return "Product updated successfully";
	}
	
	// Delete Product
	public String deleteProduct(Long productId)
	{

	    productRepository.deleteById(productId);

	    return "Product deleted successfully";
	}
}
