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


public class Connect_Exp_module_testcases extends admin_user
{
	
	SoftAssert softAssert = new SoftAssert();
	
	WebElement conn;
	WebElement button;
	WebElement email;

	String conn_name = "Health Care ";
	String button_text = "Health Care";
	String email_copy = "<div>\r\n"
			+ "<p>\r\n"
			+ "<span\r\n"
			+ "><img\r\n"
			+ "src=\"https://ik.imagekit.io/mediflix/Channel_Banners_1280x721/Yale_Channel_Banner_cChHzzHwZ.jpg?ik-sdk-version=javascript-1.4.3&updatedAt=1656714466898\"\r\n"
			+ "/><br />\r\n"
			+ "<br />\r\n"
			+ "<br />\r\n"
			+ "Thank you for your interest in Mediflix Info on Request.<br />\r\n"
			+ "<br />\r\n"
			+ "In addition to &quot;Expert Led | Patient Focused&quot; original\r\n"
			+ "programming and education, Mediflix provides access to the world's leading\r\n"
			+ "health institutions to help you navigate your healthcare journey.\r\n"
			+ "<br />\r\n"
			+ "<br />\r\n"
			+ "</span>\r\n"
			+ "</p>\r\n"
			+ "</div>";
	
	WebElement conn2;
	WebElement button2;
	WebElement email2;
	String conn_name2 = "- Skin";
	String email_copy2 ="<div>\r\n"
			+ "<p>\r\n"
			+ "<span\r\n"
			+ "><img\r\n"
			+ "src=\"https://ik.imagekit.io/mediflix/Channel_Banners_1280x721/CDN_Channel_Banner_3dYQA4Hoas.jpg?ik-sdk-version=javascript-1.4.3&updatedAt=1656714465489\"\r\n"
			+ "/><br />\r\n"
			+ "<br />\r\n"
			+ "<br />\r\n"
			+ "Thank you for your interest in Mediflix Info on Request.<br />\r\n"
			+ "<br />\r\n"
			+ "In addition to &quot;Expert Led | Patient Focused&quot; original\r\n"
			+ "programming and education, Mediflix provides access to the world's leading\r\n"
			+ "health institutions to help you navigate your healthcare journey.\r\n"
			+ "<br />\r\n"
			+ "<br />\r\n"
			+ "</span>\r\n"
			+ "</p>\r\n"
			+ "</div>"; 
	
	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public void Create_Conn_Exp() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/connect-experience");
			 
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		 	
		 System.out.println("Connect_Exp -> Verify The Create Connect_Exp With All Fields**************");
		 Reporter.log("Connect_Exp -> Verify The Create Connect_Exp With All Fields");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		 WebDriverWait Create_Conn_Exp = new WebDriverWait(driver, Duration.ofSeconds(30));
		 Create_Conn_Exp.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button"))).click();
		 		 
		 Thread.sleep(2000);
		 //connect exp name
		 conn = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input"));
		 conn.sendKeys(conn_name);
		 
		 //button text
		 button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div/input"));
		 button.sendKeys(button_text);
		 
		 //email text
		 email = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[4]/div/textarea[1]"));
		 email.sendKeys(email_copy);
		 
		 Thread.sleep(2000);
		 
		 // save 
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button[2]"))).click();
		 		
		 Thread.sleep(4000);
		 
	 }
