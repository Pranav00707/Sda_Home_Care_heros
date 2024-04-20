package com.sda.demo.dto;


import org.springframework.web.multipart.MultipartFile;

import com.sda.demo.model.Category;

public class WorkerDto {
    private MultipartFile photo;
    private String name;
    private String email;
    private String contact;
    private String password;
    private Category category;
    private String location;
    private String pincode;
    public WorkerDto() {
        super();
    }

    public WorkerDto(MultipartFile photo, String name, String email, String contact, String password, Category category, String location,String pincode) {
        super();
        this.photo = photo;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.category = category;
        this.location = location;
        this.pincode=pincode;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
