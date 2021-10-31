package com.dtcc.dao;

import com.dtcc.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    public List<Employee> getEmployees();  //all employees

    public void saveEmployee(Employee theEmployee); //save employee

    public Employee getEmployee(Long theId); //get a employee by id

    public void deleteEmployee(Long theId); //delete employee

}
