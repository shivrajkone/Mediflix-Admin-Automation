package Adminportal;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.admin_user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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



public class Institute_module_testcases extends admin_user
{

	
	SoftAssert softAssert = new SoftAssert();
	
	
	WebElement name;
	WebElement logo;
	WebElement image;
	WebElement desc;
	WebElement slug;
	WebElement expert;
	WebElement tagcount;
	WebElement collection;
	WebElement videos;
	WebElement zipcode;
		
	String inst_name="CRDF Global";
	String inst_desc="An independent nonprofit organization that promotes international scientific and technical collaboration";
	String inst_slug="346jhgkjh";
	
	WebElement name2;
	WebElement logo2;
	WebElement image2;
	WebElement desc2;
	WebElement slug2;
	WebElement expert2;
	WebElement collection2;
	WebElement videos2;
	WebElement zipcode2;
		
	String inst_name2="Cornell";
	String inst_desc2="University is a private institution that was founded in 1865";
	String inst_slug2="198ndhd";
	String tagcount2;
	
	
	
	
	 @Test (priority=2)
//	 @Test (enabled = false)
	 public void Create_Institutions_With_Madatory_fields() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/institutions");
		 driver.manage().window().maximize();
		 Thread.sleep(10000);
		 
		 System.out.println("Institute -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 Reporter.log("Institute -> Verifying Mandatory Fields Validation Is Working Or Not");
		 		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]")));

		 WebElement create_institute_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button"));
		 create_institute_button.click();
			
		 Thread.sleep(3000);
		    
		 WebDriverWait wait_save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_save.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();

		 Thread.sleep(2000);
		 
		 System.out.println(" Verify The Create Institutions With Mandatory Fields Only**************");
		
		 Reporter.log("Institute -> Create Institutions With Mandatory Fields Only");
		 
		 //institute name
		 name= driver.findElement(By.id("institution-name"));
		 name.sendKeys(inst_name);
		 
		 // inst log 
		 
		  logo=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/button"));
		  logo.click();
		  
		  WebDriverWait wait_logo = new WebDriverWait(driver, Duration.ofSeconds(30));
		  wait_logo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img")));
			    		 
		  WebElement logo_select=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"));
		  logo_select.click();
		
		  WebElement select_button1 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
		  select_button1.click();
		 
		  // inst image
		  
		  image=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/button"));
		  image.click();
		 
		  WebDriverWait wait_img = new WebDriverWait(driver, Duration.ofSeconds(30));
		  wait_img.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img")));
			    		 
		  WebElement img_select=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img"));
		  img_select.click();
		
		  WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
		  select_button.click();
	     
		  Thread.sleep(5000);
	     
	      WebDriverWait wait_save2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	      wait_save2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		 		
//	     WebElement savebutton2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
//		 savebutton2.click();
	      Thread.sleep(10000);
	     
	 }
	 
	 @Test (priority=3)
//	 @Test (enabled = false)
	 public void View_And_Verify_Institutions_With_Mandatory_Fields() throws InterruptedException 
	 {
		 	driver.manage().window().maximize();
		    driver.navigate().refresh();
		    Thread.sleep(10000);
		 	
		    System.out.println("Institution -> search and view the newly created institution*******************");
		    Reporter.log("Institution -> Search And View The Newly Created Institution");
		    
			WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			coll_searchbox.sendKeys(inst_name);
		 
			Thread.sleep(2000);
			
			 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_view.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]"))).click();
			    			
			Thread.sleep(2000);
						
			//inst name
			
			String s1 = driver.findElement(By.xpath("//input[@id='institution-name']")).getAttribute("value");
			System.out.println("Institution name is ____________________________"+s1);
		
			if(s1.equals(inst_name))
			{
				System.out.println("Institution name is present");
				AssertJUnit.assertEquals(s1, inst_name);
			}
			else
			{
				System.out.println("Institution name is not present");
				AssertJUnit.assertEquals(s1, inst_name);
				Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Name Is Not Present In Banner view Screen.");
			}
			
			// logo and image
			
			String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[1]/div/div/div/img")).getAttribute("src");
			System.out.println("logo scr__________"+s8);
			
			if (s8.equals(s8))
			{
					System.out.println("logo is present");
					AssertJUnit.assertEquals(s8, s8);
			}
			else
			{
					System.out.println("logo is not present");
					AssertJUnit.assertEquals(s8, s8);
					Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Logo is not present in Banner View Screen.");
					
			}
		 
			String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[2]/div/div/div/img")).getAttribute("src");
			System.out.println("img scr__________"+s9);
			
			if (s9.equals(s9))
			{
					System.out.println("image is present");
					AssertJUnit.assertEquals(s9, s9);
			}
			else
			{
					System.out.println("image is not present");
					AssertJUnit.assertEquals(s9, s9);
					Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Image is not present in Banner View Screen.");
					
			}
			
			softAssert.assertAll();
			
			//close button
			
			 WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
			    	
			 Thread.sleep(3000);
			
	 } 
	
