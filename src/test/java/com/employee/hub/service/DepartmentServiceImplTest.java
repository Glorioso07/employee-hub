package com.employee.hub.service;

import com.employee.hub.entity.Department;
import com.employee.hub.repository.DepartmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceImplTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;

    @Test
    public void insertEmployeeOk() {
        final Department department = new Department();
        this.departmentServiceImpl.save(department);
        Mockito.verify(departmentRepository).save(Mockito.any(Department.class));
    }

    @Test
    public void updatedEmployeeOk() {
        final Department department = new Department();
        department.setDepartmentCode("departmentCode");
        Mockito.when(this.departmentRepository.findByDepartmentCode(Mockito.anyString())).thenReturn(department);
        this.departmentServiceImpl.save(department);
        Mockito.verify(this.departmentRepository).save(Mockito.any(Department.class));
    }
}
