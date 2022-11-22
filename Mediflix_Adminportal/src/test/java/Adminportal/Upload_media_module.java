package Adminportal;

import base.admin_user;
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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
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

public class Upload_media_module extends admin_user
{
	
	SoftAssert softAssert = new SoftAssert();

	String File_path ="C://Users//Prasad_aute//Downloads//mediflix//Videos file//1234_MP4_1920_18MG.mp4";
	String Status;
	String Brighcove_ID;
	String Folder;
	String Filename;
	
	String view_filename;
	String view_brightcove_id;
	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public  void Upload_Videos() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/upload");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		 	
		 System.out.println("Upload video -> Verify The Video Upload Without Selecting Folder**************");
		 Reporter.log("Upload video -> Verify The Video Upload Without Selecting Folder");
		 
		 //click video toggle  button
		 WebDriverWait video_toggle = new WebDriverWait(driver, Duration.ofSeconds(30));
		 video_toggle.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/div[1]/div/button[2]"))).click();
		 Thread.sleep(2000);
		 
		 //click the video upload 
		 
		 WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
		 chooseFile.sendKeys(File_path);
		 
		 Thread.sleep(4000);
		 driver.navigate().refresh();
		 
		 System.out.println("Upload video -> Verify The Video Upload**************");
		 Reporter.log("Upload video -> Verify The Video Upload");
		 
		//click video toggle  button
		 WebDriverWait video_toggle2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 video_toggle2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/div[1]/div/button[2]"))).click();
		 Thread.sleep(2000);
		  
		 //select folder
		 //click 	 
		 WebDriverWait click_folder = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_folder.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div/div/input"))).click();
		 Thread.sleep(2000);
		 //select
		 WebDriverWait select_folder = new WebDriverWait(driver, Duration.ofSeconds(30));
		 select_folder.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/ul/li[7]"))).click();
		 Thread.sleep(2000);
		 			 
		 //click and send path
		 WebElement chooseFile2 = driver.findElement(By.xpath("//input[@type='file']"));
		 chooseFile2.sendKeys(File_path);
		 
		 Thread.sleep(4000);
		 WebElement Progress_bar = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div/div/div[2]/span[1]"));
		
		 //logic for length of video 
		 
		 WebDriverWait pwait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		 boolean progress_status= pwait.until(ExpectedConditions.attributeToBe(Progress_bar, "aria-valuenow", "100"));
		 pwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div/div/div[2]/span[2]")));
			 
		
		 		 
		 // brightcove id
		 String s1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div/div/span")).getText();
		 s1 = s1.substring(15);
		 System.out.println("Brightcove ID________________"+s1);
		 Brighcove_ID = s1;
		 
	 	 //file name   
		 String s3 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div/div/div[1]/p/strong")).getText();
		 System.out.println("File name________________"+s3);
		 Filename = s3;
	 	  
		 // folder name  
		 String s4 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div/div/p")).getText();
		 s4 = s4.substring(8);
		 System.out.println("Folder name________________"+s4);
		 Folder = s4;
		 
		 		 	 
		//status
		 String s2 =driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div/div/div[2]/span[2]")).getText();
		 System.out.println("Status is________________"+s2);
	 	 Status = s2;
		 
		 Thread.sleep(4000);
	 }
	 
	 @Test (priority=2)
//	 @Test (enabled = false)
	 public  void Verify_Upload_Videos() throws InterruptedException 
	 {
		 WebDriverWait click_video = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_video.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/button[4]"))).click();
	
		 Thread.sleep(4000);
		 	
		 System.out.println("Verify Upload video -> search and view the newly created uploaded video***********");
		 Reporter.log("Verify Upload video -> Search And View The Newly Created Uploaded Video");
		 
		 //search 
		 
		 WebElement searchbox = driver.findElement(By.xpath("//input[@type='text']"));
		 searchbox.sendKeys(Brighcove_ID);
		 
		 Thread.sleep(4000);
		 
		 // load 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[2]")));
		 System.out.println("element is loaded");
		
		 
		 WebDriverWait click_search_video = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_search_video.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[12]/button[3]"))).click();
		 System.out.println("element is clicked");
		 Thread.sleep(4000);
		 
		  view_filename = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/textarea[1]")).getText();
		
		 // verify the file name
		 if(view_filename.equals(Filename))
		 {
				System.out.println("Video file name is present");
				softAssert.assertEquals(view_filename, Filename); 
		 }
		 else
		 {
				System.out.println("Video file name is not present");
				softAssert.assertEquals(view_filename, Filename);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Video file name is not present in Content view screen.");
		 }		
		 
		 // Brightcove ID
		 
		 view_brightcove_id = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div[2]/div/div[1]/div[1]/div/input")).getAttribute("value");
		
		 if(view_brightcove_id.equals(Brighcove_ID))
		 {
				System.out.println("Video Brighcove_ID is present");
				softAssert.assertEquals(view_brightcove_id, Brighcove_ID); 
		 }
		 else
		 {
				System.out.println("Video Brighcove_ID is not present");
				softAssert.assertEquals(view_brightcove_id, Brighcove_ID);
				Reporter.log( "[ERROR] -> Content -> View Screen -> Video Brighcove_ID is not present in Content view screen.");
		 }		
		 
		 	softAssert.assertAll();
			Thread.sleep(2000);
			//close button
	 
			WebElement close_button =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/header/div/button[2]"));
			close_button.click();
			Thread.sleep(2000);
		 
	 }
	 
	
}
