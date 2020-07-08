package com.employee.hub.util;

import org.apache.poi.ss.usermodel.Cell;

import java.util.Objects;

public class CellUtil {

    public final static int EMPLOYEE_CODE = 0;
    public final static int FIRST_NAME = 1;
    public final static int LAST_NAME = 2;
    public final static int GENDER = 3;
    public final static int DOB = 4;
    public final static int CONTACT_NUMBER = 5;
    public final static int EMAIL = 6;
    public final static int DEPARTMENT_CODE = 7;
    public final static int DEPARTMENT_NAME = 8;
    public final static int ADDRESS_LINE_1 = 9;
    public final static int ADDRESS_LINE_2 = 10;
    public final static int ADDRESS_TOWN = 11;
    public final static int ADDRESS_POSTCODE = 12;
    public final static int ADDRESS_COUNTRY = 13;
    public final static int IS_CURRENT = 14;

    public static String sanitizeCellValue(Cell cell) {
        return cell != null && cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getStringCellValue() != null ? cell.getStringCellValue().trim() : null;
    }

    public static String formatDepartmentCode(Cell cell) {
        String value = null;
        if (cell != null) {
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                value = Objects.toString((int) cell.getNumericCellValue());
            } else if (cell.getStringCellValue() != null) {
                value = cell.getStringCellValue().trim();
            }
        }
        return value;
    }
}
