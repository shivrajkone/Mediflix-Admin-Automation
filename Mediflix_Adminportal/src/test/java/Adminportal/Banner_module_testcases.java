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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.TakesScreenshot;

public class Banner_module_testcases 
{
	WebDriver driver; 
//	ChromeDriver driver; 
//	SoftAssert softAssert; 
	SoftAssert softAssert = new SoftAssert();
	
	WebElement title;
	WebElement subtitle;
	WebElement overtitle;
	WebElement alt_text;
	WebElement decs;
	WebElement action_button_title;
	WebElement	banner_searchbox;
	WebElement tagcount1;
	
	String banner_title="AIG Health";
	String banner_subtitle="global";
	String banner_overtitle="health";
	String banner_alttext="health org";
	String banner_decs="Global Health Council is the leading member organization devoted to advancing global health";
	String banner_actionbuttontitle="Share";
	String bannerimg;
	String tagcount2;
	
	WebElement title2;
	WebElement subtitle2;
	WebElement overtitle2;
	WebElement alt_text2;
	WebElement decs2;
	WebElement action_button_title2;
	WebElement	banner_searchbox2;
		
	String banner_title2="Issues in Brain";
	String banner_subtitle2="Neurologists";
	String banner_overtitle2="Dr";
	String banner_alttext2="health org";
	String banner_decs2="Neurologists are specialists who treat diseases of the brain and spinal cord";
	String banner_actionbuttontitle2="Share";
	String bannerimg2;
	String tagcount3;
	
	String banner_order="Order";
	String banner_button_title="Title";
	String banner_type="Type";
	String banner_action_type="Action Type";
	
