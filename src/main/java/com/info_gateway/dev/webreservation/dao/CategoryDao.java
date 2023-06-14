package com.info_gateway.dev.webreservation.dao;





import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.info_gateway.dev.webreservation.dto.Category;
import static com.info_gateway.dev.webreservation.dao.DaoSqls.*;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	
	public CategoryDao(DataSource dataSource)	{
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);				
	}
	
	public List<Category> selectAll()	{
		return jdbc.query(SELECT_CATEGORY_ALL, rowMapper);
	}
}
