package com.sda.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.demo.model.Category;
import com.sda.demo.repo.CategoryRepo;

@Service
public class Categoryservice {
@Autowired
private CategoryRepo categoryrepo;
public List<Category> getAllCategories(){
	return categoryrepo.findAll();
	
}
}
