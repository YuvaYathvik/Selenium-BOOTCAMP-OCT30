package Selenium.Started.Nov;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Dashboards_sort_order_by_Dashboard_name {

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
	    
	    //Click on toggle 
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	   
	    //Click on view all
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
		//3. Click Dashboards from App Launcher
	    WebElement click = driver.findElement(By.xpath("//p[text() = 'Dashboards']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		driver.executeScript("arguments[0].click();", click);
		  
		Thread.sleep(10000);
		// 5. Click the sort arrow in the Dashboard Name.
	    WebElement click3 = driver.findElement(By.xpath("//thead/tr[1]/th[1]/lightning-primitive-header-factory[1]/span[1]/a"));
	    JavascriptExecutor exe = (JavascriptExecutor) driver;
		driver.executeScript("arguments [0].click();", click3);
		  
		// 6. Verify the Dashboard displayed in ascending order by Dashboard name.
		int size = driver.findElements(By.xpath("//tbody/tr")).size();
		System.out.println(size);
		java.util.List<String> names = new ArrayList<String>();
		int i=1;
		
		do {
			try {
			driver.findElement(By.xpath("//tbody/tr["+i+"]//th//span/div//a")).sendKeys(Keys.PAGE_DOWN);
			System.out.println(driver.findElement(By.xpath("//tbody/tr["+i+"]//th//span/div//a")).getText());
			} catch(org.openqa.selenium.NoSuchElementException e) {
			break;
			}
			i=i+1;

			} while (true);
			System.out.println("Completed");
     

	}

}
