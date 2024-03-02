package org.jsp.hospitalmanagmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.jsp.hospitalmanagmentsystem.dao.HospitalDao;
import org.jsp.hospitalmanagmentsystem.dto.Hospital;
import org.jsp.hospitalmanagmentsystem.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao hospitaldao;
	
	public ResponseStructure<Hospital> saveHospital(Hospital hospital){
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		
		structure.setMessage("Hsopital saved");
		structure.setData(hospital);
		structure.setStatus_code(HttpStatus.OK.value());
		return structure;
	}
	
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital){
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		Optional<Hospital> recHospital= hospitaldao.findById(hospital.getHospital_id());
		
		if(recHospital.isPresent()) {
			Hospital dbhospital=recHospital.get();
			dbhospital.setHospital_name(hospital.getHospital_name());
			dbhospital.setHospital_gstnumber(hospital.getHospital_gstnumber());
			dbhospital.setHospital_founder(hospital.getHospital_founder());
			dbhospital.setHospital_Established_date(hospital.getHospital_Established_date());
			
			hospitaldao.saveHospital(dbhospital);
			structure.setMessage("updated hospital");
			structure.setData(dbhospital);
			structure.setStatus_code(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> findById(int id){
		Optional<Hospital> rechospital=hospitaldao.findById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if(rechospital.isPresent()) {
			structure.setMessage("Hsopital found");
			structure.setData(rechospital.get());
			structure.setStatus_code(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> findBygstNumber(String gst_number){
		Optional<Hospital> rechospital=hospitaldao.findByGst(gst_number);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if(rechospital.isPresent()) {
			structure.setMessage("Hsopital found");
			structure.setData(rechospital.get());
			structure.setStatus_code(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<ResponseStructure<Hospital>> findBygstFounder(String founder){
		Optional<Hospital> rechospital=hospitaldao.findByFounder(founder);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if(rechospital.isPresent()) {
			structure.setMessage("Hsopital found");
			structure.setData(rechospital.get());
			structure.setStatus_code(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteById(int id){
		Optional<Hospital> rechospital= hospitaldao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if(rechospital.isPresent()) {
			structure.setMessage("HOSPITAL FOUND");
			structure.setData("HOSPITAL DELETED");
			structure.setStatus_code(HttpStatus.OK.value());
			hospitaldao.deleteById(id);
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		structure.setMessage("Merchant Not found");
		structure.setData("cannot delete merchant as Id is Invalid");
		structure.setStatus_code(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<ResponseStructure<List<Hospital>>> findAll(){
		List<Hospital> rechospital = hospitaldao.findAll();
		ResponseStructure<List<Hospital>> structure = new ResponseStructure<>();
		structure.setMessage("ALL HOSPITALS DISPLAYED");
		structure.setData(rechospital);
		structure.setStatus_code(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(HttpStatus.OK);
		
	}
	
	
	
	
}
