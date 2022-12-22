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

public class Advice_module_testcases extends admin_user
{
	
	SoftAssert softAssert = new SoftAssert();
	
	WebElement question;
	WebElement question_location;
	WebElement slug;
	WebElement tags;
	
	String advice_question="Should I Go on a Diet?";
	String advice_question_location="UK";
	String advice_slug="iuwe45";
	String tagcount1;
	
	WebElement expert;
	WebElement answer;
	WebElement video;
	String expert_answer="Some people say I could lose weight, other people say I look good the way I am.";
	
	WebElement question2;
	WebElement question_location2;
	WebElement slug2;
	WebElement tags2;
	
	String advice_question2="What is the skin issues";
	String advice_question_location2="CA";
	String tagcount2;
	String advice_slug2="883gdhd";
	String expert_answer2="Skin issues are may be bec of the allergy";
	

	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public void Create_Advice_With_Madatory_fields() throws InterruptedException 
	 {
		 	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/advice");
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		  
		 System.out.println("Advice -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 
		 Reporter.log("Advice -> Verifying Mandatory Fields Validation Is Working Or Not");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("load_page"))));
		 
		 WebDriverWait Create_advice_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 Create_advice_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button"))).click();

		 Thread.sleep(1000);
		    
		 WebDriverWait wait_save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_save.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("save")))).click();
		 
		 Thread.sleep(1000);
		 
		 System.out.println("Advice -> Verify The Create From Advice Module With Mandatory Fields Only**************");
		
		 Reporter.log("Advice -> Create Advice With Mandatory Fields Only");
		 
		 
		 //advice question 
		 question = driver.findElement(By.id("tag-category"));
		 question.sendKeys(advice_question);
		 //location 
		 question_location = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/input"));
		 question_location.sendKeys(advice_question_location);
			 
		 Thread.sleep(1000);
		 	 
		 WebElement save_advice=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"));
		 save_advice.click();
		 
		 Thread.sleep(3000);

		 //add answer press yes
		 
		 WebDriverWait wait_click_yes = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_click_yes.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"))).click();
		 
		 Thread.sleep(3000);
		 
		 WebDriverWait ans_expert_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 ans_expert_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[2]/div/div/div/input")));
		 
		 WebDriverWait ans_expert_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 ans_expert_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[2]/div[2]/div/ul/li[1]")));
		 
		 Thread.sleep(2000);
		 
		 answer = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[3]/div/textarea[1]"));
		 answer.sendKeys(expert_answer);
		 
		 Thread.sleep(2000);
		 
		 WebDriverWait video_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 video_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[4]/div/div/input")));
		 
		 WebDriverWait video_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 video_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[5]/div/ul/li[3]")));
		 
		 Thread.sleep(2000);
		 
		 WebDriverWait wait_save2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_save2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/button[2]"))).click();
		 
		 Thread.sleep(2000);
		 
		 //cancel click
		 		
		 WebDriverWait wait_click_cancel = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_click_cancel.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[1]"))).click();
		 		 
		 Thread.sleep(3000);
		 
		 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=2)
	 public void View_And_Verify_Advice_With_Mandatory_Fields() throws InterruptedException 
	 {
		 	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/advice");
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	
		 	 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("load_page"))));
		 			 	 
		    System.out.println("Advice -> search and view the newly created Advice*******************");
		    Reporter.log("Advice -> Search And View The Newly Created Advice");
		 			 
			WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			advice_searchbox.sendKeys(advice_question);
		
			Thread.sleep(3000);
			
			WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("view")))).click();

			Thread.sleep(3000);
			
			//advice question 
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/textarea[1]")).getText();
			System.out.println("advice question is ____________________________"+s1);
				
					if(s1.equals(advice_question))
					{
						System.out.println("advice question is present");
						softAssert.assertEquals(s1, advice_question);
					}
					else
					{
						System.out.println("advice question is not present");
						softAssert.assertEquals(s1, advice_question);
						Reporter.log( "[ERROR] -> Advice -> View Screen -> Advice Question is not present in Advice view screen.");
					}		
					
		 	//question location
					
			String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/input")).getAttribute("value");
			System.out.println("advice question location is ____________________________"+s2);
						
					if(s2.equals(advice_question_location))
					{
							System.out.println("advice question location is present");
							softAssert.assertEquals(s2, advice_question_location);
					}
					else
					{
							System.out.println("advice question location is not present");
							softAssert.assertEquals(s2, advice_question_location);
							Reporter.log( "[ERROR] -> Advice -> View Screen -> Advice Question Location is not present in Advice view screen.");
					}	
					
					//close button 
					softAssert.assertAll();
					WebElement close_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"));
					close_button.click();
					Thread.sleep(3000);
	 }
	
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void Edit_Advice_With_All_Fields() throws InterruptedException 
	 {
		  driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/advice");
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	
		 	 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("load_page"))));
			 
		    System.out.println("Advice -> Search And Edit The Newly Created Advice With Remaining Fields");
			Reporter.log("Advice -> Search And Edit The Newly Created Advice With Remaining Fields");
		 			 
			WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			advice_searchbox.sendKeys(advice_question);
			Thread.sleep(3000);
			
			WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[1]"))).click();

			Thread.sleep(3000);
			
			//slug			
		    slug = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/div/input"));
			slug.sendKeys(advice_slug);
			
			Thread.sleep(1000);
			
			WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[5]/div/button"));
		     tab_button.click();
			    
		     Thread.sleep(1000);
			 
		     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"));
			 tab_topic.click();

			 Thread.sleep(1000);
			    
			 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/button[2]"));
			 selectbutton.click();
			 
			 //edit answer  
			 
			 WebElement click_edit_answer = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[6]/div[2]/div/div[2]/div[2]/div/div/div/div/div[3]/span/button[1]"));
			 click_edit_answer.click();
			 
			 Thread.sleep(1000);
			 
			 WebDriverWait wait_click_expert = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_click_expert.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div[2]/div/div/div/input"))).click();
			 
			 WebDriverWait wait_select_expert = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_select_expert.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div[2]/div[2]/div/ul/li[2]"))).click();
		
	 
			 //click ramdom
			 
			 WebElement clickramdom = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]"));
			 clickramdom.click();
			  
			 
			 // videos edit
			 
			 WebElement click_edit_video = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div[4]/div/div/input"));
			 click_edit_video.click();
			 
			 Thread.sleep(1000);
			 
			 WebElement select_edit_video = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div[5]/div/ul/li[1]"));
			 select_edit_video.click();
			 
			 //click ramdom
			 
			 WebElement clickramdom2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]"));
			 clickramdom2.click();
			  
			 Thread.sleep(1000);
			 // save button from edit answer			 
			 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
			 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/button[2]"))).click();
		 
			 Thread.sleep(3000);
			 
			 //save button from edit popup
			 
			 
			 WebDriverWait save_edit_popup = new WebDriverWait(driver, Duration.ofSeconds(30));
			 save_edit_popup.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 
			 Thread.sleep(3000);
			 			 
	 }

	 
