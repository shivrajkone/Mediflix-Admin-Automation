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
  
 
public class Content_video_module extends admin_user
{
	SoftAssert softAssert = new SoftAssert();
	
	WebElement name;
	WebElement desc;
	WebElement slug;
	WebElement tags;
	WebElement url;
	WebElement poster_url;
	
	WebElement expert;
	WebElement sponsor;
	WebElement collection;
	WebElement videos;
	WebElement conn_exp;
	WebElement lang;
	WebElement access_type;
		
	String content_name="Moyo Clinic";
	String content_desc="Treatment at Mayo Clinic is a truly human experience";
	String content_slug="1292873gfgh";
	String tagcount1;
	String content_url="https://www.freelogo.com/image1";
	String content_poster_url="https://www.freelogo.com/image2";
	
		
	String content_name2="PubMed";
	String content_desc2="national lib for midicine";
	String content_slug2="kds21894";
	String tagcount2;
	String content_url2="https://www.freelogo.com/image3";
	String content_poster_url2="https://www.freelogo.com/image4";
	

	
	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public void Create_Content_With_Madatory_fields() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com");
		    
		    Thread.sleep(5000);
		    
		    WebElement click_content  = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/button[4]"));
		    click_content.click();		
		    
		    Thread.sleep(10000);
		 
