package com.javaweb.model;

public class BuildingRequestDTO {
	private String name;
	private String street;
	private String ward;
	private Integer districtId;
	private Integer floorArea;
	private Integer numberOfBasement;
	private String direction;
	private String level;
	private Integer areaMin,areaMax;
	private Integer priceMin,priceMax;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getAreaMin() {
		return areaMin;
	}
	public void setAreaMin(Integer areaMin) {
		this.areaMin = areaMin;
	}
	public Integer getAreaMax() {
		return areaMax;
	}
	public void setAreaMax(Integer areaMax) {
		this.areaMax = areaMax;
	}
	public Integer getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(Integer priceMin) {
		this.priceMin = priceMin;
	}
	public Integer getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(Integer priceMax) {
		this.priceMax = priceMax;
	}
	
	
}
