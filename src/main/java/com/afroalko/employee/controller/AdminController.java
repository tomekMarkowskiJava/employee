package com.afroalko.employee.controller;

import com.afroalko.employee.manager.EmployeeManager;
import com.afroalko.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private EmployeeManager employeeManager;

    @Autowired
    public AdminController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping
    public String adminMenu(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeList", employeeManager.findAll());
        return "admin";
    }

    @PostMapping
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeManager.add(employee);
        employee.setNumberOfVotes(0);
        model.addAttribute("employeeList", employeeManager.findAll());
        return "redirect:/admin";
    }
}