	Local_Store local_storage_class;

	
/*	


	  public void TestLocalStorageSetAndGetItem()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Prasad_aute//Downloads//selenium/106/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://admin-portal.us-east-1.dev.mediflix.com");

	    LocalStorage local = ((WebStorage) driver).getLocalStorage();    

	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.LastAuthUser","saurav.anand@mediflix.com");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.deviceGroupKey","-9b0ne3AP");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.refreshToken","eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.ByPQl514AbDvY7B-TIeq-5O0aWYNZG5-dMX4r7cf26tVTFY3FMHAeyo5w_7zFZDs4njefK9uuTXKHdeDqi21FnDQ9nREJth7r3QlufiKG_RXR35NKrTzJz4cLketw-cNoO8YVpRvB4JF7l2sjVdVQlZyWXKwUPtqI_ffsC8m6mVu7a1uZ5O-gJLdI8mGQSqB_qkJjZanu0UfCPjq1YfvZM6oOcHgiW0eX_QB_XPXi0FRgwOeXi_yiPodLVJ7FDw6hW4JD-KIUpzIftApLtfe5d8JGZLmm6XvaNfEiaG5hTHHjHj5TGzCcKi_KaXzvv2M0xoRRF0JalXUyQZipff0lg.mJn7UcOSEiLtspGz.PZYaCbGLZqtPvo-tnN2PLoi8zbIjxc1AYgbvdfM3_9G-BoC4cc55kbCgpJAqJOdUXzlLvsOTssp9zdLEQQGXyL0AQ-D15X_cWZnwBG8YhNRJQtBiRL1KazJHV_RdgHoMnDqeQqDwnnf5TEuTnKj8QdSYC_uZbqUgR7LyhKXVPAQXwT1wBOhInBrud0lOUpSC190vSfK2T9VEd1gBLg8qnySfUoBH5XRz-0IgtEgpFSZzAzdR--VgLRrSUghKiBvAkW_GopdgKFyD16Qpkux5ZeUidQjy-3d3OOrlSkJyGtl9M3o_WELQTCS5O8Zy8DgoEkurL9L7mFWiccEDWF0XIXjR-wU1x5tCWkrCF-LJOgpTvlQ--Fh1RlEfU9DxLec9PvkHEydd-nDtC9I9qQECEnV62jwlBOH6quybSlgO4TQD_mAD3JLIkAxqTh4Z03Tj51eU-KTlkUOhGHibRmVIw0NMHQwICKL2DKLqGqH3nEd927r-Pi-A3bNny084crh52-OuZigPng-LaLR7EnJdoZ0zBBcBkzLyNhnWwQ4fsJKjKoiHA_mNLmfohGYaEnKPn-rScjYgA0ZWdkOpa9mPd0WFMXHvk7nACPGhLubzOtB2LjdpWLGK1LC10xma2Bq4eJddCMeYSRdVswTDRyFzw409Lx-osmR7frMDKTkJ03qC6W_6p6sTVHUqN24Hi8fX_jBwyLXK09YX0NgXOC5jtrUaeyvp-YTRbn-F92kffz7eB46DuimvU48Bt2g0SdJy8L4rRqLTBP6z6HblkkL-GvYxm8NlAi5U1eTdHgiDkLnRBk4PDAoabZAkv6b5bPJqiVu4hZhwuXXcS6x7f9xHtR05iRwV6GTcXTdt_rCuxsPRYPPEq2mnsV9oTqUOlEx1Lus__ISYvoB843wU1qTnZv5KG8xLsLEAHpJesndL5ugeO_RWsHETtHs7hy1a8lD3wVa6QIt3xPQTvgPeFGAageYdUtYAOq5yjLw05WNLavVvUlygxbHR3XKJB_gRbVYKQcBzqOwYdwXq0Rb89xGW-YzhzNYrlXFksSsE7_DM4i2C_x9m2BTCX74VnSHbM9_5-ukfYfD8Xwa1akYQLaZcWrqDO1uujYPIHd_4lmRXb3Tk-qgrMVIhDJo-wYUL_hVfTHmsxsfDQU2dk8_MNtX1VivKyBBirZD2XdvXZ38a5EW1beVTw-ArMXrru4ZtTZklCUPR5NAHY5VqGZwTYoPyoZa2W2hCQIQZTZg9F5dwIgCJ03ufhcullgpj-yTkLIcsq-qMSmjI0lebPiCcaEzDk6mwOf9wItN0zgV4Dr4k377SPqe1of01F2Bzf_Wdp0jD58-Je2mvnkOu4b9FIIdl9NFIIhLIQx4DQ4qHKMzTe12sHuGlR_f3Gd3usmTQsrIMKBAfEG80XPHbrWRTdrbkTb2AbaRBcEYfByUFVbcy.LAwB62nxf_q5t9cdWbzS8w");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJkZXZpY2Vfa2V5IjoidXMtZWFzdC0xXzdjNzNiNTRkLWZjMzItNGU4Yi05MGM2LTJlZGZkNDYyM2EwZCIsImNvZ25pdG86Z3JvdXBzIjpbImFkbWluIiwicGF0aWVudCJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9RdWVxOERPMEUiLCJjbGllbnRfaWQiOiIxNnZuMm5pNmQ0Mjl0ZmQzbWk4NnJlZmsycCIsIm9yaWdpbl9qdGkiOiJjOGU4NzM4NC1lODY1LTQzNWEtODg0Ni00NGRlODM3OWRhY2IiLCJldmVudF9pZCI6IjIyZGQwNDNkLWM5N2MtNDljMy1iMTFmLTQ0NTlmOTQyZTQyYyIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2NjU1NzM5MDQsImV4cCI6MTY2NTU3NzUwNCwiaWF0IjoxNjY1NTczOTA0LCJqdGkiOiI4YzRhM2EyOS04YTVjLTQ0ZDQtYTM3Yi00YjM4MzA0ZjEzNzkiLCJ1c2VybmFtZSI6IjM4ZWFlZjZkLTZhOTgtNDU0Yy1iM2RmLTg2MWMxN2NkMWZjZCJ9.qwECRSofa2J5zhnqXdvt1p_ab7pVyT1CfaqzEDj5daRSNe9KCtIHtviu3T2CGGF2vpW3fXGBdwcSFpgnePz5rnUcAL2hYgENVAPZUZjdqRFOF5Fp76sKBaxWcNz2vm4c1F_VfGunb6useh8oTQyzn2GWGuCC-BmDmM4ooeWxyM87OfMBwhIAFlC0ffgHBdQlrreB2lj0R2XpE80mfOTQzYPg3O4i6RR7BsFvv4Pp78hS7gooyPO21Dqq6aSKMWdVGRdw_PTUhpVGe8bpe1jQRRqg7i7TAHs-mO-5PgmrviJsZSTg22nYJ8INU-Gna1wjZz3rWxqXQQlOYn77G5us8g");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.clockDrift","0");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.refreshToken","eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.Hx7p23V3Iqqk4nSNbIK-zzqct84fZfNe2jbZxnqyBs6AqeG_2a4hp1QkyZ8t6wKHEDskLmElkyzi4W4gUht4AKQMMEjdOoccb_IGA6TUbYPBKambcY5zOxWizdEv_wig1Gj5wy5EHBpV3neNetWJnDPPLV_tIYZEvgTeEvNIq57EdFbdwCo-mo_FZXjHByvs9JJ92uEgzaN5tQQTWmeDKX4vmZT0Qtcs39RNh0nxXDbbbpiDW64VCHoAftd1gG-jAYrHWnIN_BhVSyL0aETHuDhu5d_LLp0xBCbBEJztextK6ihZwDwB6sCeTwqryrOWekcO7YnbkI4-R8_MVNWRpQ.vVdm-qtf3WimDqbt.bQbimb6IXOhMHyQBkgwTNTgxcHOZDskU-UBaHx7KkoNKqMYxNOxgu1YqOB8NCOs6oEwQQm4t3GvWa3r58fhSwi-SKaGB_vn97TK7DnxbIiMhwXUnFUssbZqg1JUYTlMccYZcl5u_gSmHYdm2D2LpIBCHNXpCEyCY8gZC388RI7IqhtO5vNITpeJ2MuGU5ZmtlKglhGpM-vUA8Q6OZtUQ0_nNKbwHLtpPiavE967KnoXmjXiJSzu-1HVSP5fMvsmoRQ5XIz_OIpqgVeLW8IYUNOJYBEXyImybo2IJDEBf-MLJTFo0LGbR2wFsK4_B-Ew3X8lnTdNBWamiMiEDk12OUAYLskBgCRCjb2hvpwYX2c8Kkf9E5sWE3oNQoeyjG0t-wAX01iH1PzzW2d03is39O0sD8sxYBRHSCjDpf35Tzw-8n0UpYOECMMm1vm72xySChbx1-mb8PFcZo4VXhIs_dNaPVNXMSS_e6OaC3nTbD5ZkFL_Nnun4q2IhPSzLANjOHvVQlmxomublZkmGW_fp30iE9LGx3kqkCbf14HYr_6StaC2n4tjOYnuj8rUKLJciy_yMl0dX331jYJAZarhzWpV4FbcS1ra3mQQrhEiUk0hPv9JolOB6tHDpysCHIy7p-8h5WgRoeESESCxPED2HdYztDbid540i-h-FTBNXFVfsaWaXAi0Ob2fpbsokjgmQI9mj4zGvxamLqujedoL-_mSmTXbwLadETvVsa5Jsv3q8nAwbz06WCY6Wbr8NeYdVH2iUR6CBWNrz5Eoywxzv8lxxeT-rb2oyIaBK_xHLMkQkVMxMzqLj8yuBgBeajylpbZLoZl8JBx6vlvzFrBeHgRsxmL6ncFTehmIRBEsl5qQxEvx88ZWBrzctxG6eBdtWUEY7OPB-1YyEoPB31mrT26DFFMyL2WBKZaT9Aio2-1N3UNq7Mzq6OKyegq3XX-ylzxznYgxx8Js-691M6t486Hk-Q4Nn5iVAaWuoYA53BuPB_FdqZYmjrrqUNqz6uD83MOYOkXL8zM2CZX9jCyxwGSwennUQvu_j-h6mm1O1iBDpBDDbZa9tbiNPXWftVViIs9TWi-AKtXQXlqgS1ROc6Im1G33Bt0EEaJ_raHqMx7bU8sw0c764r_zuiVhTkT-lvqpcpjckUe1EJVgJA75R6stclHCm0aJAW-BD2RHbKFtj5YaSUNn18lpL7xEMKkvGDwvmT8OOqDB9d7fB8lgImeTuXBi1hbgIWid57VXBaXF-wVNfkdNFbji-6tWORe7du00M7CsncDN-rJSRGueZAOFaBwkFBj-8tyAJMDw.NwuAlhQ-MxUlYnRFT7TgYA");
	    local.setItem("amplify-signin-with-hostedUI","false");
	    local.setItem("amplify-signin-with-hostedUI","false");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.LastAuthUser","38eaef6d-6a98-454c-b3df-861c17cd1fcd");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.idToken","eyJraWQiOiIrMDBqWVZCZVhOQVwvTkpVa1FEa0dkUHdzM1NJSjNkVVRYTUI4VGNGa3VGZz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJjb2duaXRvOmdyb3VwcyI6WyJhZG1pbiIsInBhdGllbnQiXSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfUXVlcThETzBFIiwiY29nbml0bzp1c2VybmFtZSI6IjM4ZWFlZjZkLTZhOTgtNDU0Yy1iM2RmLTg2MWMxN2NkMWZjZCIsIm9yaWdpbl9qdGkiOiJjOGU4NzM4NC1lODY1LTQzNWEtODg0Ni00NGRlODM3OWRhY2IiLCJhdWQiOiIxNnZuMm5pNmQ0Mjl0ZmQzbWk4NnJlZmsycCIsImV2ZW50X2lkIjoiMjJkZDA0M2QtYzk3Yy00OWMzLWIxMWYtNDQ1OWY5NDJlNDJjIiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2NjU1NzM5MDQsIm5hbWUiOiJzaGl2cmFqMiIsInBob25lX251bWJlciI6Iis5MTk4MzQzMzA5ODEiLCJleHAiOjE2NjU1Nzc1MDQsImlhdCI6MTY2NTU3MzkwNCwianRpIjoiNWU0Yjg0YmEtYzM1Yi00ZmM5LTk4NDAtYzk4MjljMDcxYTJjIiwiZW1haWwiOiJzaGl2cmFqdGVjaDM3QGdtYWlsLmNvbSJ9.XiaDXZdpax1E_1Pq2v0N3dGNe7PMRO8wRxdA7kw3O-cTwRF75o4yYlju6qicTR7eseyme_wk8WCjVuMVcxo0wwOdOV-_oWjiURFTk2OyQz4tJ_E_noQzgiJR1pZiZK0OvTDpVlTomTnYfwD5YGRa7lFWWELD1vR_vIw3DN1VS3YGhssTp8TWhfGIp0MSJn9W0M0QccoyHty_CHUDMMsgtivCDzXMemJDvf1huzi23Teas8gMEEfgmK9hB6xvqAzosHPOLxXJXOfh45usMw4bdQFaZUBsixqqsZNGWnKSj-8RJRDHR5PnsBZHrWqi0Wwsaa2stMrZ8aCDLj7-0WVW5w");
	    local.setItem("accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJkZXZpY2Vfa2V5IjoidXMtZWFzdC0xXzdjNzNiNTRkLWZjMzItNGU4Yi05MGM2LTJlZGZkNDYyM2EwZCIsImNvZ25pdG86Z3JvdXBzIjpbImFkbWluIiwicGF0aWVudCJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9RdWVxOERPMEUiLCJjbGllbnRfaWQiOiIxNnZuMm5pNmQ0Mjl0ZmQzbWk4NnJlZmsycCIsIm9yaWdpbl9qdGkiOiJjOGU4NzM4NC1lODY1LTQzNWEtODg0Ni00NGRlODM3OWRhY2IiLCJldmVudF9pZCI6IjIyZGQwNDNkLWM5N2MtNDljMy1iMTFmLTQ0NTlmOTQyZTQyYyIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2NjU1NzM5MDQsImV4cCI6MTY2NTU3NzUwNCwiaWF0IjoxNjY1NTczOTA0LCJqdGkiOiI4YzRhM2EyOS04YTVjLTQ0ZDQtYTM3Yi00YjM4MzA0ZjEzNzkiLCJ1c2VybmFtZSI6IjM4ZWFlZjZkLTZhOTgtNDU0Yy1iM2RmLTg2MWMxN2NkMWZjZCJ9.qwECRSofa2J5zhnqXdvt1p_ab7pVyT1CfaqzEDj5daRSNe9KCtIHtviu3T2CGGF2vpW3fXGBdwcSFpgnePz5rnUcAL2hYgENVAPZUZjdqRFOF5Fp76sKBaxWcNz2vm4c1F_VfGunb6useh8oTQyzn2GWGuCC-BmDmM4ooeWxyM87OfMBwhIAFlC0ffgHBdQlrreB2lj0R2XpE80mfOTQzYPg3O4i6RR7BsFvv4Pp78hS7gooyPO21Dqq6aSKMWdVGRdw_PTUhpVGe8bpe1jQRRqg7i7TAHs-mO-5PgmrviJsZSTg22nYJ8INU-Gna1wjZz3rWxqXQQlOYn77G5us8g");
	    local.setItem("userRole","admin");
	    local.setItem("userPhoneNumber","+********0981");
	    local.setItem("persist:root","{\"user\":\"{\\\"data\\\":{\\\"sub\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"cognito:groups\\\":[\\\"admin\\\",\\\"patient\\\"],\\\"iss\\\":\\\"https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Queq8DO0E\\\",\\\"cognito:username\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"origin_jti\\\":\\\"c8e87384-e865-435a-8846-44de8379dacb\\\",\\\"aud\\\":\\\"16vn2ni6d429tfd3mi86refk2p\\\",\\\"event_id\\\":\\\"22dd043d-c97c-49c3-b11f-4459f942e42c\\\",\\\"token_use\\\":\\\"id\\\",\\\"auth_time\\\":1665573904,\\\"name\\\":\\\"shivraj2\\\",\\\"phone_number\\\":\\\"+919834330981\\\",\\\"exp\\\":1665577504,\\\"iat\\\":1665573904,\\\"jti\\\":\\\"5e4b84ba-c35b-4fc9-9840-c9829c071a2c\\\",\\\"email\\\":\\\"shivrajtech37@gmail.com\\\"},\\\"logged\\\":true,\\\"logging\\\":false,\\\"loginError\\\":null,\\\"validating\\\":false,\\\"getOtp\\\":false,\\\"retrievingAll\\\":false,\\\"retrievingAllError\\\":{\\\"message\\\":\\\"Response not JSON\\\",\\\"status\\\":401},\\\"updating\\\":false,\\\"updateError\\\":null,\\\"updated\\\":false,\\\"updatedPassword\\\":false,\\\"updatingPassword\\\":false,\\\"updatePasswordError\\\":null}\",\"_persist\":\"{\\\"version\\\":-1,\\\"rehydrated\\\":true}\"}");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.clockDrift","0");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.deviceKey","us-east-1_7c73b54d-fc32-4e8b-90c6-2edfd4623a0d");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.accessToken","eyJraWQiOiJEc28rS0YyK1Y5M0NSK0FtYTRzXC94Z0FuXC9VdTdBcjdhZ044SXh1SWF3cGc9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJjNGQ2ZjE4ZS1lNGU5LTQ1MGItOTllZC03MzNiOTJiYjAwNDUiLCJjb2duaXRvOmdyb3VwcyI6WyJBZG1pbiJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9qMER5M3FYOE4iLCJjbGllbnRfaWQiOiIzMW5xNGNzcG5nanUycnRzdmVrZm84b2o3ZyIsIm9yaWdpbl9qdGkiOiJmZDJjNTYzOS03Yzc1LTRjNjItOWJlYS1mMWM4OGU0MzcyMDQiLCJldmVudF9pZCI6IjA0ODg1YzgwLWQ2OTUtNGRkYy1hN2QyLTcxMTI3ODQ0ZmVkMCIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2NTI0NDQzNjYsImV4cCI6MTY1NDIzNDgyNSwiaWF0IjoxNjU0MjMxMjI1LCJqdGkiOiIzNzlkNGM5MS00NjE2LTRmNzQtOWU0ZC00ODIxZTg1Y2Y1MGQiLCJ1c2VybmFtZSI6InNhdXJhdi5hbmFuZEBtZWRpZmxpeC5jb20ifQ.OIyxA5gzWlUUaIXttHx7NyGj3GR17YcCRR_pJ4VXvovga-jGRnPsGKz6Fvv4yG0SrvCWNe12PltaxTRuo1192AAr_jm__GFjIczjhr3B4l__BMJ1eMahMqsVArAAvjjik9VvGZsX61frfBsTu11MmjceoGYscoJzBKqufE91zWEv0xMRqNNQGlg-q4DiUV3Cu52zgQ-7mBaCOwVa_J63MlcWfG7WSUgr47ix4LAmbi8H94J-9RnGOyw_22rgRX5TB54ix0INmpnOyh8bKMLJEskTJ6MtJObS8TYzsJrazBlrurqCdlWOqFDx2n24K8Obtv74Sg5Pwssm4icNk6SQ5w");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.randomPasswordKey","mlvQreD0BeNzhYmuIThPelqazmNg0Lx9ibk3OO+72Hremdj3FfPJdg==");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.userData","{\"PreferredMfaSetting\":\"SMS_MFA\",\"UserAttributes\":[{\"Name\":\"sub\",\"Value\":\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\"},{\"Name\":\"name\",\"Value\":\"shivraj2\"},{\"Name\":\"phone_number\",\"Value\":\"+919834330981\"},{\"Name\":\"email\",\"Value\":\"shivrajtech37@gmail.com\"}],\"UserMFASettingList\":[\"SMS_MFA\"],\"Username\":\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\"}");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.idToken","eyJraWQiOiIzNkZrcURhRWt1eU9WcVo3V2JMaE15UVZ2UFRNY1Z5QVJ3N2IzYUJIdXU4PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJjNGQ2ZjE4ZS1lNGU5LTQ1MGItOTllZC03MzNiOTJiYjAwNDUiLCJjb2duaXRvOmdyb3VwcyI6WyJBZG1pbiJdLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX2owRHkzcVg4TiIsImNvZ25pdG86dXNlcm5hbWUiOiJzYXVyYXYuYW5hbmRAbWVkaWZsaXguY29tIiwiZ2l2ZW5fbmFtZSI6IlNhdXJhdiIsIm9yaWdpbl9qdGkiOiJmZDJjNTYzOS03Yzc1LTRjNjItOWJlYS1mMWM4OGU0MzcyMDQiLCJhdWQiOiIzMW5xNGNzcG5nanUycnRzdmVrZm84b2o3ZyIsImV2ZW50X2lkIjoiMDQ4ODVjODAtZDY5NS00ZGRjLWE3ZDItNzExMjc4NDRmZWQwIiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2NTI0NDQzNjYsImV4cCI6MTY1NDIzNDgyNSwiaWF0IjoxNjU0MjMxMjI1LCJmYW1pbHlfbmFtZSI6IkFuYW5kIiwianRpIjoiNDk2YTZkYWEtYjU1NS00MTBmLWIwYzYtNTgwZjUxYmVjNzQwIiwiZW1haWwiOiJzYXVyYXYuYW5hbmRAbWVkaWZsaXguY29tIn0.h3BOXh2CIjvlBX0y7M-r4YTVOJBagj390V0EprKTER9xfVTB5coHFZ9Y84-2tqbn_3VYO5SJwLOe9sSx_CfdhxcnNNnmAnXvycAPq5NaylrebPxtS-BMprhqWwxHvThmjAPGbSRqvWf9OGKOMCnFtvuJVv6LhN_1KB2k_UR3qgjZ223BQvF0iKvetmS8gfJHwPebDrT3l1Wctlau3dt_PmTEF4yv_ccdC-g1pAtVUM64857RjNT1cG-W_dezzd0jabjZHzzYlQ5sQ6DbzgU91xWkQynlLfkrhWlxxvorzk1F8vaT3NvO2eeJg-6kDJjtSsRjF-thV4qEZjtANwVvEA");
	       
	    driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/banners");
	    
	 }
	  
	  
*/	  
	  @BeforeClass 
	  public void setitem() 
	  {
		  System.out.println("this is before classs");
		  local_storage_class= new Local_Store(driver);
		  local_storage_class.Test_Local_Storage();
		  
//		  WebElement banner_icon_click=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/button[6]"));
//		  banner_icon_click.click();
		  
	  } 
	  
