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
import java.util.concurrent.TimeUnit;

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


public class Collection_module_testcases extends admin_user
{

	
	SoftAssert softAssert = new SoftAssert();
	
	WebElement name;
	WebElement type;
	WebElement image;
	WebElement Bg_image;
	WebElement slug;
	WebElement banner;
	WebElement desc;
	WebElement video;
	WebElement child;
	WebElement audio;
	WebElement advice;
	WebElement expert;
	WebElement institution;
	
	String coll_name="Peacefull Mind";
	String coll_slug="21ygdue7";
	String coll_desc=" Is the usual way of asking what people are thinking of doing";
	String tagcount;
	
	WebElement name2;
	WebElement type2;
	WebElement image2;
	WebElement slug2;
	WebElement banner2;
	WebElement desc2;
	WebElement video2;
	WebElement child2;
	WebElement audio2;
	WebElement advice2;
	WebElement expert2;
	WebElement institution2;
	
	String coll_name2="Skin Care";
	String coll_slug2="11jh488";
	String coll_desc2="How to live happy life";
	String tagcount2;
	
	
	
	
	 @Test (priority=2)
//	 @Test (enabled = false)
	 public void Create_Collection_With_Madatory_fields() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/collections");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(10000);
		 
		 System.out.println("Collection -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 
		 Reporter.log("Collection -> Verifying Mandatory Fields Validation Is Working Or Not");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]")));
	    
		 WebElement create_collection_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"));
		 create_collection_button.click();
			
		 Thread.sleep(3000);
		    
		 WebDriverWait wait_save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_save.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		    
		 
		 WebElement savebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"));
		 savebutton.click();
		 
		 Thread.sleep(3000);
		 
		 System.out.println("Collection -> Verify The Create Collection With Mandatory Fields Only**************");
		
		 Reporter.log("Collection -> Create Collection With Mandatory Fields Only");
		 //collection name
		 name= driver.findElement(By.id("collection-name"));
		 name.sendKeys(coll_name);
		 
		 Thread.sleep(2000);
		 // collection type   
		 type = driver.findElement(By.xpath("(//*[@class='MuiAutocomplete-endAdornment css-2iz2x6'])[1]"));
		 
		 type.click();
	     
		 Thread.sleep(2000);
		 												  
	     WebElement click_coll=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/div/ul/li[4]"));
	     click_coll.click();
	     
	     Thread.sleep(5000);
	      
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Save']"))).click();
		 
		 Thread.sleep(10000);
	
		
	     
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void View_And_Verify_Collection_With_Mandatory_Fields() throws InterruptedException  
	 {
//		    driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/collections");
		    driver.manage().window().maximize();
		    Thread.sleep(5000);
		    driver.navigate().refresh();
		    Thread.sleep(3000);
		    
		 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]")));
		    
			
		    System.out.println("Collection -> search and view the newly created collection*******************");
		    Reporter.log("Collection -> Search And View The Newly Created Collection");
		    
			WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			coll_searchbox.sendKeys(coll_name);
		 
			Thread.sleep(3000);
			
			 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
			    			
	//		WebElement icon_view = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"));
	//		icon_view.click();
			
			Thread.sleep(2000);
			
			
			//collection name
			String s1 = driver.findElement(By.xpath("//input[@id='collection-name']")).getAttribute("value");
			System.out.println("Collection name is ____________________________"+s1);
		
			if(s1.equals(coll_name))
			{
				System.out.println("name is present");
				AssertJUnit.assertEquals(s1, coll_name);
			}
			else
			{
				System.out.println("name is not present");
				AssertJUnit.assertEquals(s1, coll_name);
				Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Name Is Not Present In Banner view Screen.");
			}
			
			//collection type
			
			String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div/input")).getAttribute("value");
			System.out.println("collection type is ____________________________"+s2);
		
			if(s2.equals(s2))
			{
				System.out.println("collection type  is present");
				AssertJUnit.assertEquals(s2, s2);
			}
			else
			{
				System.out.println("collection type is not present");
				AssertJUnit.assertEquals(s2, s2);
				Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Name Is Not Present In Banner view Screen.");
			}
	
			
			softAssert.assertAll();
			
