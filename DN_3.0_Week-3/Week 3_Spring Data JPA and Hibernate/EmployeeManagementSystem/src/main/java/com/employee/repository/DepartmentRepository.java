package com.employee.repository;

import com.employee.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	
	//custom query methods
//	@Query("SELECT d FROM Department d WHERE d.name = ?1")
//    Optional<Department> findDepartmentByName(String name);
	
	//named query methods
	@Query(name = "Department.findByName")
    Optional<Department> findDepartmentByName(String name);

}
