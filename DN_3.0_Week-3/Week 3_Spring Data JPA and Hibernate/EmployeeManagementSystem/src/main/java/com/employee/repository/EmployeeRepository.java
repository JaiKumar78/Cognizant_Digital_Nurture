package com.employee.repository;

import com.employee.model.Employee;
import com.employee.model.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
		
	
		// Define a projection interface
	    interface EmployeeNameProjection {
	        String getName();
	    }

	
		//custom query methods
//	  	@Query("SELECT e FROM Employee e WHERE e.name = ?1")
//	    List<Employee> findEmployeesByName(String name);
//
//	    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
//	    List<Employee> findEmployeesByEmail(String email);
//
//	    @Query("SELECT e FROM Employee e WHERE e.department.id = ?1")
//	    List<Employee> findEmployeesByDepartmentId(Long departmentId);
	    
	    // Define a query to fetch data into DTO
	    @Query("SELECT new com.employee.model.EmployeeDTO(e.name, e.email) FROM Employee e")
	    List<EmployeeDTO> findAllEmployeeDTOs();
	    
		Page<Employee> findAll(Pageable pageable);
	
		//named query methods
	    @Query(name = "Employee.findByName")
	    List<Employee> findEmployeesByName(String name);

	    @Query(name = "Employee.findByEmail")
	    List<Employee> findEmployeesByEmail(String email);
	    
	    @Query(name = "Employee.findByDepartmentId")
	    List<Employee> findEmployeesByDepartmentId(Long departmentId);
	    
	    

}
