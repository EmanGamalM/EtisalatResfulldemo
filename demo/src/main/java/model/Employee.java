package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long employee_id;
	@Column(nullable = false, length = 20)
	@Size(min = 2)
	private String first_name;
	@Column(length = 25, nullable = false)
	@Size(min = 2)
	private String last_name;
	@Column(length = 25)
	private String email;
	@Column(length = 20)
	private String phone_number;

	@Temporal(TemporalType.DATE) // to save only the Dte withhout time
	@Column
	private Date hire_date;
	@Column(precision = 8, scale = 2)
	private BigDecimal salary;

	private Long manager_id;

	private Long department_id;
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Employee( @Size(min = 2) String first_name, @Size(min = 2) String last_name, String email,
			String phone_number, Date hire_date, BigDecimal salary) {
		super();
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.salary = salary;
	}


	public Employee(@Size(min = 2) String first_name, @Size(min = 2) String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}


	public Employee( @Size(min = 2) String first_name, @Size(min = 2) String last_name, String email,
			String phone_number, Date hire_date, BigDecimal salary, Long manager_id, Long department_id) {
		super();
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.salary = salary;
		this.manager_id = manager_id;
		this.department_id = department_id;
	}


	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Long getManager_id() {
		return manager_id;
	}

	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}

	public Long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}


	@Override
	public String toString() {
		return "Employees [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone_number=" + phone_number + ", hire_date=" + hire_date + ", salary="
				+ salary + ", manager_id=" + manager_id + ", department_id=" + department_id + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(department_id, email, employee_id, first_name, hire_date, last_name, manager_id,
				phone_number, salary);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department_id, other.department_id) && Objects.equals(email, other.email)
				&& Objects.equals(employee_id, other.employee_id) && Objects.equals(first_name, other.first_name)
				&& Objects.equals(hire_date, other.hire_date) && Objects.equals(last_name, other.last_name)
				&& Objects.equals(manager_id, other.manager_id) && Objects.equals(phone_number, other.phone_number)
				&& Objects.equals(salary, other.salary);
	}
	
	
	
	

}
