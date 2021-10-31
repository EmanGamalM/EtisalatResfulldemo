package com.etisalat.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Department {
	@Id
	@GeneratedValue
	@Column(name = "department_id")
	private Long id;
	@Column(name="department_name",length = 30)
	private String departmentName;
	
	@JsonBackReference
	//@JsonIgnore//to prevent the infinite recursion of the manager which is employee and this employee has its data so render what we need also.
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="manager_id",nullable = true)
	private Employee manager;
	
	@JsonIgnore//to prevent this list to appear at response at the manager property at Employee which made  infinite recursion due to bi-directional relation which made response serialization problem 
	@OneToMany(mappedBy ="department",fetch = FetchType.LAZY)//one department has many employees
	Set<Employee> employees = new HashSet<Employee>();

	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Department(String departmentName, Employee manager) {
		super();
		this.departmentName = departmentName;
		this.manager = manager;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public Employee getManager() {
		return manager;
	}


	public void setManager(Employee manager) {
		this.manager = manager;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
		for(Employee emp : employees)
			emp.setDepartment(this);
	}


	@Override
	public int hashCode() {
		return Objects.hash(departmentName, employees, id, manager);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(departmentName, other.departmentName) && Objects.equals(employees, other.employees)
				&& Objects.equals(id, other.id) && Objects.equals(manager, other.manager);
	}


	
	
	

}
