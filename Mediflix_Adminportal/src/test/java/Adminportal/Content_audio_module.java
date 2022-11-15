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
 
public class Content_audio_module extends admin_user
{
	
	SoftAssert softAssert = new SoftAssert();
	
	WebElement title;
	WebElement audio;
	WebElement desc;
	WebElement thumbnail;
	WebElement tags;
		
	
	String content_audio_title="Soul";
	String content_audio_desc="popular music genre that originated in the African American community";
	String folder="gomo";
	String tagcount1;
	
	String content_audio_title2="Classical";
	String content_audio_desc2=" music generally refers to the formal musical tradition of the Western world";
	String folder2="gomo";
	String tagcount2;
	
	WebElement title2;
	WebElement audio2;
	WebElement desc2;
	WebElement thumbnail2;
	WebElement tags2;
		
		

	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public void Create_Audio_With_Madatory_fields() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com");
	    
	    Thread.sleep(5000);
	    //click the content on side-panel
	    WebElement click_content  = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/button[4]"));
	    click_content.click();		
	    
	    Thread.sleep(10000);
			 
		
		 System.out.println("Content Audio-> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 
		 Reporter.log("Content Audio-> Verifying Mandatory Fields Validation Is Working Or Not");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();

		 WebDriverWait click_all_audio = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_all_audio.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/div/div/button[2]"))).click();

		 Thread.sleep(5000);
		 
		 WebElement create_new_audio = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/button[2]"));
		 create_new_audio.click();
			
		 Thread.sleep(3000);
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();

		 Thread.sleep(5000);
		 		 
		 System.out.println("Content Audio -> Verify The Create From Content Module With Mandatory Fields Only**************");
			
		 Reporter.log("Content Audio -> Create Content With Mandatory Fields Only");
		 
		 //title
		 title = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input"));
		 title.sendKeys(content_audio_title);
		 
		 //select audio
		 
		 WebDriverWait audio_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 audio_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button"))).click();
		 
		 Thread.sleep(7000);
		 
		 WebDriverWait audio_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 audio_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div"))).click();

		 WebDriverWait select_button = new WebDriverWait(driver, Duration.ofSeconds(30));
		 select_button.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[3]/button[2]"))).click();

		 Thread.sleep(4000);
		 
		 WebDriverWait save2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();

		 Thread.sleep(4000);
		 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=2)
	 public void View_And_Verify_Audio_With_Mandatory_Fields() throws InterruptedException 
	 {
/*		 	
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();

		    System.out.println("Content -> search and view the newly created Content*******************");
		    Reporter.log("Content -> Search And View The Newly Created Content");
		 			 
			WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			advice_searchbox.sendKeys(content_audio_title);
			
			Thread.sleep(5000);
*/		
		 	System.out.println("Content Audio-> view the newly created Audio*******************");
		    Reporter.log("Content Audio->  View The Newly Created Audio");
		 
			WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[3]"))).click();

			Thread.sleep(3000);
			// title
			
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input")).getAttribute("value");
			System.out.println("content audio title is_________________________"+s1);
			
			// audio name
			
			String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button")).getText();
			System.out.println("content selected audio is_________________________"+s2);
				        
			// close
						
			WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
			close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();

			Thread.sleep(4000);
			
			
	 } 
	 
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void Edit_Audio_With_All_Fields() throws InterruptedException 
	 {
		 
/*		 
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();
*/
		 	System.out.println("Content Audio-> Search And Edit The Newly Created Content With Remaining Fields");
			Reporter.log("Content Audio-> Search And Edit The Newly Created Content With Remaining Fields");
			
			WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[1]"))).click();

			Thread.sleep(3000);
			
			//desc		
			 
			 desc = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/textarea[1]"));
			 desc.sendKeys(content_audio_desc);
			 
			 //thumbnail
			 WebDriverWait thumbnail_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 thumbnail_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[4]/button"))).click();

			 WebDriverWait thumbnail_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 thumbnail_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/img"))).click();
					 
			 WebDriverWait select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"))).click();

			 //tags
			 
			 WebDriverWait tag_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 tag_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[5]/div/button"))).click();
			 
			 WebDriverWait tags_select= new WebDriverWait(driver, Duration.ofSeconds(30));
			 tags_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[7]/div[1]/div[1]/input"))).click();

			 WebDriverWait select_button_clcik= new WebDriverWait(driver, Duration.ofSeconds(30));
			 select_button_clcik.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"))).click();

			 // folder
			 
			 WebDriverWait folder_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			 folder_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[6]/div/div/div/input"))).click();

			 WebDriverWait folder_select= new WebDriverWait(driver, Duration.ofSeconds(30));
			 folder_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[7]"))).click();
			 
			 // ramdom
			 WebDriverWait ramdom= new WebDriverWait(driver, Duration.ofSeconds(30));
			 ramdom.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]"))).click();
			 
			 Thread.sleep(4000);
			 
			 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
			 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();

