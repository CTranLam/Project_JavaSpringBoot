package com.javaweb.model;

public class BuildingDTO {
	// Doi tuong model tra ra cho client 
	private String name;
	private Integer numberOfBasement;
	private String address;
	private Integer floorArea;
	private Integer rentPrice;
	private String level;
	private String rentAreaValue;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}
	public Integer getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getRentAreaValue() {
		return rentAreaValue;
	}
	public void setRentAreaValue(String rentAreaValue) {
		this.rentAreaValue = rentAreaValue;
	}
	
}