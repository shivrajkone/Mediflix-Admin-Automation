package website_modules;

import org.testng.AssertJUnit;
import access.login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class Mylist_Verify_From_Website extends login

{
	
	SoftAssert softAssert = new SoftAssert();
	String topic_name;
	String video_name;
	String expert_name;
	String channel_name;

	
	

//	 @Test (priority=1)
	 @Test (enabled = false)
    public void Follow() throws InterruptedException 
	{
		
		driver.manage().window().maximize();
	    driver.get("https://client-portal.us-east-1.dev.mediflix.com/browse");
	    Actions act = new Actions(driver);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    Thread.sleep(5000);
	    
	    WebDriverWait load1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		load1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(@class,'leading-180 whitespace-pre-line text-lg md:text-xl')]"))).click();
	
		System.out.println("Website -> Click and Follow Topics, Videos, Expert, Channel**************");
	
		 Thread.sleep(5000);
	    
	    WebDriverWait load_page = new WebDriverWait(driver, 60);
	    load_page.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Obesity + Weight')]")));
	    
//	    js.executeScript("arguments[0].scrollIntoView();", load_page);
	    
	    WebElement topic = driver.findElement(By.xpath("//div[contains(text(),'Obesity + Weight')]"));
	    act.moveToElement(topic);
	    
	    topic_name = topic.getText();
	    System.out.println("topic is _________________"+topic_name);
	    
	    Thread.sleep(3000);
	    WebDriverWait click_follow = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_follow.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/main/div[2]/div[1]/div/div[3]/div/div/div[1]/div/div/div/div[3]/button"))).click();
	
	    System.out.println("click on follow topics");
	    
	    Thread.sleep(5000);
  
	    
	    String video_name=driver.findElement(By.xpath("//p[normalize-space()='Becca Miller | S3 E11']")).getText();
	    System.out.println("video for selection_________________"+video_name);
	    
//	    js.executeScript("arguments[0].scrollIntoView();", video_name);
	    //click video  
	    
	    WebDriverWait click_video = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_video.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/main/div[2]/div[8]/div/div[3]/div/div/div[2]/div/div/div[2]/div/button"))).click();
	
	    //click add to watch list  
	    
	    WebDriverWait click_watchlist= new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_watchlist.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div/button[2]"))).click();
	    
	    System.out.println("click on add to watchlist");
	    
	    Thread.sleep(5000);
	    
	    //go to advice page
	    
	    WebDriverWait click_advice= new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_advice.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Advice']"))).click();
	
	    //load 
	    WebDriverWait load_advice= new WebDriverWait(driver, 60);
	    load_advice.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='slick-slide slick-active slick-current']//div//div[@class='absolute bottom-0 right-0 px-4 py-3 hidden md:block']")));
	
//	    //scroll 
//	    WebElement scroll_ele=driver.findElement(By.xpath("//div[@class='slick-slide slick-active slick-current']//div//div[@class='absolute bottom-0 right-0 px-4 py-3 hidden md:block']"));
//	    
//	    js.executeScript("arguments[0].scrollIntoView();", scroll_ele);
	    
	    Thread.sleep(3000);
	    
	    WebElement expert = driver.findElement(By.xpath("//div[@class='slick-slide slick-active slick-current']//div//div[@class='absolute bottom-0 right-0 px-4 py-3 hidden md:block']"));
	    act.moveToElement(expert);
	   
	    Thread.sleep(3000);
	    WebDriverWait click_follow_expert = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_follow_expert.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/main/div[2]/div/div[3]/div/div/div[1]/div/div/div[1]/div[3]/button"))).click();
	
	    System.out.println("click on follow expert");
	    
	    String expert_name = driver.findElement(By.xpath("//div[@class='slick-slide slick-active slick-current']//p[1]")).getText();
	    System.out.println("expert is _________________"+expert_name);
	    
	    Thread.sleep(5000);
	    
	    //go to channel
	    WebDriverWait click_channel= new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_channel.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Channels']"))).click();
	
	    //load 
	    WebDriverWait load_channel= new WebDriverWait(driver, Duration.ofSeconds(30));
	    load_channel.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[normalize-space()='Meet our Institutions']"))).click();
	
	    //click on channel
	    WebDriverWait click_channel_icon= new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_channel_icon.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/channels/cleveland-clinic']"))).click();
	
	    //click learn more
	    WebDriverWait learn_more= new WebDriverWait(driver, Duration.ofSeconds(30));
	    learn_more.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Learn more']"))).click();
	
	    //get channel name
	    channel_name = driver.findElement(By.xpath("//p[@class='text-lg']")).getText();
	    System.out.println("channel name is_____________"+channel_name);
	    
	    //click cancel
	    WebDriverWait cancel= new WebDriverWait(driver, Duration.ofSeconds(30));
	    cancel.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[2]"))).click();
	
	    //click follow
	    WebDriverWait click_channel_follow= new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_channel_follow.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='relative w-full group bg-denim dark']//button[2]"))).click();
	
	    Thread.sleep(5000);

	
	}  
	
//	 @Test (priority=2)
	 @Test (enabled = false)
	public void verify() throws InterruptedException
	{
		
		driver.manage().window().maximize();
	    driver.get("https://client-portal.us-east-1.dev.mediflix.com/journey");
	    
	    //load
	    Thread.sleep(7000);
	    
	    System.out.println("Website -> Verifying MyList From User Profile**************");
		
		 //click profile icon 
	    WebDriverWait click_profile_icon2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_profile_icon2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'relative')])[1]"))).click();
	
	    //click mylist  
	    WebDriverWait click_mylist2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_mylist2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='My List']"))).click();
	   
	    Thread.sleep(10000);
	    
	    //load 
	    WebDriverWait load4 = new WebDriverWait(driver, Duration.ofSeconds(30));
	    load4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Your List']")));
	
	    Thread.sleep(5000);
	    
	    System.out.println("Verify MyList and following of topics************************");
	    
	    String topic_verify = driver.findElement(By.xpath("//div[contains(text(),'Obesity + Weight')]")).getText();
	   	    
	   
	    System.out.println("topic is _________________"+topic_verify);
	    
