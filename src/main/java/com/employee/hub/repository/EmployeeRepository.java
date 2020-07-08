package com.employee.hub.repository;

import com.employee.hub.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findByEmployeeCode(String employeeCode);

}
