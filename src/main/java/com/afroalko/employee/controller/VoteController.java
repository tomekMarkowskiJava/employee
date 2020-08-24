package com.afroalko.employee.controller;

import com.afroalko.employee.manager.EmployeeManager;
import com.afroalko.employee.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    private EmployeeManager employeeManager;

    public VoteController() {
    }

    @GetMapping("/vote")
    public Iterable<Employee> showEmployees(){
        employeeManager.add(new Employee("Tomek"));
        employeeManager.add(new Employee("Julia"));
        return employeeManager.findAll();
    }
}
