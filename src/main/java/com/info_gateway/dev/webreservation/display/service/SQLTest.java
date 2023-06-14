package com.info_gateway.dev.webreservation.display.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.info_gateway.dev.webreservation.config.ApplicationConfig;
import com.info_gateway.dev.webreservation.display.dao.ProductPricesDAO;
import com.info_gateway.dev.webreservation.display.dto.ProductPrices;

public class SQLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("테스트하는 중");
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		
		ProductPricesDAO dao = ac.getBean(ProductPricesDAO.class);
  

  
  
		List<ProductPrices> data = dao.getProductImages(1);
  
		 
		
		System.out.println(data.get(0).toString());
		
		/*
		 * DisplayInfoServiceImpl impl = new DisplayInfoServiceImpl();
		 * 
		 * DisplayDetail detail = new DisplayDetail();
		 * 
		 * detail = impl.getDisplayDetail(1);
		 * 
		 * System.out.println(detail);
		 */		
	}

}
