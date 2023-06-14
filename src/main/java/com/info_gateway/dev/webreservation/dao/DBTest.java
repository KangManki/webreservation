package com.info_gateway.dev.webreservation.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.info_gateway.dev.webreservation.config.ApplicationConfig;
import com.info_gateway.dev.webreservation.dto.Products;
import com.info_gateway.dev.webreservation.dto.PromotionCategoryItem;

public class DBTest {
	

	public static void main(String[] args) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		
		  ProductsDao dao = ac.getBean(ProductsDao.class);
		  
//		  int count = dao.selectCount(1);
		  
		  
		  List<Products> prom = dao.select(0, 0);
		  
		  
		  
		  Products promObj = prom.get(0);
		  
		  System.out.println(promObj);
		  
		  
		  
		  
		  
//		  System.out.println("Product 테이블의 행 갯수 : " + count);
		  
			/*
			 * Product product = new Product();
			 * 
			 * List<Product> products = dao.selectByID(1);
			 * 
			 * if(products == null) { System.out.println("데이터를 가져오는데 실패하였습니다."); } else {
			 * product = (Product)products.get(0);
			 * 
			 * System.out.println(product.getContent()); }
			 */
		 
		
		/*
		 * CategoryDao cat = ac.getBean(CategoryDao.class);
		 * 
		 * List<Category> cats = cat.selectAll();
		 * 
		 * 
		 * 
		 * 
		 * for (Iterator iterator = cats.iterator(); iterator.hasNext();) { Category
		 * category = (Category) iterator.next();
		 * 
		 * 
		 * System.out.println(category.getName()); }
		 */
	}
}
