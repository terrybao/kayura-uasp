/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.uasp.web;

import java.io.Serializable;

/**
 * @author liangxia@live.com
 */
public class UploadModel implements Serializable {

	private static final long serialVersionUID = 5013405337626162388L;

	private String bizId;
	private String fileName;
	private String category;
	private Integer serial;
	private Boolean allowChange;
	private String uploaderId;
	private String uploaderName;
	private Boolean isEncrypt;
	private String tags;

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	/**
	 * @return the allowChange
	 */
	public Boolean getAllowChange() {
		return allowChange;
	}

	/**
	 * @param allowChange the allowChange to set
	 */
	public void setAllowChange(Boolean allowChange) {
		this.allowChange = allowChange;
	}

	/**
	 * @return the uploaderId
	 */
	public String getUploaderId() {
		return uploaderId;
	}

	/**
	 * @param uploaderId the uploaderId to set
	 */
	public void setUploaderId(String uploaderId) {
		this.uploaderId = uploaderId;
	}

	/**
	 * @return the uploaderName
	 */
	public String getUploaderName() {
		return uploaderName;
	}

	/**
	 * @param uploaderName the uploaderName to set
	 */
	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	public Boolean getIsEncrypt() {
		return isEncrypt;
	}

	public void setIsEncrypt(Boolean isEncrypt) {
		this.isEncrypt = isEncrypt;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