			//close button
			
			Thread.sleep(5000);
			
			 WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();
			    	
			 Thread.sleep(10000);
		 }
			 
//		@Test (enabled = false)
		 @Test (priority=4)
		 public void Edit_Collection_With_All_Fields() throws InterruptedException 
		 {		
//			 	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/collections");
			    driver.manage().window().maximize();
			    driver.navigate().refresh();
//			    Thread.sleep(10000);
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
			    
			    WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
				load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]")));
			    
			    System.out.println("Collection -> Search And Edit The Newly Created Collection With Remaining Fields");
			    Reporter.log("Collection -> Search And Edit The Newly Created Collection With Remaining Fields");
			    
			    WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(coll_name);
			 
				Thread.sleep(3000);
			    
			    WebDriverWait wait_edit = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait_edit.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[1]"))).click();
				    	
			    Thread.sleep(3000);
			    
			    
			    //collection image
			    image = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/button/p"));
			    image.click();
			    
			    Thread.sleep(2000);
			    
			    WebDriverWait wait_image = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait_image.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"))).click();
			    
			    Thread.sleep(3000);
			   //select button
			    
			    WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
			    select_button.click();
			    
			    Thread.sleep(2000);
			    
			    //bg image  
			    Bg_image = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[4]/button/p"));
			    Bg_image.click();
			    Thread.sleep(2000);
			    
			    WebDriverWait wait_bg_image = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait_bg_image.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"))).click();
			    
			    Thread.sleep(3000);
			   //select button
			    
			    WebElement select_button2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
			    select_button2.click();
			    
			    //slug 
			    slug = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[5]/div/input"));
			    slug.sendKeys(coll_slug);
			    
			    //banner 
			    
			    WebDriverWait banner_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			    banner_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[6]/div/div/input"))).click();
			    
			    WebDriverWait banner_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			    banner_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[7]/div/ul/li[3]"))).click();
			        			    
			    //description
			    desc = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[7]/div/textarea[1]"));
			    desc.sendKeys(coll_desc);
			    
			    //video click 
			    video=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]/div/div/div/input"));
			    video.click();
			    //video select 
			    WebElement video_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]"));
			    video_select.click();
			    
			    WebElement m1=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m1.click();
			    
			    
			    //child click 
			    child=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/input"));
			    child.click();
			    //child select 
			    WebElement child_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]"));
			    child_select.click();
			    WebElement m2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m2.click();
			    
			    
			    //audio click 
			    audio=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div[1]/div/div/input"));
			    audio.click();
			    //audio select 
			    WebElement audio_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div[2]/div/ul/li[1]"));
			    audio_select.click();
			    WebElement m3=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m3.click();
			    
			    
			    //advice click 
			    advice=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/input"));
			    advice.click();
			    //advice select 
			    WebElement advice_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div[2]/div/ul/li[1]"));
			    advice_select.click();
			    WebElement m4=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m4.click();
			    
			    
			    //expert click 
			    expert=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[5]/div/div/input"));
			    expert.click();
			    //expert select 
			    WebElement expert_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[9]"));
			    expert_select.click();
			    WebElement m5=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m5.click();
			    
			    
			    //institution click 
			    institution=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[6]/div/div/input"));
			    institution.click();
			    //institution select 
			    WebElement institution_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[7]/div/ul/li[4]"));
			    institution_select.click();
			    WebElement m6=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m6.click();
			    
			    //tags
			    WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[8]/div/button"));
			    tab_button.click();
				    
			     Thread.sleep(2000);
				 
			     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"));
				 tab_topic.click();
							  
				 Thread.sleep(2000);
				    
				 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/button[2]"));
				 selectbutton.click();
				    
				 Thread.sleep(5000);
			    
				 WebDriverWait save_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 save_click.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
				 
				 Thread.sleep(10000);
			    
		 }
	
