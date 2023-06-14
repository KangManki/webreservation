package com.info_gateway.dev.webreservation.display.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info_gateway.dev.webreservation.display.dao.*;
import com.info_gateway.dev.webreservation.display.dto.DisplayDetail;
@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {
	
	@Autowired
	CommentsDAO comDao;
	
	@Autowired
	DisplayInfoDAO dispDao;
	
	@Autowired
	DisplayInfoImageDAO dispImgDao;
	
	@Autowired
	ProductImagesDAO prodImgDao;
	
	@Autowired
	ProductPricesDAO prodPriceDao;


	@Transactional	
	public DisplayDetail getDisplayDetail(int displayId) {
		// TODO Auto-generated method stub
		DisplayDetail detail = new DisplayDetail();
		
		detail.setAverageScore(comDao.getAverageScore(displayId));
		detail.setComments(comDao.getComments(displayId));
		detail.setDisplayInfo(dispDao.getDisplayInfo(displayId));
		detail.setDisplayInfoImage(dispImgDao.getDisplayInfoImage(displayId));
		detail.setProductImages(prodImgDao.getProductImages(displayId));
		detail.setProductPrices(prodPriceDao.getProductImages(displayId));
		
		return detail;
	}

}
