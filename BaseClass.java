package Selenium.Started.Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
    ChromeDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup () throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
	    
	    driver  = new ChromeDriver();
	    
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
	    
	    //doongle button
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	   
	    //Click on View all
	    driver.findElement(By.xpath("//button[text()='View All']")).click();

		
	}
       //Logout
	@AfterMethod
	public void close() {
		driver.close();
	}

	}
	

