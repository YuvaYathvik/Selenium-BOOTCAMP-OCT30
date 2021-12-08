package Selenium.Started.Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateWorkTypeGroup extends BaseClass{

	@SuppressWarnings("deprecation")
	@Test 
	public void main() throws InterruptedException {
		// TODO Auto-generated method stub
	
		  
		  //3.Click Work Type Groups from App Launcher
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
		 
		   
		  //6.Enter Work Type Group Name as 'Salesforce Automation by Your Name'
		  driver.findElement(By.xpath("(//span[@title = 'required']/following::input)[1]")).sendKeys("Salesforce Automation by Yuvaraj S");
		  
		  
		  
		  //7.Click save and verify Work Type Group Name
		  driver.findElement(By.xpath("//button[@title = 'Save']")).click();
		  String text = driver.findElement(By.xpath("(//span [@class = 'uiOutputText'])[2]")).getText();
		  System.out.println(text);
	}


}
