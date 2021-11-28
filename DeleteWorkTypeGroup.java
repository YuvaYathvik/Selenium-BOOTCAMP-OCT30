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

public class DeleteWorkTypeGroup {

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
	    
	      //Click on toogle button 
	      driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	   
	      //Click on view all
	      driver.findElement(By.xpath("//button[text()='View All']")).click();
		  
		  //3. click Work Type Groups from App Launcher
		  WebElement click = driver.findElement(By.xpath("//p[text() = 'Work Type Groups']"));
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
		  driver.executeScript("arguments[0].click();", click);
		  
		  Thread.sleep(10000);
		  //4. Click on the Work Type Group tab 
		  //WebElement click1 = driver.findElement(By.xpath("//span[text() = 'Recently Viewed | Work Type Groups']"));
		  //JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		  //driver.executeScript("arguments[0].click();", click1);
		  
		  //5. Search the Work Type Group 'Salesforce Automation by Your Name'
		  driver.findElement(By.xpath("//input[@placeholder = 'Search this list...']")).
		  sendKeys("Salesforce Automation by Yuvaraj S"+ Keys.ENTER);
		  
		  Thread.sleep(10000);
		  //6. Click on the Dropdown icon and Select Delete
		  driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[contains(@class,'slds-icon_container')]")));
		  
		  Thread.sleep(10000);
		  //7.Click on the Delete option in the displayed popup window.
		  driver.findElement(By.xpath("//a[@role = 'menuitem']/following::li")).click();
		  
		 // 8. Verify Whether Work Type group is Deleted using Work Type Group Name
		  driver.findElement(By.xpath("//button[@title = 'Delete']")).click();
		  
		  String text = driver.findElement(By.xpath("//span[text() = 'No items to display.']")).getText();
		  System.out.println(text);

		  
		 
	}

}
