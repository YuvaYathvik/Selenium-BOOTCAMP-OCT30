package Selenium.Started.Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOpportunity extends BaseClass{

	private static final String JavascriptExecutor = null;

	@SuppressWarnings("deprecation")
	@Ignore
	@Test (invocationCount = 3)
	public void main() throws InterruptedException {
		
	
		//Download the chrome driver set the path
		
	   
	   driver.findElement(By.xpath("//p[text()='Sales']")).click();
	   
	   
	   WebElement opportuinity = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
	   JavascriptExecutor executor = (JavascriptExecutor) driver;
       driver.executeScript("arguments[0].click();", opportuinity);
       
       Thread.sleep(10000);
       
	   driver.findElement(By.xpath("//div[text() = 'New']")).click();
	   driver.findElement(By.xpath("//input[@name = 'Name']")).sendKeys("Salesforce Automation by Yuvaraj S");
	   driver.findElement(By.xpath("//input[@name = 'CloseDate']")).sendKeys("11/13/2021");
	   	
	   WebElement none = driver.findElement(By.xpath("(//div[@role='none']//input)[3]"));
	   JavascriptExecutor executor1 = (JavascriptExecutor) driver;
       driver.executeScript("arguments[0].click();", none);
       
	   driver.findElement(By.xpath("//div[@role = 'listbox']/lightning-base-combobox-item[4]/span[2]")).click();
	   driver.findElement(By.xpath("//li[@class ='slds-button-group-item visible']//button[text() = 'Save']")).click();
	   System.out.println("Salesforce Automation by Yuvaraj S");
	   
	   
	   
	    
	   
		

	}

	
	}


