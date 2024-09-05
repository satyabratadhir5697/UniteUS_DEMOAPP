package com.uniteUs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniteUs.Model.Category;

import com.uniteUs.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
   
    private CategoryService categoryService;
    
    
    // Save the category and its subcategories in the database
    @PostMapping("/addcategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
 
        Category savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(savedCategory);
    }
    
    //To get All categories with its Subcategories

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }
        return new ResponseEntity<>(categories, HttpStatus.OK); // 200 OK
    }
  
    
    
   //to get all a category and it sub-categories
    @GetMapping("/categories/{Category_name}")
   public ResponseEntity<Category> getCategory(@PathVariable String Category_name){
    	Category category = categoryService.getCategoryByName(Category_name);
	   return ResponseEntity.ok(category);
   }
}
