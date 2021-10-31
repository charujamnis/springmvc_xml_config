package com.dtcc.service;

import com.dtcc.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employee> getEmployees();  //all employees

    public void saveEmployee(Employee theEmployee); //save employee

    public Employee getEmployee(Long theId); //get a employee by id

    public void deleteEmployee(Long theId); //delete employee
}
