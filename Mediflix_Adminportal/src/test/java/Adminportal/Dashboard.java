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

public class Dashboard extends admin_user
{
	
	SoftAssert softAssert = new SoftAssert();
			
	String videos_Dcount;
	String videos_Vcount;
	
	String images_Dcount;
	String images_count;
	
	String coll_Dcount;
	String coll_count;
	
	String series_Dcount;
	String series_count;
	
	String total_question_Dcount;
	String total_question_count;
	
	String expert_Dcount;
	String expert_count;
	
	String banner_Dcount;
	String banner_count;
	
	String sponsor_Dcount;
	String sponsor_count;
	
	
 
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public void Verify_The_Dashboard_Videos() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com");
		 driver.manage().window().maximize();
		 
		 Thread.sleep(10000);
		 
		 System.out.println("Dashboard -> Verifying The Videos From Dashboard**************");
		 Reporter.log("Dashboard -> Verifying The Videos From Dashboard");
		 
		 Thread.sleep(4000);

		 //videos count from dashboard 
		 
		 videos_Dcount = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/a/div/div/div[1]/p[2]")).getText();
		 System.out.println("Dashboard videos count is_______________________"+videos_Dcount);
		 
		 // videos click
		 
		 WebDriverWait Videos_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 Videos_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/a"))).click();
		 																		 
		 Thread.sleep(5000);
		   
		 //videos count from video page
		 
		 videos_Vcount = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/p[2]")).getText();
	//	 System.out.println("Dashboard videos count is_______________________"+videos_Vcount);
		 
		 videos_Vcount = videos_Vcount.substring(8);
		 
		 System.out.println("Dashboard videos count is_______________________"+videos_Vcount);
		 
		 
		 if (videos_Dcount.equals(videos_Vcount))
		 {
			 System.out.println("Dashboard videos count is matching");
			 softAssert.assertEquals(videos_Dcount, videos_Vcount);
		 }
		 else
		 {
			 System.out.println("Dashboard videos count is not  matching");
			 softAssert.assertEquals(videos_Dcount, videos_Vcount);
				Reporter.log( "[ERROR] -> Dashboard -> Dashboard Videos Count Is Not  Matching From Content Videos Page.");
		 }
		 softAssert.assertAll();
		 
		 
	 }
	 @Test (priority=2)
//	 @Test (enabled = false)
	 public void Verify_The_Dashboard_collection() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com");
		 driver.manage().window().maximize();
		 