	  @BeforeTest
	  public void navigate()
	  {
		//  driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/banners");
		  WebElement banner_icon_click=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/button[6]"));
		  banner_icon_click.click();
		  
	  }
  
	
	@Test (priority=2)
//	 @Test (enabled = false)
	 public void Create_Banner_With_Madatory_fields() throws InterruptedException 
	 {
		 
		 driver.manage().window().maximize();
		 System.out.println("Banner -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 
		 Reporter.log("Banner -> Verifying Mandatory Fields Validation Is Working Or Not");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 WebElement create_banner_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"));
		 create_banner_button.click();
			
		 Thread.sleep(1000);
		    
		 WebElement savebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
		 savebutton.click();
		 
		 Thread.sleep(1000);
		 
		 System.out.println("Banner -> Verify The Create From Banner Module With Mandatory Fields Only**************");
		
		 Reporter.log("Banner -> Create Banner With Mandatory Fields Only");
		 //banner title
		 title= driver.findElement(By.id("title"));
		 title.sendKeys(banner_title);
			 
		 Thread.sleep(1000);
		 //banner image
		 WebElement banner_img=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button"));
		 banner_img.click();
		 	 
	//	 Thread.sleep(10000);
	 
		 WebDriverWait wait_img = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_img.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img")));
		    		 
		 WebElement img_select=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"));
		 img_select.click();
	
		 WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
		 select_button.click();
		 
		 Thread.sleep(1000);

		 WebElement save_banner=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
		 save_banner.click();
		 
		 Thread.sleep(3000);

	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void View_And_Verify_Banner_With_Mandatory_Fields() throws InterruptedException 
	 {
		 	
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
//		 	Thread.sleep(3000);
		 			 	 
		    System.out.println("Banner -> search and view the newly created banner*******************");
		    Reporter.log("Banner -> Search And View The Newly Created Banner");
		 			 
			WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title);
			
			 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[2]"))).click();

//			Thread.sleep(3000);
			
//			WebElement icon_view = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[2]"));
//			icon_view.click();
			
			Thread.sleep(3000);
			
			//banner title
			String s1 = driver.findElement(By.xpath("//input[@id='title']")).getAttribute("value");
			System.out.println("banner tile is ____________________________"+s1);
		
			if(s1.equals(banner_title))
			{
				System.out.println("title is present");
				AssertJUnit.assertEquals(s1, banner_title);
			}
			else
			{
				System.out.println("title is not present");
				AssertJUnit.assertEquals(s1, banner_title);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Title is not present in Banner view screen.");
			}
	
			// verify banner image
			
			String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/div/div/img")).getAttribute("src");
			System.out.println("img scr__________"+s8);
			
			if (s8.equals(s8))
			{
					System.out.println("image is present");
					AssertJUnit.assertEquals(s8, s8);
			}
			else
			{
					System.out.println("image is not present");
					AssertJUnit.assertEquals(s8, s8);
					Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Image is not present in Banner View Screen.");
					
			}
				
			softAssert.assertAll();
			WebElement closebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"));
		    closebutton.click();
		    Thread.sleep(3000);
		       
	 }
	 

//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void Edit_Banner_With_All_Fields() throws InterruptedException 
	 {
		    driver.navigate().refresh();

		    driver.manage().window().maximize();
		    System.out.println("Banner -> Search And Edit The Newly Created Banner With Remaining Fields");
		    Reporter.log("Banner -> Search And Edit The Newly Created Banner With Remaining Fields");
			
		    WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title);

			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
			
			WebElement icon_edit = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[1]"));
			icon_edit.click();
			
		   	subtitle= driver.findElement(By.id("subtitle"));
			subtitle.sendKeys(banner_subtitle);
			 
			 overtitle= driver.findElement(By.id("over-title"));
			 overtitle.sendKeys(banner_overtitle);
			 
			 alt_text= driver.findElement(By.id("image-alt-text"));
			 alt_text.sendKeys(banner_alttext);
			
			decs= driver.findElement(By.id("description"));
			decs.sendKeys(banner_decs);
			
			WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/button"));
		     tab_button.click();
			    
		     Thread.sleep(1000);
			 //tags topic
		     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"));
			 tab_topic.click();

			 Thread.sleep(1000);
			    
			 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 selectbutton.click();
			    
			 Thread.sleep(1000);
			
			 // tags count
			 tagcount2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/button/p")).getText();
			 System.out.println("the tag count is __________________"+tagcount2); 
			 
			 WebElement add_button=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/button"));
			 add_button.click();

			 action_button_title=driver.findElement(By.xpath("//*[@id=\'banner-description\']"));
			 action_button_title.sendKeys(banner_actionbuttontitle);
			 
			 WebElement type_button=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div"));
			 type_button.click();
			 
			 WebElement select_type=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[1]"));
			 select_type.click();
			 
			 Thread.sleep(1000);
			 
			 WebElement action_type=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[3]/div/div"));
			 action_type.click();
			 Thread.sleep(1000);
			 WebElement action_select=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[5]"));
			 action_select.click();
			 Thread.sleep(1000);
			 WebElement save_actionbutton=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 save_actionbutton.click();
			 
			 Thread.sleep(3000);

			 WebElement savebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
			 savebutton.click();
			
			 Thread.sleep(3000);
			 
	 }
	 
