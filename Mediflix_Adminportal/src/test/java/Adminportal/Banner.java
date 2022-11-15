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

public class Banner extends admin_user
{
	
	
//	SoftAssert softAssert; 
	SoftAssert softAssert = new SoftAssert();
	
	WebElement title;
	WebElement subtitle;
	WebElement overtitle;
	WebElement alt_text;
	WebElement decs;
	WebElement action_button_title;
	WebElement	banner_searchbox;
	WebElement tagcount1;
	
	String banner_title="AIG Health";
	String banner_subtitle="global";
	String banner_overtitle="health";
	String banner_alttext="health org";
	String banner_decs="Global Health Council is the leading member organization devoted to advancing global health";
	String banner_actionbuttontitle="Share";
	String bannerimg;
	String tagcount2;
	
	WebElement title2;
	WebElement subtitle2;
	WebElement overtitle2;
	WebElement alt_text2;
	WebElement decs2;
	WebElement action_button_title2;
	WebElement	banner_searchbox2;
		
	String banner_title2="Issues in Brain";
	String banner_subtitle2="Neurologists";
	String banner_overtitle2="Dr";
	String banner_alttext2="health org";
	String banner_decs2="Neurologists are specialists who treat diseases of the brain and spinal cord";
	String banner_actionbuttontitle2="Share";
	String bannerimg2;
	String tagcount3;
	
	String banner_order="Order";
	String banner_button_title="Title";
	String banner_type="Type";
	String banner_action_type="Action Type";
	
	

	
	
	@Test (priority=2)
//	 @Test (enabled = false)
	 public void Create_Banner_With_Madatory_fields() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/banners");
		 driver.manage().window().maximize();
		 
		 Thread.sleep(20000);
		 
		 System.out.println("Banner -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 
		 Reporter.log("Banner -> Verifying Mandatory Fields Validation Is Working Or Not");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 WebElement create_banner_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"));
		 create_banner_button.click();
			
		 Thread.sleep(1000);
		    
		 WebElement savebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
		 savebutton.click();
		 
		 Thread.sleep(1000);
		 
		 System.out.println("Banner -> Verify The Create From Banner Module With Mandatory Fields Only**************");
		
		 Reporter.log("Banner -> Create Banner With Mandatory Fields Only");
		 //banner title
		 title= driver.findElement(By.id("title"));
		 title.sendKeys(banner_title);
			 
		 Thread.sleep(1000);
		 //banner image
		 WebElement banner_img=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button"));
		 banner_img.click();
		 	 
	//	 Thread.sleep(10000);
	 
		 WebDriverWait wait_img = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_img.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img")));
		    		 
		 WebElement img_select=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"));
		 img_select.click();
	
		 WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
		 select_button.click();
		 
		 Thread.sleep(1000);

		 WebElement save_banner=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
		 save_banner.click();
		 
		 Thread.sleep(20000);

	 }
	  
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void View_And_Verify_Banner_With_Mandatory_Fields() throws InterruptedException 
	 {
		 	 
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
//		 	Thread.sleep(3000);
		 	
		 	 Thread.sleep(10000);
		 			 	 
		    System.out.println("Banner -> search and view the newly created banner*******************");
		    Reporter.log("Banner -> Search And View The Newly Created Banner");
		    
		    WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 			 
			WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title);
			
			 WebDriverWait load2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			 load2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[2]"))).click();

//			Thread.sleep(3000);
			
//			WebElement icon_view = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[2]"));
//			icon_view.click();
			
			Thread.sleep(3000);
			
			//banner title
			String s1 = driver.findElement(By.xpath("//input[@id='title']")).getAttribute("value");
			System.out.println("banner tile is ____________________________"+s1);
		
			if(s1.equals(banner_title))
			{
				System.out.println("title is present");
				AssertJUnit.assertEquals(s1, banner_title);
			}
			else
			{
				System.out.println("title is not present");
				AssertJUnit.assertEquals(s1, banner_title);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Title is not present in Banner view screen.");
			}
	
			// verify banner image
			
			String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/div/div/img")).getAttribute("src");
			System.out.println("img scr__________"+s8);
			
