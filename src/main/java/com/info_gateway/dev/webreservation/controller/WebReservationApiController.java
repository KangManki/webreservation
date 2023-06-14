package com.info_gateway.dev.webreservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info_gateway.dev.webreservation.dao.ProductsDao;
import com.info_gateway.dev.webreservation.display.dto.DisplayDetail;
import com.info_gateway.dev.webreservation.display.service.DisplayInfoService;
import com.info_gateway.dev.webreservation.dto.Category;
import com.info_gateway.dev.webreservation.dto.Products;
import com.info_gateway.dev.webreservation.dto.PromotionCategoryItem;
import com.info_gateway.dev.webreservation.service.WebReservationService;

@RestController
@RequestMapping(path="/api")
public class WebReservationApiController {
	@Autowired
	WebReservationService webReservationService;
	
	/*
	 * @Autowired DisplayInfoService displayInfoService;
	 */
	
	@GetMapping("/promotions")
	public Map<String, Object> list()	{
		
		List<PromotionCategoryItem> list = webReservationService.getPromotionList();
		
		Map<String, Object> returnMap = new HashMap<>();
		
		returnMap.put("items", list);
		
		return returnMap;
	}
	
	@GetMapping("/products")
	public Map<String, Object> products(@RequestParam(name="categoryId", required=false, defaultValue="0") int categoryId
										, @RequestParam(name="start", required=false, defaultValue="0") int start)	{
		
		List<Products> items = webReservationService.getProductsList(categoryId, start);
		
		int totalCount = webReservationService.getProductCount(categoryId);
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("items", items);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}
	
   @GetMapping("/categories") 
   public Map<String, Object> categories() { 
	   List<Category> list = webReservationService.getCategory();
	   
	   Map<String, Object> returnMap = new HashMap<>();
	   returnMap.put("items", list);
	   
	   return returnMap;
	   
	   
	 }
		/*
		 * @GetMapping("/products/{displayInfoId}") public Map<String, Object>
		 * products(@PathVariable int displayInfoId) {
		 * 
		 * Map<String, Object> returnMap = new HashMap<>();
		 * 
		 * DisplayDetail detail = displayInfoService.getDisplayDetail(displayInfoId);
		 * 
		 * returnMap.put("averageScore", detail.getAverageScore());
		 * returnMap.put("comments", detail.getComments()); returnMap.put("displayInfo",
		 * detail.getDisplayInfo()); returnMap.put("displayInfoImage",
		 * detail.getDisplayInfoImage()); returnMap.put("productImages",
		 * detail.getProductImages()); returnMap.put("productPrices",
		 * detail.getProductPrices());
		 * 
		 * System.out.println(returnMap);
		 * 
		 * return returnMap;
		 * 
		 * }
		 */
}