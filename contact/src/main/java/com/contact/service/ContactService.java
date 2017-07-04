package com.contact.service;

import java.util.List;

import com.contact.domain.Contact;

public interface ContactService {
	Iterable<Contact> findAll();

	List<Contact> search(String q);

	Contact findOne(int Id);

	void save(Contact contact);
	
	void delete(int id);
}
