package com.info_gateway.dev.webreservation.service;

import java.util.List;

import com.info_gateway.dev.webreservation.dto.Category;
import com.info_gateway.dev.webreservation.dto.Product;
import com.info_gateway.dev.webreservation.dto.Products;
import com.info_gateway.dev.webreservation.dto.PromotionCategoryItem;

public interface WebReservationService {	
	public static final Integer MOREVIEWS = 4;
	public List<Category> getCategory();
	public List<Product> getProducts(Integer prodCount);
	public List<PromotionCategoryItem> getPromotionList();
	public int getProductCount(Integer categoryID);	
	public List<Products> getProductsList(Integer categoryId, Integer start);	
}
