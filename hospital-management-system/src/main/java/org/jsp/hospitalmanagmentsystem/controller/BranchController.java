package org.jsp.hospitalmanagmentsystem.controller;



import java.util.List;


import org.jsp.hospitalmanagmentsystem.dto.Branch;
import org.jsp.hospitalmanagmentsystem.dto.ResponseStructure;
import org.jsp.hospitalmanagmentsystem.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BranchController {
	@Autowired
 private BranchService service;
	
	
	  @PostMapping("/branch")
	  public ResponseStructure<Branch> SaveUser(@RequestBody Branch b) {
		  return service.saveBranch(b);
	  }
	  
	  @GetMapping("branch/{id}")
	  public ResponseEntity<ResponseStructure<Branch>> FindById(@PathVariable(name="id") int id) {
		 
		 return service.FindById(id);
		 
		 
	  }
	  
	  @GetMapping("users/{name}")
	  public List<Branch> findByName(@PathVariable String name){
		  return service.findByName(name);
	  }
}
