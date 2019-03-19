package com.grizzly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grizzly.dao.ProductDAO;
import com.grizzly.entity.Product;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}

	@Override
	public List<String> getProductCategoryNames() {
		// TODO Auto-generated method stub
		return productDAO.getCategoriesNames();
	}

	@Override
	public boolean persistProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.insertProduct(product);
	}

	@Override
	public int checkProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.checkProduct(product);
	}

	@Override
	public Product getProductDescription(int productId) {
		// TODO Auto-generated method stub
		return productDAO.getProductInfo(productId);
	}

	@Override
	public boolean deleteProductInfo(int productId) {
		// TODO Auto-generated method stub
		return productDAO.deleteProduct(productId);
	}

}
