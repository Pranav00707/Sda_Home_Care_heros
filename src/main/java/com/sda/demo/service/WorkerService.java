package com.sda.demo.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.sda.demo.dto.WorkerDto;
import com.sda.demo.model.Category;
import com.sda.demo.model.Worker;
import com.sda.demo.repo.WorkerRepo;
import com.sda.demo.util.ImageUtils;

@Service
public class WorkerService implements UserDetailsService,WorkerService1{
	@Autowired
	private WorkerRepo workerRepo;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder2;
	


    public Worker findByEmail(String email) {
        return workerRepo.findByEmail(email);
    }

	@Override
	public boolean authenticate(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Worker> getWorkersByCategory(Long categoryId) {
		return workerRepo.findByCategory_Id(categoryId);

	}



	@Override
	public Worker save(WorkerDto dto) throws IOException {
		Worker worker=new Worker();
		worker.setPhoto(ImageUtils.compressImage(dto.getPhoto().getBytes()));
		worker.setName(dto.getName());
		worker.setEmail(dto.getEmail());
		worker.setContact(dto.getContact());
		worker.setPassword(passwordEncoder2.encode(dto.getPassword()));
		worker.setCategory(dto.getCategory());
		worker.setLocation(dto.getLocation());
		return workerRepo.save(worker);
	}

	

	
	  @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Worker worker = workerRepo.findByEmail(username);
	        if (worker == null) {
	            throw new UsernameNotFoundException("Worker not found with username: " + username);
	        }
	        // You may need to customize the GrantedAuthorities for roles
	        return new org.springframework.security.core.userdetails.User(
	                worker.getEmail(),
	                worker.getPassword(),
	                worker.getRoles());
	    }

	@Override
	public com.sda.demo.model.User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
