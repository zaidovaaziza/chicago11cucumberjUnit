package test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWrite {
    public static void main(String[] args) throws Exception{
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;
        String path= "src/SampleData.xlsx";

        //loading workbook class
        FileInputStream fileInputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInputStream);

        //providing the sepcific sheet that we want to work on from this workbook
        sheet = workbook.getSheet("Employees");

        //we are selecting and saving the sheet
        row = sheet.getRow(1);

        //selescting the cell from the row
        cell = row.getCell(1);

        System.out.println("Steven's last name: "+ cell);

        XSSFCell adamCell = sheet.getRow(2).getCell(0);
        System.out.println("Before: " + adamCell.toString());
        adamCell.setCellValue("Trump");


        //for sending a value to file
        FileOutputStream fileOutputStream = new FileOutputStream(path);


        //executing everyting in memory
        workbook.write(fileOutputStream);
        System.out.println("After: " + adamCell.toString());

        //TODO: Change trump's JOB_ID to president dynamically

        for(int rowNum = 0; rowNum<sheet.getLastRowNum(); rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Trump")){
                sheet.getRow(rowNum).getCell(2).setCellValue("President");
            }
        }


        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
