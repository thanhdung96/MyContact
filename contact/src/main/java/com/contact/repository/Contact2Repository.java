package com.contact.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.contact.domain.Contact;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class Contact2Repository extends JdbcRepository<Contact, Integer> {

	private static final RowMapper<Contact> ROW_MAPPER = new RowMapper<Contact>() {

		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Contact(rs.getInt("id"), rs.getString("name"),
					rs.getString("email"), rs.getString("phone"));
		}
	};
	private static final RowUnmapper<Contact> ROW_UNMAPPER = new RowUnmapper<Contact>() {
		@Override
		public Map<String, Object> mapColumns(Contact contact) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", contact.getId());
			mapping.put("name", contact.getName());
			mapping.put("email", contact.getEmail());
			mapping.put("phone", contact.getPhone());
			return mapping;
		}
	};

	public Contact2Repository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "contact", "id");
	}
	
	public static RowMapper<Contact> getRowMapper() {
		return ROW_MAPPER;
	}

	@Override
	protected <S extends Contact> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}
}