package com.etisalat.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()//accept requests from angular only origins ="http://localhost:4200"
@RestController 
public class EmployeeController {
	@Autowired
	 EmployeeRepository empRepo;

	

	//
	@GetMapping("/employees")
	List<Employee> getAllEmployees()  {
//listAll
		List<Employee> employees = empRepo.findAll();	
		//employees.stream().forEach(e->{if(e.getManager() != null)e.getManager().setManager(null);});
		return employees;
	}

//getById
	
	 @GetMapping("/employees/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
	        throws ResourceNotFoundException {
	        Employee employee = empRepo.findById(employeeId)
	          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	        return ResponseEntity.ok().body(employee);
	    }

	// add

	@PostMapping("/employees")
	Employee createEmployee(@RequestBody Employee newEmployee) {
		
		return empRepo.save(newEmployee);
	}

	// update 
	@PutMapping("/employees/{id}")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) throws ResourceNotFoundException {

		Employee employee = empRepo.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		        employee.setEmail(newEmployee.getEmail());
		        employee.setLastName(newEmployee.getLastName());
		        employee.setFirstName(newEmployee.getFirstName());
		        final Employee updatedEmployee = empRepo.save(employee);
		        return ResponseEntity.ok(updatedEmployee);
		        }
	//delete byId
	
	
	
	@Transactional
	@DeleteMapping("/employees/{id}")
	 public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
	         throws ResourceNotFoundException {
		
	        Employee employee = empRepo.findById(employeeId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	        /*
	         * if the deleted employee is amanager then set the manager_id of   the employees under this manager by null 
	         *this is  because of the relations between the employee and manager 
	         */
	        empRepo.removeDepartementManager(employeeId);
	        empRepo.removeEmployeeManager(employeeId);
	        /*
	         * 
	         */
	        empRepo.delete(employee);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	
	

}
