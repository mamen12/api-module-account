package com.test.sigmatech.account.beans;

import java.util.Date;

import jakarta.persistence.Column;

public class BaseEntity {

	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "version")
	private Integer version;
	@Column(name = "is_del")
	private String isDel;
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	
}
