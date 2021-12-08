package Selenium.Started.Nov;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.list.TreeList;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@SuppressWarnings("unused")
public class Verify_WorkType_Group_sort_order_by_Name {

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Test
	public void main() throws InterruptedException {
		// TODO Auto-generated method stub	
		  
        WebDriverManager.chromedriver().setup();
	    
	    ChromeDriver driver  = new ChromeDriver();
	    
	    //Handle Notification
		ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
	    
        //url
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
        
	    //3.click Work Type Groups from App Launcher
		WebElement click = driver.findElement(By.xpath("//p[text() = 'Work Type Groups']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;	
		driver.executeScript("arguments[0].click();", click);
		  
		//div[@class = 'listViewContent slds-table--header-fixed_container'])[2]
		
		 
		//4.Click on the Work Type Group tab & sort arrow in the Work Type Group Name
		WebElement click1 = driver.findElement(By.xpath("//thead/tr[1]/th[3]/div[1]/a[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	    driver.executeScript("arguments[0].click();", click1);
		  
	    Thread.sleep(1000);
	    
		 int size = driver.findElements(By.xpath("//tbody/tr")).size();
		 System.out.println(size);
		java.util.List<String> names = new ArrayList<String>();
			int i=1;
	   //5. Verify the Work Type Group displayed in ascending order by Work Type Group Name.	
			do {
				try {
					driver.findElement(By.xpath("//tbody/tr["+i+"]//th/span/a"));
				System.out.println(driver.findElement(By.xpath("//tbody/tr["+i+"]//th/span/a")).getText());
				} catch(org.openqa.selenium.NoSuchElementException e) {
				break;
				}
			    i=i+1;

				} while (true);
				System.out.println("Completed");
			
			//	.sendKeys(Keys.PAGE_DOWN);
	}

}
