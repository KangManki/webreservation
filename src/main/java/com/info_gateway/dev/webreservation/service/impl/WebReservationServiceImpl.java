package com.info_gateway.dev.webreservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info_gateway.dev.webreservation.dao.CategoryDao;
import com.info_gateway.dev.webreservation.dao.ProductDao;
import com.info_gateway.dev.webreservation.dao.ProductsDao;
import com.info_gateway.dev.webreservation.dao.PromotionCategoryItemDao;
import com.info_gateway.dev.webreservation.dto.Category;
import com.info_gateway.dev.webreservation.dto.Product;
import com.info_gateway.dev.webreservation.dto.Products;
import com.info_gateway.dev.webreservation.dto.PromotionCategoryItem;
import com.info_gateway.dev.webreservation.service.WebReservationService;
@Service
public class WebReservationServiceImpl implements WebReservationService {

	@Autowired
	CategoryDao catDao;
	
	@Autowired
	ProductDao prodDao;
	
	@Autowired
	PromotionCategoryItemDao promDao;
	
	@Autowired
	ProductsDao productsDao;
	
	
	@Transactional
	public List<Category> getCategory() {
		
		return catDao.selectAll();
	}

	@Transactional
	public List<Product> getProducts(Integer prodCount) {
		
		return prodDao.selectAll(prodCount);
	}

	@Transactional
	public int getProductCount(Integer categoryId) {
		
		return prodDao.selectCount(categoryId);
	}
	
	@Transactional
	public List<PromotionCategoryItem> getPromotionList()	{
		return promDao.selectAll();
	}
	
	@Transactional
	public List<Products> getProductsList(Integer categoryId, Integer start)	{
		return productsDao.select(categoryId, start);
	}	
}
