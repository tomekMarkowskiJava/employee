package com.afroalko.employee.manager;

import com.afroalko.employee.model.Employee;
import com.afroalko.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManager {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeManager(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee add(Employee employee){
        return employeeRepo.save(employee);
    }

    public Iterable<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Employee findyByName(String name){return employeeRepo.findByName(name);}

    public void clear() {
        employeeRepo.deleteAll();
    }
}
