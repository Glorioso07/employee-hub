package com.employee.hub.service;

import com.employee.hub.entity.Employee;
import com.employee.hub.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @Test
    public void insertEmployeeOk() {
        final Employee employee = new Employee();
        this.employeeServiceImpl.save(employee);
        Mockito.verify(this.employeeRepository).save(Mockito.any(Employee.class));
    }

    @Test
    public void updatedEmployeeOk() {
        final Employee employee = new Employee();
        employee.setEmployeeCode("employeeCode");
        Mockito.when(this.employeeRepository.findByEmployeeCode(Mockito.anyString())).thenReturn(employee);
        this.employeeServiceImpl.save(employee);
        Mockito.verify(this.employeeRepository).save(Mockito.any(Employee.class));
    }
}
