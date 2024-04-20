package com.sda.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sda.demo.dto.UserDto;
import com.sda.demo.model.User;
import com.sda.demo.repo.UserRepo;
import com.sda.demo.util.ImageUtils;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User save(UserDto dto) throws IOException {
		User user=new User();
		user.setPhoto(ImageUtils.compressImage(dto.getPhoto().getBytes()));
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setContact(dto.getContact());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setLocation(dto.getLocation());
		user.setPincode(dto.getPincode());
		
		return userRepo.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user=userRepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),Collections.emptyList());
	}
	

	 @Override
	    public User getUserByEmail(String email) {
	        return userRepo.findByEmail(email);
	    }
	 
	 @Override
	 public User getUserById(long id) {
			Optional<User> optional=userRepo.findById(id);
			User user=null;
			if(optional.isPresent()) {
				user=optional.get();
			}else {
				throw new RuntimeException("User not found with id: "+id);
			}
			return user;
		}
	 
	 public User update(long id,UserDto userDto) throws IOException{
			User existingUser=userService.getUserById(id);
			existingUser.setPhoto(ImageUtils.compressImage(userDto.getPhoto().getBytes()));
			existingUser.setName(userDto.getName());
			existingUser.setEmail(userDto.getEmail());
			existingUser.setContact(userDto.getContact());
			existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
			existingUser.setLocation(userDto.getLocation());
			return userRepo.save(existingUser);
		}
	@Override
	public List<User> getAll(){
		List<User> userCompressed=new ArrayList<>();
		List<User> users=userRepo.findAll();
		for(User user:users) {
			user.setPhoto(ImageUtils.decompressImage(user.getPhoto()));
			user.setName(user.getName());
			user.setEmail(user.getEmail());
			user.setContact(user.getContact());
			user.setPassword(user.getPassword());
			user.setLocation(user.getLocation());
			user.setPincode(user.getPincode());
			userCompressed.add(user);
		}
		return userCompressed;
	}
}
