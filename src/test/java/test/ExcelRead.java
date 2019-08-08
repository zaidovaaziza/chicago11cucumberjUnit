package test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelRead {
    public static void main(String[] args) throws Exception {
        //creating files
        //import from java.io

        File file = new File("/Users/Azika/Desktop/chicago11cucumberjUnit/src/test/SampleData.xlsx");


        //file.exists method checks the given path
        //if finds the file, will return true, if not returns false
        System.out.println(file.exists());


        //loads our file in java memory so we can write and read
        FileInputStream fileInputStream = new FileInputStream(file);

        //Workbook--> sheet--> rows--> cells

        //Loading the workbook to our class
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //pass the sheet name
        XSSFSheet sheet = workbook.getSheet("Employees");

        //this line is getting Sendler from employees sheet
        //cell and row like index, always starts from 0
        System.out.println(sheet.getRow(2).getCell(1));

        //getPhysicalNumberOfRows -->this method will skip the empty rows and will count only used rows
        //this method starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("PhysicalNumberOfRows: " + usedRows);

        //getLastRowNum counts all and do not care if it's used or empty
        //this method starts from 0
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println("getLastRowNum: " + lastUsedRow);

        //TODO: Create a logic that prints out "NEENA" NAME DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Neena")) {
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }
        //TODO: Create a logic that prints out "Adams" job_id dynamically

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Adam")) {
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }

        workbook.close();
        fileInputStream.close();


    }

}
