package Adminportal;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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



public class Collection_module_testcases 
{

	ChromeDriver driver; 
	SoftAssert softAssert = new SoftAssert();
	
	WebElement name;
	WebElement type;
	WebElement image;
	WebElement slug;
	WebElement banner;
	WebElement desc;
	WebElement video;
	WebElement child;
	WebElement audio;
	WebElement advice;
	WebElement expert;
	WebElement institution;
	
	String coll_name="Peacefull Mind";
	String coll_slug="21ygdue7";
	String coll_desc=" Is the usual way of asking what people are thinking of doing";
	String tagcount;
	
	WebElement name2;
	WebElement type2;
	WebElement image2;
	WebElement slug2;
	WebElement banner2;
	WebElement desc2;
	WebElement video2;
	WebElement child2;
	WebElement audio2;
	WebElement advice2;
	WebElement expert2;
	WebElement institution2;
	
	String coll_name2="Skin Care";
	String coll_slug2="11jh488";
	String coll_desc2="How to live happy life";
	String tagcount2;
	
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
	      
	    driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/collections");
	    
	 }
	
	 @Test (priority=2)
//	 @Test (enabled = false)
	 public void Create_Collection_With_Madatory_fields() throws InterruptedException 
	 {
		 driver.manage().window().maximize();
		 driver.navigate().refresh();
		 Thread.sleep(20000);
		 
		 System.out.println("Collection -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 
		 Reporter.log("Collection -> Verifying Mandatory Fields Validation Is Working Or Not");
		 
		 WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
		 load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]")));
	    
		 WebElement create_collection_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"));
		 create_collection_button.click();
			
		 Thread.sleep(3000);
		    
		 WebDriverWait wait_save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_save.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		    
		 
		 WebElement savebutton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
		 savebutton.click();
		 
		 Thread.sleep(3000);
		 
		 System.out.println("Collection -> Verify The Create Collection With Mandatory Fields Only**************");
		
		 Reporter.log("Collection -> Create Collection With Mandatory Fields Only");
		 //collection name
		 name= driver.findElement(By.id("collection-name"));
		 name.sendKeys(coll_name);
		 
		 type = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div"));
	     type.click();
		 
  	     
	     WebElement click_coll=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/div/ul/li[4]"));
	     click_coll.click();
	     
	     Thread.sleep(10000);
	      
		 WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
		 
		 
		 Thread.sleep(10000);
		 
    
		
	     
	 }
	 
//	 @Test (enabled = false)
	 @Test (priority=3)
	 public void View_And_Verify_Collection_With_Mandatory_Fields() throws InterruptedException  
	 {
		    driver.manage().window().maximize();
		    Thread.sleep(5000);
		    driver.navigate().refresh();
		    Thread.sleep(3000);
		    
		 	WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]")));
		    
			
		    System.out.println("Collection -> search and view the newly created collection*******************");
		    Reporter.log("Collection -> Search And View The Newly Created Collection");
		    
			WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			coll_searchbox.sendKeys(coll_name);
		 
			Thread.sleep(3000);
			
			 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
			    			
	//		WebElement icon_view = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"));
	//		icon_view.click();
			
			Thread.sleep(2000);
			
			
			//collection name
			String s1 = driver.findElement(By.xpath("//input[@id='collection-name']")).getAttribute("value");
			System.out.println("Collection name is ____________________________"+s1);
		
			if(s1.equals(coll_name))
			{
				System.out.println("name is present");
				AssertJUnit.assertEquals(s1, coll_name);
			}
			else
			{
				System.out.println("name is not present");
				AssertJUnit.assertEquals(s1, coll_name);
				Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Name Is Not Present In Banner view Screen.");
			}
			
			//collection type
			
			String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div/input")).getAttribute("value");
			System.out.println("collection type is ____________________________"+s2);
		
			if(s2.equals(s2))
			{
				System.out.println("collection type  is present");
				AssertJUnit.assertEquals(s2, s2);
			}
			else
			{
				System.out.println("collection type is not present");
				AssertJUnit.assertEquals(s2, s2);
				Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Name Is Not Present In Banner view Screen.");
			}
	
			
			softAssert.assertAll();
			
			//close button
			
			Thread.sleep(5000);
			
			 WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
			    	
			 Thread.sleep(10000);
		 }
			
