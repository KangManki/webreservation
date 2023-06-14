package com.info_gateway.dev.webreservation.dao;

import static com.info_gateway.dev.webreservation.dao.DaoSqls.SELECT_CATEGORY_ITEM;
import static com.info_gateway.dev.webreservation.dao.DaoSqls.SELECT_CATEGORY_ITEM_WHERE;
import static com.info_gateway.dev.webreservation.service.WebReservationService.MOREVIEWS;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.info_gateway.dev.webreservation.dto.Products;;

@Repository
public class ProductsDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Products> mapper = BeanPropertyRowMapper.newInstance(Products.class);
	
	public ProductsDao(DataSource dataSource)	{
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);		
	}
	
	public List<Products> select(Integer categoryId, Integer start)	{
		String query = "";
		
		Map<String, Integer> params = new HashMap<>();
		
		params.put("category_Id", categoryId);
		params.put("start", start);
		params.put("limit", start + MOREVIEWS);
		
		
		query = categoryId != 0 ? SELECT_CATEGORY_ITEM_WHERE : SELECT_CATEGORY_ITEM;
		
		System.out.println(query);
		
		System.out.println(params);
		return jdbc.query(query, params, mapper);		
	}
}