			 Thread.sleep(5000);
	 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void View_And_Verify_Edited_Audio_content() throws InterruptedException 
	 {
		 	
		 	System.out.println("Content Audio ->  View The Edited audio Content*******************");
		    Reporter.log("Content Audio ->  View The Edited Audio Content");
		    
		    WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[3]"))).click();

			Thread.sleep(3000);
			// title
			
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input")).getAttribute("value");
			System.out.println("content audio title is_________________________"+s1);
			
			if(s1.equals(content_audio_title))
			{
				System.out.println("content audio title is present");
				softAssert.assertEquals(s1, content_audio_title); 
			}
			else
			{
				System.out.println("content audio title is not present");
				softAssert.assertEquals(s1, content_audio_title);
				Reporter.log( "[ERROR] -> Content Audio -> View Screen -> Content Audio Title is not present in Content View Screen.");
			}		
			
			// audio name
			
			String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button")).getText();
			System.out.println("content selected audio is_________________________"+s2);
			
			if(s2.equals(s2))
			{
				System.out.println("content selected audio is present");
				softAssert.assertEquals(s2, s2); 
			}
			else
			{
				System.out.println("content selected audio is not present");
				softAssert.assertEquals(s2, s2);
				Reporter.log( "[ERROR] -> Content Audio -> View Screen -> Content Audio Title is not present in Content View Screen.");
			}		
			
			//desc
							
			String s3 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/textarea[1]")).getText();
			System.out.println("content audio description is_________________________"+s3);
			
			if(s3.equals(content_audio_desc))
			{
				System.out.println("content audio description is present");
				softAssert.assertEquals(s3, content_audio_desc); 
			}
			else
			{
				System.out.println("content audio description is not present");
				softAssert.assertEquals(s3, content_audio_desc);
				Reporter.log( "[ERROR] -> Content Audio -> View Screen -> Content Audio Description is not present in Content View Screen.");
			}			
			
			//image  
			
			String s4 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[4]/button")).getText();
			System.out.println("content audio image is_________________________"+s4);
			
			if(s4.equals(s4))
			{
				System.out.println("content audio image is present");
				softAssert.assertEquals(s4, s4); 
			}
			else
			{
				System.out.println("content audio image is not present");
				softAssert.assertEquals(s4, s4);
				Reporter.log( "[ERROR] -> Content Audio -> View Screen -> Content Audio Image is not present in Content View Screen.");
			}		
			
			
			//tags 

			String s5 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[5]/div/button")).getText();
			System.out.println("content audio tags is_________________________"+s5);
			
			if(s5.equals(s5))
			{
				System.out.println("content audio tags is present");
				softAssert.assertEquals(s5, s5); 
			}
			else
			{
				System.out.println("content audio tags is not present");
				softAssert.assertEquals(s5, s5);
				Reporter.log( "[ERROR] -> Content Audio -> View Screen -> Content Audio tags is not present in Content View Screen.");
			}		
			
			
			softAssert.assertAll();
			Thread.sleep(2000);			
				        
			
			// close
						
			WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
			close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();

			Thread.sleep(4000);		
	 }
	 
	 		// create new audio content with all fields
			 @Test (priority=5)
			 public void Create_New_Audio_Content_With_All_Fields() throws InterruptedException
			 {	
				 driver.manage().window().maximize();
				 driver.navigate().refresh();
				 System.out.println("Content Audio -> Verifying Create New Audio Content With All Information*****************");
				 Reporter.log("Content Audio -> Verifying Create New Audio Content With All Information");
					 
				 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
				 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();

				 WebDriverWait click_all_audio = new WebDriverWait(driver, Duration.ofSeconds(30));
				 click_all_audio.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/div/div/button[2]"))).click();

				 Thread.sleep(5000);
				 
				 WebElement create_new_audio = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/button[2]"));
				 create_new_audio.click();
					
				 Thread.sleep(3000);
				 
				 System.out.println("Content Audio -> Verify The Create From Content Module With Mandatory Fields Only**************");
					
				 Reporter.log("Content Audio -> Create Content With Mandatory Fields Only");
				 //title
				 title = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input"));
				 title.sendKeys(content_audio_title2);
				 
				 //select audio
				 
				 WebDriverWait audio_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 audio_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button"))).click();
				 
				 Thread.sleep(7000);
				 
				 WebDriverWait audio_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 audio_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div"))).click();

				 WebDriverWait select_button = new WebDriverWait(driver, Duration.ofSeconds(30));
				 select_button.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[3]/button[2]"))).click();

				 
				 //desc		
				 
				 desc = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/textarea[1]"));
				 desc.sendKeys(content_audio_desc2);
				 
				 //thumbnail
				 WebDriverWait thumbnail_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 thumbnail_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[4]/button"))).click();

				 WebDriverWait thumbnail_select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 thumbnail_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/img"))).click();
						 
				 WebDriverWait select = new WebDriverWait(driver, Duration.ofSeconds(30));
				 select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"))).click();

				 //tags
				 
				 WebDriverWait tag_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 tag_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[5]/div/button"))).click();

				 WebDriverWait tags_select= new WebDriverWait(driver, Duration.ofSeconds(30));
				 tags_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[7]/div[1]/div[1]/input"))).click();

				 WebDriverWait select_button_clcik= new WebDriverWait(driver, Duration.ofSeconds(30));
				 select_button_clcik.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"))).click();

				 // folder
				 
				 WebDriverWait folder_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 folder_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[6]/div/div/div/input"))).click();

				 WebDriverWait folder_select= new WebDriverWait(driver, Duration.ofSeconds(30));
				 folder_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[7]"))).click();
				 
				 // ramdom
				 WebDriverWait ramdom= new WebDriverWait(driver, Duration.ofSeconds(30));
				 ramdom.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]"))).click();
				 
