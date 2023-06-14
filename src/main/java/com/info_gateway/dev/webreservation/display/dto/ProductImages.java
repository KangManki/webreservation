package com.info_gateway.dev.webreservation.display.dto;

import java.util.Date;

public class ProductImages {
	 String contentType;
     Date createDate;
     boolean deleteFlag;
     int fileInfoId;
     String fileName;
     Date modifyDate;
     int productId;
     int productImageId;
     String saveFileName;
     String type;
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public int getFileInfoId() {
		return fileInfoId;
	}
	public void setFileInfoId(int fileInfoId) {
		this.fileInfoId = fileInfoId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductImageId() {
		return productImageId;
	}
	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ProductImages [contentType=" + contentType + ", createDate=" + createDate + ", deleteFlag=" + deleteFlag
				+ ", fileInfoId=" + fileInfoId + ", fileName=" + fileName + ", modifyDate=" + modifyDate
				+ ", productId=" + productId + ", productImageId=" + productImageId + ", saveFileName=" + saveFileName
				+ ", type=" + type + "]";
	}
     
     
}
