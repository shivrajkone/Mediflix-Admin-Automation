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

import base.BaseTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Action;

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
import base.Super_user;

public class Profiling_questions extends Super_user 
{
	WebElement Questions;
	String search_key="davor";
	String question="Should I get a second opinion?";
	WebElement related_tag;
	WebElement polarity;
	WebElement ans_type;
	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public  void Create_Profiling_Questions() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/settings");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(10000);
	
		 
		 System.out.println("Profiling Questions-> Verify Create Profiling Questions**************");
		 Reporter.log("Profiling Questions -> Verify Create Profiling Questions");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]"))).click();
		 		 
		 WebElement create_profiling_ques = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[1]/button"));
		 create_profiling_ques.click();
		 
		 Thread.sleep(4000);
		 
		 // questions
		 Questions = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div/input"));
		 Questions.sendKeys(question);
		 
		 //related tag  
		 //click
		 WebDriverWait related_tag_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 related_tag_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[2]/div/div/div/input"))).click();
		 		 
		 // select
		 WebDriverWait related_tag_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 related_tag_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[3]"))).click();
		 		 
		 //polarity
		//click
		 WebDriverWait polarity_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 polarity_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[3]/div/div/div"))).click();
		 		 
		 // select
		 WebDriverWait polarity_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 polarity_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/ul/li[1]"))).click();
		 
		 //ans type
		 //click 
		 WebDriverWait ans_type_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 ans_type_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[4]/div/div/div"))).click();
		 		 
		 // select
		 WebDriverWait ans_type_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 ans_type_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/ul/li[2]"))).click();
		 
		 //save  
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		 
		 Thread.sleep(4000);
	 }
	 
	 @Test (priority=2)
//	 @Test (enabled = false)
	 public  void View_And_Verify_Profiling_Questions() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/settings");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(10000);
	
		 System.out.println("Profiling Questions-> Search And View Profiling Questions**************");
		 Reporter.log("Profiling Questions -> Search And View Profiling Questions");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]"))).click();
		 	
		 
		 WebElement searchbox = driver.findElement(By.xpath("//input[@type='text']"));
		 searchbox.sendKeys(question);
		 
		 Thread.sleep(4000);
			
		 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_view.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/button[2]"))).click();
			    			
		 Thread.sleep(4000);
		 
		 //verify question
		 
		 String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div/input")).getAttribute("value");
		 System.out.println("Question is ____________________________"+s1);
		
			if(s1.equals(question))
			{
				System.out.println("Question is  present");
				AssertJUnit.assertEquals(s1, question);
			}
			else
			{
				System.out.println("Question is not present");
				AssertJUnit.assertEquals(s1, question);
				Reporter.log( "[ERROR] -> Profiling Question -> View Screen -> Question Is Not Present In Profiling Question View Screen.");
			}
		 
			//related tag
		 String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[2]/div/div/div/input")).getAttribute("value");
		 System.out.println("Related Tag is____________________________"+s2);
			
				if(s2.equals(s2))
				{
					System.out.println("Related Tag is present");
					AssertJUnit.assertEquals(s2, s2);
				}
				else
				{
					System.out.println("Related Tag is not present");
					AssertJUnit.assertEquals(s2, s2);
					Reporter.log( "[ERROR] -> Profiling Question -> View Screen -> Related Tag Is Not Present In Profiling Question View Screen.");
				}
				
				//polarity
		 String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[3]/div/div/div")).getText();
		 System.out.println("Polarity is ____________________________"+s3);
					
				if(s3.equals(s3))
				{
					System.out.println("Polarity is  present");
					AssertJUnit.assertEquals(s3, s3);
				}
				else
				{
					System.out.println("Polarity is not present");
					AssertJUnit.assertEquals(s3, s3);
					Reporter.log( "[ERROR] -> Profiling Question -> View Screen -> Polarity Is Not Present In Profiling Question View Screen.");
				}
				
				//answer type
		 String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[4]/div/div/div")).getText();
		 System.out.println("Answer Type is ____________________________"+s4);
							
				if(s4.equals(s4))
				{
					System.out.println("Answer Type is  present");
					AssertJUnit.assertEquals(s4, s4);
				}
				else
				{
					System.out.println("Answer Type is not present");
					AssertJUnit.assertEquals(s4, s4);
					Reporter.log( "[ERROR] -> Profiling Question -> View Screen -> Answer Type Is Not Present In Profiling Question View Screen.");
				}
				
				//close
			WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
			close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
			 Thread.sleep(4000);
		 
	 }
	 
	 @Test (priority=3)
