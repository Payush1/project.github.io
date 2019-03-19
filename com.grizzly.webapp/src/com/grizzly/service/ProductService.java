package com.grizzly.service;

import java.util.List;

import com.grizzly.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();
	List<String> getProductCategoryNames();
	boolean persistProduct(Product product);
	int checkProduct(Product product);
	Product getProductDescription(int productId);
	boolean deleteProductInfo(int productId);
	

}
