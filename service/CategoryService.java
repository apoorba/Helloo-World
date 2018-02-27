package com.ar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.dao.CategoryDao;
import com.ar.model.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	public void addCategory(Category category){
		
		categoryDao.addCategory(category);
		
	}
	
	public List<Category> getCategoryList(){
		
		return categoryDao.getCategoryList();
	}
	
	public void updateCategory(Category category){
		
		categoryDao.updateCategory(category);
	}
	
	public void deleteCategory(int categoryId){
		
		categoryDao.deleteCategory(categoryId);
	}
	
	public Category getCategory(int categoryId){
		
		return categoryDao.getCategory(categoryId);
	}
}
