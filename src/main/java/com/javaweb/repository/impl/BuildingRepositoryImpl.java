package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingRequestDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.SQLQuery.BuildingSQLBuilder;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentaAreaEntity;

// Data Access Layer
@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS ="213205";
	@Override
	public List<BuildingEntity> findAll(BuildingRequestDTO buildingRequestDTO) {
		String sql = BuildingSQLBuilder.buildQuery(buildingRequestDTO);
		Map<Integer,BuildingEntity> mp = new LinkedHashMap<>();
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString())){
				
				while(rs.next()) {
					int buildingId = rs.getInt("id");
					if(mp.get(buildingId) == null) {
					    BuildingEntity building = new BuildingEntity();
					    building.setName(rs.getString("name"));
					    building.setStreet(rs.getString("street"));
					    building.setWard(rs.getString("ward"));
					    building.setNumberOfBasement(rs.getInt("numberofbasement"));
					    building.setFloorArea(rs.getInt("floorarea"));
					    building.setDirection(rs.getString("direction"));
					    building.setLevel(rs.getString("level"));
					    building.setRentPrice(rs.getInt("rentprice"));
					    DistrictEntity districtEntity = new DistrictEntity();
					    districtEntity.setId(rs.getInt("districtid"));
					    districtEntity.setName(rs.getString("districtName"));
					    building.setDistrictEntity(districtEntity);
					    List<Integer> list = new ArrayList<>(); 
					    list.add(rs.getInt("value"));
					    building.setRentArea(list);
					    mp.put(buildingId, building);
					}
					else {
						BuildingEntity building= mp.get(buildingId);
						building.getRentArea().add(rs.getInt("value"));
						mp.put(buildingId, building);
					}
				}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		List<BuildingEntity> result = new ArrayList<>(mp.values());
		return result;
	}
	
}