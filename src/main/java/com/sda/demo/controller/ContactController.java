package com.sda.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
//ContactController.java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sda.demo.model.Contact;
import com.sda.demo.repo.contactrepo;

@Controller
public class ContactController {
	
@Autowired
private contactrepo conRepo;

 @GetMapping("/contact")
 public String showContactForm(Model model) {
     model.addAttribute("contact", new Contact());
     return "contactus"; // Assuming you have a Thymeleaf template named contact.html
 }

 @GetMapping("/thankyou")
 public String getThankyou() {
	 return "thankyou";
 }
 @PostMapping("/contactadd")
 public String processContactForm(Contact contact) {
     // TODO: Process the form data (e.g., save to database)
     // You can add the processing logic here
conRepo.save(contact);
     // For simplicity, redirect to a thank you page
     return "redirect:/thankyou";
 }
}