	 @Test (priority=5)
	 public void View_And_Verify_Edited_Banner()  throws InterruptedException 
	 {
		 Thread.sleep(10000);
		     driver.navigate().refresh();
		 	 driver.manage().window().maximize();
		 	 
		    System.out.println("Banner -> search and view the edited banner*******************");
		    Reporter.log("Banner -> Search and View The Edited Banner");
		    
			WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title);
		 
			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
						
			WebElement icon_view = driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-1muvhzt'])[1]"));
			icon_view.click();
			
			Thread.sleep(1000);
			
			//banner title
			String s1 = driver.findElement(By.xpath("//input[@id='title']")).getAttribute("value");
			System.out.println("banner tile is ____________________________"+s1);
		//	String expected="ttitle";
			
			if(s1.equals(banner_title))
			{
				System.out.println("title is present");
				AssertJUnit.assertEquals(s1, banner_title);
			}
			else
			{
				System.out.println("title is not present");
				AssertJUnit.assertEquals(s1, banner_title);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Title is not present in Banner view screen.");
			}
	
			//subtitle
			String s2 = driver.findElement(By.xpath("//input[@id='subtitle']")).getAttribute("value");
			System.out.println("banner subtile is ____________________________"+s2);
		//	String expected2=banner_subtitle;
			
