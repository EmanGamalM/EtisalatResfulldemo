package com.etisalat.demo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private Long id;
	@Column(name = "first_name", nullable = false, length = 20)
	@Size(min = 2)
	private String firstName;
	@Column(name = "last_name", length = 25, nullable = false)
	@Size(min = 2)
	private String lastName;
	@Column(length = 25)
	private String email;
	@Column(name = "phone_number", length = 20)
	private String phoneNumber;

	@Temporal(TemporalType.DATE) // to save only the Date withhout time
	@Column(name = "hire_date")
	private Date hireDate;
	@Column(precision = 8, scale = 2)
	private BigDecimal salary;

	@ManyToOne // many employee at one department
	@JoinColumn(name = "department_id")
	private Department department;
	// >>>>self join//many employee has one manger
	//@JsonView(Views.Internal.class)
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;

	@JsonIgnore//to prevent recursion problem when get the manager data which has list of employee ..we need only the manager data itself to be rendered 
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)//
	private Set<Employee> mangerTeam = new HashSet<Employee>();

	
	// >>>>

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(@Size(min = 2) String first_name, @Size(min = 2) String last_name, String email,
			String phone_number, Date hire_date, BigDecimal salary) {
		super();

		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.phoneNumber = phone_number;
		this.hireDate = hire_date;
		this.salary = salary;
	}

	public Employee(@Size(min = 2) String first_name, @Size(min = 2) String last_name) {
		super();
		this.firstName = first_name;
		this.lastName = last_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Employee> getMangerTeam() {
		return mangerTeam;
	}

	public void setMangerTeam(Set<Employee> mangerTeam) {
		this.mangerTeam = mangerTeam;
		for(Employee emp  : mangerTeam)
			emp.setManager(this);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", salary=" + salary + ", department="
				+ department + ", manager=" + manager + ", mangerTeam=" + mangerTeam + "]";
	}

}
