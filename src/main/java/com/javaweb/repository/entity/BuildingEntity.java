package com.javaweb.repository.entity;

import java.util.List;

public class BuildingEntity {
	private String name;
	private Integer numberOfBasement;
	private String ward;
	private String street;
	private Integer floorArea;
	private String direction;
	private String level;
	private Integer rentPrice;
	private DistrictEntity districtEntity;
	private List<Integer> rentArea;
	
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
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}
	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
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
	public List<Integer> getRentArea() {
		return rentArea;
	}
	public void setRentArea(List<Integer> rentArea) {
		this.rentArea = rentArea;
	}
}
