package com.sda.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sda.demo.model.User;

public interface UserRepo extends JpaRepository<User,Long>{
	User findByEmail(String email);
}
