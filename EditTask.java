package Selenium.Started.Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditTask {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
	    //Handle Notification
	    ChromeOptions options=new ChromeOptions();
	    options.addArguments("--disable-notifications");
		
			
		//1) Launch the app/url
		 driver.get("https://login.salesforce.com");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			
		//2) Click Login
		 driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		 driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");
		 

		//3) Login with the credentials
		 driver.findElement(By.id("Login")).click();
		 Thread.sleep(10000);
			
			
		//4) Click on tonggle button 
		 driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		 
		//5) Click on View all
		    driver.findElement(By.xpath("//button[text()='View All']")).click();
		 
		 //6) Click on Global Actions SVG icon
		    driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//p[text() = 'Sales']")));

		
		//7) Click on Dropdown icon available under tasks and select value as Recently viewed

		    WebElement click = driver.findElement(By.xpath("//a[@title = 'Tasks']/following::div/one-app-nav-bar-menu-button/a/lightning-icon[1]"));
		    JavascriptExecutor executor = (JavascriptExecutor) driver;
			driver.executeScript("arguments[0].click();", click);
			
			Thread.sleep(1000);
			
			driver.executeScript("arguments[0]. click()",driver.findElement(By.xpath("//a[@role = 'menuitem']//span[text() = 'Recently Viewed']")));
	
			Thread.sleep(1000);
		//8) Click the Dropdown for Bootcamp task and select Edit
			driver.executeScript("arguments[0]. click()",driver.findElement(By.xpath("//li[@data-aura-class = 'oneActionsDropDown']//following::a/lightning-icon//span[text() = 'Show 13 more actions']")));

		//9) Select todays date as Due date
			//span[text()= 'Due Date']//following::span/span
			
		//10) Select Priority as low
			
			
		//11) Click save and verify Subject


	}

}
