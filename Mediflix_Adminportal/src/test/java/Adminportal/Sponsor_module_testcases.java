package Adminportal;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import base.admin_user;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.TakesScreenshot;

public class Sponsor_module_testcases extends admin_user
{
	
	 
	SoftAssert softAssert = new SoftAssert();
	
	WebElement sponsor;
	WebElement logo;
	String sponsor_name = "Care ";

	WebElement sponsor2;
	WebElement logo2;
	String sponsor_name2 = "Global";
	

	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public void Create_Sponsor() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/sponsors");
			 
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		 	
		 System.out.println("Sponsor -> Verify The Create Sponsor With All Fields**************");
		 Reporter.log("Sponsor -> Verify The Create Sponsor With All Fields");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		 WebDriverWait Create_sponsor = new WebDriverWait(driver, Duration.ofSeconds(30));
		 Create_sponsor.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button"))).click();
		 		 
		 Thread.sleep(2000);
		 
		 sponsor = driver.findElement(By.id("sponsor-name"));
		 sponsor.sendKeys(sponsor_name);
		 
		 Thread.sleep(2000);
		 
		 // logo select
		 
		 WebDriverWait logo_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 logo_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button"))).click();
		 
		 WebDriverWait select_image = new WebDriverWait(driver, Duration.ofSeconds(30));
		 select_image.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[3]/div/img"))).click();
		 
		 WebDriverWait select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"))).click();
		 		
		 // save 
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 		
		 Thread.sleep(4000);
		 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=2)
	 public void View_And_Verify_Sponsor() throws InterruptedException 
	 {
//		driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/sponsors");
		 
		System.out.println("Sponsor -> view the newly created Sponsor*******************");
		Reporter.log("Sponsor ->  View The Newly Created Sponsor ");
		
		WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]/button[2]"))).click();

		Thread.sleep(3000);
		
		// sponsor name
		
		String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input")).getAttribute("value");
		System.out.println("Sponsor name is_________________________"+s1);
				
		if(s1.equals(sponsor_name))
		{
				System.out.println("Sponsor name is present");
				softAssert.assertEquals(s1, sponsor_name); 
		}
		else
		{
				System.out.println("Sponsor name is not present");
				softAssert.assertEquals(s1, sponsor_name);
				Reporter.log( "[ERROR] -> Tags Category -> View Screen -> Sponsor is not present in Sponsor View Category Screen.");
		}
		
		// logo
		
		String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div/div/div/img")).getAttribute("src");
        System.out.println("Logo is_________________________"+s2);
        
        if(s2.equals(s2))
		{
			System.out.println("logo is present");
			softAssert.assertEquals(s2, s2); 
		}
		else
		{
			System.out.println("logo is not present");
			softAssert.assertEquals(s2, s2);
			Reporter.log( "[ERROR] -> Content -> View Screen -> Sponsor logo is not present in Sponsor View Screen.");
		}	
        
        Thread.sleep(2000);
        
		// close
								
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();

		Thread.sleep(4000);
        
	 }
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void Edit_Sponsor() throws InterruptedException 
	 {
		System.out.println("Sponsor -> Edit newly created Sponsor*******************");
		Reporter.log("Sponsor ->  Edit The Newly Created Sponsor ");
		
		WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]/button[1]"))).click();

		Thread.sleep(3000);
		
		sponsor2 = driver.findElement(By.id("sponsor-name"));
		sponsor2.sendKeys(sponsor_name2);
		 
		Thread.sleep(2000);
		      
		 // save
									
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 
		 Thread.sleep(4000);
		
	 }
//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void View_And_Verify_Edited_Sponsor() throws InterruptedException 
	 {
//		driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/sponsors");
		 
		System.out.println("Sponsor -> view the edited Sponsor*******************");
		Reporter.log("Sponsor ->  View The Edited Sponsor ");
		
		WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]/button[2]"))).click();

		Thread.sleep(3000);
		
		// sponsor name
		
		String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input")).getAttribute("value");
		System.out.println("Sponsor name is_________________________"+s1);
	//	System.out.println("after edit Sponsor name is_________________________"+sponsor_name2);
				
		if(s1.equals(s1))
		{
				System.out.println("Sponsor name is present");
				softAssert.assertEquals(s1, s1); 
		}
		else
		{
				System.out.println("Sponsor name is not present");
				softAssert.assertEquals(s1, s1);
				Reporter.log( "[ERROR] -> Tags Category -> View Screen -> Sponsor is not present in Sponsor View Category Screen.");
		}
		
		// logo
		
		String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div/div/div/img")).getAttribute("src");
        System.out.println("Logo is_________________________"+s2);
        
        if(s2.equals(s2))
		{
			System.out.println("logo is present");
			softAssert.assertEquals(s2, s2); 
		}
		else
		{
			System.out.println("logo is not present");
			softAssert.assertEquals(s2, s2);
			Reporter.log( "[ERROR] -> Content -> View Screen -> Sponsor logo is not present in Sponsor View Screen.");
		}	
        
        Thread.sleep(2000);
        
		// close
								
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();

		Thread.sleep(4000);
        
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=5)
	 public void Delete_Sponsor() throws InterruptedException 
	 {
		System.out.println("Tags Catagory -> delete sponsor*******************");
		Reporter.log("Tags Catagory ->  Delete Sponsor ");
		
		WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait delete_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		delete_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]/button[3]"))).click();

		Thread.sleep(3000);
		
		WebDriverWait delete = new WebDriverWait(driver, Duration.ofSeconds(30));
		delete.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		
		Thread.sleep(5000);
	 } 
	 
//	 @AfterTest
//	 public void closeBrowser() 
//	 {
//	 	driver.quit();
//	 	
//	 }
	

}
