package com.etisalat.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

	@Modifying
	@Query(value="update Employee set manager_id= null where manager_id = :mangerId", nativeQuery=true)
	void removeEmployeeManager(Long mangerId);
	
	@Modifying
	@Query(value="update Department set manager_id= null where manager_id = :mangerId", nativeQuery=true)
	void removeDepartementManager(Long mangerId);

}
