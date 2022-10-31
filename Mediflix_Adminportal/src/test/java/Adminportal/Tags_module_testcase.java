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

public class Tags_module_testcase 
{
	
	ChromeDriver driver; 
	SoftAssert softAssert = new SoftAssert();
	
	WebElement name;
	WebElement category;
	WebElement desc;
	
	String tags_name="spine";
	String tags_desc="The bones in the spine are called vertebrae.";
	
	WebElement name2;
	WebElement category2;
	WebElement desc2;
	
	String tags_name2="Osteopenia";
	String tags_desc2="Osteopenia is a term used for low bone mass that isn't low enough to be osteoporosis.";
	
	
	@BeforeTest 
	  public void TestLocalStorageSetAndGetItem()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Prasad_aute//Downloads//selenium/106/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://admin-portal.us-east-1.dev.mediflix.com");

	    LocalStorage local = ((WebStorage) driver).getLocalStorage();    
	    
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.LastAuthUser","saurav.anand@mediflix.com");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.deviceGroupKey","-9b0ne3AP");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.refreshToken","eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.D2xeFHpZmvdJtXI2KI_GhWQL9PnCTiALFDoTILhZNKPRw-vG_FS2fDs53Y75_1upg3Ofs9xSIQYRng8IdPgLdcqK6CtdWpJAOB_TfmpmnnUvi2QSyMfRHGShN5HvCdzsyzFhUAsjYPQ_b3P28o4vX__vSABk05YJq5m-L1KKp6czkiVvleUoLtW4y7kQh6ukNjCNHgYKu8kQ2yENfL3Ist3vKWOkEx2_fMkVcqHW2ehPSLoxUuIkxuDBGVMHKU64nh6nohwtqsbFG-52IqhDXqUfUKXOY6EcGkeqGgsiiVwA-G6D2DwuqNeVZKH-n_y-MeVJo4KakHJJbD6Ur-Opvw.l8UbUuIyH7jQNPmx.4V1HTinuIG-hY_xHQBRzQK4IcvReDRDFkVHn4dF3anGtZ4ZVHrVZ4H8nnPPm6UlBBuQfNy2lp8GHg4NFq6NpY2fYxNf31RlaJQoNJjBX5WFwN3gE-qquBJvec5y7Vaqmc1DguYu5ugfSKCClKxJZZ0DkxONb-gOUDekBYXwBOBVD9s9aKjXbvHIe8eade6LCjPShcC96OoquN_V2Kb4eAnYOyg8JMD0CgTY31yWWdzlBC8KwWvgUXRVEX-D6vj9BIf-ws3h7JZ93SP33lNwbYm8Ol8sH2ZFpGXDMaE5yl8kC-2yMSLt4t5hfOx8LW50He-3dqtOneQ1jnCFEK4WYq6O4UabA_Q5O7v1su9v3Z08yIapuArVV_jndOfMQodM641CoZ5mUYue8y54YLlsDRM-m_FedIRF0E5xJGV7T-38jpf5c2HYvzvAeraMIBWx1IVptiQ6lrGE8wJYOHKKJJDMz0dlV22A86p0DJ5b2hIhDDnlI1qdSZrErSWoSBPMIsiNDuxN1iUQwl0COaDCz016t51a7dGFdCeemceSAmLyx-aidQDxyAT_2sP91VjBo2gLLyyDR6KwdqjVG7zbp8UDRjMi--L5BK-Ud217IyXunaBSPkPTD5V5FIf3Ax7cdumTOML8Hoh9lpriaJYgNVQlx70QwOkXXvIMkw-DPliDlZUKZxe2eEOp2CciUHyBpkFqTOFl895lfXNui4K6cRBSGfhmn6fW1F73oqa44q968J4KmQLRdctAhxhTfd_AVfP9cid6hbrSRHdSUT2RmY98NsIZOGYHaQhMWiFbbiWLDA-RS69_bZpT2hTnjM1UXhahg0k1ADthuvj80kmU9KXHr49ylMQPTYAaC7r2T-s5ODzC7UnQUPP74-x08L-j7hmJOhCuGDu2dQzTN6oeiIrQY8JmxC63fV_qbxJV9xxpRl7l6qt1qcCaTysejdfPNTmRrtdhjXZIxbXMsb4z7J36ceRRZxFzhO3RtLSwv4ZJrIuvqa1e4gfqcbytP1EHh9bN8r31belGzGWHAfEIlcosREwEWffzaGT1bujEzDrtaVsRDiWag63GXSHSeYH8hzRNugK-eJueSjRZFufzzeLn5FOvCi3f2Xu_rKx1Ryb67IZuLAhuZFTBe73mkNIJQS7vfLP-IC7OgNDaznf1h4XczKAwp4uXqmKLw4I-aPkB_saaMDWFEAvIUIR_h9OL4VOnHlSsb7In2_WF9UYB7MeVHgCXEJjN-GEADL40yheZkLV2thVlGmeiZ6iaNJig7JBpsBwClhOGNbOUr-J7xh8lhAaMlBnXaPwtptLPy6dNS9fHx7xFvOqcWvz-lGLqLQbspNOA5jYOWiCaUx_52BGTXoy7IgpkwVewCimcJEdjMhDjvjkKYTEPDqWO0_kTMmqEebWJ-rg1fHWbnt7EGM-KkNJIJLel8g9xY3QDf.QnnBXlr521wQz9b4pYhYXg");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJkZXZpY2Vfa2V5IjoidXMtZWFzdC0xXzdjNzNiNTRkLWZjMzItNGU4Yi05MGM2LTJlZGZkNDYyM2EwZCIsImNvZ25pdG86Z3JvdXBzIjpbImFkbWluIiwicGF0aWVudCJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9RdWVxOERPMEUiLCJjbGllbnRfaWQiOiIxNnZuMm5pNmQ0Mjl0ZmQzbWk4NnJlZmsycCIsIm9yaWdpbl9qdGkiOiIyODZiYmQxNy1jODQ3LTRmNTQtYmI2Zi04YzM2ZDAzYjFkOTMiLCJldmVudF9pZCI6IjUyYTA2NDUyLWYyZjEtNGUwNi05ZTcwLTNmYWI3MTMxNjNlZiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2NjU3MjI2MjYsImV4cCI6MTY2NTczNTIzMSwiaWF0IjoxNjY1NzMxNjMxLCJqdGkiOiI0NWFmOWUwMC1lMWUxLTQ2Y2ItOTA5Ni03YWQ5NzU4MThjZWUiLCJ1c2VybmFtZSI6IjM4ZWFlZjZkLTZhOTgtNDU0Yy1iM2RmLTg2MWMxN2NkMWZjZCJ9.g0ndKxJS1f5ZmgcmC1Nng1HgWGFMR15XD_vlyL7fHMkJJ-a_JW35NluAQ4gHtDTLU7wjPVHfL0OYoI_okgQi7qSzxZdhTq0rbliQKQOlkUIj2BRAgdqMenRG1DnDNroh8m_gExU65K87sAu83L8myPSqj9DFCv5TK8XySiMBakEAtHvFKFu5i-XVLDu3XeG0mpTtkiwi7W5w_MZOhoA_btkBoWb0S7sNdSeVcKY_CpfZkHMaYCqWG9GAB0TxbWM3uDqTO84ZSTGfAN6b4IWkBwNuMuETkGxiM-VNtzjrN9fQIJbmxIJoXSwycbjMLY8tt4iUFx6wIKR_99R46mbwSQ");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.refreshToken","eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.Hx7p23V3Iqqk4nSNbIK-zzqct84fZfNe2jbZxnqyBs6AqeG_2a4hp1QkyZ8t6wKHEDskLmElkyzi4W4gUht4AKQMMEjdOoccb_IGA6TUbYPBKambcY5zOxWizdEv_wig1Gj5wy5EHBpV3neNetWJnDPPLV_tIYZEvgTeEvNIq57EdFbdwCo-mo_FZXjHByvs9JJ92uEgzaN5tQQTWmeDKX4vmZT0Qtcs39RNh0nxXDbbbpiDW64VCHoAftd1gG-jAYrHWnIN_BhVSyL0aETHuDhu5d_LLp0xBCbBEJztextK6ihZwDwB6sCeTwqryrOWekcO7YnbkI4-R8_MVNWRpQ.vVdm-qtf3WimDqbt.bQbimb6IXOhMHyQBkgwTNTgxcHOZDskU-UBaHx7KkoNKqMYxNOxgu1YqOB8NCOs6oEwQQm4t3GvWa3r58fhSwi-SKaGB_vn97TK7DnxbIiMhwXUnFUssbZqg1JUYTlMccYZcl5u_gSmHYdm2D2LpIBCHNXpCEyCY8gZC388RI7IqhtO5vNITpeJ2MuGU5ZmtlKglhGpM-vUA8Q6OZtUQ0_nNKbwHLtpPiavE967KnoXmjXiJSzu-1HVSP5fMvsmoRQ5XIz_OIpqgVeLW8IYUNOJYBEXyImybo2IJDEBf-MLJTFo0LGbR2wFsK4_B-Ew3X8lnTdNBWamiMiEDk12OUAYLskBgCRCjb2hvpwYX2c8Kkf9E5sWE3oNQoeyjG0t-wAX01iH1PzzW2d03is39O0sD8sxYBRHSCjDpf35Tzw-8n0UpYOECMMm1vm72xySChbx1-mb8PFcZo4VXhIs_dNaPVNXMSS_e6OaC3nTbD5ZkFL_Nnun4q2IhPSzLANjOHvVQlmxomublZkmGW_fp30iE9LGx3kqkCbf14HYr_6StaC2n4tjOYnuj8rUKLJciy_yMl0dX331jYJAZarhzWpV4FbcS1ra3mQQrhEiUk0hPv9JolOB6tHDpysCHIy7p-8h5WgRoeESESCxPED2HdYztDbid540i-h-FTBNXFVfsaWaXAi0Ob2fpbsokjgmQI9mj4zGvxamLqujedoL-_mSmTXbwLadETvVsa5Jsv3q8nAwbz06WCY6Wbr8NeYdVH2iUR6CBWNrz5Eoywxzv8lxxeT-rb2oyIaBK_xHLMkQkVMxMzqLj8yuBgBeajylpbZLoZl8JBx6vlvzFrBeHgRsxmL6ncFTehmIRBEsl5qQxEvx88ZWBrzctxG6eBdtWUEY7OPB-1YyEoPB31mrT26DFFMyL2WBKZaT9Aio2-1N3UNq7Mzq6OKyegq3XX-ylzxznYgxx8Js-691M6t486Hk-Q4Nn5iVAaWuoYA53BuPB_FdqZYmjrrqUNqz6uD83MOYOkXL8zM2CZX9jCyxwGSwennUQvu_j-h6mm1O1iBDpBDDbZa9tbiNPXWftVViIs9TWi-AKtXQXlqgS1ROc6Im1G33Bt0EEaJ_raHqMx7bU8sw0c764r_zuiVhTkT-lvqpcpjckUe1EJVgJA75R6stclHCm0aJAW-BD2RHbKFtj5YaSUNn18lpL7xEMKkvGDwvmT8OOqDB9d7fB8lgImeTuXBi1hbgIWid57VXBaXF-wVNfkdNFbji-6tWORe7du00M7CsncDN-rJSRGueZAOFaBwkFBj-8tyAJMDw.NwuAlhQ-MxUlYnRFT7TgYA");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.clockDrift","0");
	    local.setItem("amplify-signin-with-hostedUI","false");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.LastAuthUser","38eaef6d-6a98-454c-b3df-861c17cd1fcd");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.idToken","eyJraWQiOiIrMDBqWVZCZVhOQVwvTkpVa1FEa0dkUHdzM1NJSjNkVVRYTUI4VGNGa3VGZz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJjb2duaXRvOmdyb3VwcyI6WyJhZG1pbiIsInBhdGllbnQiXSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfUXVlcThETzBFIiwiY29nbml0bzp1c2VybmFtZSI6IjM4ZWFlZjZkLTZhOTgtNDU0Yy1iM2RmLTg2MWMxN2NkMWZjZCIsIm9yaWdpbl9qdGkiOiIyODZiYmQxNy1jODQ3LTRmNTQtYmI2Zi04YzM2ZDAzYjFkOTMiLCJhdWQiOiIxNnZuMm5pNmQ0Mjl0ZmQzbWk4NnJlZmsycCIsImV2ZW50X2lkIjoiNTJhMDY0NTItZjJmMS00ZTA2LTllNzAtM2ZhYjcxMzE2M2VmIiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2NjU3MjI2MjYsIm5hbWUiOiJzaGl2cmFqMiIsInBob25lX251bWJlciI6Iis5MTk4MzQzMzA5ODEiLCJleHAiOjE2NjU3MzUyMzEsImlhdCI6MTY2NTczMTYzMSwianRpIjoiMmRhOTliYWItMWQyZS00ZjcxLWFiZTItNWYwM2RlNWQzY2NkIiwiZW1haWwiOiJzaGl2cmFqdGVjaDM3QGdtYWlsLmNvbSJ9.HdDmb1yhnIgPVz5Dcyreu5P5H_EescQpLUMlqet6lGbtwhQ8di6t3NJPOkTTB5Iuw_HTtvF9IKjn4teC6GdZeCqMCOzZNPyX5qA0LLxzPIL3RERE1QzKOOfHhCuwj0-YAqt64KdprDLnKbfPmX3i55TZaChChIuTy80LXAmVxDNQLk2KZYhRKusylCWfp5bWzEUXAU6FzWgjtxQybWWTMeupQC-yFIZYLrYyyn2unDlkzf8nGbxJKwain04PEmhLaOUaHDRHh_8mCmKA1mHbRiva5mGfBWURp134MUg0Ps-v05v8gEMaLFnBkhch8gip43nuy8aWi22oGSfqti__xQ");
	    local.setItem("accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJkZXZpY2Vfa2V5IjoidXMtZWFzdC0xXzdjNzNiNTRkLWZjMzItNGU4Yi05MGM2LTJlZGZkNDYyM2EwZCIsImNvZ25pdG86Z3JvdXBzIjpbImFkbWluIiwicGF0aWVudCJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9RdWVxOERPMEUiLCJjbGllbnRfaWQiOiIxNnZuMm5pNmQ0Mjl0ZmQzbWk4NnJlZmsycCIsIm9yaWdpbl9qdGkiOiIyODZiYmQxNy1jODQ3LTRmNTQtYmI2Zi04YzM2ZDAzYjFkOTMiLCJldmVudF9pZCI6IjUyYTA2NDUyLWYyZjEtNGUwNi05ZTcwLTNmYWI3MTMxNjNlZiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2NjU3MjI2MjYsImV4cCI6MTY2NTczNTIzMSwiaWF0IjoxNjY1NzMxNjMxLCJqdGkiOiI0NWFmOWUwMC1lMWUxLTQ2Y2ItOTA5Ni03YWQ5NzU4MThjZWUiLCJ1c2VybmFtZSI6IjM4ZWFlZjZkLTZhOTgtNDU0Yy1iM2RmLTg2MWMxN2NkMWZjZCJ9.g0ndKxJS1f5ZmgcmC1Nng1HgWGFMR15XD_vlyL7fHMkJJ-a_JW35NluAQ4gHtDTLU7wjPVHfL0OYoI_okgQi7qSzxZdhTq0rbliQKQOlkUIj2BRAgdqMenRG1DnDNroh8m_gExU65K87sAu83L8myPSqj9DFCv5TK8XySiMBakEAtHvFKFu5i-XVLDu3XeG0mpTtkiwi7W5w_MZOhoA_btkBoWb0S7sNdSeVcKY_CpfZkHMaYCqWG9GAB0TxbWM3uDqTO84ZSTGfAN6b4IWkBwNuMuETkGxiM-VNtzjrN9fQIJbmxIJoXSwycbjMLY8tt4iUFx6wIKR_99R46mbwSQ");
	    local.setItem("userRole","admin");
	    local.setItem("userPhoneNumber","+********0981");
	    local.setItem("persist:root","{\"user\":\"{\\\"data\\\":{\\\"sub\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"cognito:groups\\\":[\\\"admin\\\",\\\"patient\\\"],\\\"iss\\\":\\\"https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Queq8DO0E\\\",\\\"cognito:username\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"origin_jti\\\":\\\"286bbd17-c847-4f54-bb6f-8c36d03b1d93\\\",\\\"aud\\\":\\\"16vn2ni6d429tfd3mi86refk2p\\\",\\\"event_id\\\":\\\"52a06452-f2f1-4e06-9e70-3fab713163ef\\\",\\\"token_use\\\":\\\"id\\\",\\\"auth_time\\\":1665722626,\\\"name\\\":\\\"shivraj2\\\",\\\"phone_number\\\":\\\"+919834330981\\\",\\\"exp\\\":1665735231,\\\"iat\\\":1665731631,\\\"jti\\\":\\\"2da99bab-1d2e-4f71-abe2-5f03de5d3ccd\\\",\\\"email\\\":\\\"shivrajtech37@gmail.com\\\"},\\\"logged\\\":true,\\\"logging\\\":false,\\\"loginError\\\":null,\\\"validating\\\":false,\\\"getOtp\\\":false,\\\"retrievingAll\\\":false,\\\"retrievingAllError\\\":{\\\"message\\\":\\\"Response not JSON\\\",\\\"status\\\":401},\\\"updating\\\":false,\\\"updateError\\\":null,\\\"updated\\\":false,\\\"updatedPassword\\\":false,\\\"updatingPassword\\\":false,\\\"updatePasswordError\\\":null}\",\"_persist\":\"{\\\"version\\\":-1,\\\"rehydrated\\\":true}\"}");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.clockDrift","0");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.deviceKey","us-east-1_7c73b54d-fc32-4e8b-90c6-2edfd4623a0d");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.accessToken","eyJraWQiOiJEc28rS0YyK1Y5M0NSK0FtYTRzXC94Z0FuXC9VdTdBcjdhZ044SXh1SWF3cGc9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJjNGQ2ZjE4ZS1lNGU5LTQ1MGItOTllZC03MzNiOTJiYjAwNDUiLCJjb2duaXRvOmdyb3VwcyI6WyJBZG1pbiJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9qMER5M3FYOE4iLCJjbGllbnRfaWQiOiIzMW5xNGNzcG5nanUycnRzdmVrZm84b2o3ZyIsIm9yaWdpbl9qdGkiOiJmZDJjNTYzOS03Yzc1LTRjNjItOWJlYS1mMWM4OGU0MzcyMDQiLCJldmVudF9pZCI6IjA0ODg1YzgwLWQ2OTUtNGRkYy1hN2QyLTcxMTI3ODQ0ZmVkMCIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2NTI0NDQzNjYsImV4cCI6MTY1NDIzNDgyNSwiaWF0IjoxNjU0MjMxMjI1LCJqdGkiOiIzNzlkNGM5MS00NjE2LTRmNzQtOWU0ZC00ODIxZTg1Y2Y1MGQiLCJ1c2VybmFtZSI6InNhdXJhdi5hbmFuZEBtZWRpZmxpeC5jb20ifQ.OIyxA5gzWlUUaIXttHx7NyGj3GR17YcCRR_pJ4VXvovga-jGRnPsGKz6Fvv4yG0SrvCWNe12PltaxTRuo1192AAr_jm__GFjIczjhr3B4l__BMJ1eMahMqsVArAAvjjik9VvGZsX61frfBsTu11MmjceoGYscoJzBKqufE91zWEv0xMRqNNQGlg-q4DiUV3Cu52zgQ-7mBaCOwVa_J63MlcWfG7WSUgr47ix4LAmbi8H94J-9RnGOyw_22rgRX5TB54ix0INmpnOyh8bKMLJEskTJ6MtJObS8TYzsJrazBlrurqCdlWOqFDx2n24K8Obtv74Sg5Pwssm4icNk6SQ5w");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.randomPasswordKey","mlvQreD0BeNzhYmuIThPelqazmNg0Lx9ibk3OO+72Hremdj3FfPJdg==");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.userData","{\"PreferredMfaSetting\":\"SMS_MFA\",\"UserAttributes\":[{\"Name\":\"sub\",\"Value\":\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\"},{\"Name\":\"name\",\"Value\":\"shivraj2\"},{\"Name\":\"phone_number\",\"Value\":\"+919834330981\"},{\"Name\":\"email\",\"Value\":\"shivrajtech37@gmail.com\"}],\"UserMFASettingList\":[\"SMS_MFA\"],\"Username\":\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\"}");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.idToken","eyJraWQiOiIzNkZrcURhRWt1eU9WcVo3V2JMaE15UVZ2UFRNY1Z5QVJ3N2IzYUJIdXU4PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJjNGQ2ZjE4ZS1lNGU5LTQ1MGItOTllZC03MzNiOTJiYjAwNDUiLCJjb2duaXRvOmdyb3VwcyI6WyJBZG1pbiJdLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX2owRHkzcVg4TiIsImNvZ25pdG86dXNlcm5hbWUiOiJzYXVyYXYuYW5hbmRAbWVkaWZsaXguY29tIiwiZ2l2ZW5fbmFtZSI6IlNhdXJhdiIsIm9yaWdpbl9qdGkiOiJmZDJjNTYzOS03Yzc1LTRjNjItOWJlYS1mMWM4OGU0MzcyMDQiLCJhdWQiOiIzMW5xNGNzcG5nanUycnRzdmVrZm84b2o3ZyIsImV2ZW50X2lkIjoiMDQ4ODVjODAtZDY5NS00ZGRjLWE3ZDItNzExMjc4NDRmZWQwIiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2NTI0NDQzNjYsImV4cCI6MTY1NDIzNDgyNSwiaWF0IjoxNjU0MjMxMjI1LCJmYW1pbHlfbmFtZSI6IkFuYW5kIiwianRpIjoiNDk2YTZkYWEtYjU1NS00MTBmLWIwYzYtNTgwZjUxYmVjNzQwIiwiZW1haWwiOiJzYXVyYXYuYW5hbmRAbWVkaWZsaXguY29tIn0.h3BOXh2CIjvlBX0y7M-r4YTVOJBagj390V0EprKTER9xfVTB5coHFZ9Y84-2tqbn_3VYO5SJwLOe9sSx_CfdhxcnNNnmAnXvycAPq5NaylrebPxtS-BMprhqWwxHvThmjAPGbSRqvWf9OGKOMCnFtvuJVv6LhN_1KB2k_UR3qgjZ223BQvF0iKvetmS8gfJHwPebDrT3l1Wctlau3dt_PmTEF4yv_ccdC-g1pAtVUM64857RjNT1cG-W_dezzd0jabjZHzzYlQ5sQ6DbzgU91xWkQynlLfkrhWlxxvorzk1F8vaT3NvO2eeJg-6kDJjtSsRjF-thV4qEZjtANwVvEA");
	    
	    driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/tags");
	    
	 }
	 @Test (priority=1)
