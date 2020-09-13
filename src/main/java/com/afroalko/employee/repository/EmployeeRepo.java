package com.afroalko.employee.repository;

import com.afroalko.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {

    Employee findByName(String name);
}
