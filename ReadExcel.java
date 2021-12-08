package Selenium.Started.Nov;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
      
	public static String[][] readExcelData (String FileName) throws InvalidFormatException, IOException {
		
	   
		//workbook
		File excelFileName = new File ("C:\\Users\\399416\\eclipse-workspace\\SeleniumNov\\data\\Book.xlsx");
		XSSFWorkbook wbook = new XSSFWorkbook(excelFileName);
		
		//Sheet
		XSSFSheet sheet = wbook.getSheet(FileName);
		
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
        String[][] data = new String [rowCount][columnCount];
        		
		//int columncount = sheet.getRow(0).getLastCellNum();
		
		
		for (int i = 1; i <= rowCount; i++) {
		XSSFRow row = sheet.getRow(i);
	
		for (int j = 0; j < columnCount; j++) {
			XSSFCell cell = row.getCell(j);
		System.out.println(cell.getStringCellValue());
		
		//Column 
	    //XSSFCell cell = row.getCell(0);
		
		//Print value
		data[i-1][j] = cell.getStringCellValue();
		
	    }
		}	
		//close workbook
		wbook.close();
		
		return data;

		

		
	}
}