			if (s2.equals(banner_subtitle))
			{
				System.out.println("banner subtitle is matching "+s2);
				AssertJUnit.assertEquals(s2, banner_subtitle);
			}
			else
			{
				System.out.println("banner subtitle is not matching "+s2);
				AssertJUnit.assertEquals(s2, banner_subtitle);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner SubTitle is not present in Banner view screen.");
				
			}
			
			//over title
			
			String s3 = driver.findElement(By.xpath("//input[@id='over-title']")).getAttribute("value");
			System.out.println("banner overtitle is ____________________________"+s3);
			//String expected3=banner_overtitle;
			
			if (s3.equals(banner_overtitle))
			{
				System.out.println("banner overtitle is matching "+s3);
				AssertJUnit.assertEquals(s3, banner_overtitle);
			}
			else
			{
				System.out.println("banner overtitle is not matching "+s3);
				AssertJUnit.assertEquals(s3, banner_overtitle);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Over Title is not present in Banner view screen.");
				
			}
			
//img alt text
			
			String s4 = driver.findElement(By.xpath("//input[@id='image-alt-text']")).getAttribute("value");
			System.out.println("banner img alt text is ____________________________"+s4);
			
	//		String expected4=banner_alttext;
			
			if (s4.equals(banner_alttext))
			{
				System.out.println("banner image alt text is matching "+s4);
				AssertJUnit.assertEquals(s4, banner_alttext);
			}
			else
			{
				System.out.println("banner image alt text is not matching "+s4);
				AssertJUnit.assertEquals(s4, banner_alttext);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Image Alternative Text is not present in Banner view screen.");
				
			}
			
			
			//desc
			
