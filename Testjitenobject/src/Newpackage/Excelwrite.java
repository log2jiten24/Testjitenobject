package Newpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelwrite {

	
	@Test
	public void excelwrite()  throws Exception{
		
		
			 // Specify the file path which you want to create or write
			  File src=new File("E:\\excelfolder\\Demo.xlsx");
			 // Load the file
			 FileInputStream fis=new FileInputStream(src);
			 // load the workbook
			 XSSFWorkbook wb=new XSSFWorkbook(fis);
			 // get the sheet which you want to modify or create
			 XSSFSheet sh1= wb.getSheetAt(0);
			 // getRow specify which row we want to read and getCell which column
			 System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
			 
			 //to write the value - to create a new cell at 1st row (0th row).
			 
			 sh1.getRow(0).createCell(2).setCellValue("Status");
			 
			 if (sh1.getRow(1).getCell(1).getStringCellValue().toString().equalsIgnoreCase("jeet2400")) {
			System.out.println ("jeet2400 present");	 	 
			 }
			 
			 if (sh1.getRow(1).getCell(0).getStringCellValue().equalsIgnoreCase(sh1.getRow(1).getCell(1).getStringCellValue())) { 
           
			//create cell of status as Pass 
				 sh1.getRow(1).createCell(2).setCellValue("Pass");
			 }else {
				 //create fail status 
				 
				 sh1.getRow(1).createCell(2).setCellValue("Fail");
			 }
			 
		FileOutputStream fout = new FileOutputStream(src) ;
		//write the excel file 
	    wb.write(fout);
	    //close the excel sheet
	   wb.close(); 
	   
	   
	}
}
