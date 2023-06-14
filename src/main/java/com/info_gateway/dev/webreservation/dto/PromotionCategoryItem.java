package com.info_gateway.dev.webreservation.dto;

public class PromotionCategoryItem {
// 이미지 URL, 타이틀, 주소, 디스크립션
	private String file_name;
	private String description;
	private String content;
	private String place_name;
	
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	
	
	@Override
	public String toString() {
		return "Promotion [file_name=" + file_name + ", description=" + description + ", content=" + content
				+ ", place_name=" + place_name + "]";
	}
}