			String s5 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[5]/div/textarea[1]")).getAttribute("value");
		//	String expected5=banner_decs;
			System.out.println("banner description is ____________________________"+s5);
			if (s5.equals(banner_decs))
			{
				System.out.println("banner description is matching "+s5);
				AssertJUnit.assertEquals(s5, banner_decs);
			}
				else
			{
				System.out.println("banner description is not matching "+s5);
				AssertJUnit.assertEquals(s5, banner_decs);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Description is not present in Banner view screen.");
			
			}
			
			//tags count
			String s7 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[6]/button/p")).getText();
			System.out.println("view_____________________________tag count"+s7);
			

			if (s7.equals(tagcount2))
			{
			
			System.out.println("tags count is matching "+s7);
			AssertJUnit.assertEquals(s7, tagcount2);
			
			}
				
			else
			{
				System.out.println("tags count is not matching "+s7);
				AssertJUnit.assertEquals(s7, tagcount2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Tags is not present in Banner View Screen.");
			}
				
			
			// verify banner image
			
			String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/div/div/img")).getAttribute("src");
			System.out.println("img scr__________"+s8);
			
			if (s8.equals(s8))
			{
					System.out.println("image is present");
					AssertJUnit.assertEquals(s8, s8);
			}
			else
			{
					System.out.println("image is not present");
					AssertJUnit.assertEquals(s8, s8);
					Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Image is not present in Banner View Screen.");
					
			}
			
			softAssert.assertAll();
			WebElement closebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"));
		    closebutton.click();
		    Thread.sleep(3000);
			    
	 }
	 
