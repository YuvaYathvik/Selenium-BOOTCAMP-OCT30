package Selenium.Started.Nov;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;

@Parameter ({browser})
@Test
public class CreateTask {
	public RemoteWebDriver driver;
	
	public void crossbrowser(String browserName) throws InterruptedException {

	if(browserName.equalsIgnoreCase("chrome")){
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	
	}
	else if (browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		
		 driver = new FirefoxDriver();
	}
	
	else if (browserName.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		
		 driver = new EdgeDriver();
		 
		 //Handle Notification
		    ChromeOptions options=new ChromeOptions();
		    options.addArguments("--disable-notifications");
	}
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
	   
	    
	    
	    WebElement click = driver.findElement(By.xpath("//a[@title = 'Tasks']/following::div/one-app-nav-bar-menu-button/a/lightning-icon[1]"));
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
		driver.executeScript("arguments[0].click();", click);
		
	    Thread.sleep(1000);
	//7) Click New Task
	   driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='New Task']")));
	   WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
	//8) Enter subject as "Bootcamp "
	   driver.findElement(By.xpath("(//input[@aria-haspopup= 'listbox'])[2]")).sendKeys("Bootcamp");
		
	//09) Select status as 'Waiting on someone else'
	   driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("(//a[@class = 'select'])[1]")));
		driver.executeScript("arguments [0].click()",driver.findElement(By.xpath("//a[@title = 'Waiting on someone else']")));
	
	//9) Select Contact from DropDown
	   driver.findElement(By.xpath("(//span[text() = 'Pick an object']//following::div/input)[3]")).click();
	   Thread.sleep(1000);
	   
	   driver.findElement(By.xpath("//div[@class = 'listContent']/ul/li/a/div/div")).click();
	 

	//11) Save and verify the 'Task created' message
	   driver.findElement(By.xpath("//button[@title = 'Save']")).click();
	   
	   String text = driver.findElement(By.xpath("//span[@class= 'toastMessage slds-text-heading--small forceActionsText']")).getText();
       
       System.out.println(text);
	
	   
	}

}