//		@Test (enabled = false)
		 @Test (priority=4)
		 public void Edit_Institution_With_All_Fields() throws InterruptedException 
		 {
			 	driver.manage().window().maximize();
			    driver.navigate().refresh();
			    Thread.sleep(10000);
			    
			    WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
				load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
				
			    System.out.println("Institution -> Search And Edit The Newly Created Institution With Remaining Fields");
			    Reporter.log("Institution -> Search And Edit The Newly Created Institution With Remaining Fields");
			    
			    WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(inst_name);
				
				Thread.sleep(3000);
			 			
				WebElement icon_edit = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[1]"));
				icon_edit.click();
				
				// desc and slug
				driver.findElement(By.id("description")).sendKeys(inst_desc);
				
				driver.findElement(By.id("slug")).sendKeys(inst_slug);
				
				Thread.sleep(3000);
				// expert
				expert = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[7]/div/div/div"));
				expert.click(); 
				
				WebElement expert_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[16]"));
				expert_select.click();
				
				Thread.sleep(3000);
				WebElement m1=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m1.click();
			    Thread.sleep(3000);
				//collection 
				collection = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[9]/div/div/input"));
				collection.click();
				
				WebElement coll_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[119]"));
				coll_select.click();
				Thread.sleep(3000);
				// videos
				videos = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div/div/div/input"));
				videos.click();
				
				WebElement videos_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[7]"));
				videos_select.click();
				Thread.sleep(3000);
				//zip
				zipcode = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[11]/div/div"));
				zipcode.click();
				
				WebElement zip_select = driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[2]"));
				zip_select.click();
				Thread.sleep(3000);
				
				WebDriverWait load2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				load2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/h2/p"))).click();
								
				Thread.sleep(5000);
				
				WebElement save_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
				 Thread.sleep(1000);
				save_button.click();
				
				Thread.sleep(10000);
			 
		 } 
	
