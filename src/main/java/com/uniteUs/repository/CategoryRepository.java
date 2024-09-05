package com.uniteUs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniteUs.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{
	Category findByName(String name);
}