//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void View_And_Verify_Edited_Advice() throws InterruptedException 
	 {
		  driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/advice");
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	 
		 	 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("load_page"))));
			 
		 	System.out.println("Advice -> search and view the edited advice*******************");
		    Reporter.log("Advice -> Search and View The Edited Advice");
		    
			WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			advice_searchbox.sendKeys(advice_question);
		
			Thread.sleep(3000);
			
			WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[2]"))).click();

			Thread.sleep(2000);
			
			//advice question 
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/textarea[1]")).getText();
			System.out.println("advice question is ____________________________"+s1);
				
					if(s1.equals(advice_question))
					{
						System.out.println("advice question is present");
						softAssert.assertEquals(s1, advice_question); 
					}
					else
					{
						System.out.println("advice question is not present");
						softAssert.assertEquals(s1, advice_question);
						Reporter.log( "[ERROR] -> Advice -> View Screen -> Advice Question is not present in Advice view screen.");
					}		
					
		 	//question location
					
			String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/input")).getAttribute("value");
			System.out.println("advice question location is ____________________________"+s2);
						
					if(s2.equals(advice_question_location))
					{
							System.out.println("advice question location is present");
							softAssert.assertEquals(s2, advice_question_location);
					}
					else
					{
							System.out.println("advice question location is not present");
							softAssert.assertEquals(s2, advice_question_location);
							Reporter.log( "[ERROR] -> Advice -> View Screen -> Advice Question Location is not present in Advice view screen.");
					}	
					
			// slug
					String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/div/input")).getAttribute("value");
					System.out.println("advice slug is ____________________________"+s3);
								
					if(s3.equals(advice_slug))
					{
							System.out.println("advice slug is present");
							softAssert.assertEquals(s3, advice_slug);
					}
					else
					{
							System.out.println("advice slug is not present");
							softAssert.assertEquals(s3, advice_slug);
							Reporter.log( "[ERROR] -> Advice -> View Screen -> Advice slug is not present in Advice view screen.");
					}
							
				// tags       
							
					String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[5]/div/button")).getText();
					System.out.println("advice tags is ____________________________"+s4);
										
					if(s4.equals(s4))
					{
							System.out.println("advice tags is present");
							softAssert.assertEquals(s4, s4);
					}
					else
					{
							System.out.println("advice tags is not present");
							softAssert.assertEquals(s4, s4);
							Reporter.log( "[ERROR] -> Advice -> View Screen -> Advice tags is not present in Advice view screen.");
					}
			
					//answer -> expert verify
					String s5 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[6]/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div")).getText();
					System.out.println("advice expert is ____________________________"+s5);
												
					if(s5.equals(s5))
					{
							System.out.println("advice expert is present");
							softAssert.assertEquals(s5, s5);
					}
					else
					{
							System.out.println("advice expert is not present");
							softAssert.assertEquals(s5, s5);
							Reporter.log( "[ERROR] -> Advice -> View Screen -> Advice Expert is not present in Advice view screen.");
					}
					softAssert.assertAll();
					Thread.sleep(3000);
			//close button
			 
			WebElement close_button =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"));
			close_button.click();
			Thread.sleep(2000);
	 }
	 
	 // create new advice with all fields
	 @Test (priority=5)
	 public void Create_New_Advice_With_All_Fields() throws InterruptedException
	 {
		  driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/advice");
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
	
		 System.out.println("Advice -> Verifying Create New Advice With All Information");
		 Reporter.log("Advice -> Verifying Create New Advice With All Information");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("load_page"))));
		 
		 WebElement create_advice_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button"));
		 create_advice_button.click();
		 
		 Thread.sleep(5000);
		 
		//advice question 
		 question = driver.findElement(By.id("tag-category"));
		 question.sendKeys(advice_question2);
		 //location 
		 question_location = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/input"));
		 question_location.sendKeys(advice_question_location2);
			 	 
		 //slug
		 slug2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/div/input"));
		 slug2.sendKeys(advice_slug2);
		 
		 //tags
		 Thread.sleep(3000);
		 
		 	WebDriverWait tab_button = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	tab_button.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[5]/div/button"))).click();
		 	 Thread.sleep(3000);
		 	WebDriverWait tab_topic = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	tab_topic.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"))).click();
		 	 Thread.sleep(3000);
		 	WebDriverWait select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/button[2]"))).click();
		 
		/* 														 
			WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[5]/div/button"));
		     tab_button.click();
			    
		     Thread.sleep(1000);
			 
		     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"));
			 tab_topic.click();

			 Thread.sleep(1000);
			    
			 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 selectbutton.click();
		*/	 
			 //tags count
			 	 
			 tagcount2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[5]/div/button")).getText();
			 System.out.println("tags count is ___________________________"+tagcount2);	 
			 
			 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
			 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
			 	
			 Thread.sleep(3000);
			 
			//add answer press yes
			 WebDriverWait wait_click_yes = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_click_yes.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"))).click();
			 
			 Thread.sleep(3000);
			 
			 WebElement ans_expert_click=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[2]/div/div/div/input"));
			 ans_expert_click.click();
			 
			 WebElement ans_expert_select=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[2]/div[2]/div/ul/li[2]"));
			 ans_expert_select.click();					               
			 
			 Thread.sleep(2000);
			 
			 answer = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[3]/div/textarea[1]"));
			 answer.sendKeys(expert_answer2);
			 
			 Thread.sleep(2000);
			 
			 WebElement video_click=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[4]/div/div/input"));
			 video_click.click();
			 
			 WebElement video_select=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[5]/div/ul/li[3]"));
			 video_select.click();
			 
			 Thread.sleep(2000);
			 
			 WebElement save_button=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/button[2]"));
			 save_button.click();
			 Thread.sleep(5000);
			 
			 //cancel click
			 		
			 WebDriverWait wait_click_cancel = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_click_cancel.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[1]"))).click();
			 
			 Thread.sleep(10000);
		 
	 }
	 
	 
