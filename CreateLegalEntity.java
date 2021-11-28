package Selenium.Started.Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLegalEntity extends BaseClass{

	@SuppressWarnings("deprecation")
	@Test 
	public void main() throws InterruptedException {
		// TODO Auto-generated method stub

			
	    
	    Thread.sleep(10000);
	    //Click on Legal entity tab
	    WebElement click = driver.findElement(By.xpath("//p[text() = 'Legal Entities']"));
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    driver.executeScript("arguments[0].click();", click);
	    
		//Click on Legal Entity dropdown
	    WebElement dropdown = driver.findElement(By.xpath("//a[@title = 'Legal Entities']/following::lightning-primitive-icon[1]"));
	    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	    driver.executeScript("arguments[0].click();", dropdown);
	    
	    Thread.sleep(10000);
	    //Click on New legal Entity
	    WebElement select = driver.findElement(By.xpath("//span[text() = 'New Legal Entity']"));
	    JavascriptExecutor executor2 = (JavascriptExecutor) driver;
	    driver.executeScript("arguments[0].click();", select);
	    
	    //Enter Name as 'Salesforce Automation by Your Name'
	    driver.findElement(By.xpath("//input [@class = ' input'][1]")).sendKeys("Salesforce Automation by Yuvaraj S");
	    
	    //Click save and verify Legal Entity Name
	    driver.findElement(By.xpath("//button [@title = 'Save']")).click();
	    
	    String text = driver.findElement(By.xpath("//span [@class = 'test-id__field-value slds-form-element__static slds-grow '][1]")).getText();
	    System.out.println(text);
	    
	    
	    
			   
		
	}

}
