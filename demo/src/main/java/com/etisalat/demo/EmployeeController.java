package com.etisalat.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="http://localhost:4200")//accept requests from angular only
@RestController 
public class EmployeeController {
	@Autowired
	 EmployeeRepository empRepo;

	

	//
	@GetMapping("/employees")
	List<Employee> all() {
//listAll
		List<Employee> employees = empRepo.findAll();
		if(employees.isEmpty()) {
System.out.println("noo data loaded");	
}		
		//employees.stream().forEach(e->{if(e.getManager() != null)e.getManager().setManager(null);});
		return employees;
	}

	// get one by Id
	@GetMapping("/employees/{id}")
	Employee one(@org.springframework.web.bind.annotation.PathVariable Long id) {

		Optional<Employee> findById = empRepo.findById(id);
		Employee employee = findById.orElseThrow(() -> new EmployeeNotFoundException(id));

		return employee;
	}

	// add

	@PostMapping("/employees")
	Employee createEmployee(@RequestBody Employee newEmployee) {
		newEmployee.getFirstName();
		return empRepo.save(newEmployee);
	}

	// update >>for test update name
	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return empRepo.findById(id).map(employee -> {
			
			employee.setFirstName(newEmployee.getFirstName());
			employee.setLastName(newEmployee.getLastName());
			employee.setEmail(newEmployee.getEmail());
			employee.setPhoneNumber(newEmployee.getPhoneNumber());
			return empRepo.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return empRepo.save(newEmployee);
		});
	}
	//delete byId
	
	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id){
		empRepo.deleteById(id);
		
	}
	
	//delete All
	@DeleteMapping("/employees")
	void deleteEmployee(){
		empRepo.deleteAll();
		
	}
	

}
