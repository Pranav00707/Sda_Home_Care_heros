package com.sda.demo.model;

import java.util.Arrays;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name="user_heros")
public class User {
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
	private String location;
	private String pincode;
	
	
	
	public User(byte[] photo, String name, String email, String contact, String password, String location,String pincode) {
		super();
		this.photo = photo;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.location = location;
		this.pincode=pincode;
		
	}
	
	public User() {
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

	

	@Override
	public String toString() {
		return "User [id=" + id + ", photo=" + Arrays.toString(photo) + ", name=" + name + ", email=" + email
				+ ", contact=" + contact + ", password=" + password + ", location=" + location + "]";
	}

	public User getUserByEmail(String username) {
		
		return null;
	}
	
}