//		@Test (enabled = false)
		 @Test (priority=4)
		 public void Edit_Collection_With_All_Fields() throws InterruptedException 
		 {
			    driver.manage().window().maximize();
			    driver.navigate().refresh();
			    Thread.sleep(10000);
			    WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
				load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]")));
			    
			    System.out.println("Collection -> Search And Edit The Newly Created Collection With Remaining Fields");
			    Reporter.log("Collection -> Search And Edit The Newly Created Collection With Remaining Fields");
			    
			    WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(coll_name);
			 
				Thread.sleep(3000);
			    
			    WebDriverWait wait_edit = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait_edit.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[1]"))).click();
				    	
			    Thread.sleep(3000);
			    
			    //image
			    image = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/button/p"));
			    image.click();
			    
			    Thread.sleep(2000);
			    
			    WebDriverWait wait_image = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait_image.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"))).click();
			    
			    Thread.sleep(3000);
			   //select button
			    
			    WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
			    select_button.click();
			    //slug 
			    slug = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[4]/div/input"));
			    slug.sendKeys(coll_slug);
			    
			        
			    desc = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[6]/div/textarea[1]"));
			    desc.sendKeys(coll_desc);
			    
			    //banner 
			    
			    WebDriverWait banner_click = new WebDriverWait(driver, Duration.ofSeconds(30));
			    banner_click.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[5]/div/div/input"))).click();
			    
			    WebDriverWait banner_select = new WebDriverWait(driver, Duration.ofSeconds(30));
			    banner_select.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[6]/div/ul/li[16]"))).click();
			        			    
			    //video click 
			    video=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]/div/div/div/input"));
			    video.click();
			    //video select 
			    WebElement video_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]"));
			    video_select.click();
			    
			    WebElement m1=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m1.click();
			    
			    
			    //child click 
			    child=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/input"));
			    child.click();
			    //child select 
			    WebElement child_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]"));
			    child_select.click();
			    WebElement m2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m2.click();
			    
			    
			    //audio click 
			    audio=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div[1]/div/div/input"));
			    audio.click();
			    //audio select 
			    WebElement audio_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div[2]/div/ul/li[1]"));
			    audio_select.click();
			    WebElement m3=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m3.click();
			    
			    
			    //advice click 
			    advice=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/input"));
			    advice.click();
			    //advice select 
			    WebElement advice_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div[2]/div/ul/li[1]"));
			    advice_select.click();
			    WebElement m4=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m4.click();
			    
			    
			    //expert click 
			    expert=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[5]/div/div/input"));
			    expert.click();
			    //expert select 
			    WebElement expert_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[9]"));
			    expert_select.click();
			    WebElement m5=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m5.click();
			    
			    
			    //institution click 
			    institution=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[6]/div/div/input"));
			    institution.click();
			    //institution select 
			    WebElement institution_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[7]/div/ul/li[4]"));
			    institution_select.click();
			    WebElement m6=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m6.click();
			    
			    //tags
			    WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[7]/div/button"));
			    tab_button.click();
				    
			     Thread.sleep(2000);
				 
			     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"));
				 tab_topic.click();
							  
				 Thread.sleep(2000);
				    
				 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
				 selectbutton.click();
				    
				 Thread.sleep(10000);
			    
				 WebDriverWait save_click = new WebDriverWait(driver, Duration.ofSeconds(30));
				 save_click.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();
				 
				 Thread.sleep(10000);
			    
		 }
	
