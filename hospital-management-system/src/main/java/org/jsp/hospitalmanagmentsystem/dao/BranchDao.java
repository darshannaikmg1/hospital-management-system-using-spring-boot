package org.jsp.hospitalmanagmentsystem.dao;

import java.util.List;
import java.util.Optional;


import org.jsp.hospitalmanagmentsystem.dto.Branch;
import org.jsp.hospitalmanagmentsystem.respository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BranchDao {
	@Autowired
 private BranchRepository repository;
 
 public Branch SaveBranch( Branch b) {
	 return repository.save(b);
 }
 public Optional<Branch> findById(int id){
	 return repository.findById(id);
 }
 public List<Branch> findByNam(String name){
	 return repository.findByName(name);
 }

}