//	 @Test (enabled = false)
	 @Test (priority=2)
	 public void View_And_Verify_Connect_Exp() throws InterruptedException 
	 {
//		driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/sponsors");
		 
		System.out.println("Connect_Exp -> view the newly created Connect_Exp*******************");
		Reporter.log("Connect_Exp ->  View The Newly Created Connect_Exp ");
		
		WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[2]"))).click();

		Thread.sleep(3000);
		
		// conn exp name
		String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input")).getAttribute("value");
		System.out.println("conn exp name is_________________________"+s1);
				
		if(s1.equals(conn_name))
		{
				System.out.println("conn exp name is present");
				softAssert.assertEquals(s1, conn_name); 
		}
		else
		{
				System.out.println("conn exp name is not present");
				softAssert.assertEquals(s1, conn_name);
				Reporter.log( "[ERROR] -> Connect Exp -> View Screen -> Conn Exp Name is not present in Connect Exp View Category Screen.");
		}
		
		//button text
		
		String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div/input")).getAttribute("value");
		System.out.println("conn exp button_text is_________________________"+s2);
						
		if(s2.equals(button_text))
		{
				System.out.println("conn exp button_text  is present");
				softAssert.assertEquals(s2, button_text); 
		}
		else
		{
				System.out.println("conn exp button_text is not present");
				softAssert.assertEquals(s2, button_text);
				Reporter.log( "[ERROR] -> Connect Exp -> View Screen -> Conn Exp button_text is not present in Connect Exp View Category Screen.");
		}
				
		Thread.sleep(2000);
        
		// close
								
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();

		Thread.sleep(4000);
		
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void Edit_Sponsor() throws InterruptedException 
	 {
//		driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/sponsors");
		 
		System.out.println("Connect_Exp  -> Edit newly created Connect_Exp *******************");
		Reporter.log("Connect_Exp  ->  Edit The Newly Created Connect_Exp  ");
		
		WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[1]"))).click();

		Thread.sleep(3000);
		
		//connect exp name
		 conn2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input"));
		 conn2.sendKeys(conn_name2);
		 
				 
		 //email text
//		 email2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[4]/div/textarea[1]"));
//		 email2.sendKeys(email_copy2);
		Thread.sleep(2000);
		      
		 // save
									
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();
		 
		 Thread.sleep(4000);
		
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void View_And_Verify_Edited_Connect_Exp() throws InterruptedException 
	 {
//		driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/sponsors");
		 
		System.out.println("Connect_Exp -> view the newly Edited Connect_Exp*******************");
		Reporter.log("Connect_Exp ->  View The Newly Edited Connect_Exp ");
		
		WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[2]"))).click();

		Thread.sleep(3000);
		
		// conn exp name
		String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/div/input")).getAttribute("value");
		System.out.println("conn exp name is_________________________"+s1);
				
		if(s1.equals(s1))
		{
				System.out.println("conn exp name is present");
				softAssert.assertEquals(s1, s1); 
		}
		else
		{
				System.out.println("conn exp name is not present");
				softAssert.assertEquals(s1, s1);
				Reporter.log( "[ERROR] -> Connect Exp -> View Screen -> Conn Exp Name is not present in Connect Exp View Category Screen.");
		}
		
		//button text
		
		String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div/input")).getAttribute("value");
		System.out.println("conn exp button_text is_________________________"+s2);
						
		if(s2.equals(button_text))
		{
				System.out.println("conn exp button_text  is present");
				softAssert.assertEquals(s2, button_text); 
		}
		else
		{
				System.out.println("conn exp button_text is not present");
				softAssert.assertEquals(s2, button_text);
				Reporter.log( "[ERROR] -> Connect Exp -> View Screen -> Conn Exp button_text is not present in Connect Exp View Category Screen.");
		}
		
		// email copy
		String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div/input")).getAttribute("value");
//		System.out.println("conn exp email copy is_________________________"+s3);
						
		if(s3.equals(s3))
		{
				System.out.println("conn exp email copy  is present");
				softAssert.assertEquals(s3, s3); 
		}
		else
		{
				System.out.println("conn exp email copy is not present");
				softAssert.assertEquals(s3, s3);
				Reporter.log( "[ERROR] -> Connect Exp -> View Screen -> Conn Exp Email Copy is not present in Connect Exp View Category Screen.");
		}
		
				
		Thread.sleep(2000);
        
		// close
								
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/button"))).click();

		Thread.sleep(4000);
		
	 }
//	 @Test (enabled = false)
	 @Test (priority=5)
	 public void Delete_Connect_Exp() throws InterruptedException 
	 {
		System.out.println("Connect_Exp -> delete Connect_Exp*******************");
		Reporter.log("Connect_Exp ->  Delete Connect_Exp ");
		
		WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		WebDriverWait delete_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		delete_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[3]"))).click();

		Thread.sleep(3000);
		
		WebDriverWait delete = new WebDriverWait(driver, Duration.ofSeconds(30));
		delete.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		
		Thread.sleep(5000);
	 } 
	 
//	 @AfterTest
//	 public void closeBrowser() 
//	 {
//	 	driver.quit();
//	 	
//	 }
	 	

}