//		 // load
//		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
//		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[4]/div/a")));
//		 					
		 Thread.sleep(10000);

		 
		 System.out.println("Dashboard -> Verifying The Collection From Dashboard**************");
		 Reporter.log("Dashboard -> Verifying The Collection From Dashboard");
		 
		 Thread.sleep(7000);

		 
		// collection count from dashboard 
		 
		 coll_Dcount = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[4]/div/a/div/div/div[1]/p[2]")).getText();
		 System.out.println("Dashboard Collection count is_______________________"+coll_Dcount);
		 
		 series_Dcount = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[4]/div/a/div/div/div[2]/p[2]")).getText();
		 System.out.println("Dashboard Collection Series count is_______________________"+series_Dcount);
		 		 
		// collection click
		 
		 WebDriverWait collection_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 collection_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[4]/div/a"))).click();
		 																		
		 Thread.sleep(5000);
		 
		 WebDriverWait load2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 		
		 //filter click
		 WebDriverWait filter_clcik = new WebDriverWait(driver, Duration.ofSeconds(30));
		 filter_clcik.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[1]"))).click();
		 
		 Thread.sleep(2000);
		 //  click collection type   
		 WebDriverWait coll_type_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 coll_type_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div/div/input"))).click();
		 
		 //select collection   
		 WebDriverWait select_coll = new WebDriverWait(driver, Duration.ofSeconds(30));
		 select_coll.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/ul/li[4]"))).click();
		 
		 //apply button   
		 WebDriverWait apply = new WebDriverWait(driver, Duration.ofSeconds(30));
		 apply.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		                                                                  
	//	 Thread.sleep(7000);
		 
		 WebDriverWait load4 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 		
		 	 
		 // collection count from collection page
		 							
		 coll_count = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/div/p[2]")).getText();
			//	 System.out.println("Dashboard videos count is_______________________"+videos_Vcount);
				 
		 coll_count = coll_count.substring(8);
				 
				 System.out.println("Collection Page count is_______________________"+coll_count);
				 
				 
				 if (coll_Dcount.equals(coll_count))
				 {
					 System.out.println("Dashboard collection count is matching");
					 softAssert.assertEquals(coll_Dcount, coll_count);
				 }
				 else
				 {
					 System.out.println("Dashboard collection count is not matching");
					 softAssert.assertEquals(coll_Dcount, coll_count);
						Reporter.log( "[ERROR] -> Dashboard -> Dashboard Collection Count Is Not  Matching From Collection Page.");
				 }
				 			 
				 
				 Thread.sleep(3000);
				 			 
				 // click filter again for series count
				 
				//filter click
				 WebDriverWait filter_click2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				 filter_click2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[1]"))).click();
				 
				 Thread.sleep(2000);
				 //  click collection type   
				 WebDriverWait coll_type_click2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				 coll_type_click2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div/div/input"))).click();
				 
				 //select collection   
				 WebDriverWait select_coll2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				 select_coll2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/ul/li[5]"))).click();
				 
				 //apply button   
				 WebDriverWait apply2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				 apply2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" /html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
				 
				 Thread.sleep(5000);			 
				 // series count from collection page
				 
				 series_count = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/div/p[2]")).getText();
		//		 System.out.println("Series Count is (get)_______________________"+series_count);
				 
				 series_count = series_count.substring(8);
						 
				 System.out.println("Series Count is_______________________"+series_count);
				 
				 if (series_Dcount.equals(series_count))
				 {
					 System.out.println("Dashboard series count is matching");
					 softAssert.assertEquals(series_Dcount, series_count);
				 }
				 else
				 {
					 System.out.println("Dashboard series count is not matching");
					 softAssert.assertEquals(series_Dcount, series_count);
						Reporter.log( "[ERROR] -> Dashboard -> Dashboard Series Count Is Not  Matching From Collection Page.");
				 }
				 softAssert.assertAll();
				 
				 
				 Thread.sleep(7000);
				 		 
		 
	 }
	
	 @Test (priority=3)
//	 @Test (enabled = false)
	 public void Verify_The_Dashboard_Questions() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com");
		 driver.manage().window().maximize();
		 
		 Thread.sleep(10000);
		 
		 System.out.println("Dashboard -> Verifying The Questions From Dashboard**************");
		 Reporter.log("Dashboard -> Verifying The Questions From Dashboard");
		 
		 Thread.sleep(7000);
		 
		// question count from dashboard 
		 
		 total_question_Dcount = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[5]/div/a/div/div/div[1]/p[2]")).getText();
		 System.out.println("Dashboard Question count is_______________________"+total_question_Dcount);
		
		 // question click
		 
		 WebDriverWait question_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 question_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[5]/div/a"))).click();
				 																		
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		 		
		 // question count	from advice page			 
		 
		 total_question_count = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/div/p[2]")).getText();
							 
		 total_question_count = total_question_count.substring(8);
				 
		 System.out.println("Advice Page question count is_______________________"+total_question_count);
				 
				 
				 if (total_question_Dcount.equals(total_question_count))
				 {
					 System.out.println("Dashboard Question count is matching");
					 softAssert.assertEquals(total_question_Dcount, total_question_count);
				 }
				 else
				 {
					 System.out.println("Dashboard Question count is not matching");
					 softAssert.assertEquals(total_question_Dcount, total_question_count);
					 Reporter.log( "[ERROR] -> Dashboard -> Dashboard Question Count Is Not Matching With Advice Page Question.");
				 }
				 			 
				 softAssert.assertAll();
				 
				 Thread.sleep(5000);
				
	 }
	 
	 @Test (priority=4)