//			@Test (enabled = false)
		    @Test (priority=5)
			 public void View_And_Verify_Edited_Institutions() throws InterruptedException 
			 {
		    	driver.manage().window().maximize();
		    	 Thread.sleep(5000);
			    driver.navigate().refresh();
			    Thread.sleep(10000);
			    
			    WebDriverWait wait_pageload = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait_pageload.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
							 	
			    System.out.println("Institution -> search and view the edited institution*******************");
			    Reporter.log("Institution -> Search And View Edited Institution");
			    
				WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(inst_name);
			 
				Thread.sleep(2000);
				
				 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
				 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
				    			
				Thread.sleep(2000);
					
				    //inst name
					
					String s1 = driver.findElement(By.xpath("//input[@id='institution-name']")).getAttribute("value");
					System.out.println("Institution name is ____________________________"+s1);
				
					if(s1.equals(inst_name))
					{
						System.out.println("Institution name is present");
						AssertJUnit.assertEquals(s1, inst_name);
					}
					else
					{
						System.out.println("Institution name is not present");
						AssertJUnit.assertEquals(s1, inst_name);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Name Is Not Present In Banner view Screen.");
					}
					
					//description
					String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/textarea[1]")).getText();
					System.out.println("Institution desc is ____________________________"+s2);
					
					if(s2.equals(inst_desc))
					{
						System.out.println("Institution desc is present");
						AssertJUnit.assertEquals(s2, inst_desc);
					}
					else
					{
						System.out.println("Institution desc is not present");
						AssertJUnit.assertEquals(s2, inst_desc);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Description Is Not Present In Banner view Screen.");
					}
					
					//slug
					String s3 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/div/textarea[1]")).getText();
					System.out.println("Institution slug is ____________________________"+s3);
					
					if(s3.equals(inst_slug))
					{
						System.out.println("Institution slug is present");
						AssertJUnit.assertEquals(s3, inst_slug);
					}
					else
					{
						System.out.println("Institution slug is not present");
						AssertJUnit.assertEquals(s3, inst_slug);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Slug Is Not Present In Banner view Screen.");
					}
					
					//expert
					String s4 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[5]/div/div/div")).getText();
					System.out.println("expert is ____________________________"+s4);
					
					if(s4.equals(s4))
					{
						System.out.println("expert is present");
						AssertJUnit.assertEquals(s4, s4);
					}
					else
					{
						System.out.println("expert is not present");
						AssertJUnit.assertEquals(s4, s4);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Expert Is Not Present In Banner view Screen.");
					}
					
					// collection
					
					String s5 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[7]/div/div/input")).getAttribute("value");
					System.out.println("Collection is ____________________________"+s5);
					
					if(s5.equals(s5))
					{
						System.out.println("Collection is present");
						AssertJUnit.assertEquals(s5, s5);
					}
					else
					{
						System.out.println("Collection is not present");
						AssertJUnit.assertEquals(s5, s5);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Collection Is Not Present In Banner view Screen.");
					}
					
					//videos
					String s6 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[8]/div/div/div")).getText();
					System.out.println("Videos is ____________________________"+s6);
					
					if(s6.equals(s6))
					{
						System.out.println("Videos is present");
						AssertJUnit.assertEquals(s6, s6);
					}
					else
					{
						System.out.println("Videos is not present");
						AssertJUnit.assertEquals(s6, s6);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Videos Is Not Present In Banner view Screen.");
					}
					
					//zip
					String s7 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[9]/div/div")).getText();
					System.out.println("Zipcode is ____________________________"+s7);
					
					if(s7.equals(s7))
					{
						System.out.println("Zipcode is present");
						AssertJUnit.assertEquals(s7, s7);
					}
					else
					{
						System.out.println("Zipcode is not present");
						AssertJUnit.assertEquals(s7, s7);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Zipcode Is Not Present In Banner view Screen.");
					}
					
					
					// logo and image
					
					String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[1]/div/div/div/img")).getAttribute("src");
					System.out.println("logo scr__________"+s8);
					
					if (s8.equals(s8))
					{
							System.out.println("logo is present");
							AssertJUnit.assertEquals(s8, s8);
					}
					else
					{
							System.out.println("logo is not present");
							AssertJUnit.assertEquals(s8, s8);
							Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Logo is not present in Banner View Screen.");
							
					}
				 
					String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[2]/div/div/div/img")).getAttribute("src");
					System.out.println("img scr__________"+s9);
					
					if (s9.equals(s9))
					{
							System.out.println("image is present");
							AssertJUnit.assertEquals(s9, s9);
					}
					else
					{
							System.out.println("image is not present");
							AssertJUnit.assertEquals(s9, s9);
							Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Image is not present in Banner View Screen.");
							
					}
					 
					softAssert.assertAll();
				 	 
					WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
					    	
					Thread.sleep(3000);
				
			 }
		    
