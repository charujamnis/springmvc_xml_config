package com.dtcc.controller;

import com.dtcc.entity.Employee;
import com.dtcc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    public EmployeeController() {
    }

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        System.out.println("in list Employees");
        List<Employee> employees=employeeService.getEmployees();
        model.addAttribute("employees",employees);
        return "list-employees";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employee-form";
    }

    @PostMapping("/saveEmployee")
    public String saveCustomer(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.saveEmployee(theEmployee);
        return "redirect:/employee/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("employeeId") Long theId,
                                    Model theModel) {
        Employee theEmployee = employeeService.getEmployee(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") Long theId) {
        employeeService.deleteEmployee(theId);
        return "redirect:/employee/list";
    }
}
