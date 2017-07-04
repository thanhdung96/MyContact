package com.contact.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.contact.domain.Slide;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class SlideRepository extends JdbcRepository<Slide, Integer> {

	private static final RowMapper<Slide> ROW_MAPPER = new RowMapper<Slide>() {

		@Override
		public Slide mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Slide(rs.getInt("id"), rs.getString("name"),
					rs.getString("image"), rs.getDate("create_date"),
					rs.getString("creator"));
		}
	};
	private static final RowUnmapper<Slide> ROW_UNMAPPER = new RowUnmapper<Slide>() {

		@Override
		public Map<String, Object> mapColumns(Slide slide) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", slide.getId());
			mapping.put("name", slide.getName());
			mapping.put("image", slide.getImage());
			mapping.put("create_date", slide.getCreateDate());
			mapping.put("creator", slide.getCreator());
			return mapping;
		}
	};

	public SlideRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "slides", "id");
	}

	@Override
	protected <S extends Slide> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}
}
