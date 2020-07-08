package com.employee.hub.service;

import com.employee.hub.entity.Department;
import com.employee.hub.entity.Employee;
import com.employee.hub.entity.EmployeeAddress;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;

@Service
public class ImporterServiceImpl implements ImporterService {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;
    private final EmployeeAddressService employeeAddressService;

    public ImporterServiceImpl(DepartmentService departmentService, EmployeeService employeeService, EmployeeAddressService employeeAddressService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.employeeAddressService = employeeAddressService;
    }

    public void parseAndStore(MultipartFile file) throws IOException {
        final Iterator<Row> rowIterator = new XSSFWorkbook(file.getInputStream()).getSheetAt(0).iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            final Row row = rowIterator.next();
            final Department department = this.departmentService.save(new Department(row));
            final Employee employee = this.employeeService.save(new Employee(row, department));
            this.employeeAddressService.save(new EmployeeAddress(row, employee));
        }
    }
}
