package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingRequestDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

//Business Logic Layer
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public List<BuildingDTO> findAll(BuildingRequestDTO buildingRequestDTO) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingRequestDTO);
		List<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setAddress(item.getStreet() +", " + item.getWard() + ", " +item.getDistrictEntity().getName());
			building.setNumberOfBasement(item.getNumberOfBasement());
			building.setFloorArea(item.getFloorArea());
			building.setLevel(item.getLevel());
			building.setRentPrice(item.getRentPrice());
			String rentAreaValue="";
			List<Integer> l=item.getRentArea();
			for(int i= 0 ; i <l.size(); i++) {
				if(i != l.size()-1) rentAreaValue += l.get(i) +", ";
				else rentAreaValue += l.get(i);
			}
			building.setRentAreaValue(rentAreaValue);
			result.add(building);
		}
		return result;
	}
	
}