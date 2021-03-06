package com.afroalko.employee.controller;

import com.afroalko.employee.manager.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VoteController {

    private EmployeeManager employeeManager;

    @Autowired
    public VoteController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping("/vote")
    public String showEmployees(Model model){
        model.addAttribute("employeeList", employeeManager.findAll());
        return "vote";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
