package com.etisalat.demo;

class EmployeeNotFoundException extends RuntimeException {

	 public EmployeeNotFoundException(Long id) {
	    super("Could not find employee " + id);
	  }
	}
