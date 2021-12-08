package Selenium.Started.Nov;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
    ChromeDriver driver;
	
	
    
    @org.testng.annotations.Parameters({"url","username","password"})
    @BeforeMethod
	public void pre (String url, String username, String password) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
	    
	    driver  = new ChromeDriver();
	    
	    //Handle Notification
		ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
	    
        //Url
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    //Login Page
	    driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("Login")).click();
	    Thread.sleep(10000);
	    
	    //doongle button
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	   
	    //Click on View all
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
		//driver.findElement(By.xpath("//p[text()='Sales']")).click();
		   
		   
		 //  WebElement opportuinity = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		  // JavascriptExecutor executor = (JavascriptExecutor) driver;
	       //driver.executeScript("arguments[0].click();", opportuinity);
	       
	       //Thread.sleep(10000);
	       
		   
		
	}
       //Logout
	@AfterMethod
	public void post() {
		driver.close();
	}

	
	
	
	
    
	}


