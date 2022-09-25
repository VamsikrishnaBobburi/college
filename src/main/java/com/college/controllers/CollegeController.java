package com.college.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.college.Entity.College;

import com.college.Model.CollegeImpl;
import com.college.Repository.CollegeRepositroy;



@RestController
@RequestMapping("/College")
public class CollegeController {
	
	@Autowired
	private CollegeRepositroy centerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path ="/add")
	public ResponseEntity<College> addCitizen(@RequestBody College college) {
		
		College vaccinationCenterAdded = centerRepo.save(college);
		return new ResponseEntity<>(college, HttpStatus.OK);
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<CollegeImpl> getAllDadaBasedonCenterId(@PathVariable Integer id){
		CollegeImpl requiredResponse =  new CollegeImpl();
	
		College center  = centerRepo.findById(id).get();
		requiredResponse.setCenter(center);
		

		
		java.util.List<College> listOfCitizens = restTemplate.getForObject("http://STUDENT-LIST/citizen/id/"+id, List.class);
		requiredResponse.setCitizens(listOfCitizens);
		return new ResponseEntity<CollegeImpl>(requiredResponse, HttpStatus.OK);
	}
	
	
	
	
	

}