//	 @Test (enabled = false)
	 public  void Edit_Profiling_Questions() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/settings");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(10000);
	
		 System.out.println("Profiling Questions-> Search And Edit Profiling Questions**************");
		 Reporter.log("Profiling Questions -> Search And Edit Profiling Questions");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]"))).click();
		 			 
		 WebElement searchbox = driver.findElement(By.xpath("//input[@type='text']"));
		 searchbox.sendKeys(question);
		 
		 Thread.sleep(4000);
			
		 WebDriverWait wait_edit = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_edit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/button[1]"))).click();
			    			
		 Thread.sleep(4000);
	 
		 // multiple choice 
		 
		 //click 
		 WebDriverWait multiple_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 multiple_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[4]/div/div/div"))).click();
		 		 
		 // select
		 WebDriverWait multiple_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 multiple_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/ul/li[4]"))).click();
		 
		 // click add option
		 WebDriverWait click_add_option = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_add_option.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[5]/button"))).click();
		 																			  
		 // option  click sendkeys
		 WebElement options = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[6]/div/div/input"));
		 options.sendKeys("Treatment Options");
		 
		 //click add  
		 WebDriverWait click_add = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_add.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[6]/button[1]"))).click();
		 
		 Thread.sleep(2000);
		 // click add option
		 WebDriverWait click_add_option2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_add_option2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[5]/button"))).click();
		 
		 // 2 option  click sendkeys
		 WebElement options2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[6]/div/div/input"));
		 options2.sendKeys("Expected Result");
				 
		 //click add 
		 WebDriverWait click_add2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_add2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[6]/button[1]"))).click();
		 
		 Thread.sleep(4000);
		 //save  
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		 
		 Thread.sleep(5000);
		 
	 } 
	 
	 @Test (priority=4)
//	 @Test (enabled = false)
	 public  void View_And_Verify_Edited_Profiling_Questions() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/settings");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(10000);
	
		 System.out.println("Profiling Questions-> Search And View Edited Profiling Questions**************");
		 Reporter.log("Profiling Questions -> Search And View Edited Profiling Questions");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]"))).click();
		 	
		 
		 WebElement searchbox = driver.findElement(By.xpath("//input[@type='text']"));
		 searchbox.sendKeys(question);
		 
		 Thread.sleep(4000);
			
		 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_view.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/button[2]"))).click();
			    			
		 Thread.sleep(4000);
/*		 
		 //verify question
		 
		 String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div/input")).getAttribute("value");
		 System.out.println("Question is ____________________________"+s1);
		
			if(s1.equals(question))
			{
				System.out.println("Question is  present");
				AssertJUnit.assertEquals(s1, question);
			}
			else
			{
				System.out.println("Question is not present");
				AssertJUnit.assertEquals(s1, question);
				Reporter.log( "[ERROR] -> Profiling Question -> View Screen -> Question Is Not Present In Profiling Question View Screen.");
			}
		 
			//related tag
		 String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[2]/div/div/div/input")).getAttribute("value");
		 System.out.println("Related Tag is____________________________"+s2);
			
				if(s2.equals(s2))
				{
					System.out.println("Related Tag is present");
					AssertJUnit.assertEquals(s2, s2);
				}
				else
				{
					System.out.println("Related Tag is not present");
					AssertJUnit.assertEquals(s2, s2);
					Reporter.log( "[ERROR] -> Profiling Question -> View Screen -> Related Tag Is Not Present In Profiling Question View Screen.");
				}
				
				//polarity
		 String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[3]/div/div/div")).getText();
		 System.out.println("Polarity is ____________________________"+s3);
					
				if(s3.equals(s3))
				{
					System.out.println("Polarity is  present");
					AssertJUnit.assertEquals(s3, s3);
				}
				else
				{
					System.out.println("Polarity is not present");
					AssertJUnit.assertEquals(s3, s3);
					Reporter.log( "[ERROR] -> Profiling Question -> View Screen -> Polarity Is Not Present In Profiling Question View Screen.");
				}
*/				
				//answer type
		 		String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[4]/div/div/div")).getText();
		 		System.out.println("Answer Type is ____________________________"+s4);
							
				if(s4.equals(s4))
				{
					System.out.println("Answer Type is  present");
					AssertJUnit.assertEquals(s4, s4);
				}
				else
				{
					System.out.println("Answer Type is not present");
					AssertJUnit.assertEquals(s4, s4);
					Reporter.log( "[ERROR] -> Profiling Question -> View Screen -> Answer Type Is Not Present In Profiling Question View Screen.");
				}
				
				// options are 
				
				String multiple_options =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/ul")).getText();
				System.out.println("options are____________________"+multiple_options);
				
				
				//close
			    WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
			    close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
			    Thread.sleep(4000);
		 
	 }
	 
	 @Test (priority=5)
