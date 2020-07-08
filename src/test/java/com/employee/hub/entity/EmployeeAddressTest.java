package com.employee.hub.entity;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeAddressTest {

    @Test
    public void constructorFieldsAreOk() {
        final String addressLine1 = "addressLine1";
        final String addressLine2 = "addressLine2";
        final String addressTown = "addressTown";
        final String addressPostcode = "addressPostcode";
        final String addressCountry = "addressCountry";
        final String current = "FALSE";
        final boolean isCurrent = false;

        final Row row = new XSSFWorkbook().createSheet().createRow(0);
        row.createCell(9).setCellValue(addressLine1);
        row.createCell(10).setCellValue(addressLine2);
        row.createCell(11).setCellValue(addressTown);
        row.createCell(12).setCellValue(addressPostcode);
        row.createCell(13).setCellValue(addressCountry);
        row.createCell(14).setCellValue(current);

        final EmployeeAddress employeeAddress = new EmployeeAddress(row, null);
        Assert.assertEquals(addressLine1, employeeAddress.getAddressLine1());
        Assert.assertEquals(addressLine2, employeeAddress.getAddressLine2());
        Assert.assertEquals(addressTown, employeeAddress.getAddressTown());
        Assert.assertEquals(addressPostcode, employeeAddress.getAddressPostcode());
        Assert.assertEquals(addressCountry, employeeAddress.getAddressCountry());
        Assert.assertEquals(isCurrent, employeeAddress.isCurrent());
    }

}