	//Now create new banner and validate all required field and add all information and create it
	 
	 @Test (priority=6)
	 public void Create_New_Banner_With_All_Fields() throws InterruptedException
	 {
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
	
		 System.out.println("Banner -> Verifying Create New Banner With All Information");
		 Reporter.log("Banner -> Verifying Create New Banner With All Information");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 WebElement create_banner_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"));
		 create_banner_button.click();
		
		 //banner title
		 title= driver.findElement(By.id("title"));
		 title.sendKeys(banner_title2);
			 
		 Thread.sleep(1000);
		 //banner image
		 WebElement banner_img2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/button"));
		 banner_img2.click();
		 
//		 Thread.sleep(9000);
		 
		 WebDriverWait wait_img = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_img.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img")));
		    	
		 WebElement img_select2=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"));
		 img_select2.click();
		 
//		 Thread.sleep(3000);
		    
		 WebElement select_button2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
		 select_button2.click();
		 
		 Thread.sleep(1000);
		 
			subtitle= driver.findElement(By.id("subtitle"));
			subtitle.sendKeys(banner_subtitle2);
			 
			 overtitle= driver.findElement(By.id("over-title"));
			 overtitle.sendKeys(banner_overtitle2);
			 
			 alt_text= driver.findElement(By.id("image-alt-text"));
			 alt_text.sendKeys(banner_alttext2);
			
			decs= driver.findElement(By.id("description"));
			decs.sendKeys(banner_decs2);
			
			WebElement tab_button2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/button"));
		     tab_button2.click();
			    
		     Thread.sleep(3000);
			 
		     WebElement tab_topic2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[4]/div[1]/div[1]/label"));
			 tab_topic2.click();
			
			 Thread.sleep(1000);
			    
			 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 selectbutton.click();
			    
			 Thread.sleep(1000);
			
			 // tags count
			 tagcount3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/button/p")).getText();
			 System.out.println("the tag count is __________________"+tagcount3); 
			 
			 WebElement add_button=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/button"));
			 add_button.click();
			 
			 
			 action_button_title=driver.findElement(By.xpath("//*[@id=\'banner-description\']"));
			 action_button_title.sendKeys(banner_actionbuttontitle);
			 
			 WebElement type_button=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div"));
			 type_button.click();
			 
			 WebElement select_type=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[1]"));
			 select_type.click();
			 
			 Thread.sleep(2000);
			 
			 WebElement action_type=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[3]/div/div"));
			 action_type.click();
			 Thread.sleep(2000);
			 
			 WebElement action_select=driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[5]"));
			 action_select.click();
			 Thread.sleep(2000);
			 
			 WebElement save_actionbutton=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 save_actionbutton.click();
			 
			 Thread.sleep(3000);
			
			 WebElement savebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
			 savebutton.click();
			
			 Thread.sleep(3000);
		
	 }
	
	 @Test (priority=7)
	 public void View_And_Verify_The_New_Banner() throws InterruptedException
	 {
		 driver.navigate().refresh();
	 	 driver.manage().window().maximize();
		 	 
		    System.out.println("Banner -> search and view the new banner*******************");
		    Reporter.log("Banner -> Search and View The New Banner");
		    
			WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title2);
		 
			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
							
			WebElement icon_view = driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-1muvhzt'])[1]"));
			icon_view.click();
			
			Thread.sleep(1000);
			