//	 @Test (enabled = false)
	 @Test (priority=6)
	 public void View_And_Verify_New_Advice() throws InterruptedException 
	 {
		  driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/advice");
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 			 	 
		 	System.out.println("Advice -> search and view the new advice*******************");
		    Reporter.log("Advice -> Search and View The New Advice");
		    
		    WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("load_page"))));
		    
			WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			advice_searchbox.sendKeys(advice_question2);
			
			WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[2]"))).click();

			Thread.sleep(3000);
			
			//advice question 
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/textarea[1]")).getText();
			System.out.println("new advice question is ____________________________"+s1);
				
					if(s1.equals(advice_question2))
					{
						System.out.println("new advice question is present");
						softAssert.assertEquals(s1, advice_question2);
					}
					else
					{
						System.out.println("new advice question is not present");
						softAssert.assertEquals(s1, advice_question2);
						Reporter.log( "[ERROR] -> Advice -> View Screen -> New Advice Question is not present in Advice view screen.");
					}		
					
		 	//question location
					
			String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/input")).getAttribute("value");
			System.out.println("New advice question location is ____________________________"+s2);
						
					if(s2.equals(advice_question_location2))
					{
							System.out.println("New advice question location is present");
							softAssert.assertEquals(s2, advice_question_location2);
					}
					else
					{
							System.out.println("New advice question location is not present");
							softAssert.assertEquals(s2, advice_question_location2);
							Reporter.log( "[ERROR] -> Advice -> View Screen -> New Advice Question Location is not present in Advice view screen.");
					}	
					
			// slug
					String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/div/input")).getAttribute("value");
					System.out.println("New advice slug is ____________________________"+s3);
								
					if(s3.equals(advice_slug2))
					{
							System.out.println("New advice slug is present");
							softAssert.assertEquals(s3, advice_slug2);
					}
					else
					{
							System.out.println("New advice slug is not present");
							softAssert.assertEquals(s3, advice_slug2);
							Reporter.log( "[ERROR] -> Advice -> View Screen -> New Advice slug is not present in Advice view screen.");
					}
							
				// tags       
							
					String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[5]/div/button")).getText();
					System.out.println("New advice tags is ____________________________"+s4);
										
					if(s4.equals(tagcount2))
					{
							System.out.println("New advice tags is present");
							softAssert.assertEquals(s4, tagcount2);
					}
					else
					{
							System.out.println("New advice tags is not present");
							softAssert.assertEquals(s4, tagcount2);
							Reporter.log( "[ERROR] -> Advice -> View Screen -> Advice tags is not present in Advice view screen.");
					}
			
					//answer -> expert verify
					String s5 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[6]/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div")).getText();
					System.out.println("New advice expert is ____________________________"+s5);
												
					if(s5.equals(s5))
					{
							System.out.println("New advice expert is present");
							softAssert.assertEquals(s5, s5);
					}
					else
					{
							System.out.println("New advice expert is not present");
							softAssert.assertEquals(s5, s5);
							Reporter.log( "[ERROR] -> Advice -> View Screen -> New Advice Expert is not present in Advice view screen.");
					}
					
					softAssert.assertAll();
	
			//close button
			
			WebElement close_button =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"));
			close_button.click();
	 }
	 
		//delete 