//	 @Test (enabled = false)
	 public void Verify_The_Dashboard_Expert() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com");
		 driver.manage().window().maximize();
		 
		 Thread.sleep(10000);
		 
		 System.out.println("Dashboard -> Verifying The Expert From Dashboard**************");
		 Reporter.log("Dashboard -> Verifying The Expert From Dashboard");
		 
		 Thread.sleep(7000);
	 
		 // expert count from dashboard 
	 
		 expert_Dcount = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[6]/div/a/div/div/div/p[2]")).getText();
		 System.out.println("Dashboard Expert count is_______________________"+expert_Dcount);
		 
		// expert click
		 
		 WebDriverWait question_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 question_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[6]/div/a"))).click();
		 																						 																		
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
		
		 
		// question count	from advice page			 
		 
		 expert_count = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/div/p[2]")).getText();
									 
		 expert_count = expert_count.substring(8);
						 
		 System.out.println("Expert Page Expert count is_______________________"+expert_count);
						 
						 
			if (expert_Dcount.equals(expert_count))
				{
						System.out.println("Dashboard Expert count is matching");
						softAssert.assertEquals(expert_Dcount, expert_count);
				}
			else
				{
						System.out.println("Dashboard Expert count is not matching");
						softAssert.assertEquals(expert_Dcount, expert_count);
						Reporter.log( "[ERROR] -> Dashboard -> Dashboard Expert Count Is Not Matching With Expert Page.");
				}
						 			 
						 softAssert.assertAll();
						 
						 Thread.sleep(5000);
		 
	 }		 
	 
	 @Test (priority=5)
//	 @Test (enabled = false)
	 public void Verify_The_Dashboard_Banner() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com");
		 driver.manage().window().maximize();
		 
		 Thread.sleep(10000);
		 
		 System.out.println("Dashboard -> Verifying The Banner From Dashboard**************");
		 Reporter.log("Dashboard -> Verifying The Banner From Dashboard");
		 
		 Thread.sleep(7000);
		
		 // banner count from dashboard 
		 
		 banner_Dcount = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[7]/div/a/div/div/div/p[2]")).getText();
		 System.out.println("Dashboard Banner count is_______________________"+banner_Dcount);
		 
	   	// banner click
		 
		 WebDriverWait banner_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 banner_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[7]/div/a"))).click();
				 																						 																		
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
				
		// banner count from banner page			  
		 
		 banner_count = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/div/p[2]")).getText();
											 
		 banner_count = banner_count.substring(8);
								 
		 System.out.println("Banner Page Banner count is_______________________"+banner_count);
								 
								 
		 if (banner_Dcount.equals(banner_count))
			{
				System.out.println("Dashboard Banner count is matching");
				softAssert.assertEquals(banner_Dcount, banner_count);
			}
		else
			{
				System.out.println("Dashboard Banner count is not matching");
				softAssert.assertEquals(banner_Dcount, banner_count);
				Reporter.log( "[ERROR] -> Dashboard -> Dashboard Banner Count Is Not Matching With Banner Page.");
			}
								 			 
			 softAssert.assertAll();
								 
			 Thread.sleep(5000);
		
	 }
	 
	 
	 @Test (priority=6)
//	 @Test (enabled = false)
	 public void Verify_The_Dashboard_Sponsor() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com");
		 driver.manage().window().maximize();
		 
		 Thread.sleep(10000);
		 
		 System.out.println("Dashboard -> Verifying The Sponsor From Dashboard**************");
		 Reporter.log("Dashboard -> Verifying The Sponsor From Dashboard");
		 
		 Thread.sleep(7000);
		 // sponsor count from dashboard 
		 
		 sponsor_Dcount = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[8]/div/a/div/div/div/p[2]")).getText();
		 System.out.println("Dashboard Sponsor count is_______________________"+sponsor_Dcount);
				 
		 // sponsor click
				  
		 WebDriverWait sponsor_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 sponsor_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[8]/div/a"))).click();
						 																						 																		
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
						
		// banner count from banner page			  
		 
		 sponsor_count = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/div/p[2]")).getText();
													 
		 sponsor_count = sponsor_count.substring(8);
										 
		 System.out.println("Sponsor Page Sponsor count is_______________________"+sponsor_count);
										 
										 
		 if (sponsor_Dcount.equals(sponsor_count))
			{
				System.out.println("Dashboard Sponsor count is matching");
				softAssert.assertEquals(sponsor_Dcount, sponsor_count);
			}
		else
			{
				System.out.println("Dashboard Sponsor count is not matching");
				softAssert.assertEquals(sponsor_Dcount, sponsor_count);
				Reporter.log( "[ERROR] -> Dashboard -> Dashboard Sponsor Count Is Not Matching With Sponsor Page.");
			}
										 			 
			 softAssert.assertAll();
										 
			 Thread.sleep(5000);
		 
	 
	 }
	
	 

}