//		 @Test (enabled = false)
	     @Test (priority=5)
		 public void View_And_Verify_Edited_Collection_() throws InterruptedException 
		 {
//	    	    driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/collections");
	    	 	driver.manage().window().maximize();
	    	 	 Thread.sleep(5000);
			    driver.navigate().refresh();
			    Thread.sleep(10000);
			 	
			 	 
			    System.out.println("Collection -> search and view edited  collection*******************");
			    Reporter.log("Collection -> Search And View Edited  Collection");
			    
				WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(coll_name);
			 
				Thread.sleep(3000);
				
				 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
				 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
				    			
		//		WebElement icon_view = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"));
		//		icon_view.click();
				
				Thread.sleep(2000);
				
				 
				//collection name
				String s1 = driver.findElement(By.xpath("//input[@id='collection-name']")).getAttribute("value");
				System.out.println("Collection name is ____________________________"+s1);
			
				if(s1.equals(coll_name))
				{
					System.out.println("name is present");
					AssertJUnit.assertEquals(s1, coll_name);
				}
				else
				{
					System.out.println("name is not present");
					AssertJUnit.assertEquals(s1, coll_name);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Name Is Not Present In Collection view Screen.");
				}
				
				//collection type
				
				String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div/input")).getAttribute("value");
				System.out.println("collection type is ____________________________"+s2);
			
				if(s2.equals(s2))
				{
					System.out.println("collection type  is present");
					AssertJUnit.assertEquals(s2, s2);
				}
				else
				{
					System.out.println("collection type is not present");
					AssertJUnit.assertEquals(s2, s2);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Name Is Not Present In Collection view Screen.");
				}
		
				
				//collection slug
				String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/div/input")).getAttribute("value");
				System.out.println("Collection slug is ____________________________"+s3);
			
				if(s3.equals(coll_slug))
				{
					System.out.println("slug is present");
					AssertJUnit.assertEquals(s3, coll_slug);
				}
				else
				{
					System.out.println("slug is not present");
					AssertJUnit.assertEquals(s3, coll_slug);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Slug Is Not Present In Collection view Screen.");
				}
				
				
				//banner
				String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[4]/div/div/input")).getAttribute("value");
				System.out.println("collection view -> banner is ____________________________"+s4);
			
				if(s4.equals(s4))
				{
					System.out.println("collection view -> banner  is present");
					AssertJUnit.assertEquals(s4, s4);
				}
				else
				{
					System.out.println("collection view -> banner is not present");
					AssertJUnit.assertEquals(s4, s4);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Banner Is Not Present In Collection view Screen.");
				}
				
				//collection description
				String s5 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[5]/div/textarea[1]")).getText();
				System.out.println("Collection description is ____________________________"+s5);
			
				if(s5.equals(coll_desc))
				{
					System.out.println("description is present");
					AssertJUnit.assertEquals(s5, coll_desc);
				}
				else
				{
					System.out.println("description is not present");
					AssertJUnit.assertEquals(s5, coll_desc);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Description Is Not Present In Collection view Screen.");
				}
				
				
				//collection videos
				String s6 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]/div/div/div")).getText();
				System.out.println("Collection -> videos is ____________________________"+s6);
			
				if(s6.equals(s6))
				{
					System.out.println("videos is present");
					AssertJUnit.assertEquals(s6, s6);
				}
				else
				{
					System.out.println("videos is not present");
					AssertJUnit.assertEquals(s6, s6);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Videos Is Not Present In Collection view Screen.");
				}
				
				//collection-> child collection 
				String s7 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div/div/div")).getText();
				System.out.println("Collection -> child collection is ____________________________"+s7);
			
				if(s7.equals(s7))
				{
					System.out.println("child collection is present");
					AssertJUnit.assertEquals(s7, s7);
				}
				else
				{
					System.out.println("child collection  is not present");
					AssertJUnit.assertEquals(s7, s7);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Child Collection Is Not Present In Collection view Screen.");
				}
				
				
				//collection audio
				String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div/div/div")).getText();
				System.out.println("Collection -> audio is ____________________________"+s8);
			
				if(s8.equals(s8))
				{
					System.out.println("audio is present");
					AssertJUnit.assertEquals(s8, s8);
				}
				else
				{
					System.out.println("audio is not present");
					AssertJUnit.assertEquals(s8, s8);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Audio Is Not Present In Collection view Screen.");
				}
				
				//collection advice
				String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div/div/div")).getText();
				System.out.println("Collection -> advice is ____________________________"+s9);
			
				if(s9.equals(s9))
				{
					System.out.println("advice is present");
					AssertJUnit.assertEquals(s9, s9);
				}
				else
				{
					System.out.println("advice is not present");
					AssertJUnit.assertEquals(s9, s9);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Advice Is Not Present In Collection view Screen.");
				}
				
				//collection expert
				String s10 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[5]/div/div")).getText();
				System.out.println("Collection -> expert is ____________________________"+s10);
			
				if(s10.equals(s10))
				{
					System.out.println("expert is present");
					AssertJUnit.assertEquals(s10, s10);
				}
				else
				{
					System.out.println("expert is not present");
					AssertJUnit.assertEquals(s10, s10);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Expert Is Not Present In Collection view Screen.");
				}
				
				//collection institution
				String s11 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[6]/div/div")).getText();
				System.out.println("Collection -> institution is ____________________________"+s11);
			
				if(s11.equals(s11))
				{
					System.out.println("institution is present");
					AssertJUnit.assertEquals(s11, s11);
				}
				else
				{
					System.out.println("institution is not present");
					AssertJUnit.assertEquals(s11, s11);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Institution Is Not Present In Collection view Screen.");
				}			
							
				softAssert.assertAll();
	 	 
				WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();
																				   
				Thread.sleep(3000);
				
		 } 
		 
