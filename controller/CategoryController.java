package com.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ar.model.Category;
import com.ar.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="category-form", method=RequestMethod.GET)
	public ModelAndView categoryForm(){
		Category category = new Category();
		ModelAndView mv = new ModelAndView("category-form");
		mv.addObject("category", category);
		return mv;
		
	}
	
	@RequestMapping(value="add-category", method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute Category category){
		
		if(category.getCategoryId()==0){
			categoryService.addCategory(category);
		}else{
			categoryService.updateCategory(category);
		}
		
		List<Category> categoryList = categoryService.getCategoryList();
		
		ModelAndView mv = new ModelAndView("category-list");
		mv.addObject("categoryList", categoryList);
		return mv;
		
	}
	
	@RequestMapping(value="delete-category/{categoryId}", method=RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable("categoryId") int categoryId){
		
		categoryService.deleteCategory(categoryId);
		List<Category> categoryList= categoryService.getCategoryList();
		ModelAndView mv = new ModelAndView("category-list");
		mv.addObject("categoryList", categoryList);
		return mv;
	}
	
	@RequestMapping(value="edit-category", method=RequestMethod.GET)
	public ModelAndView editCategory(@RequestParam("categoryId") int categoryId){
		
		
		Category category = categoryService.getCategory(categoryId);
		
		ModelAndView mv = new ModelAndView("category-form");
		mv.addObject("category", category);
		return mv;
		
	}
}