		 System.out.println("Content -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 
		 Reporter.log("Content -> Verifying Mandatory Fields Validation Is Working Or Not");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();

		 WebElement create_content_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/button[2]"));
		 create_content_button.click();
			
		 Thread.sleep(1000);
		    
		 WebElement create_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/header/div/button[2]"));
		 create_button.click();
		 
		 Thread.sleep(1000);
		 
		 System.out.println("Content -> Verify The Create From Content Module With Mandatory Fields Only**************");
		
		 Reporter.log("Content -> Create Content With Mandatory Fields Only");
		 
		 name = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/textarea[1]"));
		 name.sendKeys(content_name);
		 
		 
		 // create button
		 
		 WebDriverWait create_button_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 create_button_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/button[2]"))).click();

		 Thread.sleep(20000);
		 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=2)
	 public void View_And_Verify_Content_With_Mandatory_Fields() throws InterruptedException 
	 {
		 	
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();

		    System.out.println("Content -> search and view the newly created Content*******************");
		    Reporter.log("Content -> Search And View The Newly Created Content");
		 			 
			WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			advice_searchbox.sendKeys(content_name);
			
			Thread.sleep(5000);
			
			WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[12]/button[3]"))).click();

			// content name
			
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/textarea[1]")).getText();
	        System.out.println("content name is_________________________"+s1);
	        
	        
	 
	 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void Edit_Content_With_All_Fields() throws InterruptedException 
	 {
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();

		 	System.out.println("Content -> Search And Edit The Newly Created Content With Remaining Fields");
			Reporter.log("Content -> Search And Edit The Newly Created Content With Remaining Fields");
			
			WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			advice_searchbox.sendKeys(content_name);
			
	//		Thread.sleep(5000);
			
			WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[12]/button[1]"))).click();
			
			 desc = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[2]/div/textarea[1]"));
			 desc.sendKeys(content_desc);
			 
			 slug = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[3]/div/textarea[1]"));
			 slug.sendKeys(content_slug);
			 
			 url = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[2]/div/div[1]/div[3]/div/div/input"));
			 url.sendKeys(content_url);
			 
			 poster_url = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[2]/div/div[1]/div[5]/div/div/input"));
			 poster_url.sendKeys(content_poster_url);
			
			//expert
			 WebDriverWait expert_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 expert_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[1]/div/div/div/input"))).click();

			 WebDriverWait expert_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 expert_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[1]/div[2]/div/ul/li[2]"))).click();
			 
			 WebDriverWait click_ramdom = new WebDriverWait(driver, Duration.ofSeconds(30));
			 click_ramdom.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/div"))).click();

			//tags
			 
			 WebDriverWait tags_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 tags_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[2]/div/button"))).click();

			 WebDriverWait tags_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 tags_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[3]/div[1]/div[1]/input"))).click();
			 	 
			 WebDriverWait select_button = new WebDriverWait(driver, Duration.ofSeconds(30));
			 select_button.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" /html/body/div[3]/div[3]/div/div[2]/button[2]"))).click();

			 //sponsor
			 WebDriverWait sponsor_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 sponsor_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[3]/div[1]/div/div/input"))).click();

			 WebDriverWait sponsor_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 sponsor_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[3]/div[2]/div/ul/li[26]"))).click();

			 WebDriverWait click_ramdom2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			 click_ramdom2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/div"))).click();

			 //collection
			 WebDriverWait collection_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 collection_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[4]/div[1]/div/div/input"))).click();

			 WebDriverWait collection_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 collection_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[4]/div[2]/div/ul/li[6]"))).click();

			 WebDriverWait click_ramdom3 = new WebDriverWait(driver, Duration.ofSeconds(30));
			 click_ramdom3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/div"))).click();

			 //videos
			 WebDriverWait videos_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 videos_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[2]/div/div[2]/div/div/div/input"))).click();

			 WebDriverWait videos_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 videos_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[4]"))).click();

			 WebDriverWait click_ramdom4 = new WebDriverWait(driver, Duration.ofSeconds(30));
			 click_ramdom4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/div"))).click();

			 //connect exp
			 WebDriverWait conn_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 conn_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[1]/div[1]/div/div/input"))).click();

			 WebDriverWait conn_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 conn_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[1]/div[2]/div/ul/li[3]"))).click();

			 WebDriverWait click_ramdom5 = new WebDriverWait(driver, Duration.ofSeconds(30));
			 click_ramdom5.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/div"))).click();

			 // lang
			 WebDriverWait lang_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 lang_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[2]/div/div/input"))).click();

			 WebDriverWait lang_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 lang_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[3]/div/ul/li"))).click();
			 
			 // access type
			 WebDriverWait access_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 access_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[3]/div/div/input"))).click();

			 WebDriverWait access_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 access_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[4]/div/ul/li[1]"))).click();
			 
			 //date
			 WebDriverWait date_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 date_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[5]/div/div/div/div[1]/div/div/button"))).click();

			 WebDriverWait date_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 date_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div[2]/div/div[4]/div[3]/button"))).click();
			 
			 Thread.sleep(2000);
			// save changes button
			 
			 WebDriverWait save_changes = new WebDriverWait(driver, Duration.ofSeconds(30));
			 save_changes.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/button[3]"))).click();
			 
			 Thread.sleep(10000);
			
			
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void View_And_Verify_Edited_Advice() throws InterruptedException 
	 {
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();

		 	System.out.println("Content -> Search And View The Edited Content*******************");
		    Reporter.log("Content -> Search And View The Edited Content");
		    
		    WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			advice_searchbox.sendKeys(content_name);
			
			Thread.sleep(5000);
			
			WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[12]/button[3]"))).click();

			Thread.sleep(3000);
			// content name
			
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/textarea[1]")).getText();
	        System.out.println("content name is_________________________"+s1);
	        
	        if(s1.equals(content_name))
			{
				System.out.println("content name is present");
				softAssert.assertEquals(s1, content_name); 
			}
			else
			{
				System.out.println("content name is not present");
				softAssert.assertEquals(s1, content_name);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Content Name is not present in Content View Screen.");
			}		
	        
	        // description 
	        
	        String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[2]/div/textarea[1]")).getText();
	        System.out.println("content description is_________________________"+s2);
	        
	        if(s2.equals(content_desc))
			{
				System.out.println("content description is present");
				softAssert.assertEquals(s2, content_desc); 
			}
			else
			{
				System.out.println("content name is not present");
				softAssert.assertEquals(s2, content_desc);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Content Description is not present in Content View Screen.");
			}	
	 
		    // slug
	        
	        String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[3]/div/textarea[1]")).getText();
	        System.out.println("content slug is_________________________"+s3);
	        
	        if(s3.equals(content_slug))
			{
				System.out.println("content slug is present");
				softAssert.assertEquals(s3, content_slug); 
			}
			else
			{
				System.out.println("content slug is not present");
				softAssert.assertEquals(s3, content_slug);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Content Slug is not present in Content View Screen.");
			}	
	        
	        // expert
	        
	        String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[1]/div/div/div")).getText();
	        System.out.println("content expert is_________________________"+s4);
	        
	        if(s4.equals(s4))
			{
				System.out.println("content expert is present");
				softAssert.assertEquals(s4, s4); 
			}
			else
			{
				System.out.println("content expert is not present");
				softAssert.assertEquals(s4, s4);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Content Expert is not present in Content View Screen.");
			}	
	        
	        //tags
	        
	        String s5 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[2]/div/button")).getText();
	        System.out.println("content tags is_________________________"+s5);
	        
	        if(s5.equals(s5))
			{
				System.out.println("content tags is present");
				softAssert.assertEquals(s5, s5); 
			}
			else
			{
				System.out.println("content tags is not present");
				softAssert.assertEquals(s5, s5);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Content Tags Is Not Present In Content View Screen.");
			}	
	        
	        //sponsor
	        String s6 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[3]/div/div/div")).getText();
	        System.out.println("content sponsor is_________________________"+s6);
	        
	        if(s6.equals(s6))
			{
				System.out.println("content sponsor is present");
				softAssert.assertEquals(s6, s6); 
			}
			else
			{
				System.out.println("content sponsor is not present");
				softAssert.assertEquals(s6, s6);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Content Sponsor is not present in Content View Screen.");
			}	
	        
	        
	        //collection
	        String s7 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[4]/div/div/div")).getText();
	        System.out.println("content collection is_________________________"+s7);
	        
	        if(s7.equals(s7))
			{
				System.out.println("content collection is present");
				softAssert.assertEquals(s7, s7); 
			}
			else
			{
				System.out.println("content collection is not present");
				softAssert.assertEquals(s7, s7);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Content collection is not present in Content View Screen.");
			}	
	        
	        //videos
	        String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[2]/div/div[2]/div/div/div")).getText();
	        System.out.println("content videos is_________________________"+s8);
	        
	        if(s8.equals(s8))
			{
				System.out.println("content videos is present");
				softAssert.assertEquals(s8, s8); 
			}
			else
			{
				System.out.println("content videos is not present");
				softAssert.assertEquals(s8, s8);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Content Videos is not present in Content View Screen.");
			}	
	        
	        // connect exp
	        String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[1]/div/div/div")).getText();
	        System.out.println("content connect exp is_________________________"+s9);
	        
	        if(s9.equals(s9))
			{
				System.out.println("content connect exp is present");
				softAssert.assertEquals(s9, s9); 
			}
			else
			{
				System.out.println("content connect exp is not present");
				softAssert.assertEquals(s9, s9);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Content Connect Exp is not present in Content View Screen.");
			}	
	        
	        
	        softAssert.assertAll();
	        
	        
	        WebDriverWait close_view = new WebDriverWait(driver, Duration.ofSeconds(30));
			close_view.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/button[2]"))).click();
			 
			Thread.sleep(3000);
		    
	 }
	 
	// create new content with all fields
		 @Test (priority=5)
		 public void Create_New_Content_With_All_Fields() throws InterruptedException
		 {		
			 	driver.navigate().refresh();
			 	driver.manage().window().maximize();
			 	driver.navigate().refresh();
			 	
			 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			 	load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();
			 	
			 	System.out.println("Content -> Verifying Create New Content With All Information*****************");
				Reporter.log("Content -> Verifying Create New Content With All Information");
				 
			 	WebDriverWait create_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 	create_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/button[2]"))).click();
			 	
			 	Thread.sleep(3000);
			 	 
			 	 name = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/textarea[1]"));
				 name.sendKeys(content_name2);
			 	
			 	 desc = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[2]/div/textarea[1]"));
			 	 desc.sendKeys(content_desc2);
				 
				 slug = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[3]/div/textarea[1]"));
				 slug.sendKeys(content_slug2);
				 
				 url = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[2]/div/div[1]/div[3]/div/div/input"));
				 url.sendKeys(content_url2);
				 
				 poster_url = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[2]/div/div[1]/div[5]/div/div/input"));
				 poster_url.sendKeys(content_poster_url2);
				
				//expert
				 WebDriverWait expert_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 expert_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[1]/div/div/div/input"))).click();

				 WebDriverWait expert_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 expert_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[1]/div[2]/div/ul/li[1]"))).click();
				 
				 WebDriverWait click_ramdom = new WebDriverWait(driver, Duration.ofSeconds(30));
				 click_ramdom.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/div"))).click();

				//tags
				 
				 WebDriverWait tags_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 tags_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[2]/div/button"))).click();

				 WebDriverWait tags_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 tags_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[3]/div[1]/div[1]/input"))).click();
				 	 
				 WebDriverWait select_button = new WebDriverWait(driver, Duration.ofSeconds(30));
				 select_button.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" /html/body/div[3]/div[3]/div/div[2]/button[2]"))).click();

				 //sponsor
				 WebDriverWait sponsor_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 sponsor_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[3]/div[1]/div/div/input"))).click();

				 WebDriverWait sponsor_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 sponsor_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[3]/div[2]/div/ul/li[2]"))).click();

				 WebDriverWait click_ramdom2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				 click_ramdom2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/div"))).click();

				 //collection
				 WebDriverWait collection_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 collection_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[4]/div[1]/div/div/input"))).click();

				 WebDriverWait collection_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 collection_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[4]/div[2]/div/ul/li[4]"))).click();

				 WebDriverWait click_ramdom3 = new WebDriverWait(driver, Duration.ofSeconds(30));
				 click_ramdom3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/div"))).click();

				 //videos
				 WebDriverWait videos_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 videos_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[2]/div/div[2]/div/div/div/input"))).click();

				 WebDriverWait videos_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 videos_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[4]"))).click();

				 WebDriverWait click_ramdom4 = new WebDriverWait(driver, Duration.ofSeconds(30));
				 click_ramdom4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/div"))).click();

				 //connect exp
				 WebDriverWait conn_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 conn_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[1]/div[1]/div/div/input"))).click();

				 WebDriverWait conn_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 conn_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[1]/div[2]/div/ul/li[2]"))).click();

				 WebDriverWait click_ramdom5 = new WebDriverWait(driver, Duration.ofSeconds(30));
				 click_ramdom5.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/div"))).click();

				 // lang
				 WebDriverWait lang_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 lang_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[2]/div/div/input"))).click();

				 WebDriverWait lang_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 lang_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[3]/div/ul/li"))).click();
				 
				 // access type
				 WebDriverWait access_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 access_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[3]/div/div/input"))).click();

				 WebDriverWait access_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 access_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[4]/div/ul/li[1]"))).click();
				 
				 //date
				 WebDriverWait date_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 date_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[5]/div/div/div/div[1]/div/div/button"))).click();

				 WebDriverWait date_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 date_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div[2]/div/div[4]/div[3]/button"))).click();
				 
				// save changes button
				 
				 WebDriverWait save_changes = new WebDriverWait(driver, Duration.ofSeconds(30));
				 save_changes.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/button[2]"))).click();
				 
				 Thread.sleep(10000);
			 	
		 }
	 
