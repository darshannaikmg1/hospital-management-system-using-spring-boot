package org.jsp.hospitalmanagmentsystem.controller;

import java.util.List;

import org.jsp.hospitalmanagmentsystem.dto.Hospital;
import org.jsp.hospitalmanagmentsystem.dto.ResponseStructure;
import org.jsp.hospitalmanagmentsystem.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="hospital")
public class HospitalController {
	@Autowired
	private HospitalService hospitalservice;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseStructure<Hospital> saveHospital(@RequestBody Hospital hospital){
		return hospitalservice.saveHospital(hospital);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital){
		return hospitalservice.updateHospital(hospital);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> findById(@PathVariable int id) {
		return hospitalservice.findById(id);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return hospitalservice.deleteById(id);
	}
	
	@GetMapping(value="/gstNumber/{gstnumber}")
	public ResponseEntity<ResponseStructure<Hospital>> findBygstNumber(@PathVariable(name="gstnumber") String gstnumber) {
		return hospitalservice.findBygstNumber(gstnumber);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Hospital>>> findAll() {
		return hospitalservice.findAll();
	}
}
