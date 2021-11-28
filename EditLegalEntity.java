package Selenium.Started.Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class EditLegalEntity extends BaseClass{

	@SuppressWarnings("deprecation")
	@Test 
	public void main() throws InterruptedException {
		// TODO Auto-generated method stub

         
  //Click on Legal entity tab
  WebElement click = driver.findElement(By.xpath("//p[text() = 'Legal Entities']"));
  JavascriptExecutor executor = (JavascriptExecutor) driver;
  driver.executeScript("arguments[0].click();", click);
	    
  //4. Click on the legal Entities tab
  WebElement click1 = driver.findElement(By.xpath("//a[@title = 'Legal Entities']"));
  JavascriptExecutor executor1 = (JavascriptExecutor) driver;
  driver.executeScript("arguments[0].click();", click1);

  
  Thread.sleep(10000); 
  //5. Search the Legal Entity 'Salesforce Automation by Your Name'
  driver.findElement(By.xpath("//input[@name = 'LegalEntity-search-input']")).sendKeys("Salesforce Automation by Yuvaraj S"+ Keys.ENTER);
	    
  Thread.sleep(10000); 
  
  //6. Click on the Dropdown icon and Select Edit
  WebElement click2 = driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]"));
  JavascriptExecutor executor2 = (JavascriptExecutor) driver;
  driver.executeScript("arguments[0].click();", click2);
  
  Thread.sleep(10000); 
	    
  driver.findElement(By.xpath("//a[@title = 'Edit']")).click();
	    
  //7.Enter the Company name as 'Tetsleaf'.
  driver.findElement(By.xpath("//span[text() = 'Company Name']/following::input")).sendKeys("Testleaf");
  
  
  //8. Enter Description as 'SalesForce'. 
  driver.findElement(By.xpath("//textarea[@class = ' textarea']")).sendKeys("SalesForce");
  
 //9.Select Status as 'Active'	
  WebElement click3 = driver.findElement(By.xpath("//a[@class = 'select']"));
  JavascriptExecutor executor3 = (JavascriptExecutor) driver;
  driver.executeScript("arguments[0].click();", click3);
	    
  Thread.sleep(10000); 
 //10. Change to Active
  WebElement click4 = driver.findElement(By.xpath("//a[@title = 'Active']"));
  JavascriptExecutor executor4 = (JavascriptExecutor) driver;
  driver.executeScript("arguments[0].click();", click4);
  
  //11.Click on Save and Verify Status as Active
  driver.findElement(By.xpath("//button[@title = 'Save']")).click();
  String text = driver.findElement(By.xpath("//div[3] [@data-aura-class = 'forcePageBlockSectionRow']")).getText();
  System.out.println(text);
  
	    
	    
	    
	 
		
		
	}

	
		
	}