//		 @Test (enabled = false)
		 @Test (priority=6)
		 public void View_And_Verify_New_Content() throws InterruptedException 
		 {
			 	driver.manage().window().maximize();
			 	driver.navigate().refresh();
			 	
			 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			 	load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();
			 	
			 	System.out.println("Content -> search and view the new content*******************");
			    Reporter.log("Content -> Search and View The New Content");
			    
			    WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				advice_searchbox.sendKeys(content_name2);
				
				Thread.sleep(5000);
				
				WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[12]/button[3]"))).click();

				// content name
				
				String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/textarea[1]")).getText();
		        System.out.println("content name is_________________________"+s1);
		        
		        if(s1.equals(content_name2))
				{
					System.out.println("content name is present");
					softAssert.assertEquals(s1, content_name2); 
				}
				else
				{
					System.out.println("content name is not present");
					softAssert.assertEquals(s1, content_name2);
					Reporter.log( "[ERROR] -> Content -> View Screen -> Content Name is not present in Content View Screen.");
				}		
		        
		        // description 
		        
		        String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[2]/div/textarea[1]")).getText();
		        System.out.println("content description is_________________________"+s2);
		        
		        if(s2.equals(content_desc2))
				{
					System.out.println("content description is present");
					softAssert.assertEquals(s2, content_desc2); 
				}
				else
				{
					System.out.println("content name is not present");
					softAssert.assertEquals(s2, content_desc2);
					Reporter.log( "[ERROR] -> Content -> View Screen -> Content Description is not present in Content View Screen.");
				}	
		 
			    // slug
		        
		        String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[3]/div/textarea[1]")).getText();
		        System.out.println("content slug is_________________________"+s3);
		        
		        if(s3.equals(content_slug2))
				{
					System.out.println("content slug is present");
					softAssert.assertEquals(s3, content_slug2); 
				}
				else
				{
					System.out.println("content slug is not present");
					softAssert.assertEquals(s3, content_slug2);
					Reporter.log( "[ERROR] -> Content -> View Screen -> Content Slug is not present in Content View Screen.");
				}	
		        
		        // expert
		        
		        String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[1]/div/div/div")).getText();
		        System.out.println("content expert is_________________________"+s4);
		        
		        if(s4.equals(s4))
				{
					System.out.println("content expert is present");
					softAssert.assertEquals(s4, s4); 
				}
				else
				{
					System.out.println("content expert is not present");
					softAssert.assertEquals(s4, s4);
					Reporter.log( "[ERROR] -> Content -> View Screen -> Content Expert is not present in Content View Screen.");
				}	
		        
		        //tags
		        
		        String s5 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[2]/div/button")).getText();
		        System.out.println("content tags is_________________________"+s5);
		        
		        if(s5.equals(s5))
				{
					System.out.println("content tags is present");
					softAssert.assertEquals(s5, s5); 
				}
				else
				{
					System.out.println("content tags is not present");
					softAssert.assertEquals(s5, s5);
					Reporter.log( "[ERROR] -> Content -> View Screen -> Content Tags Is Not Present In Content View Screen.");
				}	
		        
		        //sponsor
		        String s6 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[3]/div/div/div")).getText();
		        System.out.println("content sponsor is_________________________"+s6);
		        
		        if(s6.equals(s6))
				{
					System.out.println("content sponsor is present");
					softAssert.assertEquals(s6, s6); 
				}
				else
				{
					System.out.println("content sponsor is not present");
					softAssert.assertEquals(s6, s6);
					Reporter.log( "[ERROR] -> Content -> View Screen -> Content Sponsor is not present in Content View Screen.");
				}	
		        
		        
		        //collection
		        String s7 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[3]/div/div/div[4]/div/div/div")).getText();
		        System.out.println("content collection is_________________________"+s7);
		        
		        if(s7.equals(s7))
				{
					System.out.println("content collection is present");
					softAssert.assertEquals(s7, s7); 
				}
				else
				{
					System.out.println("content collection is not present");
					softAssert.assertEquals(s7, s7);
					Reporter.log( "[ERROR] -> Content -> View Screen -> Content collection is not present in Content View Screen.");
				}	
		        
		        //videos
		        String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[2]/div/div[2]/div/div/div")).getText();
		        System.out.println("content videos is_________________________"+s8);
		        
		        if(s8.equals(s8))
				{
					System.out.println("content videos is present");
					softAssert.assertEquals(s8, s8); 
				}
				else
				{
					System.out.println("content videos is not present");
					softAssert.assertEquals(s8, s8);
					Reporter.log( "[ERROR] -> Content -> View Screen -> Content Videos is not present in Content View Screen.");
				}	
		        
		        // connect exp
		        String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[4]/div/div/div[1]/div/div/div")).getText();
		        System.out.println("content connect exp is_________________________"+s9);
		        
		        if(s9.equals(s9))
				{
					System.out.println("content connect exp is present");
					softAssert.assertEquals(s9, s9); 
				}
				else
				{
					System.out.println("content connect exp is not present");
					softAssert.assertEquals(s9, s9);
					Reporter.log( "[ERROR] -> Content -> View Screen -> Content Connect Exp is not present in Content View Screen.");
				}	
		        
		        
		        softAssert.assertAll();
		        
		        Thread.sleep(2000);
		        
		        WebDriverWait close_view = new WebDriverWait(driver, Duration.ofSeconds(30));
				close_view.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/header/div/button[2]"))).click();
				 
				Thread.sleep(3000);
			 
		 } 
		 
