package com.contact.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.contact.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
	List<Contact> findByNameContaining(String q);
}
