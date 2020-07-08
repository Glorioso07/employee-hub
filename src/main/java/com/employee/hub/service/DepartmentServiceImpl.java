package com.employee.hub.service;

import com.employee.hub.entity.Department;
import com.employee.hub.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        final Department savedDepartment = this.departmentRepository.findByDepartmentCode(department.getDepartmentCode());
        if (savedDepartment != null) {
            department.setId(savedDepartment.getId());
        }
        return this.departmentRepository.save(department);
    }
}
