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

public class Delete_Dashboard extends BaseClass{

	@SuppressWarnings("deprecation")
	@Test 
	public void main() throws InterruptedException {
		// TODO Auto-generated method stub
	
		  
		  //3. Click Dashboards from App Launcher
		  WebElement click = driver.findElement(By.xpath("//p[text() = 'Dashboards']"));
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
		  driver.executeScript("arguments[0].click();", click);
		
		  	 
		  //4. Search the Dashboard 'Salesforce Automation by Your Name'
		  driver.findElement(By.xpath("//input [@placeholder = 'Search recent dashboards...']")).
		  sendKeys("Yuvaraj S"+ Keys.ENTER);
		  
		  
		  Thread.sleep(10000);
		  //5. Click on the Dropdown icon and Select Delete
		 WebElement click1 = driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_icon-border')]//lightning-primitive-icon[1]"));
		 JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		 driver.executeScript("arguments [0].click();", click1);
		 
		 Thread.sleep(10000) ;
		 //6.Click on the Delete option in the displayed popup window.
		WebElement click2 = driver.findElement(By.xpath("//span [text() = 'Delete']"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		driver.executeScript("arguments [0].click();", click2);
		  
		Thread.sleep(10000);
		 //7. Verify Whether Dashboard is Deleted using Dashboard Name
		driver.findElement(By.xpath("//button [@title = 'Delete']")).click();
		String text = driver.findElement(By.xpath("//span [@class = 'emptyMessageTitle']")).getText();
		System.out.println(text);

	}

}
