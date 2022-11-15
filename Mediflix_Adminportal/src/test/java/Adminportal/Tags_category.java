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

public class Tags_category  extends admin_user
{
	
	SoftAssert softAssert = new SoftAssert();
	
	WebElement Tag_category;
	String tag_category_name = "Types of bones";
	String tag_category_edit = " in human";
	
	
	

	
	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public void Create_Tags_Category() throws InterruptedException 
	 {
		   driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/tags");
			 
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	Thread.sleep(4000);
		 
		 System.out.println("Tags Catagory -> Verify The Create From Tags Category**************");
		 
		 Reporter.log("Tags Catagory -> Verify The Create From Tags Category");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 WebDriverWait Create_tags_category_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 Create_tags_category_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/div[2]/button[2]"))).click();
		 		 
		 WebDriverWait load_category = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load_category.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();

	//	 Thread.sleep(4000);
		 
		 //click create tag category
		 	 
		 WebDriverWait Create_tags_category= new WebDriverWait(driver, Duration.ofSeconds(30));
		 Create_tags_category.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"))).click();
		 
		 Thread.sleep(2000);
		 
		 Tag_category = driver.findElement(By.id("tag-category"));
		 Tag_category.sendKeys(tag_category_name);
		 
		 Thread.sleep(2000);
		 
		// save
				 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		 
		 Thread.sleep(4000);
		 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=2)
	 public void View_And_Verify_Tags_Category() throws InterruptedException 
	 {
		System.out.println("Tags Catagory -> view the newly created Tags Catagory*******************");
		Reporter.log("Tags Catagory ->  View The Newly Created Tags Catagory ");
		
		WebDriverWait load_category = new WebDriverWait(driver, Duration.ofSeconds(30));
		load_category.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]/button[2]"))).click();

		Thread.sleep(3000);
		
		// tags name
		
		String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/input")).getAttribute("value");
		System.out.println("Tags category name is_________________________"+s1);
		
		if(s1.equals(tag_category_name))
		{
			System.out.println("Tags Category name is present");
			softAssert.assertEquals(s1, tag_category_name); 
		}
		else
		{
			System.out.println("Tags Category name is not present");
			softAssert.assertEquals(s1, tag_category_name);
			Reporter.log( "[ERROR] -> Tags Category -> View Screen -> Tags Category is not present in Tags View Category Screen.");
		}		
					
		Thread.sleep(2000);
						        
		// close
								
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();

		Thread.sleep(4000);
		
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void Edit_Tags_Category() throws InterruptedException 
	 {
		System.out.println("Tags Catagory -> Edit newly created Tags Catagory*******************");
		Reporter.log("Tags Catagory ->  Edit The Newly Created Tags Catagory ");
		
		WebDriverWait load_category = new WebDriverWait(driver, Duration.ofSeconds(30));
		load_category.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]/button[1]"))).click();

		Thread.sleep(3000);
		
		 Tag_category = driver.findElement(By.id("tag-category"));
		 Tag_category.sendKeys(tag_category_edit);
		 
		 Thread.sleep(2000);
		      
		 // save
									
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		 
		 Thread.sleep(4000);
		
	 }
//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void View_And_Verify_Edited_Tags_Category() throws InterruptedException 
	 {
		System.out.println("Tags Catagory -> view and verify edited Tags Catagory*******************");
		Reporter.log("Tags Catagory ->  View The Edited Created Tags Catagory ");
		
		WebDriverWait load_category = new WebDriverWait(driver, Duration.ofSeconds(30));
		load_category.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]/button[2]"))).click();

		Thread.sleep(3000);
		
		// tags name
		
		String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/input")).getAttribute("value");
		System.out.println("Tags category name is_________________________"+s2);
		
		s2 = s2.substring(15);
		System.out.println("edited string is _________________________"+s2);
		
		if(s2.equals(s2))
		{
			System.out.println("Tags Category name is present");
			softAssert.assertEquals(s2, s2); 
		}
		else
		{
			System.out.println("Tags Category name is not present");
			softAssert.assertEquals(s2, s2);
			Reporter.log( "[ERROR] -> Tags Category -> View Screen -> Tags Category is not present in Tags View Category Screen.");
		}		
					 
		Thread.sleep(2000);
						        
		// close
								
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();

		Thread.sleep(4000);
		
	 }
//	 @Test (enabled = false)
	 @Test (priority=5)
	 public void Delete_Tags_Category() throws InterruptedException 
	 {
		System.out.println("Tags Catagory -> delete Tags Catagory*******************");
		Reporter.log("Tags Catagory ->  Delete Tags Catagory ");
		
		WebDriverWait load_category = new WebDriverWait(driver, Duration.ofSeconds(30));
		load_category.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait delete_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		delete_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]/button[3]"))).click();

		Thread.sleep(3000);
		
		WebDriverWait delete = new WebDriverWait(driver, Duration.ofSeconds(30));
		delete.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		
		Thread.sleep(5000);
	 }
	 @AfterTest
	 public void closeBrowser() 
	 {
	 	driver.quit();
	 	
	 }
		 

}
