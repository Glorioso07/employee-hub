package com.employee.hub.service;

import com.employee.hub.entity.Employee;

import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> findById(Integer id);

    Iterable<Employee> findAll();

    Employee save(Employee employee);

    int getInserted();

    int getUpdated();

    void resetResults();
}
