package com.employee.hub.service;

import com.employee.hub.entity.Employee;
import com.employee.hub.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static int inserted = 0;
    private static int updated = 0;

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findById(Integer id) {
        return this.employeeRepository.findById(id);
    }

    public Iterable<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        final Employee savedEmployee = this.employeeRepository.findByEmployeeCode(employee.getEmployeeCode());
        if (savedEmployee != null) {
            employee.setId(savedEmployee.getId());
            updated++;
        } else {
            inserted++;
        }
        return this.employeeRepository.save(employee);
    }

    public int getInserted() {
        return inserted;
    }

    public int getUpdated() {
        return updated;
    }

    public void resetResults () {
        inserted = 0;
        updated = 0;
    }
}
