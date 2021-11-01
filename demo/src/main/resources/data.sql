insert into  department(department_id,department_name)  values (1,'HR');
insert into  department(department_id,department_name)  values (2,'Development');
insert into  department(department_id,department_name)  values (3,'QA');

insert into  employee(employee_id ,first_name ,last_name,department_id,hire_date) values (1,'samar','Gamal',2,TO_date('12/12/2012','dd/mm/yyyy'));
insert into  employee(employee_id ,first_name ,last_name,department_id) values (2,'salem','ali',2);
insert into  employee(employee_id ,first_name ,last_name,department_id) values (3,'joe','mostafa',2);
insert into  employee(employee_id ,first_name ,last_name,department_id) values (4,'karimaa','maohmed',2);
insert into  employee(employee_id ,first_name ,last_name,department_id) values (5,'Moamed','Ali',3);
insert into  employee(employee_id ,first_name ,last_name,department_id) values (6,'mareya','Ali',3);
insert into  employee(employee_id ,first_name ,last_name,department_id) values (7,'sara','Ali',3);
insert into  employee(employee_id ,first_name ,last_name,department_id) values (8,'esraa','Gamal',1);
insert into  employee(employee_id ,first_name ,last_name,department_id) values (9,'karam','soltan',1);

insert into  employee(employee_id ,first_name ,last_name,department_id) values (10,'mohab','ahmed',1);

insert into  employee(employee_id ,first_name ,last_name,department_id) values (11,'salma','gaber',1);

---insert into  department(department_id,department_name,manager_id)  values (1,'HR',1);
update  department set manager_id=8 where department_id =1;
update  department set manager_id=4 where department_id =2;
update  department set manager_id=7 where department_id =3;
--EMPLOYEE_ID  	EMAIL  	FIRST_NAME  	HIRE_DATE  	LAST_NAME  	PHONE_NUMBER  	SALARY  	DEPARTMENT_ID  	MANAGER_ID
update employee set MANAGER_ID = 1 where employee_id != 1;