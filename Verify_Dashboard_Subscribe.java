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

public class Verify_Dashboard_Subscribe {

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
	    
	      //Login page
	      driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
	      driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");
	      driver.findElement(By.id("Login")).click();
	      Thread.sleep(10000);
	    
	      //Click on toggle
	      driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	   
	      //Click on view all
	      driver.findElement(By.xpath("//button[text()='View All']")).click();
		  
		  //3. Click Dashboards from App Launcher
		  WebElement click = driver.findElement(By.xpath("//p[text() = 'Dashboards']"));
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
		  driver.executeScript("arguments[0].click();", click);
		
		  	 
		  //4. Search the Dashboard 'Salesforce Automation by Your Name'
		  driver.findElement(By.xpath("//input [@placeholder = 'Search recent dashboards...']")).
		  sendKeys("Yuvaraj S"+ Keys.ENTER);
		  
		  
		  Thread.sleep(10000);
		  //5. Click on the Dropdown icon and Select Subscribe
		 WebElement click1 = driver.findElement(By.xpath("//tbody/tr/td[6]/lightning-primitive-cell-factory/span/div/lightning-primitive-cell-actions/lightning-button-menu/button"));
		 JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		 driver.executeScript("arguments [0].click();", click1);
		 
		 
		 //6. Select Subscribe
		 WebElement click2 = driver.findElement(By.xpath("//span [text() = 'Subscribe']"));
		 JavascriptExecutor exe = (JavascriptExecutor) driver;
		 driver.executeScript("arguments [0].click();", click2);
		 
		 
		 //7. Select frequency as 'Daily' and Click on Save in the Edit Subscription popup window. 
		 	driver.findElement(By.xpath("//span[text () = 'Daily']")).click();
		 	driver.findElement(By.xpath("//button [@title = 'Save']")).click();
		 
		 
		 //8. Verify Whether the dashboard is subscribed.
		 	String text = driver.findElement(By.xpath("//td [@data-label = 'Subscribed']")).getText();
		 	
			System.out.println(text);
	
		 	//System.out.println("Your subscription is all set");
		 	

		 
		 
	}

}