//		 @Test (enabled = false)
	     @Test (priority=5)
		 public void View_And_Verify_Edited_Collection_() throws InterruptedException 
		 {
	    	 	driver.manage().window().maximize();
	    	 	 Thread.sleep(5000);
			    driver.navigate().refresh();
			    Thread.sleep(10000);
			 	
			 	 
			    System.out.println("Collection -> search and view edited  collection*******************");
			    Reporter.log("Collection -> Search And View Edited  Collection");
			    
				WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(coll_name);
			 
				Thread.sleep(3000);
				
				 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
				 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
				    			
		//		WebElement icon_view = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"));
		//		icon_view.click();
				
				Thread.sleep(2000);
				
				 
				//collection name
				String s1 = driver.findElement(By.xpath("//input[@id='collection-name']")).getAttribute("value");
				System.out.println("Collection name is ____________________________"+s1);
			
				if(s1.equals(coll_name))
				{
					System.out.println("name is present");
					AssertJUnit.assertEquals(s1, coll_name);
				}
				else
				{
					System.out.println("name is not present");
					AssertJUnit.assertEquals(s1, coll_name);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Name Is Not Present In Collection view Screen.");
				}
				
				//collection type
				
				String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div/input")).getAttribute("value");
				System.out.println("collection type is ____________________________"+s2);
			
				if(s2.equals(s2))
				{
					System.out.println("collection type  is present");
					AssertJUnit.assertEquals(s2, s2);
				}
				else
				{
					System.out.println("collection type is not present");
					AssertJUnit.assertEquals(s2, s2);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Name Is Not Present In Collection view Screen.");
				}
		
				
				//collection slug
				String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/div/input")).getAttribute("value");
				System.out.println("Collection slug is ____________________________"+s3);
			
				if(s3.equals(coll_slug))
				{
					System.out.println("slug is present");
					AssertJUnit.assertEquals(s3, coll_slug);
				}
				else
				{
					System.out.println("slug is not present");
					AssertJUnit.assertEquals(s3, coll_slug);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Slug Is Not Present In Collection view Screen.");
				}
				
				
				//banner
				String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[4]/div/div/input")).getAttribute("value");
				System.out.println("collection view -> banner is ____________________________"+s4);
			
				if(s4.equals(s4))
				{
					System.out.println("collection view -> banner  is present");
					AssertJUnit.assertEquals(s4, s4);
				}
				else
				{
					System.out.println("collection view -> banner is not present");
					AssertJUnit.assertEquals(s4, s4);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Banner Is Not Present In Collection view Screen.");
				}
				
				//collection description
				String s5 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[5]/div/textarea[1]")).getText();
				System.out.println("Collection description is ____________________________"+s5);
			
				if(s5.equals(coll_desc))
				{
					System.out.println("description is present");
					AssertJUnit.assertEquals(s5, coll_desc);
				}
				else
				{
					System.out.println("description is not present");
					AssertJUnit.assertEquals(s5, coll_desc);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Description Is Not Present In Collection view Screen.");
				}
				
				
				//collection videos
				String s6 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]/div/div/div")).getText();
				System.out.println("Collection -> videos is ____________________________"+s6);
			
				if(s6.equals(s6))
				{
					System.out.println("videos is present");
					AssertJUnit.assertEquals(s6, s6);
				}
				else
				{
					System.out.println("videos is not present");
					AssertJUnit.assertEquals(s6, s6);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Collection Videos Is Not Present In Collection view Screen.");
				}
				
				//collection-> child collection 
				String s7 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div/div/div")).getText();
				System.out.println("Collection -> child collection is ____________________________"+s7);
			
				if(s7.equals(s7))
				{
					System.out.println("child collection is present");
					AssertJUnit.assertEquals(s7, s7);
				}
				else
				{
					System.out.println("child collection  is not present");
					AssertJUnit.assertEquals(s7, s7);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Child Collection Is Not Present In Collection view Screen.");
				}
				
				
				//collection audio
				String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div/div/div")).getText();
				System.out.println("Collection -> audio is ____________________________"+s8);
			
				if(s8.equals(s8))
				{
					System.out.println("audio is present");
					AssertJUnit.assertEquals(s8, s8);
				}
				else
				{
					System.out.println("audio is not present");
					AssertJUnit.assertEquals(s8, s8);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Audio Is Not Present In Collection view Screen.");
				}
				
				//collection advice
				String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div/div/div")).getText();
				System.out.println("Collection -> advice is ____________________________"+s9);
			
				if(s9.equals(s9))
				{
					System.out.println("advice is present");
					AssertJUnit.assertEquals(s9, s9);
				}
				else
				{
					System.out.println("advice is not present");
					AssertJUnit.assertEquals(s9, s9);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Advice Is Not Present In Collection view Screen.");
				}
				
				//collection expert
				String s10 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[5]/div/div")).getText();
				System.out.println("Collection -> expert is ____________________________"+s10);
			
				if(s10.equals(s10))
				{
					System.out.println("expert is present");
					AssertJUnit.assertEquals(s10, s10);
				}
				else
				{
					System.out.println("expert is not present");
					AssertJUnit.assertEquals(s10, s10);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Expert Is Not Present In Collection view Screen.");
				}
				
				//collection institution
				String s11 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[6]/div/div")).getText();
				System.out.println("Collection -> institution is ____________________________"+s11);
			
				if(s11.equals(s11))
				{
					System.out.println("institution is present");
					AssertJUnit.assertEquals(s11, s11);
				}
				else
				{
					System.out.println("institution is not present");
					AssertJUnit.assertEquals(s11, s11);
					Reporter.log( "[ERROR] -> Collection -> View Screen -> Institution Is Not Present In Collection view Screen.");
				}			
							
				softAssert.assertAll();
	 	 
				WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
				    	
				Thread.sleep(3000);
				
		 } 
		 
