package com.info_gateway.dev.webreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.info_gateway.dev.webreservation.dto.PromotionCategoryItem;
import com.info_gateway.dev.webreservation.service.WebReservationService;

@Controller
public class WebReservationController {
	@Autowired
	WebReservationService webService;
	
	@GetMapping(path="/promotionList")
	public String promotionList(ModelMap model)	{
		
		List<PromotionCategoryItem> list = webService.getPromotionList();
		
		model.addAttribute("list", list);
		
		
		return "promotionList";
	}
}