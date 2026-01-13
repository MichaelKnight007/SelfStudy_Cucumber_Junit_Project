package com.cydeo.excelTests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    // *********** 1. We can copy and paste the excel document at class level.
    // ********** 2. We should create FileInputStream object and paste the path of excel file.
    @Test
    public void read_from_Excel_File() throws IOException {

        //Get the path from content root.
        String path = "Excel_Test.xlsx";

        // We'll have an exception of FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        // Then we need to create workbook>sheet>row>cell in order.
        // 1. Create workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // 2. Create sheet (We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        // 3. Select row and cell


        //TODO: Print out Marr's cell
        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        // TODO: Print out developer Job_ID
        System.out.println("sheet.getRow(3).getCell(2) = " + sheet.getRow(3).getCell(2));


        // Return the count of only used rows.
        // Start counting from 1
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        System.out.println("numberOfRows = " + numberOfRows);

        /**
         * Returns the number of top cell to bottom cell and it does not care if the cell is empty or not. Starts counting from 0.
         */

        // Get the number of last used row
        int lastRowNum = sheet.getLastRowNum();
        System.out.println("lastRowNum = " + lastRowNum);


        //TODO: Create logic to Print the name of Ahmet dynamically

        for (int rowNum = 0; rowNum <numberOfRows ; rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Ahmet")) {
                System.out.println("sheet.getRow(rowNum).getCell(0) = " + sheet.getRow(rowNum).getCell(0));
            }
            
        }

    }


}
