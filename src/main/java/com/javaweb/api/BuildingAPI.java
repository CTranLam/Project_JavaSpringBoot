package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customexception.FieldRequiredException;
import com.javaweb.customexception.ValidNumException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.service.BuildingService;

// Presentation Layer
@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	@PostMapping("/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam(value = "name" ,required = false)String name,
										@RequestParam(value = "districtId" ,required = false)Long district,
										@RequestParam(value = "typeCode" ,required = false) List<String>typecode){
		List<BuildingDTO> result = buildingService.findAll(name,district);
		return result;
	}

	@GetMapping("/api/building/")
	public Object getBuildingTwo(@RequestParam(value = "name", required = false) String nameBuilding,
								@RequestParam(value = "numberOfBasement" ,required = false) Integer num,
								@RequestParam(value = "ward", required = false) String ward,
								@RequestParam(value = "street", required = false) String street){
		validNum(nameBuilding,num,ward,street);
		BuildingDTO build = new BuildingDTO();
		build.setName(nameBuilding);
		build.setNumberOfBasement(num);
		return build;
	}
	public void validNum(String nameBuilding,Integer num,String ward,String street) {
		if( num == null || num < 0) {
			throw new ValidNumException("Num is null or smaller 0");
		}
	}
	
	
	@DeleteMapping("/api/building/{id}/{name}")
	public void deleteBuilding(@PathVariable Integer id, 
							@PathVariable String name) {
		System.out.print("Da xoa toa nha co id la " + id +" va ten la " +name + " roi nhe");
	}
}