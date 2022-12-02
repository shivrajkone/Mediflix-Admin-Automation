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


public class Tags_relationship extends admin_user
{
	 
	SoftAssert softAssert = new SoftAssert();
	
	WebElement strength;
	String strength_value = "57";
	
	WebElement strength2;
	String strength_value2 = "45";
		

	@Test (priority=1)
//	 @Test (enabled = false)
	 public void Create_Tags_Relationship() throws InterruptedException 
	 {
		  	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/tags");
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	Thread.sleep(4000);
		 
		 System.out.println("Tags relationship -> Verify The Create From Tags relationship**************");
		 
		 Reporter.log("Tags Relationship -> Verify The Create From Tags relationship");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 WebDriverWait tag_relationship = new WebDriverWait(driver, Duration.ofSeconds(30));
		 tag_relationship.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/div[2]/button[1]"))).click();
		 		 
		 WebDriverWait load_relationship = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load_relationship.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();

		 //click create tag relationship
		 WebDriverWait create_relationship = new WebDriverWait(driver, Duration.ofSeconds(30));
		 create_relationship.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"))).click();
		 
		 Thread.sleep(3000);
		 
		 //from tag
		 
		 //click
		 WebDriverWait from_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 from_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div/div/input"))).click();
		 		 
		 //select
		 WebDriverWait from_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 from_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[3]"))).click();
		 
		 //to tag
		 
		 //click
		 
		 WebDriverWait to_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 to_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/div/div/input"))).click();
		 
		 //select
		 
		 WebDriverWait to_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 to_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[5]"))).click();
		 
		 //strength value
		 strength = driver.findElement(By.id("strength"));
		 strength.sendKeys(strength_value);
		
		 //save  
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 
		 Thread.sleep(4000);
	 
	 }
	
//	 @Test (enabled = false)
	 @Test (priority=2)
	 public void View_And_Verify_Tags_Relationship() throws InterruptedException 
	 {
//		driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/tag-relationship");
		 
		System.out.println("Tags relationship -> view the newly created Tags relationship*******************");
		Reporter.log("Tags relationship  ->  View The Newly Created Tags relationship ");
		
		WebDriverWait load_category = new WebDriverWait(driver, Duration.ofSeconds(30));
		load_category.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[2]"))).click();

		Thread.sleep(3000);
		
		//from tag
		
		String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div/div/input")).getAttribute("value");
		System.out.println("from tag is_________________________"+s2);
		
		if(s2.equals(s2))
		{
			System.out.println("from tag is present");
			softAssert.assertEquals(s2, s2); 
		}
		else
		{
			System.out.println("from tag is not present");
			softAssert.assertEquals(s2, s2);
			Reporter.log( "[ERROR] -> Tags Category -> View Screen -> From tag is not present in Tags Relationship View Screen.");
			
		}	
		
		// To tag
		
		String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/div/div/input")).getAttribute("value");
		System.out.println("to tag is_________________________"+s3);
		
		if(s3.equals(s3))
		{
			System.out.println("to tag is present");
			softAssert.assertEquals(s3, s3); 
		}
		else
		{
			System.out.println("to tag is not present");
			softAssert.assertEquals(s3, s3);
			Reporter.log( "[ERROR] -> Tags Category -> View Screen -> To tag is not present in Tags Relationship View Screen.");
			
		}	
		
		// Strength
		
		String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/div/input")).getAttribute("value");
		System.out.println("Strength is_________________________"+s4);
		
		if(s4.equals(s4))
		{
			System.out.println("Strength is present");
			softAssert.assertEquals(s4, s4); 
		}
		else
		{
			System.out.println("Strength is not present");
			softAssert.assertEquals(s4, s4);
			Reporter.log( "[ERROR] -> Tags Category -> View Screen -> Strength is not present in Tags Relationship View Screen.");
			
		}	
		
		//close 
		 WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		 close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();
		 
		 Thread.sleep(4000);
		
		
		
	 }
	
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void Edit_Tags_Relationship() throws InterruptedException 
	 {
//		driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/tag-relationship");
		 
		System.out.println("Tags relationship -> edit the newly created Tags Catagory*******************");
		Reporter.log("Tags relationship  ->  Edit The Newly Created Tags Catagory ");
		
		WebDriverWait load_category = new WebDriverWait(driver, Duration.ofSeconds(30));
		load_category.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[1]"))).click();

		Thread.sleep(3000);
		
		//from tag
		//click
		 WebDriverWait from_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 from_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div/div/input"))).click();
		 		 
		 //select
		 WebDriverWait from_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 from_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[8]"))).click();
		
		 //save  
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 
		 Thread.sleep(4000);
		
		
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void View_And_Verify_Edited_Tags_Relationship() throws InterruptedException 
	 {
//		driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/tag-relationship");
		 
		System.out.println("Tags relationship -> view the newly created Tags relationship*******************");
		Reporter.log("Tags relationship  ->  View The Newly Created Tags relationship ");
		
		WebDriverWait load_category = new WebDriverWait(driver, Duration.ofSeconds(30));
		load_category.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[2]"))).click();

		Thread.sleep(3000);
		
		//from tag
		
		String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div/div/input")).getAttribute("value");
		System.out.println("from tag is_________________________"+s2);
		
		if(s2.equals(s2))
		{
			System.out.println("from tag is present");
			softAssert.assertEquals(s2, s2); 
		}
		else
		{
			System.out.println("from tag is not present");
			softAssert.assertEquals(s2, s2);
			Reporter.log( "[ERROR] -> Tags Category -> View Screen -> From tag is not present in Tags Relationship View Screen.");
			
		}	
		
		// To tag
		
		String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/div/div/input")).getAttribute("value");
		System.out.println("to tag is_________________________"+s3);
		
		if(s3.equals(s3))
		{
			System.out.println("to tag is present");
			softAssert.assertEquals(s3, s3); 
		}
		else
		{
			System.out.println("to tag is not present");
			softAssert.assertEquals(s3, s3);
			Reporter.log( "[ERROR] -> Tags Category -> View Screen -> To tag is not present in Tags Relationship View Screen.");
			
		}	
		
		// Strength
		
		String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/div/input")).getAttribute("value");
		System.out.println("Strength is_________________________"+s4);
		
		if(s4.equals(s4))
		{
			System.out.println("Strength is present");
			softAssert.assertEquals(s4, s4); 
		}
		else
		{
			System.out.println("Strength is not present");
			softAssert.assertEquals(s4, s4);
			Reporter.log( "[ERROR] -> Tags Category -> View Screen -> Strength is not present in Tags Relationship View Screen.");
			
		}	
		
		//close  
		 WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		 close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();
		 
		 Thread.sleep(4000);

	 }
		
//	 @Test (enabled = false)
	 @Test (priority=5)
	 public void Delete_Tags_Relationship() throws InterruptedException 
	 {
//		driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/tag-relationship");
		 
		System.out.println("Tags relationship -> Delete Tags Relationship*******************");
		Reporter.log("Tags relationship  ->  Delete Tags Relationship");
		
		WebDriverWait load_category = new WebDriverWait(driver, Duration.ofSeconds(30));
		load_category.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait delete_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		delete_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[3]"))).click();

		Thread.sleep(3000);
		
		WebDriverWait delete = new WebDriverWait(driver, Duration.ofSeconds(30));
		delete.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();

		Thread.sleep(3000);
		
	 }

		 
	
}
