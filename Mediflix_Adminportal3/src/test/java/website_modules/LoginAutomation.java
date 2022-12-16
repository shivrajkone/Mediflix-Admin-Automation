package website_modules;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



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

import access.login;


public class LoginAutomation 
{
	ChromeDriver driver; 
	SoftAssert softAssert = new SoftAssert();

	String Email="shivrajtech37@gmail.com";
	String Password="Shivraj@1234";
	
	WebElement search;
	String key="Psychosis";
	
	
	
	@Test (priority =1)
	
	public void login() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Prasad_aute//Downloads//selenium/108/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://client-portal.us-east-1.dev.mediflix.com/login");
	    
	    Thread.sleep(4000);
	    
	    WebDriverWait load1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		load1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[normalize-space()='Log In']"))).click();
	    
	    WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
	    email.sendKeys(Email);
	    
	    Thread.sleep(2000);
	    
	    WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	    password.sendKeys(Password);
	    
	    Thread.sleep(2000);
	    
	    WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
	    submit.click();
	    
	    Thread.sleep(3000);
	    // compare the url
	    
	    String actualUrl="https://client-portal.us-east-1.dev.mediflix.com/";
	    String expectedUrl= driver.getCurrentUrl();
	    AssertJUnit.assertEquals(expectedUrl,actualUrl);
	    System.out.println("Successfull Login");
	    
	    WebDriverWait load2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	    load2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container max-w-[1200px] mx-auto wrapper']")));
	
	    // get data
	    String get_title = driver.findElement(By.xpath("//div[@class='container max-w-[1200px] mx-auto wrapper']")).getText();
	    System.out.println("the login title of user is_________________"+get_title);
	    
	    Thread.sleep(3000);
		
		//click search 
		
		WebElement click_search = driver.findElement(By.xpath("//a[@href='/search']"));
		click_search.click();
		
		Thread.sleep(3000);
		
		WebDriverWait load3 = new WebDriverWait(driver, Duration.ofSeconds(30));
	    load3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
			
		search =driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys(key);
		
		Thread.sleep(3000);
		// submit
		
		WebElement click_submit = driver.findElement(By.xpath("//button[@type='submit']"));
		click_submit.click();
		System.out.println("Click For Search _________________");
		
		
		Thread.sleep(3000);
		//load 
		
		
		//verify the search   
		
		String s1= driver.findElement(By.xpath("//div[@class='flex-1 pt-8 max-w-full whitespace-normal truncate basis-60']")).getText();
		System.out.println("result string is_________________________"+s1);
		String[] arrOfStr = s1.split(" ");
        System.out.println("split string is ________________"+arrOfStr[0]);
        String newstr=arrOfStr[0];
       
      
        if(newstr.equals(key))
        {
        	System.out.println("Key is matching");
			AssertJUnit.assertEquals(newstr, key);
		}
		else
		{
			System.out.println("key is not matching");
			AssertJUnit.assertEquals(newstr, key);
			
		}
        
 
	     
	}
	
	

}

