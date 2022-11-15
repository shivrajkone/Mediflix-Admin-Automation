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

import base.BaseTest;

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

public class User_managment_testcases extends BaseTest	
{
	
	ChromeDriver driver; 
	SoftAssert softAssert = new SoftAssert();
	
	WebElement search;
	String search_key="Ram";
	
	
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public void Verify_Search_In_User_Managment() throws InterruptedException 
	 {
		 driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/users");
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		 	
		 System.out.println("User_Managment -> Verify The Search**************");
		 Reporter.log("User_Managment -> Verify The Search In User_Managment");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]"))).click();
		 
		 
		                                      
		 search = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/div/div/input"));
		 search.sendKeys(search_key);
		 
		 Thread.sleep(5000);
		 
		 
		 
		 
	 }
	

}