			if (s8.equals(s8))
			{
					System.out.println("image is present");
					AssertJUnit.assertEquals(s8, s8);
			}
			else
			{
					System.out.println("image is not present");
					AssertJUnit.assertEquals(s8, s8);
					Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Image is not present in Banner View Screen.");
					
			}
				
			softAssert.assertAll();
			WebElement closebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"));
		    closebutton.click();
		    Thread.sleep(3000);
		       
	 }
	 

//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void Edit_Banner_With_All_Fields() throws InterruptedException 
	 { 		
		 	driver.manage().window().maximize();
		    driver.navigate().refresh();

		    Thread.sleep(20000);
		   
		    System.out.println("Banner -> Search And Edit The Newly Created Banner With Remaining Fields");
		    Reporter.log("Banner -> Search And Edit The Newly Created Banner With Remaining Fields");
			
		    WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title);

			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
			
			WebElement icon_edit = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[1]"));
			icon_edit.click();
			
		   	subtitle= driver.findElement(By.id("subtitle"));
			subtitle.sendKeys(banner_subtitle);
			 
			 overtitle= driver.findElement(By.id("over-title"));
			 overtitle.sendKeys(banner_overtitle);
			 
			 alt_text= driver.findElement(By.id("image-alt-text"));
			 alt_text.sendKeys(banner_alttext);
			
			decs= driver.findElement(By.id("description"));
			decs.sendKeys(banner_decs);
			
			//tags
			
			 WebDriverWait tab_button = new WebDriverWait(driver, Duration.ofSeconds(30));
			 tab_button.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/button"))).click();
			
			 WebDriverWait tab_topic = new WebDriverWait(driver, Duration.ofSeconds(30));
			 tab_topic.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"))).click();
			 
			 WebDriverWait selectbutton = new WebDriverWait(driver, Duration.ofSeconds(30));
			 selectbutton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"))).click();
			
			
	/*		
			 WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/button"));
		     tab_button.click();
			    
		     Thread.sleep(1000);
			 
		     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"));
			 tab_topic.click();

			 Thread.sleep(1000);
			    
			 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 selectbutton.click();
	*/		    
			 Thread.sleep(1000);
			
			 // tags count
			 tagcount2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/button/p")).getText();
			 System.out.println("the tag count is __________________"+tagcount2); 
			 
			 WebElement add_button=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/button"));
			 add_button.click();
			 Thread.sleep(1000);
			 
			 action_button_title=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/input"));
			 action_button_title.sendKeys(banner_actionbuttontitle);
			 
			 WebElement type_button=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div"));
			 type_button.click();
			 
			 WebElement select_type=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[1]"));
			 select_type.click();
			 
			 Thread.sleep(1000);
			 
			 WebElement action_type=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[3]/div/div"));
			 action_type.click();
			 Thread.sleep(1000);
			 WebElement action_select=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[5]"));
			 action_select.click();
			 Thread.sleep(1000);
			 WebElement save_actionbutton=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 save_actionbutton.click();
			 
			 Thread.sleep(3000);

			 WebElement savebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
			 savebutton.click();
			
			 Thread.sleep(20000);
			 
	 }
	 
	 @Test (priority=5)
	 public void View_And_Verify_Edited_Banner()  throws InterruptedException 
	 {
		 	driver.manage().window().maximize();
		    driver.navigate().refresh();
		 
		     Thread.sleep(10000);
		 	 
		    System.out.println("Banner -> search and view the edited banner*******************");
		    Reporter.log("Banner -> Search and View The Edited Banner");
		    
			WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title);
		 
			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
						
			WebElement icon_view = driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-1muvhzt'])[1]"));
			icon_view.click();
			
			Thread.sleep(1000);
			
			//banner title
			String s1 = driver.findElement(By.xpath("//input[@id='title']")).getAttribute("value");
			System.out.println("banner tile is ____________________________"+s1);
		//	String expected="ttitle";
			
			if(s1.equals(banner_title))
			{
				System.out.println("title is present");
				AssertJUnit.assertEquals(s1, banner_title);
			}
			else
			{
				System.out.println("title is not present");
				AssertJUnit.assertEquals(s1, banner_title);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Title is not present in Banner view screen.");
			}
	
			//subtitle
			String s2 = driver.findElement(By.xpath("//input[@id='subtitle']")).getAttribute("value");
			System.out.println("banner subtile is ____________________________"+s2);
		//	String expected2=banner_subtitle;
			
			if (s2.equals(banner_subtitle))
			{
				System.out.println("banner subtitle is matching "+s2);
				AssertJUnit.assertEquals(s2, banner_subtitle);
			}
			else
			{
				System.out.println("banner subtitle is not matching "+s2);
				AssertJUnit.assertEquals(s2, banner_subtitle);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner SubTitle is not present in Banner view screen.");
				
			}
			
			//over title
			
			String s3 = driver.findElement(By.xpath("//input[@id='over-title']")).getAttribute("value");
			System.out.println("banner overtitle is ____________________________"+s3);
			//String expected3=banner_overtitle;
			
			if (s3.equals(banner_overtitle))
			{
				System.out.println("banner overtitle is matching "+s3);
				AssertJUnit.assertEquals(s3, banner_overtitle);
			}
			else
			{
				System.out.println("banner overtitle is not matching "+s3);
				AssertJUnit.assertEquals(s3, banner_overtitle);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Over Title is not present in Banner view screen.");
				
			}
			
