package com.sda.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sda.demo.model.Contact;

public interface contactrepo extends JpaRepository<Contact, Long> {

}
