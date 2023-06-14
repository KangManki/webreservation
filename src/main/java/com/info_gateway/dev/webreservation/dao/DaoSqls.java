package com.info_gateway.dev.webreservation.dao;

public class DaoSqls {
	public static final String SELECT_PRODUCT_PAGING = "WITH PRODUCT_CTE\r\n"
			+ "			 AS\r\n"
			+ "			 (\r\n"
			+ "			 SELECT ROW_NUMBER() OVER(ORDER BY ID) AS [ROWNUM], ID, category_id, [description], content,event,create_date, modify_date FROM [product]\r\n"
			+ "			 )			 \r\n"
			+ "			 SELECT ID, category_id, [description], content,event,create_date, modify_date "
			+ "			FROM PRODUCT_CTE WHERE ROWNUM > :start AND ROWNUM <= :limit ORDER BY ID DESC ";
	
	public static final String SELECT_PRODUCT_BY_ID = "SELECT ID, category_id, [description], content,event,create_date, modify_date FROM product WHERE id = :id ";
	
//	튜플 수 확인
	public static final String SELECT_PRODUCT_ALL_COUNT = "SELECT COUNT(*) FROM PRODUCT";
	public static final String SELECT_PRODUCT_COUNT_WHERE = " WHERE category_Id = :category_Id";
	
	
	public static final String SELECT_PRODUCT_CATEGORY_COUNT = "SELECT COUNT(CATEGORY_ID) FROM product WHERE category_id = :category_Id GROUP BY CATEGORY_ID";
	
	public static final String SELECT_CATEGORY_ALL = "SELECT ROW_NUMBER() OVER(ORDER BY ID) AS [count], id, [name] FROM category"; 
	
	public static final String SELECT_PROMOTION_CATEGORYITEM_ALL = "SELECT t4.[file_name], t2.[description], t2.content, T5.place_name "
			+ "FROM promotion T1 INNER JOIN \r\n"
			+ "PRODUCT T2 ON T1.product_id = T2.id INNER JOIN\r\n"
			+ "product_image T3 ON T2.id = T3.product_id AND T3.type = 'th' INNER JOIN\r\n"
			+ "file_info T4 ON T3.[file_id] = T4.id INNER JOIN \r\n"
			+ "display_info T5 ON T2.id = T5.id";
	
	public static final String SELECT_PROMOTION_CATEGORYITEM = "SELECT t4.[file_name], t2.[description], t2.content, T5.place_name "
			+ "FROM promotion T1 INNER JOIN \r\n"
			+ "PRODUCT T2 ON T1.product_id = T2.id INNER JOIN\r\n"
			+ "product_image T3 ON T2.id = T3.product_id AND T3.type = 'th' INNER JOIN\r\n"
			+ "file_info T4 ON T3.[file_id] = T4.id INNER JOIN \r\n"
			+ "display_info T5 ON T2.id = T5.id"
			+ "WHERE	t2.category_id = :category_Id";
	
	// 카테고리 아이템 검색 쿼리	
	public static final String SELECT_CATEGORY_ITEM	= 
						"WITH PRODUCTS_CTE \r\n"
			+ "			AS\r\n"
			+ "			(\r\n"
			+ "			SELECT	ROW_NUMBER() OVER(ORDER BY T1.ID) AS [ROWNUM],	T1.category_id AS [category_id], T4.[id] AS [displayInfoId], T4.place_name AS [placeName], T1.[description] AS [productDescription] , T1.content AS [productContent], T3.[file_name] AS [productImageUrl], t1.id AS [productId]\r\n"
			+ "			FROM PRODUCT T1 INNER JOIN\r\n"
			+ "			product_image T2 ON T1.id = T2.product_id AND T2.type = 'th' INNER JOIN\r\n"
			+ "			file_info T3 ON T2.[file_id] = T3.id  INNER JOIN \r\n"
			+ "			display_info T4 ON T1.id = T4.id\r\n"
			+ "			)\r\n"
			+ "			\r\n"
			+ "			SELECT [displayInfoId], [placeName], [productDescription] , [productContent], [productImageUrl], [productId]\r\n"
			+ "			FROM PRODUCTS_CTE WHERE ROWNUM > :start AND ROWNUM <= :limit";	
	
	public static final String SELECT_CATEGORY_ITEM_WHERE = "WITH PRODUCTS_CTE \r\n"
			+ "			AS\r\n"
			+ "			(\r\n"
			+ "			SELECT	ROW_NUMBER() OVER(ORDER BY T1.ID) AS [ROWNUM],	T1.category_id AS [category_id], T4.[id] AS [displayInfoId], T4.place_name AS [placeName], T1.[description] AS [productDescription] , T1.content AS [productContent], T3.[file_name] AS [productImageUrl], t1.id AS [productId]\r\n"
			+ "			FROM PRODUCT T1 INNER JOIN\r\n"
			+ "			product_image T2 ON T1.id = T2.product_id AND T2.type = 'th' INNER JOIN\r\n"
			+ "			file_info T3 ON T2.[file_id] = T3.id  INNER JOIN \r\n"
			+ "			display_info T4 ON T1.id = T4.id\r\n"
			+ "			where category_id = :category_Id\r\n"
			+ "			)\r\n"
			+ "			\r\n"
			+ "			SELECT [displayInfoId], [placeName], [productDescription] , [productContent], [productImageUrl], [productId]\r\n"
			+ "			FROM PRODUCTS_CTE WHERE ROWNUM > :start AND ROWNUM <= :limit AND category_id = :category_Id"; 
	
	
	
}
