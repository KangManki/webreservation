package com.info_gateway.dev.webreservation.display.dto;

import java.util.List;

public class DisplayDetail {
	float averageScore;
	List<Comments> comments;
	DisplayInfo displayInfo;
	DisplayInfoImage displayInfoImage;
	List<ProductImages> productImages;
	List<ProductPrices> productPrices;
	public float getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	public DisplayInfo getDisplayInfo() {
		return displayInfo;
	}
	public void setDisplayInfo(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
	}
	public DisplayInfoImage getDisplayInfoImage() {
		return displayInfoImage;
	}
	public void setDisplayInfoImage(DisplayInfoImage displayInfoImage) {
		this.displayInfoImage = displayInfoImage;
	}
	public List<ProductImages> getProductImages() {
		return productImages;
	}
	public void setProductImages(List<ProductImages> productImages) {
		this.productImages = productImages;
	}
	public List<ProductPrices> getProductPrices() {
		return productPrices;
	}
	public void setProductPrices(List<ProductPrices> productPrices) {
		this.productPrices = productPrices;
	}
	@Override
	public String toString() {
		return "DisplayDetail [averageScore=" + averageScore + ", comments=" + comments + ", displayInfo=" + displayInfo
				+ ", displayInfoImage=" + displayInfoImage + ", productImages=" + productImages + ", productPrices="
				+ productPrices + "]";
	}
	
	
}