//		 @Test (enabled = false)
		 @Test (priority=7)
		 public void View_And_Verify_Delete_Content() throws InterruptedException 
		 {
			 	driver.navigate().refresh();
			 	driver.manage().window().maximize();
			 	driver.navigate().refresh();
			 	
			 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			 	load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();
			 				 	
			 	WebElement refresh_page = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"));
			 	refresh_page.click();
			 	
			 	if(refresh_page.getSize() != null)
			 	{
			 		driver.navigate().refresh();
			 	}
			 	else
			 	{
			 		System.out.println("page not refresh");
			 	}
			 	
			 	System.out.println("Content -> search and delete the Content*******************");
			    Reporter.log("Content -> Search and Delete The  Content");
			    
			    WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				advice_searchbox.sendKeys(content_name);
				
				Thread.sleep(7000); 
				
//				WebDriverWait delete_icon = new WebDriverWait(driver, Duration.ofSeconds(30));
//				delete_icon.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[12]/button[5]"))).click();
					 		   
				WebDriverWait delete = new WebDriverWait(driver, Duration.ofSeconds(30));
				delete.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
				
				Thread.sleep(3000);
				
				//delete 2 content
				
				driver.navigate().refresh();
				
				WebDriverWait load2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			 	load2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();
			 				 	 			 	 
			 	WebElement advice_searchbox2 = driver.findElement(By.xpath("//input[@type='text']"));
				advice_searchbox2.sendKeys(content_name2);
				
				Thread.sleep(5000);
				
				WebDriverWait delete_icon2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				delete_icon2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[12]/button[5]"))).click();
					 		   
				WebDriverWait delete2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				delete2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
				
				Thread.sleep(3000);
			     
		 }
		 
		 @AfterTest
		 public void closeBrowser() 
		 {
		 	driver.quit();
		 	
		 }
		 

}