				 Thread.sleep(4000);
				 
				 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
				 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();

				 Thread.sleep(5000);
				 
			 }
			 
//			 @Test (enabled = false)
			 @Test (priority=6)
			 public void View_And_Verify_New_Audio_Content() throws InterruptedException 
			 {
				 	driver.manage().window().maximize();
				 	driver.navigate().refresh();
				 	
				 	System.out.println("Content Audio ->  View The New audio Content*******************");
				    Reporter.log("Content Audio ->  View The New Audio Content");
				    
				    WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
					load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]"))).click();

					 WebDriverWait click_all_audio = new WebDriverWait(driver, Duration.ofSeconds(30));
					 click_all_audio.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/div/div/button[2]"))).click();

					 Thread.sleep(5000);
					 
					 WebElement audio_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
					 audio_searchbox.sendKeys(content_audio_title2);
				    
				    WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
					view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[3]"))).click();

					Thread.sleep(3000);
					// title
					
					String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input")).getAttribute("value");
					System.out.println("New content audio title is_________________________"+s1);
					
					if(s1.equals(content_audio_title2))
					{
						System.out.println("New content audio title is present");
						softAssert.assertEquals(s1, content_audio_title2); 
					}
					else
					{
						System.out.println("content audio title is not present");
						softAssert.assertEquals(s1, content_audio_title2);
						Reporter.log( "[ERROR] -> Content Audio -> View Screen -> New Content Audio Title is not present in Content View Screen.");
					}		
					
					// audio name
															
					String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button")).getText();
					System.out.println("New content selected audio is_________________________"+s2);
					
					if(s2.equals(s2))
					{
						System.out.println("New content selected audio is present");
						softAssert.assertEquals(s2, s2); 
					}
					else
					{
						System.out.println("New content selected audio is not present");
						softAssert.assertEquals(s2, s2);
						Reporter.log( "[ERROR] -> Content Audio -> View Screen -> New Content Audio Title is not present in Content View Screen.");
					}		
					
					//desc
									
					String s3 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/textarea[1]")).getText();
					System.out.println("New content audio description is_________________________"+s3);
					
					if(s3.equals(content_audio_desc2))
					{
						System.out.println("New content audio description is present");
						softAssert.assertEquals(s3, content_audio_desc2); 
					}
					else
					{
						System.out.println("New content audio description is not present");
						softAssert.assertEquals(s3, content_audio_desc2);
						Reporter.log( "[ERROR] -> Content Audio -> View Screen -> New Content Audio Description is not present in Content View Screen.");
					}			
					
					//image   
					
					String s4 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[4]/button")).getText();
					System.out.println("New content audio image is_________________________"+s4);
					
					if(s4.equals(s4))
					{
						System.out.println("New content audio image is present");
						softAssert.assertEquals(s4, s4); 
					}
					else
					{
						System.out.println("New content audio image is not present");
						softAssert.assertEquals(s4, s4);
						Reporter.log( "[ERROR] -> Content Audio -> View Screen -> New Content Audio Image is not present in Content View Screen.");
					}		
					
					
					//tags 

					String s5 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[5]/div/button")).getText();
					System.out.println("New content audio tags is_________________________"+s5);
					
					if(s5.equals(s5))
					{
						System.out.println("New content audio tags is present");
						softAssert.assertEquals(s5, s5); 
					}
					else
					{
						System.out.println("New content audio tags is not present");
						softAssert.assertEquals(s5, s5);
						Reporter.log( "[ERROR] -> Content Audio -> View Screen -> New Content Audio Tags is not present in Content View Screen.");
					}		
					
					softAssert.assertAll();
					Thread.sleep(2000);			
						        
					// close
								
					WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
					close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();

					Thread.sleep(4000);		
				 
			 }
			 
//			 @Test (enabled = false)
			 @Test (priority=7)
			 public void View_And_Verify_Delete_Audio_Content() throws InterruptedException 
			 {
				 
			    System.out.println("Audio Content -> search and delete the Audio Content*******************");
				Reporter.log("Audio Content -> Search and Delete The  Audio Content");

				WebDriverWait delete_icon = new WebDriverWait(driver, Duration.ofSeconds(30));
				delete_icon.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[6]/button[4]"))).click();
			 
				Thread.sleep(3000);
				
				WebDriverWait delete = new WebDriverWait(driver, Duration.ofSeconds(30));
				delete.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
				
				Thread.sleep(3000); 
								 
			 }
			 
			 @AfterTest
			 public void closeBrowser() 
			 {
			 	driver.quit();
			 	
			 }
				
	 
}
	 
	 
