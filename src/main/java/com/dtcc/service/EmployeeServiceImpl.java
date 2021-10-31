package com.dtcc.service;

import com.dtcc.dao.EmployeeDao;
import com.dtcc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDAO){
        this.employeeDao=employeeDAO;
    }
    public EmployeeServiceImpl() {
    }

    public EmployeeDao getEmployeeDAO() {
        return employeeDao;
    }

    public void setEmployeeDAO(EmployeeDao employeeDAO) {
        this.employeeDao = employeeDAO;
    }

    @Override
    public List<Employee> getEmployees() {

        return employeeDao.getEmployees();
    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        employeeDao.saveEmployee(theEmployee);
    }

    @Override
    public Employee getEmployee(Long theId) {
        return employeeDao.getEmployee(theId);
    }

    @Override
    public void deleteEmployee(Long theId) {
        employeeDao.deleteEmployee(theId);
    }
}
