package Selenium.Started.Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLegalEntity extends BaseClass{

	
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
		  
		  //6. Click on the Dropdown icon 
		  WebElement click2 = driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]"));
		  JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		  driver.executeScript("arguments[0].click();", click2);
		  
		  //7. Select Delete
		  driver.findElement(By.xpath("//a[@title = 'Delete']")).click();
		  
		  
		  //8. Click on the Delete option in the displayed popup window.
		  driver.findElement(By.xpath("//button[@title = 'Delete']")).click();
		  
		  
		  //9. Verify Whether Legal Entity is Deleted using Legal Entity Name
		  String text = driver.findElement(By.xpath("//span[text() = 'No items to display.']")).getText();
		  System.out.println(text);
		  
		  
		  

	}

}
