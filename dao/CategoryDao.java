package com.ar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ar.model.Category;
import com.ar.util.HibernateUtil;

@Repository
public class CategoryDao {
	
	public void addCategory(Category category){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Category> getCategoryList(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query qry = session.createQuery("from Category");
		List<Category> categoryList = qry.list();
		session.getTransaction().commit();
		session.close();		
		return categoryList;
	}
	
	public void updateCategory(Category category){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Category category1= session.load(Category.class, category.getCategoryId());
		category1.setCategoryName(category.getCategoryName());
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteCategory(int categoryId){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Category category= session.load(Category.class, categoryId);
		session.delete(category);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Category getCategory(int categoryId){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Category category = session.get(Category.class, categoryId);		
		session.getTransaction().commit();
		session.close();
		return category;
		
	}

}
