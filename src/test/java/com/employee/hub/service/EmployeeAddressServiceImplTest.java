package com.employee.hub.service;

import com.employee.hub.entity.Employee;
import com.employee.hub.entity.EmployeeAddress;
import com.employee.hub.repository.EmployeeAddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeAddressServiceImplTest {

    @Mock
    private EmployeeAddressRepository employeeAddressRepository;

    @InjectMocks
    private EmployeeAddressServiceImpl employeeAddressServiceImpl;

    @Test
    public void insertEmployeeAddressOk() {
        final EmployeeAddress employeeAddress = new EmployeeAddress();
        this.employeeAddressServiceImpl.save(employeeAddress);
        Mockito.verify(this.employeeAddressRepository).save(Mockito.any(EmployeeAddress.class));
    }

    @Test
    public void updatedEmployeeAddressesAndUpdateCurrentAddressesOk() {
        final EmployeeAddress employeeAddress = new EmployeeAddress();
        final Employee employee = new Employee();
        employee.setId(1);
        employeeAddress.setCurrent(true);
        employeeAddress.setEmployee(employee);
        this.employeeAddressServiceImpl.save(employeeAddress);
        Mockito.verify(this.employeeAddressRepository).updateCurrentAddresses(Mockito.anyInt(), Mockito.anyBoolean());
        Mockito.verify(this.employeeAddressRepository).save(Mockito.any(EmployeeAddress.class));
    }
}
