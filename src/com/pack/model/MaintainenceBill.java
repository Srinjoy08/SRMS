package com.pack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="MaintainenceBill")
@Table(name="TBL_MAINTAINENCEBILL")
public class MaintainenceBill {
	@Id
	private Integer id;
	private String ownerName;
	private Long contactNumber;
	private String emailId;
	private String flatNumber;
	private String block;
	private String floorNumber;
	private String flatType;
	private Integer area;
	private String month;
	private String year;
	private Float billAmount;
	private String billStatus;
	public MaintainenceBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MaintainenceBill(Integer id, String ownerName, Long contactNumber, String emailId, String flatNumber,
			String block, String floorNumber, String flatType, Integer area, String month, String year, Float billAmount,
			String billStatus) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.flatNumber = flatNumber;
		this.block = block;
		this.floorNumber = floorNumber;
		this.flatType = flatType;
		this.area = area;
		this.month = month;
		this.year = year;
		this.billAmount = billAmount;
		this.billStatus = billStatus;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Float billAmount) {
		this.billAmount = billAmount;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	
}
