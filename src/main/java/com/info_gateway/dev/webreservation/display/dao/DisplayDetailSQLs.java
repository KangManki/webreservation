package com.info_gateway.dev.webreservation.display.dao;

public class DisplayDetailSQLs {
	public static final String SELECT_AVERAGESCORE = "SELECT AVG(score) AS [averageScore]　FROM product T1 INNER JOIN display_info T2 ON T1.id = T2.product_id INNER JOIN reservation_user_comment T3 ON T2.product_id = T3.product_id\r\n"
			+ "WHERE T2.id = :displayId\r\n"
			+ "GROUP BY T3.product_id";
	
	public static final String SELECT_COMMENT_IMAGES = "SELECT T4.content_type AS [contentType], T4.create_date AS [createDate], T4.delete_flag AS [deleteFlag], T4.id AS [fileId], T2.id AS [imageId], t4.modify_date AS [modifyDate], T2.reservation_info_id AS [reservationInfoId], t2.reservation_user_comment_id AS [reservationUserCommentId], t4.save_file_name AS [saveFileName]\r\n"
			+ "FROM reservation_user_comment T1 \r\n"
			+ "INNER JOIN reservation_user_comment_image T2 ON T1.id = T2.reservation_user_comment_id　\r\n"
			+ "INNER JOIN reservation_info T3 ON T2.reservation_info_id = T3.id \r\n"
			+ "INNER JOIN file_info T4 ON T2.[file_id] = T4.id\r\n"
			+ "WHERE T2.reservation_user_comment_id = :commentId";
	public static final String SELECT_COMMENTS = "SELECT T1.comment AS [comment], T1.id AS [commentId], T1.create_date AS [createDate], T1.modify_date AS [modifyDate], T2.id AS [productId], \r\n"
			+ "T4.reservation_date AS [reservationDate], T4.reservation_email AS [reservationEmail], T4.id AS [reservationInfoId], T4.reservation_name AS [reservationName], t4.reservation_tel AS [reservationTelephone], T1.score AS [score]\r\n"
			+ "FROM RESERVATION_USER_COMMENT T1 \r\n"
			+ "INNER JOIN PRODUCT T2 ON T1.product_id = T2.id \r\n"
			+ "INNER JOIN display_info T3 ON T2.id = T3.product_id　\r\n"
			+ "INNER JOIN reservation_info T4 ON T3.id = T4.display_info_id AND T3.product_id = T4.product_id\r\n"
			+ "WHERE T3.id = :displayId";
	public static final String SELECT_DISPLAYINFO ="SELECT T3.id AS [categoryId], T3.[name] AS [categoryName], T1.create_date AS [createDate], T1.id AS [displayInfoId], \r\n"
			+ "T1.email AS [email] , T1.homepage AS [homepage], t1.modify_date AS [modifyDate], T1.place_lot AS [placeLot], T1.place_name AS [placeName], T1.place_street AS [placeStreet], \r\n"
			+ "T2.content AS [productContent], T2.[description] AS [productDescription], T2.[event] AS [productEvent], T2.id AS [productId], T1.tel AS [telephone]\r\n"
			+ "FROM display_info T1 \r\n"
			+ "INNER JOIN product T2 ON T1.product_id = T2.id \r\n"
			+ "INNER JOIN category T3 ON T2.category_id = T3.id\r\n"
			+ "WHERE T1.ID = :displayId";
	public static final String SELECT_DISPLAYINFO_IMAGE = "SELECT T3.content_type AS [contentType], T3.create_date AS [createdate], T3.delete_flag AS [deleteFlag], T1.id AS [displayInfoId], T2.id AS [displayInfoImageId], T3.id AS [fileId], T3.[file_name] AS [fileName], T3.modify_date AS [modifyDate], T3.save_file_name AS [saveFileName]\r\n"
			+ "FROM display_info T1 \r\n"
			+ "INNER JOIN display_info_image T2 ON T1.id = T2.display_info_id \r\n"
			+ "INNER JOIN file_info T3 ON T2.[file_id] = T3.id\r\n"
			+ "WHERE T1.id = :displayId";
	
	public static final String SELECT_PRODUCT_IMAGES ="SELECT t3.content_type AS [contentType], T3.create_date AS [createDate], T3.delete_flag AS [deleteFlag], T3.id AS [fileInfoid], T3.[file_name] AS [fileName], T3.modify_date AS [modifyDate], T1.id AS [productId], T2.id AS [productImageId], t3.save_file_name AS [saveFileName], t2.type AS [type]\r\n"
			+ "FROM product T1 \r\n"
			+ "INNER JOIN product_image T2 ON T1.ID = T2.product_id\r\n"
			+ "INNER JOIN file_info T3 on t2.[file_id] = T3.id\r\n"
			+ "INNER JOIN display_info T4 ON T1.id = T4.product_id\r\n"
			+ "WHERE T4.id = :displayId";
	
	public static final String SELECT_PRODUCT_PRICES = "SELECT T2.create_date AS [createDate], T2.discount_rate AS [discountRate], T2.modify_date AS [modifyDate], T2.price AS [price], T2.price_type_name AS [priceTypeName], T1.id AS [productId], t2.id AS [productPriceId]\r\n"
			+ "FROM product T1\r\n"
			+ "INNER JOIN product_price T2 ON T1.id = T2.product_id\r\n"
			+ "INNER JOIN display_info T3 ON T1.id = T3.product_id\r\n"
			+ "WHERE T3.ID = :displayId\r\n"
			+ "";
	
	
}

	