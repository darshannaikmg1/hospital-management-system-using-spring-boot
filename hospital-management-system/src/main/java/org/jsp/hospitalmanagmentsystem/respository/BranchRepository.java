package org.jsp.hospitalmanagmentsystem.respository;

import java.util.List;
import java.util.Optional;

import org.jsp.hospitalmanagmentsystem.dto.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
	
	@Query("select b from Branch b where b.name=1?")
	public List<Branch> findByName(String name);
           
}
