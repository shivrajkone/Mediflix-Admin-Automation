package access;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;


public class login 
{
	public static ChromeDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	String Email="shivrajtech37@gmail.com";
	String Password="Shivraj@1234";
	 
	
	@BeforeTest
	public void Local_Storage() throws IOException, InterruptedException
	{
		FileInputStream objfile = new FileInputStream("C:\\Users\\Prasad_aute\\git\\Mediflix-Admin-Automation\\Mediflix_Adminportal\\src\\test\\resources\\Properties\\mediflix.properties");									
        prop.load(objfile);		
        
		System.setProperty("webdriver.chrome.driver", "C://Users//Prasad_aute//Downloads//selenium/108/chromedriver.exe");
	    driver = new ChromeDriver();
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
	    
	    WebDriverWait load2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	    load2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container max-w-[1200px] mx-auto wrapper']")));
	
	    // get data
	    String get_title = driver.findElement(By.xpath("//div[@class='container max-w-[1200px] mx-auto wrapper']")).getText();
	    System.out.println("the login title of user is_________________"+get_title);
	    
	    
	 }
	
	  
	                
//	 @AfterTest
//	 public void closeBrowser() 
//	 {
//	 	driver.quit();
//	 	
//	 }
	
	
	
	
}
