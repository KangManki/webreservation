package com.info_gateway.dev.webreservation.dao;



import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.info_gateway.dev.webreservation.dto.Product;
import static com.info_gateway.dev.webreservation.dao.DaoSqls.*;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductDao(DataSource dataSource)	{
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
				this.insertAction = new SimpleJdbcInsert(dataSource)
						.withTableName("Product")
						.usingGeneratedKeyColumns("id");
	}
	
	public List<Product> selectAll(Integer count)	{
		Map<String, Integer> params = new HashMap<>();
		params.put("top", count);
		
		
		return jdbc.query(SELECT_PRODUCT_PAGING, params, rowMapper);
	}
	
	public List<Product> selectByID(Integer id)	{
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		
		return jdbc.query(SELECT_PRODUCT_BY_ID,  params, rowMapper);
	}
	
	public int selectCount(Integer categoryId)	{
		String sql = SELECT_PRODUCT_ALL_COUNT;
		Map<String, Integer> params = new HashMap<>();
		
		if(categoryId != 0)	{
			sql = sql + SELECT_PRODUCT_COUNT_WHERE;
			
			System.out.println(sql);
			params.put("category_Id", categoryId);
		}		
		System.out.println(sql);
//		return jdbc.queryForObject(sql, categoryId != 0 ? params : Collections.emptyMap(), Integer.class);
		return jdbc.queryForObject(sql, params, Integer.class);
	}
	
	
	
}
