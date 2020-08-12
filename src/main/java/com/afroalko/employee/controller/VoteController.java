package com.afroalko.employee.controller;

import com.afroalko.employee.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VoteController {

    private List<Employee> employees;

    public VoteController() {
        this.employees = new ArrayList<>();
        employees.add(new Employee("Tomek"));
        employees.add(new Employee("Julia"));
    }

    @GetMapping("/vote")
    public String showEmployees(){
        return employees.get(0).getName();
    }
}
