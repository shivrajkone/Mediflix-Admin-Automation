package Adminportal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.html5.LocalStorage;

import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.admin_user;

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

public class Expert_module_test_cases  extends admin_user
{

	
	SoftAssert softAssert = new SoftAssert();
	
	String expert_name="Dr.Divid";
	String expert_slug="123dsc";
	String expert_bio="University Of Cambridge";
	String expert_tagcount;
	
	String expert_name2="MD.Patrick";
	String expert_slug2="sdkhgcs1223";
	String expert_bio2="University Of NY";
	String expert_tagcount2;
	WebElement searchbox4;
	 
	
	 
//	@Test (enabled = false)
	@Test (priority=2)
	public void Create_Expert_With_Madatory_fields() throws InterruptedException 
	{
		driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/experts");
		driver.manage().window().maximize();
    	driver.navigate().refresh();
    	Thread.sleep(3000);
    	
		System.out.println("Expert -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 
		Reporter.log("Expert -> Verifying Mandatory Fields Validation Is Working Or Not");
		
		WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();

		WebDriverWait create_expert = new WebDriverWait(driver, Duration.ofSeconds(30));
		create_expert.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"))).click();
	
	    WebDriverWait wait_save = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait_save.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
	
	    String s1="Expert Name is required";
	    String s2 = driver.findElement(By.xpath("//p[text()='Expert Name is required']")).getText();
	    if(s1.equalsIgnoreCase(s2))
	    	System.out.println("The error message is same");
	    else
	    	System.out.println("The error message is not matching");
	    
	    Thread.sleep(2000);
	    
	    System.out.println("Expert -> Verify The Create Button From Expert Module With Mandatory Fields Only**************");
		
		Reporter.log("Expert -> Create Expert With Mandatory Fields Only"); 
	    
	    driver.findElement(By.id("expert-name")).sendKeys(expert_name);
	    
	    Thread.sleep(5000);
	    
	    WebElement save_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
	    save_button.click();
	    Thread.sleep(10000);
	}
	
	
	@Test (priority=3)
	public void View_And_Verify_Expert_With_Mandatory_Fields() throws InterruptedException
	{
		driver.manage().window().maximize();
    	driver.navigate().refresh();
    	Thread.sleep(3000);
    	
	System.out.println("Expert -> search and view the newly created expert*******************");
    Reporter.log("Expert -> Search And View The Newly Created Expert");
			   
	WebElement searchbox1 = driver.findElement(By.xpath("//input[@type='text']"));

	searchbox1.sendKeys(expert_name);
	
//	Thread.sleep(3000);
	
	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
	load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();

	WebElement icon_view = driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-1muvhzt'])[1]"));
	icon_view.click();
	
	Thread.sleep(3000);
	
	//expert name
	String s1 = driver.findElement(By.xpath("//input[@id='expert-name']")).getAttribute("value");
	System.out.println("Expert name is ____________________________"+s1);

	if(s1.equals(expert_name))
	{
		System.out.println("Expert name is present  "+s1);
		AssertJUnit.assertEquals(s1, expert_name);
	}
	else
	{
		System.out.println("Expert name is not present"+s1);
		AssertJUnit.assertEquals(s1, expert_name);
		Reporter.log( "[ERROR] -> Expert -> View Screen -> Expert Name is not present in Expert view screen.");
	}
	
	
	softAssert.assertAll();
	
	WebElement closebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"));
    closebutton.click();
   
    Thread.sleep(3000);
			
	}
	   
//  @Test (enabled = false)
	  @Test (priority=4)
	public void Edit_Expert_With_All_Fields() throws InterruptedException
	{
		  	driver.manage().window().maximize();
	    	driver.navigate().refresh();
	    	Thread.sleep(3000);
			
			System.out.println("Expert -> Search And Edit The Newly Created Expert With Remaining Fields");
			Reporter.log("Expert -> Search And Edit The Newly Created Expert With Remaining Fields");
			
			
			WebElement searchbox2 = driver.findElement(By.xpath("//input[@type='text']"));
			searchbox2.sendKeys(expert_name);
			
			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
						
	//		Thread.sleep(3000);
			
			WebElement icon_edit = driver.findElement(By.xpath("//Button[@aria-label='Edit']"));
			icon_edit.click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("slug")).sendKeys(expert_slug);
		    driver.findElement(By.id("expert-bio")).sendKeys(expert_bio);
		    
		    
		    WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[6]/div/button"));
		    tab_button.click();
		    
		    Thread.sleep(1000);
		   
		    WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[7]/div[1]/div[1]/label"));
		    tab_topic.click();
		    
		    Thread.sleep(1000);
		    
		    WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
		    selectbutton.click();
			
		    Thread.sleep(1000);
			
			 // tags count
		     expert_tagcount = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[6]/div/button")).getText();
			 System.out.println("the tag count is __________________"+expert_tagcount); 
		
			// headshot image select
			    WebElement headshot = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button"));
			    headshot.click();
			    
			    WebDriverWait wait_hs = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait_hs.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[13]/div/div/p")));
			    			    
			    WebElement select_img = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[13]/div/div/p"));
			    select_img.click();
		
			    WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
			    select_button.click();
			    
			    //wideshot image select
			    
			    WebElement wideshot = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/button"));
			    wideshot.click();
			    
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img")));
			
			    WebElement select_img2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img"));
			    select_img2.click();
		
			    WebElement select_button2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
			    select_button2.click();
			    
			    Thread.sleep(1000);
			    
			    WebElement zip_click = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div/div"));
			    zip_click.click();
			    
			    WebElement zip_select = driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[2]"));
			    zip_select.click();
			    
			    Thread.sleep(5000);
			
			    WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
			    save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
			     
			    Thread.sleep(20000);
		
		   
	}   

