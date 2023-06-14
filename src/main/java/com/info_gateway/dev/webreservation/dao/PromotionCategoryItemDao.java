package com.info_gateway.dev.webreservation.dao;

import static com.info_gateway.dev.webreservation.dao.DaoSqls.SELECT_PROMOTION_CATEGORYITEM;
import static com.info_gateway.dev.webreservation.dao.DaoSqls.SELECT_PROMOTION_CATEGORYITEM_ALL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.info_gateway.dev.webreservation.dto.PromotionCategoryItem;

@Repository
public class PromotionCategoryItemDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<PromotionCategoryItem> rowMapper = BeanPropertyRowMapper.newInstance(PromotionCategoryItem.class);
	
	public PromotionCategoryItemDao(DataSource dataSource)	{
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<PromotionCategoryItem> selectAll()	{
		return jdbc.query(SELECT_PROMOTION_CATEGORYITEM_ALL, rowMapper);
	}
	
	public List<PromotionCategoryItem> select(int categoryNo)	{
		Map<String, Integer> params = new HashMap<>();
		
		params.put("category_id", categoryNo);
		
		return jdbc.query(SELECT_PROMOTION_CATEGORYITEM, params, rowMapper);
	}
	
	
}
