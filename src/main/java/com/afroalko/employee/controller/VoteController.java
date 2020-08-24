package com.afroalko.employee.controller;

import com.afroalko.employee.manager.EmployeeManager;
import com.afroalko.employee.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VoteController {

    private EmployeeManager employeeManager;

    public VoteController() {
        employeeManager.add(new Employee("Tomek"));
        employeeManager.add(new Employee("Julia"));
    }

    @GetMapping("/vote")
    public Iterable<Employee> showEmployees(){
        return employeeManager.findAll();
    }
}