//		 @Test (enabled = false)
	     @Test (priority=6)
		 public void Create_New_Collection_With_All_Fields() throws InterruptedException
		 {
	    	 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/collections");
			 driver.manage().window().maximize();
			 driver.navigate().refresh();
			 Thread.sleep(10000);
			 
			 WebDriverWait wait_pageload = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_pageload.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]/div/div"))).click();
			    	 
		//	 Thread.sleep(5000);

			 Reporter.log("Collection -> Verifying Create New Collection With All Information");
			 	 
			 WebElement create_collection_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"));
			 create_collection_button.click();
			 
			 WebDriverWait wait_popupload = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_popupload.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[1]/div/input"))).click();
			 
			 
		//	 Thread.sleep(5000);
			 
			//collection name
			 name2= driver.findElement(By.id("collection-name"));
			 name2.sendKeys(coll_name2);
			 
			 type2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div"));
		     type2.click();
		     
		     WebElement click_coll=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/div/ul/li[4]"));
		     click_coll.click();
		     
		   //colection image
			    image2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/button"));
			    image2.click();
			    
			    Thread.sleep(2000);
			    
			    WebDriverWait wait_image = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait_image.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"))).click();
			    
			    Thread.sleep(3000);
			   //select button
			    
			    WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
			    select_button.click();
			    
			  //background image
			    WebElement bg_image2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[4]/button"));
			    bg_image2.click();					                
			    
			    Thread.sleep(2000);
			    
			    WebDriverWait wait_image2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait_image2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"))).click();
			    
			    Thread.sleep(3000);
			   //select button
			    
			    WebElement select_button2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
			    select_button2.click();
			    
			    
			    slug2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[5]/div/input"));
			    slug2.sendKeys(coll_slug2);
			    
			    //banner click 
			    banner2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[6]/div/div/input"));
			    banner2.click();
			    //select banner
			    WebElement banner_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[7]/div/ul/li[3]"));
			    banner_select.click();
			    
			    desc2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[7]/div/textarea[1]"));
			    desc2.sendKeys(coll_desc2);
			    
			    
			    
			    //video click 
			    video2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]/div/div/div/input"));
			    video2.click();
			    //video select 
			    WebElement video_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]"));
			    video_select.click();
			    
			    WebElement m1=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m1.click();
			    
			    
			    //child click 
			    child2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/input"));
			    child2.sendKeys(coll_name);
			    Thread.sleep(2000);
