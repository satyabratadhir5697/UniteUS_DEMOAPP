package com.uniteUs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniteUs.Model.Category;
import com.uniteUs.Model.Subcategory;
import com.uniteUs.repository.CategoryRepository;


import jakarta.transaction.Transactional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    
    //to save category with its sub-categories
    @Transactional
    public Category saveCategory(Category category) {
        if (category.getSubCategories() != null) {
            List<Subcategory> subcategories = new ArrayList<>(category.getSubCategories());
            category.setSubCategories(new ArrayList<>());
            for (Subcategory subcategory : subcategories) {
                category.addSubcategory(subcategory);
            }
        }
        return categoryRepository.save(category);
    }
    
    //to get Category details with Sub-categories
    public Category getCategoryByName(String Category_name) {
    	return categoryRepository.findByName(Category_name);
    }
    
    //to get All categories 
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}

