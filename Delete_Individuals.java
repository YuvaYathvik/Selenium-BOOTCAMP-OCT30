package Selenium.Started.Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_Individuals {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
	    
		  ChromeDriver driver  = new ChromeDriver();
					    
		  //Handle Notification
		  ChromeOptions options=new ChromeOptions();
		  options.addArguments("--disable-notifications");
				
		  //Application url
		  driver.get("https://login.salesforce.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    
		  //Login Page	    
		  driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		  driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");
		  driver.findElement(By.id("Login")).click();
		  Thread.sleep(10000);
				
		  //1.Click on App launcher	    
		  driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
						
		  //2.Click on view All
		  driver.findElement(By.xpath("//button[text()='View All']")).click();	
		  
		 //3. Click Individuals from App Launcher
		  WebElement click = driver.findElement(By.xpath("//p [ text () = 'Individuals']"));
		  JavascriptExecutor exe = (JavascriptExecutor) driver;
		  driver.executeScript("arguments [0].click();", click);
		  
		 //5. Search the Individuals 'Yathvik'
		  driver.findElement(By.xpath("//input [@placeholder = 'Search this list...']")).
		  sendKeys("Yathvik"+ Keys.ENTER);
		  
		  Thread.sleep(1000);
		  //6. Click on the Dropdown icon and Select Delete
		  WebElement click1 = driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]"));
		  JavascriptExecutor exe1 = (JavascriptExecutor) driver;
		  driver.executeScript("arguments [0].click();", click1);
		  
		  driver.executeScript("arguments [0].click()", driver.findElement(By.xpath("//a[@title = 'Delete']")));
 
		  //7.Click on the Delete option in the displayed popup window.
		   driver.executeScript("arguments [0].click()", driver.findElement(By.xpath("//button[@title = 'Delete']")));
		  
		  // 8. Verify Whether Individual is Deleted using Individual last name
		   String text = driver.findElement(By.xpath("//span[text() = 'No items to display.']")).getText();
		  System.out.println(text);
		 
		

		
	}

}