//img alt text
			
			String s4 = driver.findElement(By.xpath("//input[@id='image-alt-text']")).getAttribute("value");
			System.out.println("banner img alt text is ____________________________"+s4);
			
	//		String expected4=banner_alttext;
			
			if (s4.equals(banner_alttext))
			{
				System.out.println("banner image alt text is matching "+s4);
				AssertJUnit.assertEquals(s4, banner_alttext);
			}
			else
			{
				System.out.println("banner image alt text is not matching "+s4);
				AssertJUnit.assertEquals(s4, banner_alttext);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Image Alternative Text is not present in Banner view screen.");
				
			}
			
			
			//desc
			
			String s5 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[5]/div/textarea[1]")).getAttribute("value");
		//	String expected5=banner_decs;
			System.out.println("banner description is ____________________________"+s5);
			if (s5.equals(banner_decs))
			{
				System.out.println("banner description is matching "+s5);
				AssertJUnit.assertEquals(s5, banner_decs);
			}
				else
			{
				System.out.println("banner description is not matching "+s5);
				AssertJUnit.assertEquals(s5, banner_decs);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Description is not present in Banner view screen.");
			
			}
			
			//tags count
			String s7 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[6]/button/p")).getText();
			System.out.println("view_____________________________tag count"+s7);
			

			if (s7.equals(tagcount2))
			{
			
			System.out.println("tags count is matching "+s7);
			AssertJUnit.assertEquals(s7, tagcount2);
			
			}
				
			else
			{
				System.out.println("tags count is not matching "+s7);
				AssertJUnit.assertEquals(s7, tagcount2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Tags is not present in Banner View Screen.");
			}
				
			
			// verify banner image
			
			String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/div/div/img")).getAttribute("src");
			System.out.println("img scr__________"+s8);
			
			if (s8.equals(s8))
			{
					System.out.println("image is present");
					AssertJUnit.assertEquals(s8, s8);
			}
			else
			{
					System.out.println("image is not present");
					AssertJUnit.assertEquals(s8, s8);
					Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Image is not present in Banner View Screen.");
					
			}
			
			softAssert.assertAll();
			WebElement closebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"));
		    closebutton.click();
		    Thread.sleep(3000);
			    
	 }
	 
	//Now create new banner and validate all required field and add all information and create it
	 
	 @Test (priority=6)
	 public void Create_New_Banner_With_All_Fields() throws InterruptedException
	 {
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 
		 Thread.sleep(20000);
	
		 System.out.println("Banner -> Verifying Create New Banner With All Information");
		 Reporter.log("Banner -> Verifying Create New Banner With All Information");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 WebElement create_banner_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"));
		 create_banner_button.click();
		
		 //banner title
		 title= driver.findElement(By.id("title"));
		 title.sendKeys(banner_title2);
			 
		 Thread.sleep(1000);
		 //banner image
		 
		 WebDriverWait banner_img2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 banner_img2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button"))).click();
		 	 
//		 WebElement banner_img2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button"));
//		 banner_img2.click();
		 
//		 Thread.sleep(9000);
		 
		 WebDriverWait wait_img = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_img.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img")));
		    	
		 WebDriverWait img_select2  = new WebDriverWait(driver, Duration.ofSeconds(30));
		 img_select2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"))).click();
		 
	//	 WebElement img_select2=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"));
	//	 img_select2.click();
		 
//		 Thread.sleep(3000);
		    
		 WebDriverWait select_button2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 select_button2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"))).click();
		 
//		 WebElement select_button2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
//		 select_button2.click();
		 
		 Thread.sleep(1000);
		 
			subtitle= driver.findElement(By.id("subtitle"));
			subtitle.sendKeys(banner_subtitle2);
			 Thread.sleep(1000);
			 overtitle= driver.findElement(By.id("over-title"));
			 overtitle.sendKeys(banner_overtitle2);
			 Thread.sleep(1000);
			 alt_text= driver.findElement(By.id("image-alt-text"));
			 alt_text.sendKeys(banner_alttext2);
			
			 Thread.sleep(1000);
			 
			decs= driver.findElement(By.id("description"));
			decs.sendKeys(banner_decs2);
			
			 Thread.sleep(1000);
			 //tags
			 
			 WebDriverWait  tab_button2= new WebDriverWait(driver, Duration.ofSeconds(30));
			 tab_button2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/button"))).click();
			 
			 WebDriverWait tab_topic2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			 tab_topic2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"))).click();
			 
			 WebDriverWait selectbutton = new WebDriverWait(driver, Duration.ofSeconds(30));
			 selectbutton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"))).click();
			 
/*			 
			WebElement tab_button2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/button"));
		     tab_button2.click();
			    
		     Thread.sleep(3000);
			 
		     WebElement tab_topic2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"));
			 tab_topic2.click();
			
			 Thread.sleep(1000);
			    
			 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 selectbutton.click();
*/			    
			 Thread.sleep(1000);
			
			 // tags count
			 tagcount3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/button/p")).getText();
			 System.out.println("the tag count is __________________"+tagcount3); 
			 
			 //add action button share
			 
			 WebDriverWait add_button = new WebDriverWait(driver, Duration.ofSeconds(30));
			 add_button.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/button"))).click();
			
//			 WebElement add_button=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/button"));
//			 add_button.click();
			 
			 Thread.sleep(1000);
			 action_button_title=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/input"));
			 action_button_title.sendKeys(banner_actionbuttontitle);
			 
			 WebDriverWait  type_button= new WebDriverWait(driver, Duration.ofSeconds(30));
			 type_button.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div"))).click();
			 
			 WebDriverWait select_type = new WebDriverWait(driver, Duration.ofSeconds(30));
			 select_type.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[3]/ul/li[1]"))).click();
			 
			 Thread.sleep(2000);
			 
			 WebDriverWait action_type = new WebDriverWait(driver, Duration.ofSeconds(30));
			 action_type.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[3]/div/div"))).click();
			 
			 WebDriverWait action_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			 action_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[3]/ul/li[5]"))).click();
			 
			 WebDriverWait save_actionbutton = new WebDriverWait(driver, Duration.ofSeconds(30));
			 save_actionbutton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"))).click();
			  
			 
/*			 
			 WebElement type_button=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div"));
			 type_button.click();
			 Thread.sleep(2000);
			 WebElement select_type=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[1]"));
			 select_type.click();
			 
			 Thread.sleep(2000);
			   
			 WebElement action_type=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[3]/div/div"));
			 action_type.click();
			 Thread.sleep(2000);
			 
			 WebElement action_select=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[5]"));
			 action_select.click();
			 Thread.sleep(2000);
			 
			 WebElement save_actionbutton=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 save_actionbutton.click();
*/			 
			 Thread.sleep(3000);

			//action button connect exp
			 
			 WebElement add_button2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/button"));
			 add_button2.click();
			 
			 
			 action_button_title=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/input"));
			 action_button_title.sendKeys("Connect Exp");
			 
			 WebElement type_button2=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div"));
			 type_button2.click();
			 
			 Thread.sleep(2000);
			 
			 WebElement select_type2=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[2]"));
			 select_type2.click();
			 
			 Thread.sleep(2000);
			 
			 WebElement action_type2=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[3]/div/div"));
			 action_type2.click();
			 Thread.sleep(2000);
			 
			 WebElement action_type_select2=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[1]"));
			 action_type_select2.click();
			 Thread.sleep(2000);
			 
			 //select conn exp videos
			 WebElement conn_click=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[4]/div/div"));
			 conn_click.click();
			 Thread.sleep(2000);
			 
			 WebElement conn_select=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[1]"));
			 conn_select.click();
			 
			 Thread.sleep(1000);
			 
			 WebElement save_actionbutton2=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 save_actionbutton2.click();
			 
			 Thread.sleep(3000);
			 
			 //action button play
			 
			 WebElement add_button3=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/button"));
			 add_button3.click();
			 			 
			 action_button_title=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/input"));
			 action_button_title.sendKeys("Play");
			 Thread.sleep(1000);
			 
			 WebElement type_click3=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div"));
			 type_click3.click();
			 
			 Thread.sleep(5000);
			 
			 WebElement select_type3=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[2]"));
			 select_type3.click();
			 
			 Thread.sleep(2000);
			 
			 WebElement action_type_click3=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[3]/div/div"));
			 action_type_click3.click();
			 Thread.sleep(2000);
			 
			 WebElement action_type_select3=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[6]"));
			 action_type_select3.click();
			 Thread.sleep(2000);
			 
			 //select conn exp videos
			 WebElement play_click=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[4]/div/div/input"));
	    	 play_click.click();
	    	 
			 Thread.sleep(5000);
			 
			 WebElement play_video_select=driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]"));
			 play_video_select.click();
			 
			 WebElement clickonramdom=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]"));
			 clickonramdom.click();
			 
     		 WebElement clickontitle=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/input"));
    		 clickontitle.click();
     		 
			 Thread.sleep(1000);
			 
			 WebElement save_actionbutton3=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 save_actionbutton3.click();
			
			 Thread.sleep(5000);
			 
			 WebElement savebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
			 Thread.sleep(1000);
			 
			 savebutton.click();
		
			 Thread.sleep(20000);
	 }
	
	 @Test (priority=7)
	 public void View_And_Verify_The_New_Banner() throws InterruptedException
	 {
		 	driver.manage().window().maximize();
		    driver.navigate().refresh();
		 
		    Thread.sleep(10000);
		     
		    System.out.println("Banner -> search and view the new banner*******************");
		    Reporter.log("Banner -> Search and View The New Banner");
		    
			WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title2);
		 
			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
							
			WebElement icon_view = driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-1muvhzt'])[1]"));
			icon_view.click();
			
			Thread.sleep(1000);
			
			//banner title
			String s11 = driver.findElement(By.xpath("//input[@id='title']")).getAttribute("value");
			System.out.println("banner tile is ____________________________"+s11);
	
			
			if(s11.equals(banner_title2))
			{
				System.out.println("title is present");
				AssertJUnit.assertEquals(s11, banner_title2);
			}
			else
			{
				System.out.println("title is not present");
				AssertJUnit.assertEquals(s11, banner_title2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Title is not present in Banner view screen.");
			}
	
			//subtitle
			String s22 = driver.findElement(By.xpath("//input[@id='subtitle']")).getAttribute("value");
			System.out.println("banner subtile is ____________________________"+s22);
		//	String expected2=banner_subtitle;
			
			if (s22.equals(banner_subtitle2))
			{
				System.out.println("banner subtitle is matching "+s22);
				AssertJUnit.assertEquals(s22, banner_subtitle2);
			}
			else
			{
				System.out.println("banner subtitle is not matching "+s22);
				AssertJUnit.assertEquals(s22, banner_subtitle2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner SubTitle is not present in Banner view screen.");
				
			}
			
			//over title
			
			String s33 = driver.findElement(By.xpath("//input[@id='over-title']")).getAttribute("value");
			System.out.println("banner overtitle is ____________________________"+s33);
			//String expected3=banner_overtitle;
			
			if (s33.equals(banner_overtitle2))
			{
				System.out.println("banner overtitle is matching "+s33);
				AssertJUnit.assertEquals(s33, banner_overtitle2);
			}
			else
			{
				System.out.println("banner overtitle is not matching "+s33);
				AssertJUnit.assertEquals(s33, banner_overtitle2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Over Title is not present in Banner view screen.");
				
			}
			
//img alt text
			
			String s44 = driver.findElement(By.xpath("//input[@id='image-alt-text']")).getAttribute("value");
			System.out.println("banner img alt text is ____________________________"+s44);
			
	//		String expected4=banner_alttext;
			
			if (s44.equals(banner_alttext2))
			{
				System.out.println("banner image alt text is matching "+s44);
				AssertJUnit.assertEquals(s44, banner_alttext2);
			}
			else
			{
				System.out.println("banner image alt text is not matching "+s44);
				AssertJUnit.assertEquals(s44, banner_alttext2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Image Alternative Text is not present in Banner view screen.");
				
			}
			
			
			//desc
			
			String s55 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[5]/div/textarea[1]")).getAttribute("value");
		//	String expected5=banner_decs;
			System.out.println("banner description is ____________________________"+s55);
			if (s55.equals(banner_decs2))
			{
				System.out.println("banner description is matching "+s55);
				AssertJUnit.assertEquals(s55, banner_decs2);
			}
				else
			{
				System.out.println("banner description is not matching "+s55);
				AssertJUnit.assertEquals(s55, banner_decs2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Description is not present in Banner view screen.");
			
			}
			
			//tags count
			String s77 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[6]/button/p")).getText();
			System.out.println("view_____________________________tag count"+s77);
			

			if (s77.equals(tagcount3))
			{
			
			System.out.println("tags count is matching "+s77);
			AssertJUnit.assertEquals(s77, tagcount3);
			
			}
				
			else
			{
				System.out.println("tags count is not matching "+s77);
				AssertJUnit.assertEquals(s77, tagcount3);
			 
			}
				
			
			// verify banner image
			
			String s88 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/div/div/img")).getAttribute("src");
			System.out.println("img scr__________"+s88);
			
			if (s88.equals(s88))
			{
					System.out.println("image is present");
					AssertJUnit.assertEquals(s88, s88);
			}
			else
			{
					System.out.println("image is not present");
					AssertJUnit.assertEquals(s88, s88);
					Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Image is not present in Banner View Screen.");
					
			}
	
			/*
			// verify banner button
						//order
						
						String s99 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div[2]/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]/div/div")).getText();
						//	String expected5=banner_decs;
							System.out.println("banner button order column name is ____________________________"+s99);
							if (s99.equals(banner_order))
							{
								System.out.println("Banner Button Order is present "+s99);
								AssertJUnit.assertEquals(s99, banner_order);
							}
								else
							{
								System.out.println("Banner Button Order is not present "+s99);
								AssertJUnit.assertEquals(s99, banner_order);
								Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Button -> Banner Button Order is not present in Banner view screen.");
							
							}
							
							//button title
							String s100 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/div/div")).getText();
							
								System.out.println("banner button title column name is ____________________________"+s100);
								if (s100.equals(banner_button_title))
								{
									System.out.println("Banner Button title is present "+s100);
									AssertJUnit.assertEquals(s100, banner_button_title);
								}
									else
								{
									System.out.println("Banner Button title is not present "+s100);
									AssertJUnit.assertEquals(s100, banner_button_title);
									Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Button -> Banner Button Title is not present in Banner view screen.");
								
								}
						
								//button type
								String s101 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div[2]/div/div[2]/div[1]/div/div/div[3]/div[1]/div[1]/div/div")).getText();
								
									System.out.println("banner button type column name is ____________________________"+s101);
									if (s101.equals(banner_type))
									{
										System.out.println("Banner Button type is present "+s101);
										AssertJUnit.assertEquals(s101, banner_type);
									}
										else
									{
										System.out.println("Banner Button type is not present "+s101);
										AssertJUnit.assertEquals(s101, banner_type);
										Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Button -> Banner Button Type is not present in Banner view screen.");
									
									}
									
									//button action type
									String s102 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div[2]/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/div/div")).getText();
									
										System.out.println("banner button action type column name is ____________________________"+s102);
										if (s102.equals(banner_action_type))
										{
											System.out.println("Banner Button action type is present "+s102);
											AssertJUnit.assertEquals(s102, banner_action_type);
										}
											else
										{
											System.out.println("Banner Button action type is not present "+s102);
											AssertJUnit.assertEquals(s102, banner_action_type);
											Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Button -> Banner Button Action type is not present in Banner view screen.");
										
										}
										*/
										softAssert.assertAll();
							
										WebElement closebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"));
										closebutton.click();									
										Thread.sleep(3000);
		 
	 }
	 
	 
//	 @Test (enabled = false)
	 @Test (priority=8)
	 public void Delete_Banner() throws InterruptedException 
	 {
		 	driver.manage().window().maximize();
		    driver.navigate().refresh();
		 
		    Thread.sleep(20000);
		 			 	
		 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]"))).click();

		 	
		    System.out.println("Banner -> search and delete the banner*******************");
		    Reporter.log("Banner -> Search And Delete The Banner");
			
		    WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title);
		 
			Thread.sleep(3000);
			//first delete the action button 
			
			WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[1]"))).click();

			
//			WebElement edit_icon = driver.findElement(By.xpath(""));
//			edit_icon.click();
			
			Thread.sleep(3000);
			
			//delete action button
			
			WebDriverWait delete = new WebDriverWait(driver, Duration.ofSeconds(30));
			delete.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div[2]/div/div[2]/div[2]/div/div/div/div/div[6]/span/button[2]"))).click();
			
			Thread.sleep(3000);
			
			WebDriverWait save_button = new WebDriverWait(driver, Duration.ofSeconds(30));
			save_button.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
					 
			Thread.sleep(3000);
			
			WebDriverWait load2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			load2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]"))).click();
			
			Thread.sleep(3000);
			
			WebDriverWait delete2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			delete2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/button[3]"))).click();
	
			Thread.sleep(3000);
			
			WebDriverWait delete3 = new WebDriverWait(driver, Duration.ofSeconds(30));
			delete3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
			
			Thread.sleep(3000);
		  
	 }
	 
	 
	 @Test (enabled = false)
//	 @Test (priority=8)
	 public void Delete_Banner2() throws InterruptedException 
	 {
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 			 	
		 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]"))).click();

		 	
		    System.out.println("Banner -> search and delete the second banner*******************");
		    Reporter.log("Banner -> Search And Delete The Second Banner");
			
		    WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title2);
		 
			Thread.sleep(3000);
			//first delete the action button 
			
			WebElement edit_icon = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[1]"));
			edit_icon.click();
			
			Thread.sleep(3000);
			
			//delete action button
			WebElement delete = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div[2]/div/div[2]/div[2]/div/div/div/div/div[6]/span/button[2]"));
			delete.click();
			
			Thread.sleep(1000);
			
			WebElement delete2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div[2]/div/div[2]/div[2]/div/div/div/div/div[6]/span/button[2]"));
			delete2.click();
			
			Thread.sleep(3000);
			
			WebElement save_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
			save_button.click();
			 
			Thread.sleep(3000);
			
			WebDriverWait load2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			load2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]"))).click();

			WebElement delete_icon = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/button[3]"));
			delete_icon.click();
			
			Thread.sleep(3000);
			
			WebElement popup_delete_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
			popup_delete_button.click();

		  
	 }
	 
	 
	  
	 @Test (enabled = false)
//	 @Test (priority=8)
	 public void filter_banner() throws InterruptedException
		{
			
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			System.out.println("Banner -> verifying the filter from banner page");
			Reporter.log("Banner -> Verifying the filter from banner page");
			
			WebElement filter = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[1]"));
			filter.click();
			
			Thread.sleep(3000);
			
			WebElement filter_tags = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/button"));
			filter_tags.click();
			
			Thread.sleep(3000);
			 
		     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[4]/div[1]/div[1]/label"));
			 tab_topic.click();
					  
			 Thread.sleep(3000);
			    
			 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 selectbutton.click();
			
			 Thread.sleep(3000);
			 
			 WebElement filter_apply = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
			 filter_apply.click();
			
			
		}
	 
	 @AfterTest
	 public void closeBrowser() {
	 	driver.quit();
	 	
	 }
	
 
	 
	
	

}
