package com.javaweb.repository.SQLQuery;

import com.javaweb.model.BuildingRequestDTO;

public class BuildingSQLBuilder {
	 public static String buildQuery (BuildingRequestDTO buildingRequestDTO) {
		 StringBuilder sql = new StringBuilder("select b.*,d.name as districtName,ra.value from building b");
			sql.append(" LEFT JOIN district d on b.districtid = d.id");
			sql.append(" LEFT JOIN rentarea ra on b.id = ra.buildingid");
			sql.append(" WHERE 1=1");
			if (buildingRequestDTO.getDistrictId() != null) {
				sql.append(" AND b.districtid = "+ buildingRequestDTO.getDistrictId());
			}
			if( buildingRequestDTO.getName() != null && !buildingRequestDTO.getName().equals("")) {
				sql.append(" AND b.name like '%" + buildingRequestDTO.getName()+"%' ");
			}
			if(buildingRequestDTO.getNumberOfBasement() != null) {
				sql.append(" AND b.numberofbasement ="+ buildingRequestDTO.getNumberOfBasement() +" ");
			}
			if(buildingRequestDTO.getStreet() != null && !buildingRequestDTO.getStreet().equals("")) {
				sql.append(" AND b.street = '" + buildingRequestDTO.getStreet() +"' ");
			}
			if(buildingRequestDTO.getWard() != null && !buildingRequestDTO.getWard().equals("")) {
				sql.append(" AND b.ward = '" + buildingRequestDTO.getWard() +"' ");
			}
			if(buildingRequestDTO.getFloorArea() != null) {
				sql.append(" AND b.floorarea =" + buildingRequestDTO.getFloorArea());
			}
			if (buildingRequestDTO.getAreaMin() != null) {
			    sql.append(" AND b.floorarea >= " + buildingRequestDTO.getAreaMin() + " ");
			}

			if (buildingRequestDTO.getAreaMax() != null) {
			    sql.append(" AND b.floorarea <= " + buildingRequestDTO.getAreaMax() + " ");
			}
			if (buildingRequestDTO.getDirection() != null && !buildingRequestDTO.getDirection().equals("")) {
			    sql.append(" AND b.direction = '").append(buildingRequestDTO.getDirection()).append("' ");
			}

			if (buildingRequestDTO.getLevel() != null && !buildingRequestDTO.getLevel().equals("")) {
			    sql.append(" AND b.level = '").append(buildingRequestDTO.getLevel()).append("' ");
			}
			if (buildingRequestDTO.getPriceMin() != null) {
			    sql.append(" AND b.rentprice >= ").append(buildingRequestDTO.getPriceMin()).append(" ");
			}
			if (buildingRequestDTO.getPriceMax() != null) {
			    sql.append(" AND b.rentprice <= ").append(buildingRequestDTO.getPriceMax()).append(" ");
			}
			return sql.toString();
	 }
}
