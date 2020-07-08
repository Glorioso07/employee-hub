package com.employee.hub.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;

public class CellUtilTest {

    @Test
    public void sanitizeCellValueCellNull() {
        Assert.assertNull(CellUtil.sanitizeCellValue(null));
    }

    @Test
    public void sanitizeCellValueCellStringEmpty() {
        final Row row = new XSSFWorkbook().createSheet().createRow(0);
        row.createCell(0).setCellValue("");
        Assert.assertEquals("", CellUtil.sanitizeCellValue(row.getCell(0)));
    }

    @Test
    public void sanitizeCellValueCellStringWithSpaces() {
        final Row row = new XSSFWorkbook().createSheet().createRow(0);
        row.createCell(0).setCellValue(" a ");
        Assert.assertEquals("a", CellUtil.sanitizeCellValue(row.getCell(0)));
    }

    @Test
    public void formatDepartmentCodeCellNull() {
        Assert.assertNull(CellUtil.formatDepartmentCode(null));
    }

    @Test
    public void formatDepartmentCodeCellNumericWithZero() {
        final Row row = new XSSFWorkbook().createSheet().createRow(0);
        row.createCell(0).setCellValue(777.0);
        Assert.assertEquals("777", CellUtil.formatDepartmentCode(row.getCell(0)));
    }

    @Test
    public void formatDepartmentCodeCellStringWithSpace() {
        final Row row = new XSSFWorkbook().createSheet().createRow(0);
        row.createCell(0).setCellValue("1234 ");
        Assert.assertEquals("1234", CellUtil.formatDepartmentCode(row.getCell(0)));
    }

}
