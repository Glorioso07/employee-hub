package com.employee.hub.entity;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class EmployeeTest {

    @Test
    public void constructorFieldsAreOk() {
        final String employeeCode = "employeeCode";
        final String firstName = "firstName";
        final String lastName = "lastName";
        final String gender = "MALE";
        final Date date = new Date();
        final String contactNumber = "contactNumber";
        final String email = "email";

        final Row row = new XSSFWorkbook().createSheet().createRow(0);
        row.createCell(0).setCellValue(employeeCode);
        row.createCell(1).setCellValue(firstName);
        row.createCell(2).setCellValue(lastName);
        row.createCell(3).setCellValue(gender);
        row.createCell(4).setCellValue(date);
        row.createCell(5).setCellValue(contactNumber);
        row.createCell(6).setCellValue(email);

        final Employee employee = new Employee(row, null);
        Assert.assertEquals(employeeCode, employee.getEmployeeCode());
        Assert.assertEquals(firstName, employee.getFirstName());
        Assert.assertEquals(lastName, employee.getLastName());
        Assert.assertEquals(Employee.Gender.MALE, employee.getGender());
        Assert.assertEquals(date, employee.getDob());
        Assert.assertEquals(contactNumber, employee.getContactNumber());
        Assert.assertEquals(email, employee.getEmail());
    }

}