//		 @Test (enabled = false)
	     @Test (priority=6)
		 public void Create_New_Collection_With_All_Fields() throws InterruptedException
		 {
			 driver.manage().window().maximize();
			 driver.navigate().refresh();
			 Thread.sleep(10000);
			 
			 WebDriverWait wait_pageload = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_pageload.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]/div/div"))).click();
			    	 
		//	 Thread.sleep(5000);

			 Reporter.log("Collection -> Verifying Create New Collection With All Information");
			 	 
			 WebElement create_collection_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[2]"));
			 create_collection_button.click();
			 
			 WebDriverWait wait_popupload = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_popupload.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[1]/div/input"))).click();
			 
			 
		//	 Thread.sleep(5000);
			 
			//collection name
			 name2= driver.findElement(By.id("collection-name"));
			 name2.sendKeys(coll_name2);
			 
			 type2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div"));
		     type2.click();
		     
		     WebElement click_coll=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/div/ul/li[4]"));
		     click_coll.click();
		     
		   //image
			    image2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/button"));
			    image2.click();
			    
			    Thread.sleep(2000);
			    
			    WebDriverWait wait_image = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait_image.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"))).click();
			    
			    Thread.sleep(3000);
			   //select button
			    
			    WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
			    select_button.click();
			    
			    slug2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[4]/div/input"));
			    slug2.sendKeys(coll_slug2);
			    
			        
			    desc2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[6]/div/textarea[1]"));
			    desc2.sendKeys(coll_desc2);
			    
			    //banner click 
			    banner2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[5]/div/div/input"));
			    banner2.click();
			    //select banner
			    WebElement banner_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[6]/div/ul/li[16]"));
			    banner_select.click();
			    
			    //video click 
			    video2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]/div/div/div/input"));
			    video2.click();
			    //video select 
			    WebElement video_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]"));
			    video_select.click();
			    
			    WebElement m1=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m1.click();
			    
			    
			    //child click 
			    child2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/input"));
			    child2.click();
			    //child select 
			    WebElement child_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]"));
			    child_select.click();
			    WebElement m2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m2.click();
			    
			    
			    //audio click 
			    audio2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div[1]/div/div/input"));
			    audio2.click();
			    //audio select 
			    WebElement audio_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div[2]/div/ul/li[1]"));
			    audio_select.click();
			    WebElement m3=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m3.click();
			    
			    
			    //advice click 
			    advice2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/input"));
			    advice2.click();
			    //advice select 
			    WebElement advice_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div[2]/div/ul/li[1]"));
			    advice_select.click();
			    WebElement m4=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m4.click();
			    
			    
			    //expert click 
			    expert2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[5]/div/div/input"));
			    expert2.click();
			    //expert select 
			    WebElement expert_select=driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[9]"));
			    expert_select.click();
			    WebElement m5=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m5.click();
			    
			    
			    //institution click 
			    institution2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[6]/div/div/input"));
			    institution2.click();
			    //institution select 
			    WebElement institution_select=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[7]/div/ul/li[4]"));
			    institution_select.click();
			    WebElement m6=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m6.click();
			    
			    //tags
			    WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[7]/div/button"));
			    tab_button.click();
				    
			     Thread.sleep(2000);
				 
			     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[6]/div[1]/div[1]/label"));
				 tab_topic.click();
							  
				 Thread.sleep(2000);
				    
				 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
				 selectbutton.click();
				    
				 Thread.sleep(10000);
			    
				 WebElement save_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
				 save_button.click();
				 
				 Thread.sleep(10000);
				  
//				 WebDriverWait after_save = new WebDriverWait(driver, Duration.ofSeconds(30));
//				 after_save.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]")));
				    
				 
			 
		 }	 

