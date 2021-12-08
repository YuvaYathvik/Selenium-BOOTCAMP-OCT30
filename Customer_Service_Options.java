package Selenium.Started.Nov;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")

public class Customer_Service_Options {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
	    
		  ChromeDriver driver  = new ChromeDriver();
					    
		  //Handle Notification
		  ChromeOptions options=new ChromeOptions();
		  options.addArguments("--disable-notifications");
				
		  //Application url
		  driver.get("https://login.salesforce.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    
		  System.out.println(driver.getWindowHandle());
		  //Login Page	    
		  driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		  driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");
		  driver.findElement(By.id("Login")).click();
		  Thread.sleep(10000);
				
		 //3. Click on Learn More link in Mobile Publisher
		  driver.executeScript("arguments [0].click()",driver.findElement(By.xpath("//button[@title = 'Learn More']")));
		 
		  Thread.sleep(1000);
		  
		  Set <String> allWindowHandles  = driver.getWindowHandles();
		  List <String> lstWindows = new ArrayList<String>(allWindowHandles);
		  
		  String secondWindowHandle = lstWindows.get(1);
		
		  //Move the control to the second window
		  driver.switchTo().window(secondWindowHandle);
		 
		  //Confirm the title and current url
		  // System.out.println("Moved?"+driver.getTitle());
		  // System.out.println("Moved?"+driver.getCurrentUrl());
		  
		 // 4. MouseHover on Products and Select Service
		  WebElement eleProducts = driver.findElement(By.xpath("//li [@data-tracking-id= 'products']"));
	 
		  //Move to element
		  Actions bulider = new Actions(driver);
		  bulider.moveToElement(eleProducts).perform();

		  Thread.sleep(1000);
		  
		  driver.executeScript("arguments [0].click()",driver.findElement(By.xpath("//span[text() = 'Service']")));
		  
		 // 5. Verify the tabs displayed in the page
		  
		
		  
		  
		 // Expected Result:
		//  Below tabs should be displayed

		  	
		

	}

}