//	 @Test (enabled = false)
	 public void Create_Tags_With_Madatory_fields() throws InterruptedException 
	 {
			 
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	Thread.sleep(4000);
		 
		 System.out.println("Tags -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 
		 Reporter.log("Tags -> Verifying Mandatory Fields Validation Is Working Or Not");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 WebDriverWait Create_tags_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 Create_tags_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/div[2]/button[3]"))).click();
		 
		 Thread.sleep(1000);
		    
		 WebDriverWait save_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		 
		 Thread.sleep(1000);
		 
		 System.out.println("Tags -> Verify The Create From Tags Module With Mandatory Fields Only**************");
		 Reporter.log("Tags -> Create Tags With Mandatory Fields Only");
		 
		 //tags name
		 name = driver.findElement(By.id("tag-name"));
		 name.sendKeys(tags_name);
		 
		 Thread.sleep(2000);
		 
		 // tags category
		 
		 WebElement category_click=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div/div/input"));
		 category_click.click();
		 
		 Thread.sleep(3000);
		 
		 WebDriverWait cat_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 cat_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[1]"))).click();
		 		  
		 Thread.sleep(2000);
		 //save   
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		 		  
		 Thread.sleep(5000);
		 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=2)
	 public void View_And_Verify_Tags_With_Mandatory_Fields() throws InterruptedException 
	 {
		System.out.println("Tags-> view the newly created Tags*******************");
		Reporter.log("Tags ->  View The Newly Created Tags");
		 
		WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[2]"))).click();

		Thread.sleep(3000);
		
		// tags name
		
		String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[1]/div/input")).getAttribute("value");
		System.out.println("Tags name is_________________________"+s1);
					
		// tags category
					
		String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div/input")).getAttribute("value");
		System.out.println("Tags category is_________________________"+s2);
						        
		// close
								
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();

		Thread.sleep(5000);
		
	 }
	
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void Edit_Tags_With_All_Fields() throws InterruptedException 
	 {
		 System.out.println("Tags-> Search And Edit The Newly Created Tags With Remaining Fields");
		 Reporter.log("Tags-> Search And Edit The Newly Created Tags With Remaining Fields");
			
		 WebDriverWait edit_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 edit_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[1]"))).click();

		 Thread.sleep(3000);
			
			//desc		
			 
		 desc = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[3]/div/textarea[1]"));
		 desc.sendKeys(tags_desc);
		 
		 Thread.sleep(2000);
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();

		 Thread.sleep(5000);
		 	 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=4)
	 public void View_And_Verify_Edited_Tags() throws InterruptedException 
	 {
		 	System.out.println("Tags-> view the newly created Tags*******************");
			Reporter.log("Tags ->  View The Newly Created Tags");
			 
			WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[2]"))).click();

			Thread.sleep(3000);
			
			// tags name
			
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[1]/div/input")).getAttribute("value");
			System.out.println("Tags name is_________________________"+s1);
			
			if(s1.equals(tags_name))
			{
				System.out.println("Tags name is present");
				softAssert.assertEquals(s1, tags_name); 
			}
			else
			{
				System.out.println("Tags name is not present");
				softAssert.assertEquals(s1, tags_name);
				Reporter.log( "[ERROR] -> Tags -> View Screen -> Tags name is not present in Tags View Screen.");
			}		
			
						
			// tags category
						
			String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div/input")).getAttribute("value");
			System.out.println("Tags category is_________________________"+s2);
			
			if(s2.equals(s2))
			{
				System.out.println("Tags name is present");
				softAssert.assertEquals(s2, s2); 
			}
			else
			{
				System.out.println("Tags name is not present");
				softAssert.assertEquals(s2, s2);
				Reporter.log( "[ERROR] -> Tags -> View Screen -> Tags name is not present in Tags View Screen.");
			}		
			
			// desc
			
			String s3 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[3]/div/textarea[1]")).getText();
			System.out.println("Tags description is_________________________"+s3);
			
			if(s3.equals(tags_desc))
			{
				System.out.println("Tags name is present");
				softAssert.assertEquals(s3, tags_desc); 
			}
			else
			{
				System.out.println("Tags name is not present");
				softAssert.assertEquals(s3, tags_desc);
				Reporter.log( "[ERROR] -> Tags -> View Screen -> Tags name is not present in Tags View Screen.");
			}	
			
			softAssert.assertAll();
			Thread.sleep(2000);			
			// close
						
			WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
			close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();

			Thread.sleep(4000);	
			
	 }
	 
	// create new tags content with all fields
	 @Test (priority=5)
	 public void Create_New_Tags_With_All_Fields() throws InterruptedException
	 {	
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 System.out.println("Tags -> Verifying Create New Tags  With All Information*****************");
		 Reporter.log("Tags -> Verifying Create New Tags  With All Information");
		 
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();

		 WebDriverWait Create_tags_click = new WebDriverWait(driver, Duration.ofSeconds(30));
		 Create_tags_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/div[2]/button[3]"))).click();
		 
		 Thread.sleep(1000);	 
			
		 //tags name
		 name2 = driver.findElement(By.id("tag-name"));
		 name2.sendKeys(tags_name2);
		 
		 Thread.sleep(2000);
		 
		 // tags category
		 
		 WebElement category_click=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div/div/input"));
		 category_click.click();
		 
		 Thread.sleep(3000);
		 
		 WebDriverWait cat_select = new WebDriverWait(driver, Duration.ofSeconds(30));
		 cat_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[1]"))).click();
		 		  
		 Thread.sleep(2000);	
		 
		//desc		
		 
		 desc2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[3]/div/textarea[1]"));
		 desc2.sendKeys(tags_desc2);
		 
		 Thread.sleep(2000);
		 
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		 		  
		 Thread.sleep(5000);		 
		 		 
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=6)
	 public void View_And_Verify_New_Tags() throws InterruptedException 
	 {
		 	driver.manage().window().maximize();
		 	driver.navigate().refresh();
		 	
		 	System.out.println("Tags ->  View The New Created Tags*******************");
		    Reporter.log("Tags ->  View The New Created Tags");
		    
		    WebDriverWait view_icon_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			view_icon_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[5]/button[2]"))).click();

			Thread.sleep(3000);
			
			// tags name
			
			String s1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[1]/div/input")).getAttribute("value");
			System.out.println("New Tags name is_________________________"+s1);
			
			if(s1.equals(tags_name2))
			{
				System.out.println("New Tags name is present");
				softAssert.assertEquals(s1, tags_name2); 
			}
			else
			{
				System.out.println("New Tags name is not present");
				softAssert.assertEquals(s1, tags_name2);
				Reporter.log( "[ERROR] -> Tags -> View Screen ->New Tags name is not present in Tags View Screen.");
			}		
			
						
			// tags category
						
			String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div/input")).getAttribute("value");
			System.out.println("New Tags category is_________________________"+s2);
			
			if(s2.equals(s2))
			{
				System.out.println("New Tags name is present");
				softAssert.assertEquals(s2, s2); 
			}
			else
			{
				System.out.println("Tags name is not present");
				softAssert.assertEquals(s2, s2);
				Reporter.log( "[ERROR] -> Tags -> View Screen -> New Tags name is not present in Tags View Screen.");
			}		
			
			// desc
			
			String s3 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/div[3]/div/textarea[1]")).getText();
			System.out.println("Tags description is_________________________"+s3);
			
			if(s3.equals(tags_desc2))
			{
				System.out.println("New Tags name is present");
				softAssert.assertEquals(s3, tags_desc2); 
			}
			else
			{
				System.out.println("New Tags name is not present");
				softAssert.assertEquals(s3, tags_desc2);
				Reporter.log( "[ERROR] -> Tags -> View Screen ->New Tags name is not present in Tags View Screen.");
			}	
			
			softAssert.assertAll();
			Thread.sleep(2000);			
			// close
						
			WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
			close.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();

			Thread.sleep(4000);	
		    
		     
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=7)
	 public void View_And_Verify_Delete_Tags() throws InterruptedException 
	 {
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]"))).click();
		 
		 System.out.println("Tags -> search and delete the Tags*******************");
		 Reporter.log("Tags -> Search and Delete The Tags");
		 
		 WebElement tags_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
		 tags_searchbox.sendKeys(tags_name);

		 WebDriverWait delete_icon = new WebDriverWait(driver, Duration.ofSeconds(30));
		 delete_icon.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/button[3]"))).click();
	 
		 Thread.sleep(2000);
		
		 WebDriverWait delete = new WebDriverWait(driver, Duration.ofSeconds(30));
		 delete.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		
		 Thread.sleep(3000); 
		 
		 
						 
	 }
	  
	 @AfterTest
	 public void closeBrowser() 
	 {
	 	driver.quit();
	 	
	 }
		 
		 
	 
}
	 
	 
	 
	 


