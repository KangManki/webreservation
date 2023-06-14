package com.info_gateway.dev.webreservation.display.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.info_gateway.dev.webreservation.display.dto.CommentImages;
import com.info_gateway.dev.webreservation.display.dto.Comments;

@Repository
public class CommentsDAO {
	private final NamedParameterJdbcTemplate jdbcTemplate;
	private static final RowMapper<Comments> COMMENTS_DTO_ROW_MAPPER = BeanPropertyRowMapper.newInstance(Comments.class);
	private static final RowMapper<CommentImages> COMMENTIMAGES_DTO_ROW_MAPPER = BeanPropertyRowMapper.newInstance(CommentImages.class);
	
	@Autowired
	CommentImagesDAO comImgDAO;
	
	public CommentsDAO(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public float getAverageScore(int displayId) {
		Map<String, Integer> params = new HashMap<>();
		
		params.put("displayId", displayId);
		
		return jdbcTemplate.queryForObject(DisplayDetailSQLs.SELECT_AVERAGESCORE, params, Float.class);
	}
	
	public List<CommentImages> getCommentImages(int commentId)	{
		Map<String, Integer> params = new HashMap<>();
		
		params.put("commentId", commentId);
		
		return jdbcTemplate.query(DisplayDetailSQLs.SELECT_COMMENT_IMAGES, params, COMMENTIMAGES_DTO_ROW_MAPPER);
		
	}
	
	public List<Comments> getComments(int displayId)	{
		Map<String, Integer> params = new HashMap<>();
		
		params.put("displayId", displayId);
		
		List<Comments> comments = jdbcTemplate.query(DisplayDetailSQLs.SELECT_COMMENTS, params, COMMENTS_DTO_ROW_MAPPER);
		
		for (Comments comm : comments)	{
			
			comm.setCommentImages(getCommentImages(comm.getCommentId()));
			
		}
		
		return comments;
	}
}