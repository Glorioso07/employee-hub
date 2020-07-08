package com.employee.hub.entity;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;

public class DepartmentTest {

    @Test
    public void constructorFieldsAreOk() {
        final String departmentCode = "1234";
        final String departmentName = "departmentName";

        final Row row = new XSSFWorkbook().createSheet().createRow(0);
        row.createCell(7).setCellValue(departmentCode);
        row.createCell(8).setCellValue(departmentName);

        final Department department = new Department(row);
        Assert.assertEquals(departmentCode, department.getDepartmentCode());
        Assert.assertEquals(departmentName, department.getDepartmentName());
    }

}
