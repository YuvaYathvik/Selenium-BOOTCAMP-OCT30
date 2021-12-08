package Selenium.Started.Nov;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class CreateNewOpportunity1 {

	@Test (dataProvider = "TestData")
	public void createnewOpp (String Name, String CloseDate) {
		
		
		   driver.findElement(By.xpath("//input[@name = 'Name']")).sendKeys("Salesforce Automation by Yuvaraj S");
		   driver.findElement(By.xpath("//input[@name = 'CloseDate']")).sendKeys("11/13/2021");
	}
	@DataProvider(name ="TestData")
	public Object [][]fetchData ()throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
	
	String [][] data = ReadExcelforDataprovider.ReadExcelData();
	return data;
	}


}
