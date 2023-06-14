package com.info_gateway.dev.webreservation.display.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.info_gateway.dev.webreservation.display.dto.ProductImages;
import com.info_gateway.dev.webreservation.display.dto.ProductPrices;
@Repository
public class ProductPricesDAO {
	private final NamedParameterJdbcTemplate jdbcTemplate;
	private static final RowMapper<ProductPrices> rowMapper = BeanPropertyRowMapper.newInstance(ProductPrices.class);
	
	public ProductPricesDAO(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);		
	}
	
	public List<ProductPrices> getProductImages(int displayId)	{
		Map<String, Integer> params = new HashMap<>();
		
		params.put("displayId", displayId);
		
		return jdbcTemplate.query(DisplayDetailSQLs.SELECT_DISPLAYINFO_IMAGE, params, rowMapper); 
	}
}
