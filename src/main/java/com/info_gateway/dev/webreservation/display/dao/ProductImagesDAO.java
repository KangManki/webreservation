package com.info_gateway.dev.webreservation.display.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.info_gateway.dev.webreservation.display.dto.DisplayInfoImage;
import com.info_gateway.dev.webreservation.display.dto.ProductImages;
@Repository
public class ProductImagesDAO {
	private final NamedParameterJdbcTemplate jdbcTemplate;
	private static final RowMapper<ProductImages> rowMapper = BeanPropertyRowMapper.newInstance(ProductImages.class);
	
	public ProductImagesDAO(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);		
	}
	
	public List<ProductImages> getProductImages(int displayId)	{
		Map<String, Integer> params = new HashMap<>();
		
		params.put("displayId", displayId);
		
		return jdbcTemplate.query(DisplayDetailSQLs.SELECT_DISPLAYINFO_IMAGE, params, rowMapper); 
	}
}
