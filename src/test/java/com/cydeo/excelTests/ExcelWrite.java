package com.cydeo.excelTests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {
    @Test
    public void testExcelWrite() throws IOException {

        String path = "Excel_Test.xlsx";

        // 1. Create FileInputStream object and paste the path of the excell sheet
        FileInputStream fileInputStream = new FileInputStream(path);

        // 2. Create workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // 3. Create sheet
        XSSFSheet sheet = workbook.getSheet("Employees");

        // Create new Column Name as Salary
        XSSFCell salaryCell= sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");

        // Add salaries of the employees
        XSSFCell salary1= sheet.getRow(1).createCell(3);
        salary1.setCellValue("100000");

        XSSFCell salary2= sheet.getRow(2).createCell(3);
        salary2.setCellValue("200000");

        XSSFCell salary3= sheet.getRow(3).createCell(3);
        salary3.setCellValue("150000");

        XSSFCell salary4= sheet.getRow(4).createCell(3);
        salary4.setCellValue("2500000");

        // After creating cells and setting the values we need to use FileOutPutStream class to pass those values to the workbook.

        FileOutputStream fileOutputStream = new FileOutputStream(path);

        // save/write the changes to the workbook
        workbook.write(fileOutputStream);



    }
}
