package com.sda.demo.service;


import java.io.IOException;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

//import org.springframework.web.multipart.MultipartFile;

//import java.io.IOException;

//import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

import com.sda.demo.dto.UserDto;
import com.sda.demo.model.User;
//import com.sda.demo.repo.UserRepo;
//import com.sda.demo.util.ImageUtils;


public interface UserService extends UserDetailsService{
	User save(UserDto userDto) throws IOException;
	List<User> getAll();
	
	/*public String saveUser(MultipartFile file, String name, String email, String contact, String password, String about) throws IOException {
		User u1=new User();
		u1.setPhoto(ImageUtils.compressImage(file.getBytes()));
		u1.setName(name);
		u1.setEmail(email);
		u1.setContact(contact);
		u1.setPassword(password);
		u1.setAbout(about);
		User u2=userRepo.save(u1);
		if(u2!=null) {
		return "User saved successfully.";
		}
		else {
			return null;
		}
	}*/
     User getUserByEmail(String email); // Add this method
     User getUserById(long id);
     User update(long id,UserDto userDto) throws IOException;
}
