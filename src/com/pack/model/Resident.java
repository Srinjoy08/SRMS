package com.pack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Resident")
@Table(name="TBL_RESIDENT")
public class Resident {
	@Id
	private Integer id;
	private String OwnerName;
	private String dob;
	private String gender;
	private Integer ContactNumber;
	private String FlatNumber;
	private String FloorNumber;
	private String Block;
	private Integer NoOfMembers;
	private Float Area;
	public Resident() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(Integer contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getFlatNumber() {
		return FlatNumber;
	}
	public void setFlatNumber(String flatNumber) {
		FlatNumber = flatNumber;
	}
	public String getFloorNumber() {
		return FloorNumber;
	}
	public void setFloorNumber(String floorNumber) {
		FloorNumber = floorNumber;
	}
	public String getBlock() {
		return Block;
	}
	public void setBlock(String block) {
		Block = block;
	}
	public Integer getNoOfMembers() {
		return NoOfMembers;
	}
	public void setNoOfMembers(Integer noOfMembers) {
		NoOfMembers = noOfMembers;
	}
	public Float getArea() {
		return Area;
	}
	public void setArea(Float area) {
		Area = area;
	}
	

}
