package Adminportal;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
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

public class Tags_module_testcase extends admin_user
{
	
	
	SoftAssert softAssert = new SoftAssert();
	
	WebElement name;
	WebElement category;
	WebElement desc;
	
	String tags_name="spine";
	String tags_desc="The bones in the spine are called vertebrae.";
	
	WebElement name2;
	WebElement category2;
	WebElement desc2;
	
	String tags_name2="Osteopenia";
	String tags_desc2="Osteopenia is a term used for low bone mass that isn't low enough to be osteoporosis.";
	
	
	
	    
	    
	
	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public void Create_Tags_With_Madatory_fields() throws InterruptedException 
	 {
		 	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/tags");
			 
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	Thread.sleep(4000);
		 
		 System.out.println("Tags -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 
		 Reporter.log("Tags -> Verifying Mandatory Fields Validation Is Working Or Not");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 WebDriverWait Create_tags_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 Create_tags_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/div[2]/button[3]"))).click();
		 
		 Thread.sleep(1000);
		    
		 WebDriverWait save_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 
		 Thread.sleep(1000);
		 
		 System.out.println("Tags -> Verify The Create From Tags Module With Mandatory Fields Only**************");
		 Reporter.log("Tags -> Create Tags With Mandatory Fields Only");
		 
		 //tags name
		 name = driver.findElement(By.id("tag-name"));
		 name.sendKeys(tags_name);
		 
		 Thread.sleep(2000);
		 
		 // tags category
		 
		 WebElement category_click=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div/div/input"));
		 category_click.click();
		 
		 Thread.sleep(3000);
		 
		 WebDriverWait cat_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 cat_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[1]"))).click();
		 		  
		 Thread.sleep(2000);
		 //save   
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 		  
		 Thread.sleep(5000);
		 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=2)
	 public void View_And_Verify_Tags_With_Mandatory_Fields() throws InterruptedException 
	 {
		System.out.println("Tags-> view the newly created Tags*******************");
		Reporter.log("Tags ->  View The Newly Created Tags");
		 
		WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[2]"))).click();

		Thread.sleep(3000);
		
		// tags name
		
		String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[1]/div/input")).getAttribute("value");
		System.out.println("Tags name is_________________________"+s1);
					
		// tags category
					
		String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div/input")).getAttribute("value");
		System.out.println("Tags category is_________________________"+s2);
						        
		// close
								
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();

		Thread.sleep(5000);
		
	 }
	
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void Edit_Tags_With_All_Fields() throws InterruptedException 
	 {
		 System.out.println("Tags-> Search And Edit The Newly Created Tags With Remaining Fields");
		 Reporter.log("Tags-> Search And Edit The Newly Created Tags With Remaining Fields");
			
		 WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[1]"))).click();

		 Thread.sleep(3000);
			
			//desc		
			 
		 desc = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[3]/div/textarea[1]"));
		 desc.sendKeys(tags_desc);
		 
		 Thread.sleep(2000);
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();

		 Thread.sleep(5000);
		 	 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void View_And_Verify_Edited_Tags() throws InterruptedException 
	 {
		 	System.out.println("Tags-> view the newly created Tags*******************");
			Reporter.log("Tags ->  View The Newly Created Tags");
			 
			WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[2]"))).click();

			Thread.sleep(6000);
			
			// tags name
			
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[1]/div/input")).getAttribute("value");
			System.out.println("Tags name is_________________________"+s1);
			
			if(s1.equals(tags_name))
			{
				System.out.println("Tags name is present");
				softAssert.assertEquals(s1, tags_name); 
			}
			else
			{
				System.out.println("Tags name is not present");
				softAssert.assertEquals(s1, tags_name);
				Reporter.log( "[ERROR] -> Tags -> View Screen -> Tags name is not present in Tags View Screen.");
			}		
			
						
			// tags category
						
			String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div/input")).getAttribute("value");
			System.out.println("Tags category is_________________________"+s2);
			
			if(s2.equals(s2))
			{
				System.out.println("Tags name is present");
				softAssert.assertEquals(s2, s2); 
			}
			else
			{
				System.out.println("Tags name is not present");
				softAssert.assertEquals(s2, s2);
				Reporter.log( "[ERROR] -> Tags -> View Screen -> Tags name is not present in Tags View Screen.");
			}		
			
			// desc
			
			String s3 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[3]/div/textarea[1]")).getText();
			System.out.println("Tags description is_________________________"+s3);
			
			if(s3.equals(tags_desc))
			{
				System.out.println("Tags name is present");
				softAssert.assertEquals(s3, tags_desc); 
			}
			else
			{
				System.out.println("Tags name is not present");
				softAssert.assertEquals(s3, tags_desc);
				Reporter.log( "[ERROR] -> Tags -> View Screen -> Tags name is not present in Tags View Screen.");
			}	
			
			softAssert.assertAll();
			Thread.sleep(2000);			
			// close
						
			WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
			close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();

			Thread.sleep(4000);	
			
	 }
	 
	// create new tags content with all fields
	 @Test (priority=5)
	 public void Create_New_Tags_With_All_Fields() throws InterruptedException
	 {	
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 System.out.println("Tags -> Verifying Create New Tags  With All Information*****************");
		 Reporter.log("Tags -> Verifying Create New Tags  With All Information");
		 
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 WebDriverWait Create_tags_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 Create_tags_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/div[2]/button[3]"))).click();
		 
		 Thread.sleep(1000);	 
			
		 //tags name
		 name2 = driver.findElement(By.id("tag-name"));
		 name2.sendKeys(tags_name2);
		 
		 Thread.sleep(2000);
		 
		 // tags category
		 
		 WebElement category_click=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div/div/input"));
		 category_click.click();
		 
		 Thread.sleep(3000);
		 
		 WebDriverWait cat_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 cat_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[1]"))).click();
		 		  
		 Thread.sleep(2000);	
		 
		//desc		
		 
		 desc2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[3]/div/textarea[1]"));
		 desc2.sendKeys(tags_desc2);
		 
		 Thread.sleep(2000);
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 		  
		 Thread.sleep(5000);		 
		 		 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=6)
	 public void View_And_Verify_New_Tags() throws InterruptedException 
	 {
//		 	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/tags");
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	System.out.println("Tags ->  View The New Created Tags*******************");
		    Reporter.log("Tags ->  View The New Created Tags");
		    
		    // load	    		
		    WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]"))).click();
		    		
		    // search
			WebElement searchbox1 = driver.findElement(By.xpath("//input[@type='text']"));
			searchbox1.sendKeys(tags_name2);
			
		    
		    WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[2]"))).click();

			Thread.sleep(6000);
			
			// tags name
			
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[1]/div/input")).getAttribute("value");
			System.out.println("New Tags name is_________________________"+s1);
			
			if(s1.equals(tags_name2))
			{
				System.out.println("New Tags name is present");
				softAssert.assertEquals(s1, tags_name2); 
			}
			else
			{
				System.out.println("New Tags name is not present");
				softAssert.assertEquals(s1, tags_name2);
				Reporter.log( "[ERROR] -> Tags -> View Screen ->New Tags name is not present in Tags View Screen.");
			}		
			
						
			// tags category
						
			String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div/input")).getAttribute("value");
			System.out.println("New Tags category is_________________________"+s2);
			
			if(s2.equals(s2))
			{
				System.out.println("New Tags name is present");
				softAssert.assertEquals(s2, s2); 
			}
			else
			{
				System.out.println("Tags name is not present");
				softAssert.assertEquals(s2, s2);
				Reporter.log( "[ERROR] -> Tags -> View Screen -> New Tags name is not present in Tags View Screen.");
			}		
			
			// desc
			
			String s3 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[3]/div/textarea[1]")).getText();
			System.out.println("Tags description is_________________________"+s3);
			
			if(s3.equals(tags_desc2))
			{
				System.out.println("New Tags name is present");
				softAssert.assertEquals(s3, tags_desc2); 
			}
			else
			{
				System.out.println("New Tags name is not present");
				softAssert.assertEquals(s3, tags_desc2);
				Reporter.log( "[ERROR] -> Tags -> View Screen ->New Tags name is not present in Tags View Screen.");
			}	
			
			softAssert.assertAll();
			Thread.sleep(2000);			
			// close
						
			WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
			close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();

			Thread.sleep(4000);	
		    
		     
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=7)
	 public void View_And_Verify_Delete_Tags() throws InterruptedException 
	 {
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		 System.out.println("Tags -> search and delete the Tags*******************");
		 Reporter.log("Tags -> Search and Delete The Tags");
		 
		 WebElement tags_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
		 tags_searchbox.sendKeys(tags_name);

		 WebDriverWait delete_icon = new WebDriverWait(driver, Duration.ofSeconds(30));
		 delete_icon.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/button[3]"))).click();
	 
		 Thread.sleep(2000);
		
		 WebDriverWait delete = new WebDriverWait(driver, Duration.ofSeconds(30));
		 delete.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		
		 Thread.sleep(3000); 
		 
		 
						 
	 } 
	 @Test (enabled = false)
//	 @Test (priority=9)
	 public void Verify_Filter_Tags() throws InterruptedException
		{
			
		 	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/tags");
			driver.manage().window().maximize();
	    	driver.navigate().refresh();
	    	Thread.sleep(5000);
	    	
			System.out.println("Tags -> Verify Tags Filter Working Or Not**************");
			 
			Reporter.log("Tags -> Verify Tags Filter Working Or Not");
			
			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();

			// click filter  
			
			WebDriverWait click_filter = new WebDriverWait(driver, Duration.ofSeconds(30));
			click_filter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[1]"))).click();

			Thread.sleep(2000);
			// click tag  
			
			WebDriverWait click_tag = new WebDriverWait(driver, Duration.ofSeconds(30));
			click_tag.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/div/div/input"))).click();
			Thread.sleep(2000);                                                   
			
			//select cat 
			
			WebDriverWait select_cat = new WebDriverWait(driver, Duration.ofSeconds(30));
			select_cat.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[2]/div/ul/li[1]"))).click();
			Thread.sleep(2000);
			
			
			
			//apply  
			
			WebDriverWait apply = new WebDriverWait(driver, Duration.ofSeconds(30));
			apply.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
			Thread.sleep(5000);

			// read tags from listing screen 
			String s2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]")).getText();
			System.out.println("tags catagory are________________________"+s2);
			
//			if(s1.equals(s2))
//				{
//					System.out.println("Filter with Tags are working");
//					AssertJUnit.assertEquals(s1, s2);
//				}
//				else
//				{
//					System.out.println("Filter with Tags are not working");
//					AssertJUnit.assertEquals(s1, s2);
//					Reporter.log( "[ERROR] -> Filter -> Listing Screen -> Filter Are Not Working");
//				}			
			
			softAssert.assertAll();
				
			Thread.sleep(2000);
			
			
		} 
	 
	 
	 
	 
	 
//	 @AfterTest
//	 public void closeBrowser() 
//	 {
//	 	driver.quit();
//	 	
//	 }
		 
		 
	 
}
	 
	 
	 
	 


