package com.contact.repository;

import org.springframework.data.repository.CrudRepository;

import com.contact.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	Role findByName(String name);
}