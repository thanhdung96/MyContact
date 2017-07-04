package com.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.contact.domain.Contact;
import com.contact.repository.Contact2Repository;

@Service("contact3")
public class Contact3Impl implements ContactService {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Contact> findAll() {
		return jdbc.query("select* from contact;",
				Contact2Repository.getRowMapper());
	}

	@Override
	public List<Contact> search(String q) {
		String sql = "select* from contact where name like ?";
		return jdbc.query(sql, Contact2Repository.getRowMapper(), new String(
				"%" + q.toLowerCase() + "%"));
	}

	@Override
	public Contact findOne(int Id) {
		return jdbc.queryForObject("select* from contact where id=?;",
				Contact2Repository.getRowMapper(), Id);
	}

	@Override
	public void save(Contact contact) {
		Contact temp;
		try {
			temp = jdbc.queryForObject("select * from contact where id=?;",
					Contact2Repository.getRowMapper(), contact.getId());
			if (!temp.equals(null)) {
				jdbc.update(
						"update contact set name=?, email=?, phone=? where id=?",
						contact.getName(), contact.getEmail(),
						contact.getPhone(), contact.getId());
			} else/* if (temp.equals(null)) */{
				try {
					jdbc.update(
							"insert into mycontact.contact(name, email, phone) values(?,?,?)",
							contact.getName(), contact.getEmail(),
							contact.getPhone());
				} catch (DataAccessException exc) {
					System.out.println(exc.getMessage());
				}
			}
		} catch (DataAccessException e) {
			e.getMessage();
		}
	}

	@Override
	public void delete(int id) {
		jdbc.update("delete from contact where id=?", id);
	}
}