	//  @Test (enabled = false)
		@Test (priority=5)
	public void View_And_Verify_Edited_Expert() throws InterruptedException
	{
			
			driver.manage().window().maximize();
	    	driver.navigate().refresh();
	    	Thread.sleep(3000);
	    	    	
	    	System.out.println("Expert -> search and view the edited  expert*******************");
	        Reporter.log("Expert -> Search And View The Edited  Expert");
	    			   
	    	WebElement searchbox1 = driver.findElement(By.xpath("//input[@type='text']"));

	    	searchbox1.sendKeys(expert_name);
	    	
	    	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		
	    	WebElement icon_view = driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-1muvhzt'])[1]"));
	    	icon_view.click();
	    	
	    	Thread.sleep(1000);
	    	
	    	//expert name
	    	String s1 = driver.findElement(By.xpath("//input[@id='expert-name']")).getAttribute("value");
	    	System.out.println("Expert name is ____________________________"+s1);

	    	if(s1.equals(expert_name))
	    	{
	    		System.out.println("Expert name is present  "+s1);
	    		AssertJUnit.assertEquals(s1, expert_name);
	    	}
	    	else
	    	{
	    		System.out.println("Expert name is not present"+s1);
	    		AssertJUnit.assertEquals(s1, expert_name);
	    		Reporter.log( "[ERROR] -> Expert -> View Screen -> Expert Name is not present in Expert view screen.");
	    	}
	    	
	    	//expert slug
	    	String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div/textarea[1]")).getAttribute("value");
	    	System.out.println("Expert slug is ____________________________"+s2);

	    	if(s2.equals(expert_slug))
	    	{
	    		System.out.println("Expert slug is present  "+s2);
	    		AssertJUnit.assertEquals(s2, expert_slug);
	    	}
	    	else
	    	{
	    		System.out.println("Expert slug is not present"+s2);
	    		AssertJUnit.assertEquals(s2, expert_slug);
	    		Reporter.log( "[ERROR] -> Expert -> View Screen -> Expert Slug is not present in Expert view screen.");
	    	}
	    	
	    	//expert bio
	    	
	    	String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/textarea[1]")).getAttribute("value");
	    	System.out.println("Expert bio is ____________________________"+s3);

	    	if(s3.equals(expert_bio))
	    	{
	    		System.out.println("Expert bio is present  "+s3);
	    		AssertJUnit.assertEquals(s3, expert_bio);
	    	}
	    	else
	    	{
	    		System.out.println("Expert bio is not present"+s3);
	    		AssertJUnit.assertEquals(s3, expert_bio);
	    		Reporter.log( "[ERROR] -> Expert -> View Screen -> Expert Bio is not present in Expert view screen.");
	    	}
	    	
	    	//tags count
			String s7 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[4]/div/button")).getText();
			System.out.println("view_____________________________tag count "+s7);
			
			if (s7.equals(expert_tagcount))
			{
				System.out.println("tags count is matching "+s7);
				AssertJUnit.assertEquals(s7, expert_tagcount);
			}
			else
			{
				System.out.println("tags count is not matching "+s7);
				AssertJUnit.assertEquals(s7, expert_tagcount);
				Reporter.log( "[ERROR] -> Expert -> View Screen -> Expert Tags is not present in Banner View Screen.");
			}
	    	
	    	
	    	softAssert.assertAll();
	    	
	    	WebElement closebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"));
	        closebutton.click();
	       
	        Thread.sleep(5000);
	   	
	}
	    
	    
		//Now create new banner and validate all required field and add all information and create it
//	    @Test (enabled = false)
		  @Test (priority=6)
		 public void Create_New_Expert_With_All_Fields() throws InterruptedException
		 {
			  	driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/experts");
			  	driver.manage().window().maximize();
		    	driver.navigate().refresh();
		    	Thread.sleep(3000);
			
				System.out.println("Expert -> Verifying Verifying Create New Expert With All Information**************");
				Reporter.log("Expert ->Verifying Create New Expert With All Information");
				
				WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
				load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();

				WebDriverWait create_expert = new WebDriverWait(driver, Duration.ofSeconds(30));
				create_expert.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"))).click();
			
				Thread.sleep(1000);
				 
			    driver.findElement(By.id("expert-name")).sendKeys(expert_name2);
			        
			 // headshot image select
			    WebElement headshot = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button"));
			    headshot.click();
			    
			    WebDriverWait wait_hs = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait_hs.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[13]/div/div/p")));
			    
			    
			    WebElement select_img = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[13]/div/div/p"));
			    select_img.click();
			
			    WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
			    select_button.click();
			    
			    //wideshot image select
			    
			    WebElement wideshot = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/button"));
			    wideshot.click();
			    
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img")));
			  
			    WebElement select_img2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img"));
			    select_img2.click();
			
			    WebElement select_button2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
			    select_button2.click();
			
				driver.findElement(By.id("slug")).sendKeys(expert_slug2);
			    
			     
			    //expert pick collection 
			    // click  
			    WebDriverWait click_pick = new WebDriverWait(driver, Duration.ofSeconds(30));
			    click_pick.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[5]/div/div/input"))).click();
					    
			    // select 
				WebDriverWait select_pick = new WebDriverWait(driver, Duration.ofSeconds(30));
				select_pick.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/ul/li[1]"))).click();
			
			    //bio
				driver.findElement(By.id("expert-bio")).sendKeys(expert_bio2);
				
				// tag
			    WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div/button"));
		        tab_button.click();
			    
		        Thread.sleep(1000);
		       
			    WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[7]/div[1]/div[1]/label"));
			    tab_topic.click();
			    
			    Thread.sleep(1000);
			    
			    WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/button[2]"));
			    selectbutton.click();
				
			    Thread.sleep(1000);
				
				 // tags count
			     expert_tagcount2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div/button")).getText();
				 System.out.println("the tag count is __________________"+expert_tagcount2); 
				
				 Thread.sleep(1000);
				    
				 WebElement zip_click = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/div"));
				 zip_click.click();
				 
				 WebElement zip_select = driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[2]"));
				 zip_select.click();
				 
				 Thread.sleep(5000);
				 
				 WebElement save_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"));
				 save_button.click();
				 
				 Thread.sleep(10000);
			
			
				 
				 
		
		 }
      
//			@Test (enabled = false)
			@Test (priority=7)
			 public void View_And_Verify_The_New_Expert() throws InterruptedException
			 {
					driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/experts");
					driver.manage().window().maximize();
			    	driver.navigate().refresh();
			    	Thread.sleep(10000);
			    	
			    	System.out.println("Expert -> search and view the new created expert*******************");
			        Reporter.log("Expert -> Search And View The New Created Expert");
			        
			        WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
					load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
			   
			    	WebElement searchbox1 = driver.findElement(By.xpath("//input[@type='text']"));

			    	searchbox1.sendKeys(expert_name2);
			    	
			    	Thread.sleep(3000);
			    	
			        WebDriverWait view = new WebDriverWait(driver, Duration.ofSeconds(30));
					view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[2]"))).click();
				   
//			    	WebElement icon_view = driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-1muvhzt'])[1]"));
//			    	icon_view.click();
			    	
			    	Thread.sleep(1000);
			    	
			    	//expert name
			    	String s11 = driver.findElement(By.xpath("//input[@id='expert-name']")).getAttribute("value");
			    	System.out.println("Expert name is ____________________________"+s11);

			    	if(s11.equals(expert_name2))
			    	{
			    		System.out.println("Expert name is present  "+s11);
			    		AssertJUnit.assertEquals(s11, expert_name2);
			    	}
			    	else
			    	{
			    		System.out.println("Expert name is not present"+s11);
			    		AssertJUnit.assertEquals(s11, expert_name2);
			    		Reporter.log( "[ERROR] -> Expert -> View Screen -> Expert Name is not present in Expert view screen.");
			    	}
			    	
			    	//expert slug
			    	String s22 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div/textarea[1]")).getAttribute("value");
			    	System.out.println("Expert slug is ____________________________"+s22);

			    	if(s22.equals(expert_slug2))
			    	{
			    		System.out.println("Expert slug is present  "+s22);
			    		AssertJUnit.assertEquals(s22, expert_slug2);
			    	}
			    	else
			    	{
			    		System.out.println("Expert slug is not present"+s22);
			    		AssertJUnit.assertEquals(s22, expert_slug2);
			    		Reporter.log( "[ERROR] -> Expert -> View Screen -> Expert Slug is not present in Expert view screen.");
			    	}
			    	
			    	//expert bio
			    	
			    	String s33 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/textarea[1]")).getAttribute("value");
			    	System.out.println("Expert bio is ____________________________"+s33);

			    	if(s33.equals(expert_bio2))
			    	{
			    		System.out.println("Expert bio is present  "+s33);
			    		AssertJUnit.assertEquals(s33, expert_bio2);
			    	}
			    	else
			    	{
			    		System.out.println("Expert bio is not present"+s33);
			    		AssertJUnit.assertEquals(s33, expert_bio2);
			    		Reporter.log( "[ERROR] -> Expert -> View Screen -> Expert Bio is not present in Expert view screen.");
			    	}
			    	
			    	//tags count
					String s77 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[4]/div/button")).getText();
					System.out.println("view_____________________________tag count "+s77);
					
					if (s77.equals(expert_tagcount2))
					{
						System.out.println("tags count is matching "+s77);
						AssertJUnit.assertEquals(s77, expert_tagcount2);
					}
					else
					{
						System.out.println("tags count is not matching "+s77);
						AssertJUnit.assertEquals(s77, expert_tagcount2);
						Reporter.log( "[ERROR] -> Expert -> View Screen -> Expert Tags is not present in Expert View Screen.");
					}
			    	
			    	
			    	softAssert.assertAll();
			    	
			    	WebElement closebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"));
			        closebutton.click();
			       
			        Thread.sleep(3000);

			 }
	    

	   
//	    @Test (enabled = false)
		@Test (priority=8)
		public void Verify_delete_Expert_is_working() throws InterruptedException
		{
	    	
	   		driver.manage().window().maximize();
	   		driver.navigate().refresh();
	   		Thread.sleep(3000);
	   		
	   		System.out.println("Expert -> Verifying the Delete from expert page");
			Reporter.log("Expert -> Verifying the Delete from expert page");
	   		
			WebElement searchbox1 = driver.findElement(By.xpath("//input[@type='text']"));
			searchbox1.sendKeys(expert_name);
							
			Thread.sleep(3000);
			
			
			WebDriverWait delete_icon = new WebDriverWait(driver, Duration.ofSeconds(30));
			delete_icon.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/button[3]"))).click();
			Thread.sleep(3000);
			
			WebDriverWait delete1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			delete1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
				
			Thread.sleep(3000);
/*	
			// delete 2 expert
			
			driver.navigate().refresh();
			
			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();

			WebElement searchbox2 = driver.findElement(By.xpath("//input[@type='text']"));
			searchbox2.sendKeys(expert_name2);
							
			Thread.sleep(3000);
			
			WebDriverWait delete_icon2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			delete_icon2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/button[3]"))).click();
			
			Thread.sleep(3000);
			
			WebDriverWait delete2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			delete2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
*/	
			Thread.sleep(3000);
			
		}
		
		

		
		
		
	}