//	 	@Test (enabled = false)
	     @Test (priority=7)
	 	 public void View_And_Verify_New_Collection_() throws InterruptedException 
	 	 {
	    	 	driver.manage().window().maximize();
	    	 	 Thread.sleep(5000);
	 		    driver.navigate().refresh();
	 		 		 	
	 		 	Thread.sleep(10000);
	 		 	
	 		    System.out.println("Collection -> search and view new collection*******************");
	 		    Reporter.log("Collection -> Search And View New Collection");
	 		    
	 			WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
	 			coll_searchbox.sendKeys(coll_name2);
	 		 
	 			Thread.sleep(3000);
	 			
	 			 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
	 			 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
	 			    			
	 			 Thread.sleep(2000);
	 				
	 				
	 				//collection name
	 				String s1 = driver.findElement(By.xpath("//input[@id='collection-name']")).getAttribute("value");
	 				System.out.println("Collection name is ____________________________"+s1);
	 			
	 				if(s1.equals(coll_name2))
	 				{
	 					System.out.println("name is present");
	 					AssertJUnit.assertEquals(s1, coll_name2);
	 				}
	 				else
	 				{
	 					System.out.println("name is not present");
	 					AssertJUnit.assertEquals(s1, coll_name2);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> Mew Collection Name Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection type
	 				
	 				String s2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div/input")).getAttribute("value");
	 				System.out.println("collection type is ____________________________"+s2);
	 			
	 				if(s2.equals(s2))
	 				{
	 					System.out.println("collection type  is present");
	 					AssertJUnit.assertEquals(s2, s2);
	 				}
	 				else
	 				{
	 					System.out.println("collection type is not present");
	 					AssertJUnit.assertEquals(s2, s2);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Name Is Not Present In Collection view Screen.");
	 				}
	 		
	 				
	 				//collection slug
	 				String s3 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[3]/div/input")).getAttribute("value");
	 				System.out.println("Collection slug is ____________________________"+s3);
	 			
	 				if(s3.equals(coll_slug2))
	 				{
	 					System.out.println("slug is present");
	 					AssertJUnit.assertEquals(s3, coll_slug2);
	 				}
	 				else
	 				{
	 					System.out.println("slug is not present");
	 					AssertJUnit.assertEquals(s3, coll_slug2);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Slug Is Not Present In Collection view Screen.");
	 				}
	 				
	 				
	 				//banner
	 				String s4 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[4]/div/div/input")).getAttribute("value");
	 				System.out.println("collection view -> banner is ____________________________"+s4);
	 			
	 				if(s4.equals(s4))
	 				{
	 					System.out.println("collection view -> banner  is present");
	 					AssertJUnit.assertEquals(s4, s4);
	 				}
	 				else
	 				{
	 					System.out.println("collection view -> banner is not present");
	 					AssertJUnit.assertEquals(s4, s4);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Banner Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection description
	 				String s5 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div[5]/div/textarea[1]")).getText();
	 				System.out.println("Collection description is ____________________________"+s5);
	 			
	 				if(s5.equals(coll_desc2))
	 				{
	 					System.out.println("description is present");
	 					AssertJUnit.assertEquals(s5, coll_desc2);
	 				}
	 				else
	 				{
	 					System.out.println("description is not present");
	 					AssertJUnit.assertEquals(s5, coll_desc2);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Description Is Not Present In Collection view Screen.");
	 				}
	 				
	 				
	 				//collection videos
	 				String s6 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]/div/div/div")).getText();
	 				System.out.println("Collection -> videos is ____________________________"+s6);
	 			
	 				if(s6.equals(s6))
	 				{
	 					System.out.println("videos is present");
	 					AssertJUnit.assertEquals(s6, s6);
	 				}
	 				else
	 				{
	 					System.out.println("videos is not present");
	 					AssertJUnit.assertEquals(s6, s6);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Videos Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection-> child collection 
	 				String s7 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div/div/div")).getText();
	 				System.out.println("Collection -> child collection is ____________________________"+s7);
	 			
	 				if(s7.equals(s7))
	 				{
	 					System.out.println("child collection is present");
	 					AssertJUnit.assertEquals(s7, s7);
	 				}
	 				else
	 				{
	 					System.out.println("child collection  is not present");
	 					AssertJUnit.assertEquals(s7, s7);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Child Collection Is Not Present In Collection view Screen.");
	 				}
	 				
	 				
	 				//collection audio
	 				String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[3]/div/div/div")).getText();
	 				System.out.println("Collection -> audio is ____________________________"+s8);
	 			
	 				if(s8.equals(s8))
	 				{
	 					System.out.println("audio is present");
	 					AssertJUnit.assertEquals(s8, s8);
	 				}
	 				else
	 				{
	 					System.out.println("audio is not present");
	 					AssertJUnit.assertEquals(s8, s8);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen ->New Collection Audio Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection advice
	 				String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[4]/div/div/div")).getText();
	 				System.out.println("Collection -> advice is ____________________________"+s9);
	 			
	 				if(s9.equals(s9))
	 				{
	 					System.out.println("advice is present");
	 					AssertJUnit.assertEquals(s9, s9);
	 				}
	 				else
	 				{
	 					System.out.println("advice is not present");
	 					AssertJUnit.assertEquals(s9, s9);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Advice Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection expert
	 				String s10 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[5]/div/div")).getText();
	 				System.out.println("Collection -> expert is ____________________________"+s10);
	 			
	 				if(s10.equals(s10))
	 				{
	 					System.out.println("expert is present");
	 					AssertJUnit.assertEquals(s10, s10);
	 				}
	 				else
	 				{
	 					System.out.println("expert is not present");
	 					AssertJUnit.assertEquals(s10, s10);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Expert Is Not Present In Collection view Screen.");
	 				}
	 				
	 				//collection institution
	 				String s11 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[6]/div/div")).getText();
	 				System.out.println("Collection -> institution is ____________________________"+s11);
	 			
	 				if(s11.equals(s11))
	 				{
	 					System.out.println("institution is present");
	 					AssertJUnit.assertEquals(s11, s11);
	 				}
	 				else
	 				{
	 					System.out.println("institution is not present");
	 					AssertJUnit.assertEquals(s11, s11);
	 					Reporter.log( "[ERROR] -> Collection -> View Screen -> New Collection Institution Is Not Present In Collection view Screen.");
	 				}			
	 							
	 				softAssert.assertAll();
	 	 	 
	 				WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
	 				wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
	 				    	
	 				Thread.sleep(3000);
	 	 }
	     
//	 	 @Test (enabled = false)
	     @Test (priority=8)
	 	 public void Delete_New_Collection_() throws InterruptedException 
	 	 {
	     	    driver.manage().window().maximize();
	     	    driver.navigate().refresh();
	     	    Thread.sleep(10000);
	     	   
//	     	    wait(self.driver, 60).until(EC.presence_of_all_elements_located);
	 		    System.out.println("Collection -> search and delete new collection*******************");
	 		    Reporter.log("Collection -> Search And Delete New Collection");
	 		    
	 			WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
	 			coll_searchbox.sendKeys(coll_name2);
	 		 
	 			WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
	 			load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]/div/div"))).click();
	 	
	 			WebElement delete_icon= driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[3]"));
	 			delete_icon.click();

	 			Thread.sleep(2000);
	 			 	 
	 			WebElement delete_click = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
	 			delete_click.click();
	 			
	 			Thread.sleep(4000);
	 			 	 	
	 	   }
	     
	 	@Test (enabled = false)
//		 @Test (priority=9)
		 public void filter_banner() throws InterruptedException
			{
				
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println("Collection -> Verifying the filter from collection page");
				Reporter.log("Collection -> Verifying the filter from collection page");
				
				WebElement filter = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button[1]"));
				filter.click();
				
				Thread.sleep(3000);
				
				WebElement filter_coll_type = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/input"));
				filter_coll_type.click();
				
				Thread.sleep(2000);
				
				WebElement filter_coll_page = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/ul/li[2]"));
				filter_coll_page.click();
				
					
				
/*				
				WebElement filter_tags = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/button"));
				filter_tags.click();
				
				Thread.sleep(3000);
				 
			     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[4]/div[1]/div[1]/label"));
				 tab_topic.click();
						  
				 Thread.sleep(3000);
				    
				 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
				 selectbutton.click();
				
				 Thread.sleep(3000);
*/		 
				 WebElement filter_apply = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
				 filter_apply.click();
				 
				
			}
	     
	 	@AfterTest
		 public void closeBrowser() 
	 	{
		 	driver.quit();
		 	
		 }
		
}


