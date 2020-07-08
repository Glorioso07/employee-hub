package com.employee.hub.repository;

import com.employee.hub.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    Department findByDepartmentCode(String departmentCode);

}
