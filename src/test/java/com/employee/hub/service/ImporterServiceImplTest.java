package com.employee.hub.service;

import com.employee.hub.entity.Department;
import com.employee.hub.entity.Employee;
import com.employee.hub.entity.EmployeeAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class ImporterServiceImplTest {

    @Mock
    private DepartmentService departmentService;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private EmployeeAddressService employeeAddressService;

    @InjectMocks
    private ImporterServiceImpl importerServiceImpl;

    @Test
    public void parseAndStoreOk() throws IOException {
        final String fileName = "src/test/resources/employeeHubImport.xlsx";
        this.importerServiceImpl.parseAndStore(new MockMultipartFile(fileName, new FileInputStream(new File(fileName))));
        Mockito.verify(this.departmentService, Mockito.times(52)).save(Mockito.any(Department.class));
        Mockito.verify(this.employeeService, Mockito.times(52)).save(Mockito.any(Employee.class));
        Mockito.verify(this.employeeAddressService, Mockito.times(52)).save(Mockito.any(EmployeeAddress.class));
    }
}