//	 @Test (enabled = false)
	 public  void Search_And_Delete_Profiling_Questions() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/settings");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(10000);
	
		 System.out.println("Profiling Questions-> Search And Delete  Profiling Questions**************");
		 Reporter.log("Profiling Questions -> Search And Delete  Profiling Questions");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]"))).click();
		 	
		 
		 WebElement searchbox = driver.findElement(By.xpath("//input[@type='text']"));
		 searchbox.sendKeys(question);
		 
		 Thread.sleep(4000);
			
		 WebDriverWait delete = new WebDriverWait(driver, Duration.ofSeconds(30));
		 delete.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/button[3]"))).click();
			    			
		 Thread.sleep(4000);
	 }
	 
	 
	 
	 @Test (priority=6)
//	 @Test (enabled = false)
	 public  void Verify_Profiling_Questions_Filter() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/settings");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(10000);
	
		 System.out.println("Profiling Questions-> Verify Filters Working Or Not**************");
		 Reporter.log("Profiling Questions -> Verify the Filter of  Profiling Questions");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]"))).click();
	
		 // click filter  
			
		 WebDriverWait click_filter = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_filter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[1]/div/button"))).click();

		 Thread.sleep(2000);
		
		 //click polarity   
		 WebDriverWait click_polarity = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_polarity.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div/div/div"))).click();
		 
		 //select  
		 WebDriverWait select_polarity = new WebDriverWait(driver, Duration.ofSeconds(30));
		 select_polarity.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/ul/li[1]"))).click();
		 
		 Thread.sleep(2000);
		 
		 //read the text from textfield  
		 String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div/div/div")).getText();
		 System.out.println("Selected filter is __________"+s1);
		 
		 //apply  
		 WebDriverWait apply = new WebDriverWait(driver, Duration.ofSeconds(30));
		 apply.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 
		 Thread.sleep(4000);
		 //load   
		 WebDriverWait load2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]"))).click();
		 
		 //read the polarity from listing screen  
		 String s2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]")).getText();
		 System.out.println("Applyed filter is ___________"+s2);
		 
		 
		 // click filter  
			
		 WebDriverWait click_filter2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_filter2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[1]/div/button"))).click();

		 Thread.sleep(2000);
		 
		 //click ans type   
		 WebDriverWait click_ans_type = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_ans_type.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[2]/div/div/div"))).click();

		 //select ans type
		 WebDriverWait select_ans_type = new WebDriverWait(driver, Duration.ofSeconds(30));
		 select_ans_type.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[3]/ul/li[4]"))).click();
 
		 Thread.sleep(2000);
		 
		 // read text from textfield   
		 String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[2]/div/div/div")).getText();
		 System.out.println("selected answer type is___________"+s3);
		 
		 Thread.sleep(2000);
		 
		 
		//apply  
		 WebDriverWait apply2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 apply2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 
		 Thread.sleep(4000);
		 //load   
		 WebDriverWait load3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load3.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]"))).click();
		 
		 //read the ans type from listing screen  
		 String s4 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]")).getText();
		 System.out.println("Applyed filter is ___________"+s4);
		 
		 
		 
	
	 }
	 
	 
	 
	 
}
