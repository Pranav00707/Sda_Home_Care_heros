package com.sda.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sda.demo.dto.WorkerDto;
import com.sda.demo.model.User;
import com.sda.demo.model.Worker;

public interface WorkerService1 extends UserDetailsService {
    boolean authenticate(String email, String password);
    
    Worker save(WorkerDto workerDto) throws IOException;
	//Worker getWorkerByEmail(String username);
	List<Worker> getWorkersByCategory(Long categoryId);

	 User getUserByEmail(String email); // Add this method

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