//			    //child select 
//			    WebElement child_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]"));
//			    child_select.click();
			    // select the searched collection
			    WebElement search_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li"));
			    search_select.click();
			    
			    
			    WebElement m2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m2.click();
			    
			    
			    //audio click 
			    audio2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div[1]/div/div/input"));
			    audio2.click();
			    //audio select 
			    WebElement audio_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div[2]/div/ul/li[1]"));
			    audio_select.click();
			    WebElement m3=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m3.click();
			    
			    
			    //advice click 
			    advice2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/input"));
			    advice2.click();
			    //advice select 
			    WebElement advice_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div[2]/div/ul/li[1]"));
			    advice_select.click();
			    WebElement m4=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m4.click();
			    
			    
			    //expert click 
			    expert2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[5]/div/div/input"));
			    expert2.click();
			    //expert select 
			    WebElement expert_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[9]"));
			    expert_select.click();
			    WebElement m5=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m5.click();
			    
			    
			    //institution click 
			    institution2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[6]/div/div/input"));
			    institution2.click();
			    //institution select 
			    WebElement institution_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[7]/div/ul/li[4]"));
			    institution_select.click();
			    WebElement m6=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m6.click();
			    
			    //tags
			    WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[8]/div/button"));
			    tab_button.click();
				    
			     Thread.sleep(2000);
				 
			     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"));
				 tab_topic.click();
							  
				 Thread.sleep(2000);
				    
				 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/button[2]"));
				 selectbutton.click();
				    
				 Thread.sleep(10000);
			    
				 WebElement save_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"));
				 save_button.click();
				 
				 Thread.sleep(10000);
		 
		 }	 

