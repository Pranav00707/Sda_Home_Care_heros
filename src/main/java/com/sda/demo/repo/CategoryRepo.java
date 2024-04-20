package com.sda.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sda.demo.model.Category;


public interface CategoryRepo extends JpaRepository<Category, Long>{

}
