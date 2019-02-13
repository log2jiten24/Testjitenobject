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
	public void excelwrite() {
		
		try {
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
			 System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());
			 System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
			 System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
			 System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
			 System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());
			 // here createCell will create column
			 // and setCellvalue will set the value
			 sh1.getRow(0).createCell(2).setCellValue("2.41.0");
			 sh1.getRow(1).createCell(2).setCellValue("2.5");
			 sh1.getRow(2).createCell(2).setCellValue("2.39");
			 
			// here we need to specify where you want to save file
			 FileOutputStream fout=new FileOutputStream(new File("E:\\excelfolder\\Demo.xlsx"));
			 // finally write content 
			 
			 wb.write(fout);
			 
			// close the file
			 
			 fout.close();
			 
			 System.out.println ("Excel writing done");
			 
			  } catch (Exception e) {
			 
			   System.out.println(e.getMessage());
			 
			  }	
		
	}

}
