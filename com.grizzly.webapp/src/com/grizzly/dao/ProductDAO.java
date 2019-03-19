package com.grizzly.dao;

import java.util.List;

import com.grizzly.entity.Product;

public interface ProductDAO {
	
	List<Product> getAllProducts();
	List<String> getCategoriesNames();
	boolean insertProduct(Product product);
	int checkProduct(Product product);
	Product getProductInfo(int productId);
	boolean deleteProduct(int productId);
	

}
