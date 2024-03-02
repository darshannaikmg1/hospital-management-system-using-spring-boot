package org.jsp.hospitalmanagmentsystem.dao;


import java.util.List;
import java.util.Optional;

import org.jsp.hospitalmanagmentsystem.dto.Hospital;
import org.jsp.hospitalmanagmentsystem.respository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepository hospitalrepository;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalrepository.save(hospital);
	}
	
	
	
	public Optional<Hospital> findById(int id) {
		return hospitalrepository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<Hospital> rechospital= findById(id);
		if(rechospital.isPresent()) {
			hospitalrepository.delete(rechospital.get());
			return true;
		}
		return false;
	}
	
	public Optional<Hospital> findByGst(String gst_number) {
		return hospitalrepository.findBygstNumber(gst_number);
	}
	
	public Optional<Hospital> findByFounder(String Founder) {
		return hospitalrepository.findByFounder(Founder);
	}
	
	public List<Hospital> findAll(){
		return hospitalrepository.findAll();
	}
}