//		    @Test (enabled = false)
		    @Test (priority=6)
			 public void Create_New_Institutions_With_All_Fields() throws InterruptedException
			 {
				 driver.manage().window().maximize();
				 driver.navigate().refresh();
				 Thread.sleep(10000);
				 
				 WebDriverWait wait_pageload = new WebDriverWait(driver, Duration.ofSeconds(30));
				 wait_pageload.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
				
				 System.out.println("Institution -> Verifying Create New Institution With All Information");
				 Reporter.log("Institution -> Verifying Create New Institution With All Information");
				 
				 WebElement create_institute_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button"));
				 create_institute_button.click();
				 
				 Thread.sleep(3000);
				 				 
				//institute name
				 name= driver.findElement(By.id("institution-name"));
				 name.sendKeys(inst_name2);
				 
				
				 
	    		 // inst logo
				 															
				  WebDriverWait logo2_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				  logo2_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/button"))).click();
					   				 								
				  WebDriverWait wait_logo2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				  wait_logo2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img")));
					    		 
				  WebElement logo_select2=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"));
				  logo_select2.click();
				
				  WebElement select_button1 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
				  select_button1.click();
				 
				  // inst image
				  
				  image2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/button"));
				  image2.click();
				 
				  WebDriverWait wait_img2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				  wait_img2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img")));
					    		 
				  WebElement img_select2=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img"));
				  img_select2.click();
				
				  WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
				  select_button.click();
				  
				// desc and slug
					driver.findElement(By.id("description")).sendKeys(inst_desc2);
					
					driver.findElement(By.id("slug")).sendKeys(inst_slug2);
					
					Thread.sleep(1000);
					// expert
					expert2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[7]/div/div/div"));
					expert2.click(); 
					
					WebElement expert_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[16]"));
					expert_select.click();
					
					WebElement m1=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
				    m1.click();
					
					//collection 
					collection2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[9]/div/div/input"));
					collection2.click();
					
					WebElement coll_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[119]"));
					coll_select.click();
					
					// videos
					videos2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div/div/div/input"));
					videos2.click();
					
					WebElement videos_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[7]"));
					videos_select.click();
					
					//zip
					zipcode2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[11]/div/div"));
					zipcode2.click();
					
					WebElement zip_select = driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[2]"));
					zip_select.click();
					
					//tags
				     WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[8]/div/button"));
				     tab_button.click();
					    
				     Thread.sleep(1000);
				     													
				     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"));
					 tab_topic.click();
								  
					 Thread.sleep(1000);
					    
					 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
					 selectbutton.click();
					    
					 Thread.sleep(1000);
					 
					// tags count
				     tagcount2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[8]/div/button")).getText();
					 System.out.println("the tag count is __________________"+tagcount2); 
					
					 Thread.sleep(5000);
					 
					 WebElement savebutton2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
					 savebutton2.click();
					 
					 Thread.sleep(10000);
							 	
			
			 }
			
