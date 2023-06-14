package com.info_gateway.dev.webreservation.display.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info_gateway.dev.webreservation.display.dto.DisplayDetail;
import com.info_gateway.dev.webreservation.display.service.DisplayInfoService;

@RestController
@RequestMapping(path="/api")
public class DisplayController {
	@Autowired
	DisplayInfoService displayInfoService;
	
	@GetMapping("/products/{displayInfoId}")
	public Map<String, Object> products(@PathVariable int displayInfoId)	{
		
		Map<String, Object> returnMap = new HashMap<>();
		
		DisplayDetail detail = displayInfoService.getDisplayDetail(displayInfoId);
		
		returnMap.put("averageScore", detail.getAverageScore());
		returnMap.put("comments", detail.getComments());
		returnMap.put("displayInfo", detail.getDisplayInfo());
		returnMap.put("displayInfoImage", detail.getDisplayInfoImage());
		returnMap.put("productImages", detail.getProductImages());
		returnMap.put("productPrices", detail.getProductPrices());
		
		System.out.println(returnMap);
		
		return returnMap;
		
	}
}
