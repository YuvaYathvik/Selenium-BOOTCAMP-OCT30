package Selenium.Started.Nov;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Individuals_without_mandatory_fields {

	@SuppressWarnings("deprecation")
	@Test
	public void main() throws InterruptedException {
		
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
		  
		 //3. Click Individuals from App Launcher
		  WebElement click = driver.findElement(By.xpath("//p [ text () = 'Individuals']"));
		  JavascriptExecutor exe = (JavascriptExecutor) driver;
		  driver.executeScript("arguments [0].click();", click);
		  
		  Thread.sleep(10000);
		 //4. Click on the Dropdown icon in the Individuals tab
		  WebElement click1 = driver.findElement(By.xpath("//span [ text () = 'Individuals Menu']"));
		  JavascriptExecutor exe1 = (JavascriptExecutor) driver;
		  driver.executeScript("arguments [0].click()", click1);
		  
		 //5. Click on New Individual
		  WebElement click2 = driver.findElement(By.xpath("//span [text() = 'New Individual']"));
		  JavascriptExecutor exe2 = (JavascriptExecutor) driver;
		  driver.executeScript("arguments [0].click()", click2);
		  
		  Thread.sleep(10000);
		//6.Select Salutation as 'Mr'
		  WebElement click3 = driver.findElement(By.xpath("//a [@class = 'select']"));
		  JavascriptExecutor exe3 = (JavascriptExecutor) driver;
		  driver.executeScript("arguments [0].click()", click3);
		  
		  driver.findElement(By.xpath("//a [@title = 'Mr.']")).click();
		  
		//7.Enter the first name as 'Ganesh'.
		  driver.findElement(By.xpath("//input [@placeholder = 'First Name']")).sendKeys("Dev");
		  
	    //8. Click on Save
		  driver.findElement(By.xpath("//button [ @title = 'Save']")).click();
		  
		  
		//9. Verify the Alert message (Complete this field) displayed for the Last Name
		  String text = driver.findElement(By.xpath("//ul [@class = 'errorsList']")).getText();
          System.out.println(text);
		  

	}

}
