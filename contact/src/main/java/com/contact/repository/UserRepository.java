package com.contact.repository;

import org.springframework.data.repository.CrudRepository;

import com.contact.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByEmail(String email);
}
