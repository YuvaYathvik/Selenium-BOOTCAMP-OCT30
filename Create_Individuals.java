package Selenium.Started.Nov;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Create_Individuals extends BaseClass{


	
	
	@Test (dataProvider = "fetchData")
	public void runcreateindividulas (String Lastname) throws InterruptedException  {
		// TODO Auto-generated method stub
          
	//	WebDriverManager.chromedriver().setup();
	    
	 //     ChromeDriver driver  = new ChromeDriver();
	    
	      //Handle Notification
	//	  ChromeOptions options=new ChromeOptions();
     //     options.addArguments("--disable-notifications");
	    
	 //    driver.get("https://login.salesforce.com");
	 //     driver.manage().window().maximize();
	  //    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	 //     driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
	 //     driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");
	 //     driver.findElement(By.id("Login")).click();
	 //     Thread.sleep(10000);
	    
	  //    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	   
	  //k    driver.findElement(By.xpath("//button[text()='View All']")).click();
		  
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
		 //6. Enter the Last Name as 'Yathvik'
		  driver.findElement(By.xpath("//input [@placeholder = 'Last Name']")).sendKeys("Lastname");
		  
		  
		  //7.Click save and verify Individuals Name
		  driver.findElement(By.xpath("//button [ @title = 'Save']")).click();
		
		 
		 
		  
	}
	
    @DataProvider (name = "fetchData")
	public Object [][] sendData ()throws IOException, Exception{
	
    String [][] data = ReadExcel.readExcelData("Create_Individuals");
    
    return data;
}
}