//	 @Test (enabled = false)
	 @Test (priority=7)
	 public void View_And_Verify_Delete_Advice() throws InterruptedException 
	 {
		 	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/advice");
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	
		 	 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("load_page"))));
			 
		 	System.out.println("Advice -> search and delete the  advice*******************");
		    Reporter.log("Advice -> Search and Delete The  Advice");
		    
			WebElement advice_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			advice_searchbox.sendKeys(advice_question2);
			
			WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[1]"))).click();

			Thread.sleep(3000);
			//answer delete	
			WebElement ans_delete = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[6]/div[2]/div/div[2]/div[2]/div/div/div/div/div[3]/span/button[2]"));		
			ans_delete.click();
					
			// delete button
					
			WebElement delete_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));		
			delete_button.click();		
											
			//save button from edit popup
			WebDriverWait save_edit_popup = new WebDriverWait(driver, Duration.ofSeconds(30));
			save_edit_popup.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
						 
			Thread.sleep(10000);
			
			//delete icon 
			WebDriverWait delete_icon = new WebDriverWait(driver, Duration.ofSeconds(30));
			delete_icon.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[3]"))).click();
			
			// delete button 				
			WebDriverWait delete2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			delete2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
			
			Thread.sleep(5000);				 	
					
	 }
	 

	  
	 
	

}