//	 	 @Test (enabled = false)
	     @Test (priority=7)
	 	 public void View_And_Verify_New_Collection_() throws InterruptedException 
	 	 {
//	    	 	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/collections");
	    	 	driver.manage().window().maximize();
	    	 	Thread.sleep(5000);
	 		    driver.navigate().refresh();
	 		 		 	
	 		 	Thread.sleep(10000);
	 		 	
	 		    System.out.println("Collection -> search and view new collection*******************");
	 		    Reporter.log("Collection -> Search And View New Collection");
	 		    
	 			WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
	 			coll_searchbox.sendKeys(coll_name2);
	 		 
	 			Thread.sleep(3000);
	 			
	 			 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
	 			 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
	 			    			
	 			 Thread.sleep(2000);
	 				
	 				
	 				//collection name
	 				String s1 = driver.findElement(By.xpath("//input[@id='collection-name']")).getAttribute("value");
	 				System.out.println("Collection name is ____________________________"+s1);
	 			
	 				if(s1.equals(coll_name2))
	 				{
	 					System.out.println("name is present");
	 					AssertJUnit.assertEquals(s1, coll_name2);
	 				}
	 				else
	 				{
	 					System.out.println("name is not present");
	 					AssertJUnit.assertEquals(s1, coll_name2);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> Mew Collection Name Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection type
	 				
	 				String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div/input")).getAttribute("value");
	 				System.out.println("collection type is ____________________________"+s2);
	 			
	 				if(s2.equals(s2))
	 				{
	 					System.out.println("collection type  is present");
	 					AssertJUnit.assertEquals(s2, s2);
	 				}
	 				else
	 				{
	 					System.out.println("collection type is not present");
	 					AssertJUnit.assertEquals(s2, s2);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Name Is Not Present In Collection view Screen.");
	 				}
	 		
	 				
	 				//collection slug
	 				String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/div/input")).getAttribute("value");
	 				System.out.println("Collection slug is ____________________________"+s3);
	 			
	 				if(s3.equals(coll_slug2))
	 				{
	 					System.out.println("slug is present");
	 					AssertJUnit.assertEquals(s3, coll_slug2);
	 				}
	 				else
	 				{
	 					System.out.println("slug is not present");
	 					AssertJUnit.assertEquals(s3, coll_slug2);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Slug Is Not Present In Collection view Screen.");
	 				}
	 				
	 				
	 				//banner
	 				String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[4]/div/div/input")).getAttribute("value");
	 				System.out.println("collection view -> banner is ____________________________"+s4);
	 			
	 				if(s4.equals(s4))
	 				{
	 					System.out.println("collection view -> banner  is present");
	 					AssertJUnit.assertEquals(s4, s4);
	 				}
	 				else
	 				{
	 					System.out.println("collection view -> banner is not present");
	 					AssertJUnit.assertEquals(s4, s4);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Banner Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection description
	 				String s5 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[5]/div/textarea[1]")).getText();
	 				System.out.println("Collection description is ____________________________"+s5);
	 			
	 				if(s5.equals(coll_desc2))
	 				{
	 					System.out.println("description is present");
	 					AssertJUnit.assertEquals(s5, coll_desc2);
	 				}
	 				else
	 				{
	 					System.out.println("description is not present");
	 					AssertJUnit.assertEquals(s5, coll_desc2);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Description Is Not Present In Collection view Screen.");
	 				}
	 				
	 				
	 				//collection videos
	 				String s6 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]/div/div/div")).getText();
	 				System.out.println("Collection -> videos is ____________________________"+s6);
	 			
	 				if(s6.equals(s6))
	 				{
	 					System.out.println("videos is present");
	 					AssertJUnit.assertEquals(s6, s6);
	 				}
	 				else
	 				{
	 					System.out.println("videos is not present");
	 					AssertJUnit.assertEquals(s6, s6);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Videos Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection-> child collection 
	 				String s7 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div/div/div")).getText();
	 				System.out.println("Collection -> child collection is ____________________________"+s7);
	 			
	 				if(s7.equals(s7))
	 				{
	 					System.out.println("child collection is present");
	 					AssertJUnit.assertEquals(s7, s7);
	 				}
	 				else
	 				{
	 					System.out.println("child collection  is not present");
	 					AssertJUnit.assertEquals(s7, s7);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Child Collection Is Not Present In Collection view Screen.");
	 				}
	 				
	 				
	 				//collection audio
	 				String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div/div/div")).getText();
	 				System.out.println("Collection -> audio is ____________________________"+s8);
	 			
	 				if(s8.equals(s8))
	 				{
	 					System.out.println("audio is present");
	 					AssertJUnit.assertEquals(s8, s8);
	 				}
	 				else
	 				{
	 					System.out.println("audio is not present");
	 					AssertJUnit.assertEquals(s8, s8);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen ->New Collection Audio Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection advice
	 				String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div/div/div")).getText();
	 				System.out.println("Collection -> advice is ____________________________"+s9);
	 			
	 				if(s9.equals(s9))
	 				{
	 					System.out.println("advice is present");
	 					AssertJUnit.assertEquals(s9, s9);
	 				}
	 				else
	 				{
	 					System.out.println("advice is not present");
	 					AssertJUnit.assertEquals(s9, s9);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Advice Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection expert
	 				String s10 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[5]/div/div")).getText();
	 				System.out.println("Collection -> expert is ____________________________"+s10);
	 			
	 				if(s10.equals(s10))
	 				{
	 					System.out.println("expert is present");
	 					AssertJUnit.assertEquals(s10, s10);
	 				}
	 				else
	 				{
	 					System.out.println("expert is not present");
	 					AssertJUnit.assertEquals(s10, s10);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Expert Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection institution
	 				String s11 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[6]/div/div")).getText();
	 				System.out.println("Collection -> institution is ____________________________"+s11);
	 			
	 				if(s11.equals(s11))
	 				{
	 					System.out.println("institution is present");
	 					AssertJUnit.assertEquals(s11, s11);
	 				}
	 				else
	 				{
	 					System.out.println("institution is not present");
	 					AssertJUnit.assertEquals(s11, s11);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Institution Is Not Present In Collection view Screen.");
	 				}			
	 							
	 				softAssert.assertAll();
	 				
	 				Thread.sleep(2000);
	 				
	 				
	 	 	 
	 				WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
	 				wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();
	 				    	
	 				Thread.sleep(3000);
	 	 }
	     
//	 	 @Test (enabled = false)
	     @Test (priority=8)
	 	 public void Verify_Parent_Collection() throws InterruptedException 
	 	 {
	    	    driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/collections");
			    driver.manage().window().maximize();
			    Thread.sleep(5000);
			    driver.navigate().refresh();
			    Thread.sleep(3000);
			    
			 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
				load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]")));
			    
				
			    System.out.println("Collection -> search and view the newly created collection*******************");
			    Reporter.log("Collection -> Search And View The Newly Created Collection");
			    
				WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(coll_name);
			 
				Thread.sleep(3000);
				
				 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
				 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
				    			
	 			Thread.sleep(2000);
	 			 
	 			// verify the parent collection 
	 				
	 				WebElement click_parent_coll = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/button"));
	 				click_parent_coll.click();
	 				
	 				//  load
	 				WebDriverWait wait_parent_coll = new WebDriverWait(driver, Duration.ofSeconds(30));
	 				wait_parent_coll.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div[1]/ul")));
	 				    	
	 				//read
	 				String Verify_parent_coll =driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/ul")).getText();
	 				System.out.println("Parent collections are___________________________"+Verify_parent_coll);
	 				
	 				if(Verify_parent_coll.equals(Verify_parent_coll))
	 				{
	 						System.out.println("Parent collection is present");
	 						softAssert.assertEquals(Verify_parent_coll, Verify_parent_coll); 
	 				 }
	 				 else
	 				 {
	 						System.out.println("Parent collection is not present");
	 						softAssert.assertEquals(Verify_parent_coll, Verify_parent_coll);
	 						Reporter.log( "[ERROR] -> Collection -> View Screen -> Parent collection is not present in Collection view screen.");
	 				 }		
	 			 
	 				// close parent  /html/body/div[3]/div[3]/div/div[2]/button
	 				 
	 				 WebDriverWait wait_close_parent = new WebDriverWait(driver, Duration.ofSeconds(30));
	 				 wait_close_parent.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button"))).click();
	 				
	 				// close view  
	 				
	 				 WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
	 				 wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();
	 			
	 	 }
	     
//	 	 @Test (enabled = false)
	     @Test (priority=9)
	 	 public void Delete_New_Collection_() throws InterruptedException 
	 	 {
	    	 
//	    	 	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/collections");
	     	    driver.manage().window().maximize();
	     	    driver.navigate().refresh();
	     	    Thread.sleep(10000);
	     	   
//	     	    wait(self.driver, 60).until(EC.presence_of_all_elements_located);
	 		    System.out.println("Collection -> search and delete new collection*******************");
	 		    Reporter.log("Collection -> Search And Delete New Collection");
	 		    
	 			WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
	 			coll_searchbox.sendKeys(coll_name2);
	 		 
	 			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
	 			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]/div/div"))).click();
	 	
	 			WebElement delete_icon= driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[3]"));
	 			delete_icon.click();

	 			Thread.sleep(2000);
	 			 	 
	 			WebElement delete_click = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
	 			delete_click.click();
	 			
	 			Thread.sleep(4000);
	 			 	 	
	 	   }
	     
	     
	     
	     
	 	@Test (enabled = false)
//		 @Test (priority=9)
		 public void filter_banner() throws InterruptedException
			{
				
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println("Collection -> Verifying the filter from collection page");
				Reporter.log("Collection -> Verifying the filter from collection page");
				
				WebElement filter = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[1]"));
				filter.click();
				
				Thread.sleep(3000);
				
				WebElement filter_coll_type = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/input"));
				filter_coll_type.click();
				
				Thread.sleep(2000);
				
				WebElement filter_coll_page = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/ul/li[2]"));
				filter_coll_page.click();
				
					
				
/*				
				WebElement filter_tags = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/button"));
				filter_tags.click();
				
				Thread.sleep(3000);
				 
			     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[4]/div[1]/div[1]/label"));
				 tab_topic.click();
						  
				 Thread.sleep(3000);
				    
				 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
				 selectbutton.click();
				
				 Thread.sleep(3000);
*/		 
				 WebElement filter_apply = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
				 filter_apply.click();
				 
				
			}
	     
//	 	@AfterTest
//		 public void closeBrowser() 
//	 	{
//		 	driver.quit();
//		 	
//		 }
	
}


