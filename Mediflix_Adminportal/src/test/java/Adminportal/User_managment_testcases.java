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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.TakesScreenshot;

public class User_managment_testcases 
{
	
	ChromeDriver driver; 
	SoftAssert softAssert = new SoftAssert();
	
	

	@BeforeTest 
	  public void Local_Storage() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Prasad_aute//Downloads//selenium/106/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://admin-portal.us-east-1.dev.mediflix.com");

	    LocalStorage local = ((WebStorage) driver).getLocalStorage();    
	    local.setItem("persist:root","{\"user\":\"{\\\"data\\\":{\\\"sub\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"cognito:groups\\\":[\\\"admin\\\",\\\"patient\\\"],\\\"iss\\\":\\\"https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Queq8DO0E\\\",\\\"cognito:username\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"origin_jti\\\":\\\"286bbd17-c847-4f54-bb6f-8c36d03b1d93\\\",\\\"aud\\\":\\\"16vn2ni6d429tfd3mi86refk2p\\\",\\\"event_id\\\":\\\"52a06452-f2f1-4e06-9e70-3fab713163ef\\\",\\\"token_use\\\":\\\"id\\\",\\\"auth_time\\\":1665722626,\\\"name\\\":\\\"shivraj2\\\",\\\"phone_number\\\":\\\"+919834330981\\\",\\\"exp\\\":1665735231,\\\"iat\\\":1665731631,\\\"jti\\\":\\\"2da99bab-1d2e-4f71-abe2-5f03de5d3ccd\\\",\\\"email\\\":\\\"shivrajtech37@gmail.com\\\"},\\\"logged\\\":true,\\\"logging\\\":false,\\\"loginError\\\":null,\\\"validating\\\":false,\\\"getOtp\\\":false,\\\"retrievingAll\\\":false,\\\"retrievingAllError\\\":{\\\"message\\\":\\\"Response not JSON\\\",\\\"status\\\":401},\\\"updating\\\":false,\\\"updateError\\\":null,\\\"updated\\\":false,\\\"updatedPassword\\\":false,\\\"updatingPassword\\\":false,\\\"updatePasswordError\\\":null}\",\"_persist\":\"{\\\"version\\\":-1,\\\"rehydrated\\\":true}\"}");
	    
	  
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.316c0afc-19df-4c87-ae0a-0f61bb60a6b4.clockDrift","0");
	    local.setItem("amplify-signin-with-hostedUI","false");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.316c0afc-19df-4c87-ae0a-0f61bb60a6b4.userData","{\"PreferredMfaSetting\":\"SMS_MFA\",\"UserAttributes\":[{\"Name\":\"sub\",\"Value\":\"316c0afc-19df-4c87-ae0a-0f61bb60a6b4\"},{\"Name\":\"name\",\"Value\":\"Saurav Anand\"},{\"Name\":\"phone_number\",\"Value\":\"+918340328513\"},{\"Name\":\"email\",\"Value\":\"anandsaurav6@gmail.com\"}],\"UserMFASettingList\":[\"SMS_MFA\"],\"Username\":\"316c0afc-19df-4c87-ae0a-0f61bb60a6b4\"}");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.316c0afc-19df-4c87-ae0a-0f61bb60a6b4.idToken","eyJraWQiOiIrMDBqWVZCZVhOQVwvTkpVa1FEa0dkUHdzM1NJSjNkVVRYTUI4VGNGa3VGZz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzMTZjMGFmYy0xOWRmLTRjODctYWUwYS0wZjYxYmI2MGE2YjQiLCJjb2duaXRvOmdyb3VwcyI6WyJzdXBlcmFkbWluIiwiYWRtaW4iLCJwYXRpZW50Il0sImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX1F1ZXE4RE8wRSIsImNvZ25pdG86dXNlcm5hbWUiOiIzMTZjMGFmYy0xOWRmLTRjODctYWUwYS0wZjYxYmI2MGE2YjQiLCJvcmlnaW5fanRpIjoiZGNlOTcxZGQtNzU3ZS00ODVjLTliZTUtY2U2N2YzYWQxNmM2IiwiYXVkIjoiMTZ2bjJuaTZkNDI5dGZkM21pODZyZWZrMnAiLCJldmVudF9pZCI6ImY0MWU3NmMxLTE2YTQtNDA2OS1iZDllLTJiNjY5M2VlMzNjNyIsInRva2VuX3VzZSI6ImlkIiwiYXV0aF90aW1lIjoxNjY3Mzg1NzgzLCJuYW1lIjoiU2F1cmF2IEFuYW5kIiwicGhvbmVfbnVtYmVyIjoiKzkxODM0MDMyODUxMyIsImV4cCI6MTY2NzM4OTM4MywiaWF0IjoxNjY3Mzg1NzgzLCJqdGkiOiIxYjU5ZjViNy1jYmVkLTQ1YWQtYmIwOC0xNDY2ZWQ2ODhjYWIiLCJlbWFpbCI6ImFuYW5kc2F1cmF2NkBnbWFpbC5jb20ifQ.ILJgJsizwNXSVYIX6FXltyrZV1eboM0iP0Mohu8BX2AEwtqtN5AvU4EBnJ9KyakaNY6cK2cKItCtFYU8OuFBWPhpGsEErMk-W6gFWn1H5saiCsunCiHTE1rkmsT8Zzr0OHcILNBT7FnCTmcEvLN4JwnituPxPlvxCwWgKotIuJtMkDn1aHYNmd5de5oyf0JPwU2j061vEfzpUaiMSKh7I-F0U66_52IYQVupBVZ72nw864soUa7sXUKDDRgvw6HiAL6yCYQKagiZnQE8yVzqztY_ehIggc9Dc1fM3qitqPALAzdbPPeW3UcrEYi10vcYGvZT61SlGrcVq5Z_ON-gzQ");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.LastAuthUser","316c0afc-19df-4c87-ae0a-0f61bb60a6b4");
	    local.setItem("accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzMTZjMGFmYy0xOWRmLTRjODctYWUwYS0wZjYxYmI2MGE2YjQiLCJjb2duaXRvOmdyb3VwcyI6WyJzdXBlcmFkbWluIiwiYWRtaW4iLCJwYXRpZW50Il0sImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX1F1ZXE4RE8wRSIsImNsaWVudF9pZCI6IjE2dm4ybmk2ZDQyOXRmZDNtaTg2cmVmazJwIiwib3JpZ2luX2p0aSI6ImRjZTk3MWRkLTc1N2UtNDg1Yy05YmU1LWNlNjdmM2FkMTZjNiIsImV2ZW50X2lkIjoiZjQxZTc2YzEtMTZhNC00MDY5LWJkOWUtMmI2NjkzZWUzM2M3IiwidG9rZW5fdXNlIjoiYWNjZXNzIiwic2NvcGUiOiJhd3MuY29nbml0by5zaWduaW4udXNlci5hZG1pbiIsImF1dGhfdGltZSI6MTY2NzM4NTc4MywiZXhwIjoxNjY3Mzg5MzgzLCJpYXQiOjE2NjczODU3ODMsImp0aSI6ImVlNjZlZmUxLTM1ZWYtNGRlOS05ZGFlLTBhZjYyNDhkMGUzOCIsInVzZXJuYW1lIjoiMzE2YzBhZmMtMTlkZi00Yzg3LWFlMGEtMGY2MWJiNjBhNmI0In0.PtVtM6SR2LL7Y9pkVPHgYDbGlb1I9sx8e4G2KlkbhgCt7DUurGTV-l8nEBWuwL9UODATS3N-R2NfZ6eF_qXmj_rgp7Np6cPSnLT78YEuBXF8hVS1g1anyscGBZfZ3IIJmuhsKN2KcOU7lRUic6SMwe9eeJAx51eYp7IZlBjU6QHHqo00FD9Xahb1etNnn4zdLTlHD7Ia9YbqFgiomjHZbJkIH7Ql17g6yNdR34wjW2uObJ663fs3sNRgo0Pjb9w44ET6yUuAxpAr2_gD80cUQvMjm_hUiwyZTMLhwi0DhOyiFeS6jJygSuwgZQ5HtDllB7CeP-gSZ2DSwlMksIUmbA");
	    local.setItem("userRole","superadmin");
	    local.setItem("userPhoneNumber","+********8513");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.316c0afc-19df-4c87-ae0a-0f61bb60a6b4.accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzMTZjMGFmYy0xOWRmLTRjODctYWUwYS0wZjYxYmI2MGE2YjQiLCJjb2duaXRvOmdyb3VwcyI6WyJzdXBlcmFkbWluIiwiYWRtaW4iLCJwYXRpZW50Il0sImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX1F1ZXE4RE8wRSIsImNsaWVudF9pZCI6IjE2dm4ybmk2ZDQyOXRmZDNtaTg2cmVmazJwIiwib3JpZ2luX2p0aSI6ImRjZTk3MWRkLTc1N2UtNDg1Yy05YmU1LWNlNjdmM2FkMTZjNiIsImV2ZW50X2lkIjoiZjQxZTc2YzEtMTZhNC00MDY5LWJkOWUtMmI2NjkzZWUzM2M3IiwidG9rZW5fdXNlIjoiYWNjZXNzIiwic2NvcGUiOiJhd3MuY29nbml0by5zaWduaW4udXNlci5hZG1pbiIsImF1dGhfdGltZSI6MTY2NzM4NTc4MywiZXhwIjoxNjY3Mzg5MzgzLCJpYXQiOjE2NjczODU3ODMsImp0aSI6ImVlNjZlZmUxLTM1ZWYtNGRlOS05ZGFlLTBhZjYyNDhkMGUzOCIsInVzZXJuYW1lIjoiMzE2YzBhZmMtMTlkZi00Yzg3LWFlMGEtMGY2MWJiNjBhNmI0In0.PtVtM6SR2LL7Y9pkVPHgYDbGlb1I9sx8e4G2KlkbhgCt7DUurGTV-l8nEBWuwL9UODATS3N-R2NfZ6eF_qXmj_rgp7Np6cPSnLT78YEuBXF8hVS1g1anyscGBZfZ3IIJmuhsKN2KcOU7lRUic6SMwe9eeJAx51eYp7IZlBjU6QHHqo00FD9Xahb1etNnn4zdLTlHD7Ia9YbqFgiomjHZbJkIH7Ql17g6yNdR34wjW2uObJ663fs3sNRgo0Pjb9w44ET6yUuAxpAr2_gD80cUQvMjm_hUiwyZTMLhwi0DhOyiFeS6jJygSuwgZQ5HtDllB7CeP-gSZ2DSwlMksIUmbA");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.316c0afc-19df-4c87-ae0a-0f61bb60a6b4.refreshToken","eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.DQ01LNbu_3ro_N-6luWrRKR70pr4Nv9s9Ix8F3aNwy1VRXlJSzw5SmN47f4ulm3mU8o0Yxpn6Xod1ky26wYY0fyQLN0w1SEgY37IZ5BTlkpieqDnbJyQyotW1YYycE59FDYTQsYcId9uNfsaAlHM1f0dd4d_Shv1Y6JoPKgd0VsC2NqSODQZlFKcxRPU2mtxFwGUs1--nU_Z9V9iwpGndv7dlyaVKO4hkTM6J-embeNhRHpDydy90hyJ3J9cdoIilNBAyKPHfT1rFBXEaVpBjeYP4-0IcJvujMWUKLONy39lY0tH10UY8vErjiQEtSM_f_yz6EtCeagVXZ4_jaS6vQ.mgc1eY5yi1sq1Y_0.RE9vdY52dgjIzxo0KXW0kmQ4hI-CK-CtP8gMzQ8VUzlOvjCmaj14aGIp9RMpEZIO21yTflNhYtsesZoKryjD6Lb4IwT8gAi6yh_cD0kj8nO5rykJsx0urz4Ed3NJ7fBnEuuC9IxuobISjWvtFPC71v4XT9ruQiQWqomrVlAfwH1amr-Ug0tekSxmgUvN_5IcZe-DS3SZJZ6ygmUsuQ4Au9VLFbdOgDPu1-H-YnI6IMKAASiii-xbzJeVxtQP1S99G_IqPOgIs30YMFoQiAm42G04QJhBuoWtf_TZXcM_3_eDR7ZvsbbfdhP3lWfvlZSglWtvbf_8_aPWMzLXwj9G7mS4QnNB8ZL-f9bqKxRaeVqk5OKtOG_jdwt3n0SUFX5p-OWeHzgr_aIASGRUzEU54Om4Afr9GvnHZROAlDe3TnLOp0tavgjfQxK9LkuQRZw9jrh4oRPkupZvQ0KlOPBlbjaCEBM41-wrCpok0rKhBLpBTFFWw1xvSr7rOiA0pX8jAqR5aXYdrc4bdSyUI392UQvU9GIqoptHhQhB_RzZEgdOn3njBgqOe_meVbl-0WBey534KcVJ9HwClOqPKcub3skUllGff0w2oA6aTYVODjF9MRvtezD3Pb9shWnBz07tyJiiEnhMdBlbykytlZi6SiV9G1w0vaCDsKZL5dVq0HgJTv2H47fUb5sah9TztOL3LzetJi11z7FeBwpRaEFJ6DaNCiFGQfI2hAGiYTLAgdV92fQw-98s1Ue3NSl4YaQirm5QtsprvVhm0aX-XGRhCKyATIPfmDMiAXoIoWpdTCBbygje2-x-I5qH_Ukdn2hILF1POZbyX6hcDMPuGbPNrELKeK0eMAi_5FZpp0nO4JviwfZJP3FMblTc3gaHxF2gkwI-agZO2ckD_tHCFRPMRPGdOj9W6MoyW_506FHYxwlvld07BlpHT_PmOkHp5NUT0VhoKBcr13Ir3u4u3YMFnD1NypnkK9Arwc0zi3AGHM8nnQn71Y9_ZcBZDlpbOxx3Y1iDCEOd72ev6_QB-p-lSgnE5JQtprAU3oX3TDWnCW4d6Xr2dUB4zvBxIh2sZX6hF0aAygee_B5bhdbgmVyPnM9o592PWd1fvS9fSU7fOnq8PWpVtmYYJRNei-LfviW9UUntOMs8i3p3pH3ydGBJ_UQFf0IUZmrOcbfRemlR8DAKU37CG4ByqdiwQpOEce8WRfQHRR64lbbwKS4BFZxuj-a4LDLVYPc5FZbES825-tayUgd_eRrHnUdL3ZGpqL3hz3Vzus0wKoUAenI-kRLBUX2UGqqFj4ImZZ5DQcXC8NjgxOGcGh1O89l-hQ.B41gkhMm5dRoFAMiF7gbwg");
	    	   
	    driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/users");
	       	    
	 }
	
	@Test (priority=1)
//	 @Test (enabled = false)
	 public void Verify_Search_In_User_Managment() throws InterruptedException 
	 {
			 
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		 	
		 System.out.println("User_Managment -> Verify The Search**************");
		 Reporter.log("User_Managment -> Verify The Search In User_Managment");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).click();
		 
		 
	 }
	

}
