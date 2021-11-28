package Selenium.Started.Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateWorkTypeGroupwithoutmandatoryfields {

	@SuppressWarnings("deprecation")
	@Test (timeOut = 3000)
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
	    
	    //Login
	    driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
	    driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");
	    driver.findElement(By.id("Login")).click();
	    Thread.sleep(10000);
	    
	    //Click on toggle button
	   driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	   
	   //Click on view all
	   driver.findElement(By.xpath("//button[text()='View All']")).click();
		  Thread.sleep(10000);
		 //3. Click Work Type Groups from App Launcher
		  WebElement click = driver.findElement(By.xpath("//p[text() = 'Work Type Groups']"));
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
		  driver.executeScript("arguments[0].click();", click);
		  
		  Thread.sleep(10000);
		  //4.Click on the Dropdown icon in the Work Type Groups tab
		  driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='Work Type Groups Menu']")));
		  Thread.sleep(5000);
		  
		//5.Click on New Work Type Group
		  driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='New Work Type Group']")));
		  Thread.sleep(3000);
		 
		  Thread.sleep(10000);
		 //6.Enter Description as 'Automation'
		  driver.findElement(By.xpath("// textarea [@role = 'textbox']")).sendKeys("Automation");
		  
		  
		 // 7.Select Group Type as 'Capacity'
		  WebElement click3 = driver.findElement(By.xpath("//a[@class = 'select']"));
		  JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		  driver.executeScript("arguments[0].click();", click3);
		  
		  
		  driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//a[@title = 'Capacity']")));
		  
		  
		 //8. Click on Save
		  driver.findElement(By.xpath("//button [@title = 'Save']")).click();
		  
		  
		  
		 // 9. Verify the Alert message (Complete this field) displayed for Work Type Group Name
         String text = driver.findElement(By.xpath("//ul[@class = 'errorsList']")).getText();
         System.out.println(text);

	}

}