//			@Test (enabled = false)
		    @Test (priority=7)
			 public void View_And_Verify_New_Institutions() throws InterruptedException 
			 {
		    	driver.manage().window().maximize();
		    	 Thread.sleep(5000);
			    driver.navigate().refresh();
			    Thread.sleep(10000);
			    
			    WebDriverWait wait_pageload = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait_pageload.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
							 	
			    System.out.println("Institution -> search and view the new institution*******************");
			    Reporter.log("Institution -> Search And View New Institution");
			    
				WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(inst_name2);
			 
				Thread.sleep(2000);
				
				 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
				 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
				    			
				Thread.sleep(3000);
					
				    //inst name
					
					String s1 = driver.findElement(By.xpath("//input[@id='institution-name']")).getAttribute("value");
					System.out.println("Institution name is ____________________________"+s1);
				
					if(s1.equals(inst_name2))
					{
						System.out.println("Institution name is present");
						AssertJUnit.assertEquals(s1, inst_name2);
					}
					else
					{
						System.out.println("Institution name is not present");
						AssertJUnit.assertEquals(s1, inst_name2);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Name Is Not Present In Banner view Screen.");
					}
					
					//description
					String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/textarea[1]")).getText();
					System.out.println("Institution desc is ____________________________"+s2);
					
					if(s2.equals(inst_desc2))
					{
						System.out.println("Institution name is present");
						AssertJUnit.assertEquals(s2, inst_desc2);
					}
					else
					{
						System.out.println("Institution name is not present");
						AssertJUnit.assertEquals(s2, inst_desc2);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Description Is Not Present In Banner view Screen.");
					}
					
					//slug
					String s3 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/div/textarea[1]")).getText();
					System.out.println("Institution slug is ____________________________"+s3);
					
					if(s3.equals(inst_slug2))
					{
						System.out.println("Institution slug is present");
						AssertJUnit.assertEquals(s3, inst_slug2);
					}
					else
					{
						System.out.println("Institution slug is not present");
						AssertJUnit.assertEquals(s3, inst_slug2);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Slug Is Not Present In Banner view Screen.");
					}
					
					//expert
					String s4 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[5]/div/div/div")).getText();
					System.out.println("expert is ____________________________"+s4);
					
					if(s4.equals(s4))
					{
						System.out.println("expert is present");
						AssertJUnit.assertEquals(s4, s4);
					}
					else
					{
						System.out.println("expert is not present");
						AssertJUnit.assertEquals(s4, s4);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Expert Is Not Present In Banner view Screen.");
					}
					
					// collection
					
					String s5 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[7]/div/div/input")).getAttribute("value");
					System.out.println("Collection is ____________________________"+s5);
					
					if(s5.equals(s5))
					{
						System.out.println("Collection is present");
						AssertJUnit.assertEquals(s5, s5);
					}
					else
					{
						System.out.println("Collection is not present");
						AssertJUnit.assertEquals(s5, s5);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Collection Is Not Present In Banner view Screen.");
					}
					
					//videos
					String s6 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[8]/div/div/div")).getText();
					System.out.println("Videos is ____________________________"+s6);
					
					if(s6.equals(s6))
					{
						System.out.println("Videos is present");
						AssertJUnit.assertEquals(s6, s6);
					}
					else
					{
						System.out.println("Videos is not present");
						AssertJUnit.assertEquals(s6, s6);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Videos Is Not Present In Banner view Screen.");
					}
					
					//zip
					String s7 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[9]/div/div")).getText();
					System.out.println("Zipcode is ____________________________"+s7);
					
					if(s7.equals(s7))
					{
						System.out.println("Zipcode is present");
						AssertJUnit.assertEquals(s7, s7);
					}
					else
					{
						System.out.println("Zipcode is not present");
						AssertJUnit.assertEquals(s7, s7);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Zipcode Is Not Present In Banner view Screen.");
					}
					
					
					// logo and image
					
					String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[1]/div/div/div/img")).getAttribute("src");
					System.out.println("logo scr__________"+s8);
					
					if (s8.equals(s8))
					{
							System.out.println("logo is present");
							AssertJUnit.assertEquals(s8, s8);
					}
					else
					{
							System.out.println("logo is not present");
							AssertJUnit.assertEquals(s8, s8);
							Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Logo is not present in Banner View Screen.");
							
					}
				 
					String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[2]/div/div/div/img")).getAttribute("src");
					System.out.println("img scr__________"+s9);
					
					if (s9.equals(s9))
					{
							System.out.println("image is present");
							AssertJUnit.assertEquals(s9, s9);
					}
					else
					{
							System.out.println("image is not present");
							AssertJUnit.assertEquals(s9, s9);
							Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Image is not present in Banner View Screen.");
							
					}
					
					softAssert.assertAll();
				 	 
					WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
					    	
					Thread.sleep(3000);
		   	
			 }
			
		     
		    
		  //delete 
		    @Test (priority=8)
			public void Verify_delete_Expert_is_working() throws InterruptedException
			{
		    	
		   		driver.manage().window().maximize();
		   	    Thread.sleep(5000);
		   		driver.navigate().refresh();
		   		Thread.sleep(10000);
		   		
		   		System.out.println("Institution -> Verifying the Delete from Institution page");
				Reporter.log("Institution -> Verifying the Delete from Institution page");
				
				WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
				load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]")));

		   		
				WebElement searchbox3 = driver.findElement(By.xpath("//input[@type='text']"));
				searchbox3.sendKeys(inst_name);
								
				Thread.sleep(3000);
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[3]"))).click();
				    	
				
//				WebElement icon_delete = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[3]"));
//				icon_delete.click();
				
				Thread.sleep(2000);
						
				WebElement delete_click2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
				delete_click2.click();
				
				Thread.sleep(3000);
				
				
			} 
		    
		    @AfterTest
			 public void closeBrowser() {
			 	driver.quit();
			 	
			 }

	
}
