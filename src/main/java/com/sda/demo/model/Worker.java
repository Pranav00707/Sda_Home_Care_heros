package com.sda.demo.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.sda.demo.util.ImageUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="worker_heros")
public class Worker {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Lob
	@Column(name="profile_photo",length=200000)
	private byte[] photo;
	
	private String name;
	private String email;
	private String contact;
	private String password;
	@ManyToOne
	private Category category;
	private String location;
	private String pincode;
	
	

	public Worker(long id, byte[] photo, String name, String email, String contact, String password,Category category, String location,String pincode) {
		super();
		this.id = id;
		this.photo = photo;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.category=category;
		this.location=location;
		this.pincode=pincode;
	}
	
	public Worker() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
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
		this.category=category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
    
	@Override
	public String toString() {
		return "Worker [id=" + id + ", photo=" + Arrays.toString(photo) + ", name=" + name + ", email=" + email
				+ ", contact=" + contact + ", password=" + password + ", category=" + category + ", location=" + location + "]";
	}
	public String getStringOfPhoto() {
		return ImageUtils.encodeToBase64(this.photo);
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
