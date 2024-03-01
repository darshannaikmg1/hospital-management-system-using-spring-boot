package org.jsp.hospitalmanagmentsystem.service;


import java.util.List;
import java.util.Optional;

import org.jsp.hospitalmanagmentsystem.dao.BranchDao;
import org.jsp.hospitalmanagmentsystem.dto.Branch;
import org.jsp.hospitalmanagmentsystem.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class BranchService {
	@Autowired
 private BranchDao dao;
 
	public ResponseStructure<Branch> saveBranch(Branch b) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		structure.setMessage("Branch Saved");
		structure.setData(dao.SaveBranch(b));
		structure.setStatus_code(HttpStatus.CREATED.value());
		return structure;
	}
	
	public ResponseEntity<ResponseStructure<Branch>> FindById(int id) {
		Optional<Branch> merch = dao.findById(id);
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (merch.isPresent()) {
			structure.setMessage("Branch Found");
			structure.setData(merch.get());
			structure.setStatus_code(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);

		}
		structure.setMessage("Branch Not Found");
		structure.setData(null);
		structure.setStatus_code(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.NOT_FOUND);

		

	}
	public List<Branch> findByName(String name) {
		return dao.findByNam(name);
	}


}
