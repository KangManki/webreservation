package com.info_gateway.dev.webreservation.display.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.info_gateway.dev.webreservation.display.dto.CommentImages;
import com.info_gateway.dev.webreservation.dto.Category;

@Repository
public class CommentImagesDAO {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentImages> rowMapper = BeanPropertyRowMapper.newInstance(CommentImages.class);
	
	public CommentImagesDAO(DataSource dataSource)	{
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);				
	}
	
	public List<CommentImages> select(int commentId)	{
		Map<String, Object> params = new HashMap<>();
		
		params.put("commentId", commentId);
		
		return jdbc.query(DisplayDetailSQLs.SELECT_COMMENT_IMAGES, params, rowMapper);
	}
}
