package com.grizzly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.grizzly.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<Product> productList = session.createQuery("from Product").list();
		session.close();
		return productList;
	}

	@Override
	public List<String> getCategoriesNames() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query=session.createSQLQuery("select category_name from productcategories");
		List<String> categoryList=query.list();
		return categoryList;
	}

	@Override
	public boolean insertProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(product);
		tx.commit();
		session.close();
		return true;
	
	}

	@Override
	public int checkProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("from Product o where o.productId=:productId or o.productCategory=:productCategory");
		query.setInteger("productId", product.getProductId());
		query.setString("productCategory", product.getProductCategory());
		int productExists=0;
		List<Product> productList=query.list();
		for(Product productDB:productList){
			if(productDB.getProductId()==product.getProductId()){
				productExists= 1;
			}else if(productDB.getProductCategory().equals(product.getProductCategory())){
				productExists= 2;
			}else{
				productExists= 0;
			}
		}
	   return productExists;
	}

	@Override
	public Product getProductInfo(int productId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Product product=(Product) session.load(Product.class, productId);
		return product;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		System.out.println("in delete");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery("delete from Product o where o.productId=:productId");
		query.setParameter("productId", productId);
			
		int result=query.executeUpdate();
		tx.commit();
		
		
		return true;
	}


}