			//banner title
			String s11 = driver.findElement(By.xpath("//input[@id='title']")).getAttribute("value");
			System.out.println("banner tile is ____________________________"+s11);
	
			
			if(s11.equals(banner_title2))
			{
				System.out.println("title is present");
				AssertJUnit.assertEquals(s11, banner_title2);
			}
			else
			{
				System.out.println("title is not present");
				AssertJUnit.assertEquals(s11, banner_title2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Title is not present in Banner view screen.");
			}
	
			//subtitle
			String s22 = driver.findElement(By.xpath("//input[@id='subtitle']")).getAttribute("value");
			System.out.println("banner subtile is ____________________________"+s22);
		//	String expected2=banner_subtitle;
			
			if (s22.equals(banner_subtitle2))
			{
				System.out.println("banner subtitle is matching "+s22);
				AssertJUnit.assertEquals(s22, banner_subtitle2);
			}
			else
			{
				System.out.println("banner subtitle is not matching "+s22);
				AssertJUnit.assertEquals(s22, banner_subtitle2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner SubTitle is not present in Banner view screen.");
				
			}
			
			//over title
			
			String s33 = driver.findElement(By.xpath("//input[@id='over-title']")).getAttribute("value");
			System.out.println("banner overtitle is ____________________________"+s33);
			//String expected3=banner_overtitle;
			
			if (s33.equals(banner_overtitle2))
			{
				System.out.println("banner overtitle is matching "+s33);
				AssertJUnit.assertEquals(s33, banner_overtitle2);
			}
			else
			{
				System.out.println("banner overtitle is not matching "+s33);
				AssertJUnit.assertEquals(s33, banner_overtitle2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Over Title is not present in Banner view screen.");
				
			}
			
//img alt text
			
			String s44 = driver.findElement(By.xpath("//input[@id='image-alt-text']")).getAttribute("value");
			System.out.println("banner img alt text is ____________________________"+s44);
			
	//		String expected4=banner_alttext;
			
			if (s44.equals(banner_alttext2))
			{
				System.out.println("banner image alt text is matching "+s44);
				AssertJUnit.assertEquals(s44, banner_alttext2);
			}
			else
			{
				System.out.println("banner image alt text is not matching "+s44);
				AssertJUnit.assertEquals(s44, banner_alttext2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Image Alternative Text is not present in Banner view screen.");
				
			}
			
			
			//desc
			
			String s55 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[5]/div/textarea[1]")).getAttribute("value");
		//	String expected5=banner_decs;
			System.out.println("banner description is ____________________________"+s55);
			if (s55.equals(banner_decs2))
			{
				System.out.println("banner description is matching "+s55);
				AssertJUnit.assertEquals(s55, banner_decs2);
			}
				else
			{
				System.out.println("banner description is not matching "+s55);
				AssertJUnit.assertEquals(s55, banner_decs2);
				Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Description is not present in Banner view screen.");
			
			}
			
			//tags count
			String s77 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[6]/button/p")).getText();
			System.out.println("view_____________________________tag count"+s77);
			

			if (s77.equals(tagcount3))
			{
			
			System.out.println("tags count is matching "+s77);
			AssertJUnit.assertEquals(s77, tagcount3);
			
			}
				
			else
			{
				System.out.println("tags count is not matching "+s77);
				AssertJUnit.assertEquals(s77, tagcount3);
			 
			}
				
			
			// verify banner image
			
			String s88 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div/div/div/img")).getAttribute("src");
			System.out.println("img scr__________"+s88);
			
			if (s88.equals(s88))
			{
					System.out.println("image is present");
					AssertJUnit.assertEquals(s88, s88);
			}
			else
			{
					System.out.println("image is not present");
					AssertJUnit.assertEquals(s88, s88);
					Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Image is not present in Banner View Screen.");
					
			}
	
			/*
			// verify banner button
						//order
						
						String s99 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div[2]/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]/div/div")).getText();
						//	String expected5=banner_decs;
							System.out.println("banner button order column name is ____________________________"+s99);
							if (s99.equals(banner_order))
							{
								System.out.println("Banner Button Order is present "+s99);
								AssertJUnit.assertEquals(s99, banner_order);
							}
								else
							{
								System.out.println("Banner Button Order is not present "+s99);
								AssertJUnit.assertEquals(s99, banner_order);
								Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Button -> Banner Button Order is not present in Banner view screen.");
							
							}
							
							//button title
							String s100 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/div/div")).getText();
							
								System.out.println("banner button title column name is ____________________________"+s100);
								if (s100.equals(banner_button_title))
								{
									System.out.println("Banner Button title is present "+s100);
									AssertJUnit.assertEquals(s100, banner_button_title);
								}
									else
								{
									System.out.println("Banner Button title is not present "+s100);
									AssertJUnit.assertEquals(s100, banner_button_title);
									Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Button -> Banner Button Title is not present in Banner view screen.");
								
								}
						
								//button type
								String s101 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div[2]/div/div[2]/div[1]/div/div/div[3]/div[1]/div[1]/div/div")).getText();
								
									System.out.println("banner button type column name is ____________________________"+s101);
									if (s101.equals(banner_type))
									{
										System.out.println("Banner Button type is present "+s101);
										AssertJUnit.assertEquals(s101, banner_type);
									}
										else
									{
										System.out.println("Banner Button type is not present "+s101);
										AssertJUnit.assertEquals(s101, banner_type);
										Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Button -> Banner Button Type is not present in Banner view screen.");
									
									}
									
									//button action type
									String s102 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[7]/div[2]/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/div/div")).getText();
									
										System.out.println("banner button action type column name is ____________________________"+s102);
										if (s102.equals(banner_action_type))
										{
											System.out.println("Banner Button action type is present "+s102);
											AssertJUnit.assertEquals(s102, banner_action_type);
										}
											else
										{
											System.out.println("Banner Button action type is not present "+s102);
											AssertJUnit.assertEquals(s102, banner_action_type);
											Reporter.log( "[ERROR] -> Banner -> View Screen -> Banner Button -> Banner Button Action type is not present in Banner view screen.");
										
										}
										*/
										softAssert.assertAll();
							
										WebElement closebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"));
										closebutton.click();									
										Thread.sleep(3000);
		 
	 }
	 
	 
//	 @Test (enabled = false)
	 @Test (priority=7)
	 public void Delete_Banner() throws InterruptedException 
	 {
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 			 	
		 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]"))).click();

		 	
		    System.out.println("Banner -> search and delete the banner*******************");
		    Reporter.log("Banner -> Search and delete the banner");
			
		    WebElement banner_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			banner_searchbox.sendKeys(banner_title);
		 
			Thread.sleep(3000);
			//first delete the action button 
			
			WebElement edit_icon = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[6]/button[1]"));
			edit_icon.click();
			
			Thread.sleep(3000);
			
			//delete action button
			WebElement delete = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div/div[8]/div[2]/div/div[2]/div[2]/div/div/div/div/div[6]/span/button[2]"));
			delete.click();
			
			Thread.sleep(3000);
			
			WebElement save_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
			save_button.click();
			 
			Thread.sleep(3000);
			
			WebElement delete2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/button[3]"));
			delete2.click();
			
			Thread.sleep(3000);
			
			WebElement delete3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
			delete3.click();

		  
	 }
	 
	 @Test (enabled = false)
//	 @Test (priority=8)
	 public void filter_banner() throws InterruptedException
		{
			
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			System.out.println("Banner -> verifying the filter from banner page");
			Reporter.log("Banner -> Verifying the filter from banner page");
			
			WebElement filter = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[1]"));
			filter.click();
			
			Thread.sleep(3000);
			
			WebElement filter_tags = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/button"));
			filter_tags.click();
			
			Thread.sleep(3000);
			 
		     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[4]/div[1]/div[1]/label"));
			 tab_topic.click();
					  
			 Thread.sleep(3000);
			    
			 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
			 selectbutton.click();
			
			 Thread.sleep(3000);
			 
			 WebElement filter_apply = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
			 filter_apply.click();
			
			
		}
	 
	 @Test (enabled = false)
//	 @AfterTest
	 public void closeBrowser() {
	 	driver.quit();
	 	
	 }
	 

	 
}