//	    if(topic_name.equals(topic_verify))
//	    {
//			System.out.println("Followed topic is matching");
//			AssertJUnit.assertEquals(topic_name, topic_verify);
//		}
//		else
//		{
//			System.out.println("Followed topic is not matching");
//			AssertJUnit.assertEquals(topic_name, topic_verify);
//			Reporter.log( "[ERROR] -> Website -> MyList -> Followed Topic Is Not Matching.");
//		}
	    
	    
	    System.out.println("Verify MyList and verify video watchlist************************");
	    
	    String video_name_verify =driver.findElement(By.xpath("//p[normalize-space()='Becca Miller | S3 E11']")).getText();
	    
	    System.out.println("video for selection_________________"+video_name_verify);
	    
//	    if(video_name.equals(video_name_verify))
//	    {
//	    	System.out.println("Video Watchlist is matching");
//			AssertJUnit.assertEquals(video_name, video_name_verify);
//	    	
//	    }
//	    else
//	    {
//	    	System.out.println("Video Watchlist is not matching");
//			AssertJUnit.assertEquals(video_name, video_name_verify);
//			Reporter.log( "[ERROR] -> Website -> MyList -> Video Not Added In WatchList.");
//	    }
	    
	    
	    System.out.println("Verify MyList and follow expert ************************");
	    
	    String expert_verify =driver.findElement(By.xpath("//p[normalize-space()='Becca Miller | S3 E11']")).getText();
	    
	    System.out.println("Following expert is_________________"+expert_verify);
	    
//	    if(expert_name.equals(expert_verify))
//	    {
//	    	System.out.println("Followed expert is matching");
//			AssertJUnit.assertEquals(expert_name, expert_verify);
//	    	
//	    }
//	    else
//	    {
//	    	System.out.println("Followed expert is not matching");
//			AssertJUnit.assertEquals(expert_name, expert_verify);
//			Reporter.log( "[ERROR] -> Website -> MyList -> Followed expert is not matching.");
//	    }
	    
	    
	    System.out.println("Verify MyList and follow channel ************************");
	    
	    String channel_verify =driver.findElement(By.xpath("//p[normalize-space()='Becca Miller | S3 E11']")).getText();
	    
	    System.out.println("Following expert is_________________"+channel_verify);
	    
//	    if(channel_name.equals(expert_verify))
//	    {
//	    	System.out.println("Followed expert is matching");
//			AssertJUnit.assertEquals(channel_name, expert_verify);
//	    	
//	    }
//	    else
//	    {
//	    	System.out.println("Followed expert is not matching");
//			AssertJUnit.assertEquals(channel_name, expert_verify);
//			Reporter.log( "[ERROR] -> Website -> MyList -> Followed expert is not matching.");
//	    }
		
	}

	
	 @Test (priority=3)
//	 @Test (enabled = false)
	public void unfollow() throws InterruptedException
	{
		driver.manage().window().maximize();
	    driver.get("https://client-portal.us-east-1.dev.mediflix.com/journey");
	    Actions act = new Actions(driver);
	    //load
	    Thread.sleep(7000);
	    
	    System.out.println("Website -> Verifying MyList From User Profile To Unfollow**************");
	    	    
	    //click profile icon 
	    WebDriverWait click_profile_icon2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_profile_icon2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'relative')])[1]"))).click();
	
	    //click mylist  
	    WebDriverWait click_mylist2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_mylist2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='My List']"))).click();
	   
	    Thread.sleep(10000);
	    
	    
	    
	    //topic unfollow
	    WebDriverWait load_page = new WebDriverWait(driver, Duration.ofSeconds(30));
	    load_page.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Obesity + Weight')]")));

	    WebElement topic = driver.findElement(By.xpath("//div[contains(text(),'Obesity + Weight')]"));
	    act.moveToElement(topic);
	    
	    Thread.sleep(3000);
	    WebDriverWait click_follow = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_follow.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div[3]/button"))).click();
	
	    System.out.println("Unfollow the topics");
	    Thread.sleep(5000);
	    
	    // expert unfollow
	    
	    WebElement expert = driver.findElement(By.xpath("//div[@class='slick-slide slick-active slick-current']//div//div[@class='absolute bottom-0 right-0 px-4 py-3 hidden md:block']"));
	    act.moveToElement(expert);
	   
	    Thread.sleep(3000);
	    WebDriverWait click_follow_expert = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_follow_expert.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[4]/div/div[3]/div/div/div[1]/div/div/div[1]/div[3]/button"))).click();
	
	    System.out.println("Unfollow the expert");
	    Thread.sleep(5000);
	    
	    //channel unfollow
	    
	    //click channel   
	    WebDriverWait click_channel = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_channel.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='absolute w-full h-full']"))).click();
	
	    //click follow   
	    WebDriverWait click_follow_channel = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_follow_channel.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Following']"))).click();
	    
	    System.out.println("Unfollow the channel");
	    Thread.sleep(3000);
	    
	    //click go back  //span[normalize-space()='Go Back']
	    WebDriverWait click_goback = new WebDriverWait(driver, Duration.ofSeconds(30));
	    click_goback.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Go Back']"))).click();
	    
	}
	
	
}
	
	


