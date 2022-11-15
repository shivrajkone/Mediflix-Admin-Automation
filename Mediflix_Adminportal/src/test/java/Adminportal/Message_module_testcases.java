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

public class Message_module_testcases extends BaseTest	
{
	
	WebElement search;
	String search_key="davor";
	
	WebElement message;
	String message_data="need to close";
	String read_msg;
	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public  void Verify_Search_In_Message() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/messages");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		 Actions act = new Actions(driver);
		 
		 System.out.println("Message -> Verify The Search**************");
		 Reporter.log("Messaget -> Verify The Search In Message");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/div/div/input"))).click();
		 
//		 search = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/div/div/input"));
//		 search.sendKeys(search_key);
		 
		 WebDriverWait load_result = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load_result.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div")));
		 
		 Thread.sleep(5000); 
		 //click on thread  
		 
		 WebDriverWait click_result_1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_result_1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div"))).click();
		 			 
		 Thread.sleep(5000); 
		 WebDriverWait checkbox_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 checkbox_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/span/input"))).click();
		 		 
		 String s1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[3]/p")).getText();
		 System.out.println("the thread status is_____________________"+s1);
		 
		 Thread.sleep(2000);
		
		 DateFormat dateFormat = new SimpleDateFormat("dd MMM HH:mm");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);

		 // Print the Date
		 System.out.println("Current date and time is " +date1.toString());
		 
		 //send message
		 message = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div[3]/div/div/textarea[1]"));
		 message.sendKeys(date1);
		 
		 //click send button  
		 WebDriverWait send = new WebDriverWait(driver, Duration.ofSeconds(30));
		 send.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div[3]/button"))).click();
		 Thread.sleep(5000);
		 
		 WebDriverWait Thread_closed_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 Thread_closed_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div[1]/button"))).click();
	  
		 Thread.sleep(2000);
		 
		 WebDriverWait closed_click2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 closed_click2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
	 
		 Thread.sleep(5000);
		 
		 //filter click  
		 
		 WebDriverWait filter_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 filter_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/button"))).click();
		 
		 Thread.sleep(2000);
		 //click 1 
		 WebDriverWait click_checkbox1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_checkbox1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/ul/li[1]/span[1]/input"))).click();
		 
		 Thread.sleep(2000);
		 //click 2 
		 WebDriverWait click_checkbox2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_checkbox2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/ul/li[2]/span[1]/input"))).click();
		 
		 Thread.sleep(2000);
		 //click 3 
		 WebDriverWait click_checkbox3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_checkbox3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/ul/li[3]/span[1]/input"))).click();
		 
		 Thread.sleep(3000);
		 
		 WebElement dclick3 =driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[2]"));
		 act.doubleClick(dclick3).perform();
		 Thread.sleep(3000);
		 
		 String s2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[3]/p")).getText();
		 System.out.println("after thread closed the status is_____________________"+s2);
		 Thread.sleep(3000);
		 // click other thread  
		 WebDriverWait click_2thread = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_2thread.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div"))).click();
		 
		 // click back 
		 Thread.sleep(3000);
		 WebDriverWait click_bkthread = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_bkthread.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div"))).click();
		 
		 Thread.sleep(3000);
		 // message   
		 		 
//		 read_msg = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div[2]/div/div/div[10]/p")).getText();
//		 System.out.println("message is _______________"+read_msg);
		 
		 List<WebElement> allChats = driver.findElements(By.xpath("//*[@class='MuiTypography-root MuiTypography-body2 css-tp2kxb']//div"));
		 String kk = allChats.get(allChats.size() - 1).getText();
		 System.out.println("message is _______________"+kk);
		 
		 Thread.sleep(8000);
	 
	 }
	 
	 @Test (priority=2)
//	 @Test (enabled = false)
	 public  void Verify_Filter_In_Message_Module() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/messages");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		 Actions act = new Actions(driver);
		 System.out.println("Message -> Verify The Filter**************");
		 Reporter.log("Messaget -> Verify The Filter In Message Module");
		 
		 // load    
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[2]"))).click();
		 
		 //filter click  
		 
		 WebDriverWait filter_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 filter_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/button"))).click();
		 
		 Thread.sleep(2000);
		 //click 1 
		 WebDriverWait click_checkbox1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_checkbox1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/ul/li[1]/span[1]/input"))).click();
		 
		 Thread.sleep(2000);
		 //click 2 
		 WebDriverWait click_checkbox2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_checkbox2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/ul/li[2]/span[1]/input"))).click();
		 		 
		 Thread.sleep(2000);
		 //click 3 close 
		 WebDriverWait click_checkbox3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_checkbox3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/ul/li[3]/span[1]/input"))).click();
		 
		 Thread.sleep(2000);		 
		 
		 WebElement dclick =driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[2]"));
		 act.doubleClick(dclick).perform();
		 
		 String s1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[3]/p")).getText();
	     System.out.println("Status is _________________________"+s1);
	     
	     Thread.sleep(2000);	
	     
	     //wating for expert
	     //filter click  
		 
		 WebDriverWait filter_click1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 filter_click1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/button"))).click();
		 
		 //click 2 
		 WebDriverWait click_waiting = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/ul/li[2]/span[1]/input"))).click();
		 		 
		 Thread.sleep(2000);
		 //click 3 close 
		 WebDriverWait click_closed = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_closed.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/ul/li[3]/span[1]/input"))).click();
		 
		 Thread.sleep(2000);	
	        
		 WebElement dclick2 =driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[2]"));
		 act.doubleClick(dclick2).perform();
		 
		 String s2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[3]/p")).getText();
	     System.out.println("Status is _________________________"+s2);
	     
	     Thread.sleep(2000);	
	     
	     //waiting for user
	     //filter click  
		 
		 WebDriverWait filter_click3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 filter_click3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[1]/button"))).click();
		 
		 Thread.sleep(2000);
		 //click 1 
		 WebDriverWait click_user = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_user.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/ul/li[1]/span[1]/input"))).click();
		 
		 Thread.sleep(2000);
		 //click 2 
		 WebDriverWait click_expert = new WebDriverWait(driver, Duration.ofSeconds(30));
		 click_expert.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/ul/li[2]/span[1]/input"))).click();
		
		 Thread.sleep(2000);	
	        
		 WebElement dclick3 =driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[2]"));
		 act.doubleClick(dclick3).perform();
		 
		 String s3 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div[2]/div[1]/div[3]/p")).getText();
	     System.out.println("Status is _________________________"+s3);
	     
		 Thread.sleep(3000);
		 
		 
		
	 }
	 
	 
	 
	 
	 
		 
	

}
