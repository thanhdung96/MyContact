package com.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.domain.Contact;
import com.contact.repository.Contact2Repository;

@Service("contact2")
public class Contact2Impl implements ContactService {

	@Autowired
	private Contact2Repository contact2Repository;

	@Override
	public Iterable<Contact> findAll() {
		// add find all to contact2Repository
		return contact2Repository.findAll();
	}

	@Override
	public List<Contact> search(String q) {
		// TODO add search by name to contact2Repository (skip this)
		// return contact2Repository.findOne(q);
		return null;
	}

	@Override
	public Contact findOne(int Id) {
		// add findOne by id to contact2Repository
		return contact2Repository.findOne(Id);
	}

	@Override
	public void save(Contact contact) {
		// add save new contact to contact2Repository
		contact2Repository.save(contact);
	}

	@Override
	public void delete(int id) {
		// add delete by id to contact2Repository
		contact2Repository.delete(id);
	}
}
