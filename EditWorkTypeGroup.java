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

public class EditWorkTypeGroup {

	@SuppressWarnings("deprecation")
	@Test
	public void main() throws InterruptedException {
		// TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
	    
	    ChromeDriver driver  = new ChromeDriver();
	    
	     //Handle Notification
		 ChromeOptions options=new ChromeOptions();
         options.addArguments("--disable-notifications");
	    
         //Url
	     driver.get("https://login.salesforce.com");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	     //Login Page
	     driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
	     driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");
	     driver.findElement(By.id("Login")).click();
	     Thread.sleep(10000);
	    
	     //Click on toggle button
	     driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	   
	      //Click on view all
	      driver.findElement(By.xpath("//button[text()='View All']")).click();
		  
		  //3.Click Work Type Groups from App Launcher
		  WebElement click = driver.findElement(By.xpath("//p[text() = 'Work Type Groups']"));
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
		  driver.executeScript("arguments[0].click();", click);
		  
		  Thread.sleep(10000);
		  
		  //4. Click on the Work Type Group tab
		  //driver.findElement(By.xpath("//span[text() = 'Recently Viewed | Work Type Groups']")).click();
		  
		  Thread.sleep(10000);
		  //5. Search the Work Type Group 'Salesforce Automation by Your Name'
		  driver.findElement(By.xpath("//input[@placeholder = 'Search this list...']")).
		  sendKeys("Salesforce Automation by Yuvaraj S"+ Keys.ENTER);
		  
		  Thread.sleep(10000);
		  //6. Click on the Dropdown icon and Select Edit
		  driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[contains(@class,'slds-icon_container')]")));
		  Thread.sleep(10000);
		  driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a [@title = 'Edit']")));
		  
		  //7.Enter Description as 'Automation'.
		  driver.findElement(By.xpath("//textarea[@role = 'textbox']")).sendKeys("Automation");
		  
		  //8.Select Group Type as 'Capacity'
		  driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//a[@class = 'select']")));
		  driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//a[@title = 'Capacity']")));
		  
		  //9.Click on Save
		  driver.findElement(By.xpath("//button[@title = 'Save']")).click();
		  
		  Thread.sleep(10000);
		  //10. Click on 'Salesforce Automation by Your Name'and Verify Description as 'Automation'
		  WebElement click1 = driver.findElement(By.xpath("//a[contains(text(),'Salesforce Automation by Yuvaraj S')]"));
		  JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		  driver.executeScript("arguments[0].click();", click1);
		  String text = driver.findElement(By.xpath("(//div[contains(@class,'slds-form-element slds-form-element_readonly')])[2]")).getText();
		  System.out.println(text);
		  
		
	}

}
