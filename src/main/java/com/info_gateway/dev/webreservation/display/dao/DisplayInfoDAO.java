package com.info_gateway.dev.webreservation.display.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.info_gateway.dev.webreservation.display.dto.DisplayInfo;
@Repository
public class DisplayInfoDAO {
	private final NamedParameterJdbcTemplate jdbcTemplate;
	private static final RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	
	
	public DisplayInfoDAO(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);		
	}
	
	public DisplayInfo getDisplayInfo(int displayId)	{
		Map<String, Integer> params = new HashMap<>();
		
		params.put("displayId", displayId);
		
		return jdbcTemplate.queryForObject(DisplayDetailSQLs.SELECT_DISPLAYINFO, params, rowMapper); 
	}
}
