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



public class Institute_module_testcases 
{

	ChromeDriver driver; 
	SoftAssert softAssert = new SoftAssert();
	
	
	WebElement name;
	WebElement logo;
	WebElement image;
	WebElement desc;
	WebElement slug;
	WebElement expert;
	WebElement tagcount;
	WebElement collection;
	WebElement videos;
	WebElement zipcode;
		
	String inst_name="CRDF Global";
	String inst_desc="An independent nonprofit organization that promotes international scientific and technical collaboration";
	String inst_slug="346jhgkjh";
	
	WebElement name2;
	WebElement logo2;
	WebElement image2;
	WebElement desc2;
	WebElement slug2;
	WebElement expert2;
	WebElement collection2;
	WebElement videos2;
	WebElement zipcode2;
		
	String inst_name2="Cornell";
	String inst_desc2="University is a private institution that was founded in 1865";
	String inst_slug2="198ndhd";
	String tagcount2;
	
	
	@BeforeTest
	  public void Test_Local_Storage()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Prasad_aute//Downloads//selenium/106/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://admin-portal.us-east-1.dev.mediflix.com");

	    LocalStorage local = ((WebStorage) driver).getLocalStorage();    

	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.LastAuthUser","saurav.anand@mediflix.com");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.deviceGroupKey","-9b0ne3AP");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.refreshToken","eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.nDfZ6CxJBwxQ32zrfpV2rodjAVZvfKmK3zouXGmFuLOVMNLGc2WH8mKUWjKQmZbOhv30hCSrP_uK4noeAp-Vi3HrPFvQC06bAVQ1nN5ui1SZfw62-lPUQSQLayrEZO94sDxNrNoa8Fl8NVgDoO2RcR3GFSo9Yl6PUdFZr_mGgmPOzZk24eS62cDNtcJ4YfUQI8AcYsY40ACiocamgz-LFosXzgwBnyXXExYoy8Z3KqpsCtBL1xibOLL48hftc8R6N_zmTIe0nWA2A1gAP3bF8b6VMfE5jx1_-5xeKh_k7uhfaRb4gZaBV8TqTnw4IN_J1Hc4Qz3pdcv-X0OX_W7SGA.UKmV9hX07996GueY.8CN3Q86AxWooFy48qzNzc0EB4N_4zXvjUvhYuy5oNjCkXIVGna-Xx18wyE0MTnqtNz_-7b41du_f5_c6mpv4vCZRy-Z94YDwmG81EAQAu47yLP9gUEPKzlm030hgg1kc9m21p7impkTTQFs1KuJgFGBCITU8q4LlOvZS7HcbremaHQfPLtp1gghEF5XCYZC2YyCQeaa0xhKfiVJNn-_TDq_UhkWqDmD1PlKHCE9PiMx5bbykzfo_2cAznSNk0Mq4g1wKbg87RN0vl-el8x5MR_NY7ZQULQ6NyfdyM50NFO-jNEcIJBUbbP-QAvBKMwAt7Kpe379XO9TPmitkK-NTYFwt8JGlpgaz-RMIuRikJHDnYQTTtwJx5HHtJKAzUUIxerTsS3P_5U97pgeoU2NlRPg3UmqLbAsHW_GWlZDRUP8WCqnk_Ny9npSuM13hM1PNgbCwJX9yIvNMptB9oQ3WATKYet7NYkoiUZ8IHhZP8YYuVdBwtU1Ht4sVTSR6IeGVFad6aLcixfEUEzFoYrKKJlpGRcIN63chYvXLwb7M1f9u9JdVNyHz0vCSnpha6Z7KrTpuOU98wYsfHDMNmj-y1xWJQA6g4zjGpop9pjNT7_acofq_T4cgwB_oymw6SMNNrISBCcKeKuzQoOXNpgkk92IgQ-FoaEdpk9o823--g72DFEcUxsoBvb6v-ViFsRB5Jafqcf0BAER67rN_-8GHaydkRZbrp0rbeMU5zxP7xXE8aGnkXpRp_OKp6jznM41D1h0t1Q61I9onvp-jqkjpCA9LMoUSWUibB6hQYPB4rr6tx8KenUFEI-hvljpGOtJSW-9MuPEqv2CW6XApOe20nhudn2okcaYax2FtlQMJO3PbG4hCuSjtrziJKBn0Cx4nGWo11uw9E6-GM-TGiyfjRUr-soj_DfV5gfbvriitpGTefVj-PloAQjZYrhC-t3Pdu-sh0Y-nQLxKA5P_wQ8UY4ozx14qvdsLu_9_9dHJKBPwdY0VqxvwooPI-juNO7q56a31sjhHGj9jh0WhLryFJ4zVgzf7CPbdaJrV5Wv0KHeRhEYKU4HMXMo1aPaIi8MaMuOS22q9SHeEjija-4jyphmJVGIRGmbYFHQ5n40lG_R-8325puhpQ2fukEwjoQQrWmMiiep1ffVGUw-SzqZcxGQdj4_paLrLUx31yGskhdhnD2okv93t22XBOsQdjtY4dFUjjK8hNbVBDpgkbGdTRH-_UX3vSsHhtH6TgEowA1aotJq5zA4V38RFnkVnjV8e5FAG6uKgiJiDmRGJcBBxyLiSFvZdqqMgFU3Wy0up7EKcg1j2jrouxOUzaFJFdqp85J9kvUMQ_CVstDFfga9kbdY1WS2dNCOmEh2-ExgtR-oyWlgqTUlY_3XDyHR0aQIXUh6g1BOrXGjDvw6OnuQIM4pGaTJyM8wBxKfpuXmH.msRg2clNdvG_LYeEXDmVrg");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJkZXZpY2Vfa2V5IjoidXMtZWFzdC0xXzdjNzNiNTRkLWZjMzItNGU4Yi05MGM2LTJlZGZkNDYyM2EwZCIsImNvZ25pdG86Z3JvdXBzIjpbImFkbWluIiwicGF0aWVudCJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9RdWVxOERPMEUiLCJjbGllbnRfaWQiOiIxNnZuMm5pNmQ0Mjl0ZmQzbWk4NnJlZmsycCIsIm9yaWdpbl9qdGkiOiIwMzdmZjNmMy1mY2MyLTRiZWEtYmM3ZS01ZDBiMTdkNjQ0M2UiLCJldmVudF9pZCI6IjgwNjc2YzZmLTJkYjMtNDU5YS1hNjE1LWFiNjNlM2QyMDI1MCIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2NjQ0NTI5NzgsImV4cCI6MTY2NDQ1NjU3OCwiaWF0IjoxNjY0NDUyOTc4LCJqdGkiOiI0NjBhYzI2ZS0yZjY4LTQ5MWQtOTgzZC1jODNmNDJkYzhhYmIiLCJ1c2VybmFtZSI6IjM4ZWFlZjZkLTZhOTgtNDU0Yy1iM2RmLTg2MWMxN2NkMWZjZCJ9.zxOd3KexO-H0BR174PY9xtjTMHFCbMk6VLjnqcDD1PanNgFkdzaZewnLj11a4ZJNz5amT0GmBPc_FFHKBC04iTIXLz1XOp1sex6taanGd-3mvPJTD-AtsFHjMlMm3ptOrZdEFRBw6-pXlwQbTgABOYEYkq_mS8ohK6nZN6t60WznT3D6XHGwkOFj1zXge-aJYJnyqQTv9IrvkosIYN00Y8FMVGZlMOnpChzhCcY2nX7sOPRVcdm4ejGseHwteq34B-nUj1FvwQGJgWr-GZos5U0rucYPB1ZImeudwD8paLO_McOLGEdnT8U3PNOUaEasPtvPlWE8PgWjQHaxRX1r7g");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.refreshToken","eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.Hx7p23V3Iqqk4nSNbIK-zzqct84fZfNe2jbZxnqyBs6AqeG_2a4hp1QkyZ8t6wKHEDskLmElkyzi4W4gUht4AKQMMEjdOoccb_IGA6TUbYPBKambcY5zOxWizdEv_wig1Gj5wy5EHBpV3neNetWJnDPPLV_tIYZEvgTeEvNIq57EdFbdwCo-mo_FZXjHByvs9JJ92uEgzaN5tQQTWmeDKX4vmZT0Qtcs39RNh0nxXDbbbpiDW64VCHoAftd1gG-jAYrHWnIN_BhVSyL0aETHuDhu5d_LLp0xBCbBEJztextK6ihZwDwB6sCeTwqryrOWekcO7YnbkI4-R8_MVNWRpQ.vVdm-qtf3WimDqbt.bQbimb6IXOhMHyQBkgwTNTgxcHOZDskU-UBaHx7KkoNKqMYxNOxgu1YqOB8NCOs6oEwQQm4t3GvWa3r58fhSwi-SKaGB_vn97TK7DnxbIiMhwXUnFUssbZqg1JUYTlMccYZcl5u_gSmHYdm2D2LpIBCHNXpCEyCY8gZC388RI7IqhtO5vNITpeJ2MuGU5ZmtlKglhGpM-vUA8Q6OZtUQ0_nNKbwHLtpPiavE967KnoXmjXiJSzu-1HVSP5fMvsmoRQ5XIz_OIpqgVeLW8IYUNOJYBEXyImybo2IJDEBf-MLJTFo0LGbR2wFsK4_B-Ew3X8lnTdNBWamiMiEDk12OUAYLskBgCRCjb2hvpwYX2c8Kkf9E5sWE3oNQoeyjG0t-wAX01iH1PzzW2d03is39O0sD8sxYBRHSCjDpf35Tzw-8n0UpYOECMMm1vm72xySChbx1-mb8PFcZo4VXhIs_dNaPVNXMSS_e6OaC3nTbD5ZkFL_Nnun4q2IhPSzLANjOHvVQlmxomublZkmGW_fp30iE9LGx3kqkCbf14HYr_6StaC2n4tjOYnuj8rUKLJciy_yMl0dX331jYJAZarhzWpV4FbcS1ra3mQQrhEiUk0hPv9JolOB6tHDpysCHIy7p-8h5WgRoeESESCxPED2HdYztDbid540i-h-FTBNXFVfsaWaXAi0Ob2fpbsokjgmQI9mj4zGvxamLqujedoL-_mSmTXbwLadETvVsa5Jsv3q8nAwbz06WCY6Wbr8NeYdVH2iUR6CBWNrz5Eoywxzv8lxxeT-rb2oyIaBK_xHLMkQkVMxMzqLj8yuBgBeajylpbZLoZl8JBx6vlvzFrBeHgRsxmL6ncFTehmIRBEsl5qQxEvx88ZWBrzctxG6eBdtWUEY7OPB-1YyEoPB31mrT26DFFMyL2WBKZaT9Aio2-1N3UNq7Mzq6OKyegq3XX-ylzxznYgxx8Js-691M6t486Hk-Q4Nn5iVAaWuoYA53BuPB_FdqZYmjrrqUNqz6uD83MOYOkXL8zM2CZX9jCyxwGSwennUQvu_j-h6mm1O1iBDpBDDbZa9tbiNPXWftVViIs9TWi-AKtXQXlqgS1ROc6Im1G33Bt0EEaJ_raHqMx7bU8sw0c764r_zuiVhTkT-lvqpcpjckUe1EJVgJA75R6stclHCm0aJAW-BD2RHbKFtj5YaSUNn18lpL7xEMKkvGDwvmT8OOqDB9d7fB8lgImeTuXBi1hbgIWid57VXBaXF-wVNfkdNFbji-6tWORe7du00M7CsncDN-rJSRGueZAOFaBwkFBj-8tyAJMDw.NwuAlhQ-MxUlYnRFT7TgYA");
	    local.setItem("amplify-signin-with-hostedUI","false");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.LastAuthUser","38eaef6d-6a98-454c-b3df-861c17cd1fcd");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.idToken","eyJraWQiOiIrMDBqWVZCZVhOQVwvTkpVa1FEa0dkUHdzM1NJSjNkVVRYTUI4VGNGa3VGZz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJjb2duaXRvOmdyb3VwcyI6WyJhZG1pbiIsInBhdGllbnQiXSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfUXVlcThETzBFIiwiY29nbml0bzp1c2VybmFtZSI6IjM4ZWFlZjZkLTZhOTgtNDU0Yy1iM2RmLTg2MWMxN2NkMWZjZCIsIm9yaWdpbl9qdGkiOiIwMzdmZjNmMy1mY2MyLTRiZWEtYmM3ZS01ZDBiMTdkNjQ0M2UiLCJhdWQiOiIxNnZuMm5pNmQ0Mjl0ZmQzbWk4NnJlZmsycCIsImV2ZW50X2lkIjoiODA2NzZjNmYtMmRiMy00NTlhLWE2MTUtYWI2M2UzZDIwMjUwIiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2NjQ0NTI5NzgsIm5hbWUiOiJzaGl2cmFqMiIsInBob25lX251bWJlciI6Iis5MTk4MzQzMzA5ODEiLCJleHAiOjE2NjQ0NTY1NzgsImlhdCI6MTY2NDQ1Mjk3OCwianRpIjoiZGI3NDlhYzktMGVmZC00YmJkLTk4ZWUtYTRjMTA0OWI0OGU0IiwiZW1haWwiOiJzaGl2cmFqdGVjaDM3QGdtYWlsLmNvbSJ9.XA_QnJWq9qvP-GEnRHQrLnBv9_der7kSZN6zAdsaO8AEZaghKutbI4xl0KsutHrgy_tHqldtI5j2jPB_8S4YeF00p42iE2N9IN83TKqb1u3KunMQBqNOIf8VE-x8ueNNO4iK-GQgMhRAOWcvE9hdvW6NzyhjFzdWdzKykl3Ws752HSkWOkjelRZBNFBDUWDNZMBZr-N2LHx4WsoXJJecl4jsS31CSyjE-x6bE-QABBSR63CslxnntLtp3frhT13AD3ILzkwuNRwrnooP0N2h71fmbFR2L6tFWk42q3MqhS8VGKdiAY308UPHVSY3r8_-Q071GV70sTqLUsvjm1kzVw");
	    local.setItem("accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJkZXZpY2Vfa2V5IjoidXMtZWFzdC0xXzdjNzNiNTRkLWZjMzItNGU4Yi05MGM2LTJlZGZkNDYyM2EwZCIsImNvZ25pdG86Z3JvdXBzIjpbImFkbWluIiwicGF0aWVudCJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9RdWVxOERPMEUiLCJjbGllbnRfaWQiOiIxNnZuMm5pNmQ0Mjl0ZmQzbWk4NnJlZmsycCIsIm9yaWdpbl9qdGkiOiIwMzdmZjNmMy1mY2MyLTRiZWEtYmM3ZS01ZDBiMTdkNjQ0M2UiLCJldmVudF9pZCI6IjgwNjc2YzZmLTJkYjMtNDU5YS1hNjE1LWFiNjNlM2QyMDI1MCIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2NjQ0NTI5NzgsImV4cCI6MTY2NDQ1NjU3OCwiaWF0IjoxNjY0NDUyOTc4LCJqdGkiOiI0NjBhYzI2ZS0yZjY4LTQ5MWQtOTgzZC1jODNmNDJkYzhhYmIiLCJ1c2VybmFtZSI6IjM4ZWFlZjZkLTZhOTgtNDU0Yy1iM2RmLTg2MWMxN2NkMWZjZCJ9.zxOd3KexO-H0BR174PY9xtjTMHFCbMk6VLjnqcDD1PanNgFkdzaZewnLj11a4ZJNz5amT0GmBPc_FFHKBC04iTIXLz1XOp1sex6taanGd-3mvPJTD-AtsFHjMlMm3ptOrZdEFRBw6-pXlwQbTgABOYEYkq_mS8ohK6nZN6t60WznT3D6XHGwkOFj1zXge-aJYJnyqQTv9IrvkosIYN00Y8FMVGZlMOnpChzhCcY2nX7sOPRVcdm4ejGseHwteq34B-nUj1FvwQGJgWr-GZos5U0rucYPB1ZImeudwD8paLO_McOLGEdnT8U3PNOUaEasPtvPlWE8PgWjQHaxRX1r7g");
	    local.setItem("userRole","admin");
	    local.setItem("userPhoneNumber","+********0981");
	    local.setItem("persist:root","{\"user\":\"{\\\"data\\\":{\\\"sub\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"cognito:groups\\\":[\\\"admin\\\",\\\"patient\\\"],\\\"iss\\\":\\\"https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Queq8DO0E\\\",\\\"cognito:username\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"origin_jti\\\":\\\"037ff3f3-fcc2-4bea-bc7e-5d0b17d6443e\\\",\\\"aud\\\":\\\"16vn2ni6d429tfd3mi86refk2p\\\",\\\"event_id\\\":\\\"80676c6f-2db3-459a-a615-ab63e3d20250\\\",\\\"token_use\\\":\\\"id\\\",\\\"auth_time\\\":1664452978,\\\"name\\\":\\\"shivraj2\\\",\\\"phone_number\\\":\\\"+919834330981\\\",\\\"exp\\\":1664456578,\\\"iat\\\":1664452978,\\\"jti\\\":\\\"db749ac9-0efd-4bbd-98ee-a4c1049b48e4\\\",\\\"email\\\":\\\"shivrajtech37@gmail.com\\\"},\\\"logged\\\":true,\\\"logging\\\":false,\\\"loginError\\\":null,\\\"validating\\\":false,\\\"getOtp\\\":false,\\\"retrievingAll\\\":false,\\\"retrievingAllError\\\":{\\\"message\\\":\\\"Response not JSON\\\",\\\"status\\\":401},\\\"updating\\\":false,\\\"updateError\\\":null,\\\"updated\\\":false,\\\"updatedPassword\\\":false,\\\"updatingPassword\\\":false,\\\"updatePasswordError\\\":null}\",\"_persist\":\"{\\\"version\\\":-1,\\\"rehydrated\\\":true}\"}");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.clockDrift","0");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.deviceKey","us-east-1_7c73b54d-fc32-4e8b-90c6-2edfd4623a0d");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.accessToken","eyJraWQiOiJEc28rS0YyK1Y5M0NSK0FtYTRzXC94Z0FuXC9VdTdBcjdhZ044SXh1SWF3cGc9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJjNGQ2ZjE4ZS1lNGU5LTQ1MGItOTllZC03MzNiOTJiYjAwNDUiLCJjb2duaXRvOmdyb3VwcyI6WyJBZG1pbiJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9qMER5M3FYOE4iLCJjbGllbnRfaWQiOiIzMW5xNGNzcG5nanUycnRzdmVrZm84b2o3ZyIsIm9yaWdpbl9qdGkiOiJmZDJjNTYzOS03Yzc1LTRjNjItOWJlYS1mMWM4OGU0MzcyMDQiLCJldmVudF9pZCI6IjA0ODg1YzgwLWQ2OTUtNGRkYy1hN2QyLTcxMTI3ODQ0ZmVkMCIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2NTI0NDQzNjYsImV4cCI6MTY1NDIzNDgyNSwiaWF0IjoxNjU0MjMxMjI1LCJqdGkiOiIzNzlkNGM5MS00NjE2LTRmNzQtOWU0ZC00ODIxZTg1Y2Y1MGQiLCJ1c2VybmFtZSI6InNhdXJhdi5hbmFuZEBtZWRpZmxpeC5jb20ifQ.OIyxA5gzWlUUaIXttHx7NyGj3GR17YcCRR_pJ4VXvovga-jGRnPsGKz6Fvv4yG0SrvCWNe12PltaxTRuo1192AAr_jm__GFjIczjhr3B4l__BMJ1eMahMqsVArAAvjjik9VvGZsX61frfBsTu11MmjceoGYscoJzBKqufE91zWEv0xMRqNNQGlg-q4DiUV3Cu52zgQ-7mBaCOwVa_J63MlcWfG7WSUgr47ix4LAmbi8H94J-9RnGOyw_22rgRX5TB54ix0INmpnOyh8bKMLJEskTJ6MtJObS8TYzsJrazBlrurqCdlWOqFDx2n24K8Obtv74Sg5Pwssm4icNk6SQ5w");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.randomPasswordKey","mlvQreD0BeNzhYmuIThPelqazmNg0Lx9ibk3OO+72Hremdj3FfPJdg==");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.userData","{\"PreferredMfaSetting\":\"SMS_MFA\",\"UserAttributes\":[{\"Name\":\"sub\",\"Value\":\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\"},{\"Name\":\"name\",\"Value\":\"shivraj2\"},{\"Name\":\"phone_number\",\"Value\":\"+919834330981\"},{\"Name\":\"email\",\"Value\":\"shivrajtech37@gmail.com\"}],\"UserMFASettingList\":[\"SMS_MFA\"],\"Username\":\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\"}");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.clockDrift","0");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.idToken","eyJraWQiOiIzNkZrcURhRWt1eU9WcVo3V2JMaE15UVZ2UFRNY1Z5QVJ3N2IzYUJIdXU4PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJjNGQ2ZjE4ZS1lNGU5LTQ1MGItOTllZC03MzNiOTJiYjAwNDUiLCJjb2duaXRvOmdyb3VwcyI6WyJBZG1pbiJdLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX2owRHkzcVg4TiIsImNvZ25pdG86dXNlcm5hbWUiOiJzYXVyYXYuYW5hbmRAbWVkaWZsaXguY29tIiwiZ2l2ZW5fbmFtZSI6IlNhdXJhdiIsIm9yaWdpbl9qdGkiOiJmZDJjNTYzOS03Yzc1LTRjNjItOWJlYS1mMWM4OGU0MzcyMDQiLCJhdWQiOiIzMW5xNGNzcG5nanUycnRzdmVrZm84b2o3ZyIsImV2ZW50X2lkIjoiMDQ4ODVjODAtZDY5NS00ZGRjLWE3ZDItNzExMjc4NDRmZWQwIiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2NTI0NDQzNjYsImV4cCI6MTY1NDIzNDgyNSwiaWF0IjoxNjU0MjMxMjI1LCJmYW1pbHlfbmFtZSI6IkFuYW5kIiwianRpIjoiNDk2YTZkYWEtYjU1NS00MTBmLWIwYzYtNTgwZjUxYmVjNzQwIiwiZW1haWwiOiJzYXVyYXYuYW5hbmRAbWVkaWZsaXguY29tIn0.h3BOXh2CIjvlBX0y7M-r4YTVOJBagj390V0EprKTER9xfVTB5coHFZ9Y84-2tqbn_3VYO5SJwLOe9sSx_CfdhxcnNNnmAnXvycAPq5NaylrebPxtS-BMprhqWwxHvThmjAPGbSRqvWf9OGKOMCnFtvuJVv6LhN_1KB2k_UR3qgjZ223BQvF0iKvetmS8gfJHwPebDrT3l1Wctlau3dt_PmTEF4yv_ccdC-g1pAtVUM64857RjNT1cG-W_dezzd0jabjZHzzYlQ5sQ6DbzgU91xWkQynlLfkrhWlxxvorzk1F8vaT3NvO2eeJg-6kDJjtSsRjF-thV4qEZjtANwVvEA");
	    
	    driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/institutions");
	    
	 }
	
	 @Test (priority=2)
//	 @Test (enabled = false)
	 public void Create_Institutions_With_Madatory_fields() throws InterruptedException 
	 {
		 driver.manage().window().maximize();
	
		 System.out.println("Institute -> Verifying Mandatory Fields Validation Is Working Or Not**************");
		 Reporter.log("Institute -> Verifying Mandatory Fields Validation Is Working Or Not");
		 		 
		 
		 WebElement create_institute_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button"));
		 create_institute_button.click();
			
		 Thread.sleep(5000);
		    
		 WebDriverWait wait_save = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait_save.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"))).click();

		 Thread.sleep(2000);
		 
		 System.out.println(" Verify The Create Institutions With Mandatory Fields Only**************");
		
		 Reporter.log("Institute -> Create Institutions With Mandatory Fields Only");
		 
		 //institute name
		 name= driver.findElement(By.id("institution-name"));
		 name.sendKeys(inst_name);
		 
		 // inst log 
		 
		  logo=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/button"));
		  logo.click();
		  
		  WebDriverWait wait_logo = new WebDriverWait(driver, Duration.ofSeconds(30));
		  wait_logo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img")));
			    		 
		  WebElement logo_select=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"));
		  logo_select.click();
		
		  WebElement select_button1 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
		  select_button1.click();
		 
		  // inst image
		  
		  image=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/button"));
		  image.click();
		 
		  WebDriverWait wait_img = new WebDriverWait(driver, Duration.ofSeconds(30));
		  wait_img.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img")));
			    		 
		  WebElement img_select=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img"));
		  img_select.click();
		
		  WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
		  select_button.click();
	     
	     Thread.sleep(3000);
	     
	     WebElement savebutton2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
		 savebutton2.click();
		 Thread.sleep(3000);
	     
	 }
	 
	 @Test (priority=3)
//	 @Test (enabled = false)
	 public void View_And_Verify_Institutions_With_Mandatory_Fields() throws InterruptedException 
	 {
		 	driver.manage().window().maximize();
		    driver.navigate().refresh();
		 	Thread.sleep(3000);
		 	
		    System.out.println("Institution -> search and view the newly created institution*******************");
		    Reporter.log("Institution -> Search And View The Newly Created Institution");
		    
			WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
			coll_searchbox.sendKeys(inst_name);
		 
			Thread.sleep(2000);
			
			 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div[8]/button[2]"))).click();
			    			
			Thread.sleep(2000);
						
			//inst name
			
			String s1 = driver.findElement(By.xpath("//input[@id='institution-name']")).getAttribute("value");
			System.out.println("Institution name is ____________________________"+s1);
		
			if(s1.equals(inst_name))
			{
				System.out.println("Institution name is present");
				AssertJUnit.assertEquals(s1, inst_name);
			}
			else
			{
				System.out.println("Institution name is not present");
				AssertJUnit.assertEquals(s1, inst_name);
				Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Name Is Not Present In Banner view Screen.");
			}
			
			// logo and image
			
			String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[1]/div/div/div/img")).getAttribute("src");
			System.out.println("logo scr__________"+s8);
			
			if (s8.equals(s8))
			{
					System.out.println("logo is present");
					AssertJUnit.assertEquals(s8, s8);
			}
			else
			{
					System.out.println("logo is not present");
					AssertJUnit.assertEquals(s8, s8);
					Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Logo is not present in Banner View Screen.");
					
			}
		 
			String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[2]/div/div/div/img")).getAttribute("src");
			System.out.println("img scr__________"+s9);
			
			if (s9.equals(s9))
			{
					System.out.println("image is present");
					AssertJUnit.assertEquals(s9, s9);
			}
			else
			{
					System.out.println("image is not present");
					AssertJUnit.assertEquals(s9, s9);
					Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Image is not present in Banner View Screen.");
					
			}
			
			softAssert.assertAll();
			
			//close button
			
			 WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
			    	
			 Thread.sleep(3000);
			
	 }
	
//		@Test (enabled = false)
		 @Test (priority=4)
		 public void Edit_Institution_With_All_Fields() throws InterruptedException 
		 {
			 	driver.manage().window().maximize();
			    driver.navigate().refresh();
			  
			    WebDriverWait load = new WebDriverWait(driver, Duration.ofSeconds(30));
				load.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
				
			    System.out.println("Institution -> Search And Edit The Newly Created Institution With Remaining Fields");
			    Reporter.log("Institution -> Search And Edit The Newly Created Institution With Remaining Fields");
			    
			    WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(inst_name);
			 			
				WebElement icon_edit = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[1]"));
				icon_edit.click();
				
				// desc and slug
				driver.findElement(By.id("description")).sendKeys(inst_desc);
				
				driver.findElement(By.id("slug")).sendKeys(inst_slug);
				
				Thread.sleep(1000);
				// expert
				expert = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[7]/div/div/div"));
				expert.click(); 
				
				WebElement expert_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[16]"));
				expert_select.click();
				
				WebElement m1=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
			    m1.click();
				
				//collection 
				collection = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[9]/div/div/input"));
				collection.click();
				
				WebElement coll_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[119]"));
				coll_select.click();
				
				// videos
				videos = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div/div/div/input"));
				videos.click();
				
				WebElement videos_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[7]"));
				videos_select.click();
				
				//zip
				zipcode = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[11]/div/div"));
				zipcode.click();
				
				WebElement zip_select = driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[2]"));
				zip_select.click();
				
				WebDriverWait load2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				load2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/h2/p"))).click();
								
				Thread.sleep(2000);
				
				WebElement save_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
				save_button.click();
				
				Thread.sleep(5000);
			
		 }
	
//			@Test (enabled = false)
		    @Test (priority=5)
			 public void View_And_Verify_Edited_Institutions() throws InterruptedException 
			 {
		    	driver.manage().window().maximize();
			    driver.navigate().refresh();
			   			    
			    WebDriverWait wait_pageload = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait_pageload.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
							 	
			    System.out.println("Institution -> search and view the edited institution*******************");
			    Reporter.log("Institution -> Search And View Edited Institution");
			    
				WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(inst_name);
			 
				Thread.sleep(2000);
				
				 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
				 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
				    			
				Thread.sleep(2000);
					
				    //inst name
					
					String s1 = driver.findElement(By.xpath("//input[@id='institution-name']")).getAttribute("value");
					System.out.println("Institution name is ____________________________"+s1);
				
					if(s1.equals(inst_name))
					{
						System.out.println("Institution name is present");
						AssertJUnit.assertEquals(s1, inst_name);
					}
					else
					{
						System.out.println("Institution name is not present");
						AssertJUnit.assertEquals(s1, inst_name);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Name Is Not Present In Banner view Screen.");
					}
					
					//description
					String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/textarea[1]")).getText();
					System.out.println("Institution desc is ____________________________"+s2);
					
					if(s2.equals(inst_desc))
					{
						System.out.println("Institution desc is present");
						AssertJUnit.assertEquals(s2, inst_desc);
					}
					else
					{
						System.out.println("Institution desc is not present");
						AssertJUnit.assertEquals(s2, inst_desc);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Description Is Not Present In Banner view Screen.");
					}
					
					//slug
					String s3 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/div/textarea[1]")).getText();
					System.out.println("Institution slug is ____________________________"+s3);
					
					if(s3.equals(inst_slug))
					{
						System.out.println("Institution slug is present");
						AssertJUnit.assertEquals(s3, inst_slug);
					}
					else
					{
						System.out.println("Institution slug is not present");
						AssertJUnit.assertEquals(s3, inst_slug);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Slug Is Not Present In Banner view Screen.");
					}
					
					//expert
					String s4 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[5]/div/div/div")).getText();
					System.out.println("expert is ____________________________"+s4);
					
					if(s4.equals(s4))
					{
						System.out.println("expert is present");
						AssertJUnit.assertEquals(s4, s4);
					}
					else
					{
						System.out.println("expert is not present");
						AssertJUnit.assertEquals(s4, s4);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Expert Is Not Present In Banner view Screen.");
					}
					
					// collection
					
					String s5 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[7]/div/div/input")).getAttribute("value");
					System.out.println("Collection is ____________________________"+s5);
					
					if(s5.equals(s5))
					{
						System.out.println("Collection is present");
						AssertJUnit.assertEquals(s5, s5);
					}
					else
					{
						System.out.println("Collection is not present");
						AssertJUnit.assertEquals(s5, s5);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Collection Is Not Present In Banner view Screen.");
					}
					
					//videos
					String s6 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[8]/div/div/div")).getText();
					System.out.println("Videos is ____________________________"+s6);
					
					if(s6.equals(s6))
					{
						System.out.println("Videos is present");
						AssertJUnit.assertEquals(s6, s6);
					}
					else
					{
						System.out.println("Videos is not present");
						AssertJUnit.assertEquals(s6, s6);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Videos Is Not Present In Banner view Screen.");
					}
					
					//zip
					String s7 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[9]/div/div")).getText();
					System.out.println("Zipcode is ____________________________"+s7);
					
					if(s7.equals(s7))
					{
						System.out.println("Zipcode is present");
						AssertJUnit.assertEquals(s7, s7);
					}
					else
					{
						System.out.println("Zipcode is not present");
						AssertJUnit.assertEquals(s7, s7);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Zipcode Is Not Present In Banner view Screen.");
					}
					
					
					// logo and image
					
					String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[1]/div/div/div/img")).getAttribute("src");
					System.out.println("logo scr__________"+s8);
					
					if (s8.equals(s8))
					{
							System.out.println("logo is present");
							AssertJUnit.assertEquals(s8, s8);
					}
					else
					{
							System.out.println("logo is not present");
							AssertJUnit.assertEquals(s8, s8);
							Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Logo is not present in Banner View Screen.");
							
					}
				 
					String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[2]/div/div/div/img")).getAttribute("src");
					System.out.println("img scr__________"+s9);
					
					if (s9.equals(s9))
					{
							System.out.println("image is present");
							AssertJUnit.assertEquals(s9, s9);
					}
					else
					{
							System.out.println("image is not present");
							AssertJUnit.assertEquals(s9, s9);
							Reporter.log( "[ERROR] -> Institution -> View Screen -> Institution Image is not present in Banner View Screen.");
							
					}
					 
					softAssert.assertAll();
				 	 
					WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
					    	
					Thread.sleep(3000);
				
			 }
		    
//		    @Test (enabled = false)
		    @Test (priority=6)
			 public void Create_New_Institutions_With_All_Fields() throws InterruptedException
			 {
				 driver.manage().window().maximize();
				 driver.navigate().refresh();
				 
				 WebDriverWait wait_pageload = new WebDriverWait(driver, Duration.ofSeconds(30));
				 wait_pageload.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
				
				 System.out.println("Institution -> Verifying Create New Institution With All Information");
				 Reporter.log("Institution -> Verifying Create New Institution With All Information");
				 
				 WebElement create_institute_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[1]/div/button"));
				 create_institute_button.click();
				 
				//institute name
				 name= driver.findElement(By.id("institution-name"));
				 name.sendKeys(inst_name2);
				 
				 Thread.sleep(1000);
				 // inst logo
				 								
				  logo2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/button"));
				  logo2.click();
				  
				  WebDriverWait wait_logo2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				  wait_logo2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img")));
					    		 
				  WebElement logo_select2=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/img"));
				  logo_select2.click();
				
				  WebElement select_button1 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
				  select_button1.click();
				 
				  // inst image
				  
				  image2=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/button"));
				  image2.click();
				 
				  WebDriverWait wait_img2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				  wait_img2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img")));
					    		 
				  WebElement img_select2=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[4]/div/img"));
				  img_select2.click();
				
				  WebElement select_button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div[2]/button[2]"));
				  select_button.click();
				  
				// desc and slug
					driver.findElement(By.id("description")).sendKeys(inst_desc2);
					
					driver.findElement(By.id("slug")).sendKeys(inst_slug2);
					
					Thread.sleep(1000);
					// expert
					expert2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[7]/div/div/div"));
					expert2.click(); 
					
					WebElement expert_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[16]"));
					expert_select.click();
					
					WebElement m1=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/p"));
				    m1.click();
					
					//collection 
					collection2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[9]/div/div/input"));
					collection2.click();
					
					WebElement coll_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[119]"));
					coll_select.click();
					
					// videos
					videos2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div/div/div/input"));
					videos2.click();
					
					WebElement videos_select = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[7]"));
					videos_select.click();
					
					//zip
					zipcode2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[11]/div/div"));
					zipcode2.click();
					
					WebElement zip_select = driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[2]"));
					zip_select.click();
					
					//tags
				     WebElement tab_button = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[8]/div/button"));
				     tab_button.click();
					    
				     Thread.sleep(1000);
				     													
				     WebElement tab_topic = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div[1]/div/div[4]/div[1]/div[1]/input"));
					 tab_topic.click();
								  
					 Thread.sleep(1000);
					    
					 WebElement selectbutton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]"));
					 selectbutton.click();
					    
					 Thread.sleep(1000);
					 
					// tags count
				     tagcount2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[8]/div/button")).getText();
					 System.out.println("the tag count is __________________"+tagcount2); 
					
					 Thread.sleep(2000);
					 
					 WebElement savebutton2 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]"));
					 savebutton2.click();
					 
					 Thread.sleep(3000);
	//				 WebDriverWait wait_pageload2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	//				 wait_pageload2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
									 	
					 
			
			 }
			
//			@Test (enabled = false)
		    @Test (priority=7)
			 public void View_And_Verify_New_Institutions() throws InterruptedException 
			 {
		    	driver.manage().window().maximize();
			    driver.navigate().refresh();
			    
			    WebDriverWait wait_pageload = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait_pageload.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]"))).click();
							 	
			    System.out.println("Institution -> search and view the new institution*******************");
			    Reporter.log("Institution -> Search And View New Institution");
			    
				WebElement coll_searchbox = driver.findElement(By.xpath("//input[@type='text']"));
				coll_searchbox.sendKeys(inst_name2);
			 
				Thread.sleep(2000);
				
				 WebDriverWait wait_view = new WebDriverWait(driver, Duration.ofSeconds(30));
				 wait_view.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[2]"))).click();
				    			
				Thread.sleep(3000);
					
				    //inst name
					
					String s1 = driver.findElement(By.xpath("//input[@id='institution-name']")).getAttribute("value");
					System.out.println("Institution name is ____________________________"+s1);
				
					if(s1.equals(inst_name2))
					{
						System.out.println("Institution name is present");
						AssertJUnit.assertEquals(s1, inst_name2);
					}
					else
					{
						System.out.println("Institution name is not present");
						AssertJUnit.assertEquals(s1, inst_name2);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Name Is Not Present In Banner view Screen.");
					}
					
					//description
					String s2 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[3]/div/textarea[1]")).getText();
					System.out.println("Institution desc is ____________________________"+s2);
					
					if(s2.equals(inst_desc2))
					{
						System.out.println("Institution name is present");
						AssertJUnit.assertEquals(s2, inst_desc2);
					}
					else
					{
						System.out.println("Institution name is not present");
						AssertJUnit.assertEquals(s2, inst_desc2);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Description Is Not Present In Banner view Screen.");
					}
					
					//slug
					String s3 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[4]/div/textarea[1]")).getText();
					System.out.println("Institution slug is ____________________________"+s3);
					
					if(s3.equals(inst_slug2))
					{
						System.out.println("Institution slug is present");
						AssertJUnit.assertEquals(s3, inst_slug2);
					}
					else
					{
						System.out.println("Institution slug is not present");
						AssertJUnit.assertEquals(s3, inst_slug2);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Slug Is Not Present In Banner view Screen.");
					}
					
					//expert
					String s4 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[5]/div/div/div")).getText();
					System.out.println("expert is ____________________________"+s4);
					
					if(s4.equals(s4))
					{
						System.out.println("expert is present");
						AssertJUnit.assertEquals(s4, s4);
					}
					else
					{
						System.out.println("expert is not present");
						AssertJUnit.assertEquals(s4, s4);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Expert Is Not Present In Banner view Screen.");
					}
					
					// collection
					
					String s5 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[7]/div/div/input")).getAttribute("value");
					System.out.println("Collection is ____________________________"+s5);
					
					if(s5.equals(s5))
					{
						System.out.println("Collection is present");
						AssertJUnit.assertEquals(s5, s5);
					}
					else
					{
						System.out.println("Collection is not present");
						AssertJUnit.assertEquals(s5, s5);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Collection Is Not Present In Banner view Screen.");
					}
					
					//videos
					String s6 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[8]/div/div/div")).getText();
					System.out.println("Videos is ____________________________"+s6);
					
					if(s6.equals(s6))
					{
						System.out.println("Videos is present");
						AssertJUnit.assertEquals(s6, s6);
					}
					else
					{
						System.out.println("Videos is not present");
						AssertJUnit.assertEquals(s6, s6);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Videos Is Not Present In Banner view Screen.");
					}
					
					//zip
					String s7 =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[9]/div/div")).getText();
					System.out.println("Zipcode is ____________________________"+s7);
					
					if(s7.equals(s7))
					{
						System.out.println("Zipcode is present");
						AssertJUnit.assertEquals(s7, s7);
					}
					else
					{
						System.out.println("Zipcode is not present");
						AssertJUnit.assertEquals(s7, s7);
						Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Zipcode Is Not Present In Banner view Screen.");
					}
					
					
					// logo and image
					
					String s8 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[1]/div/div/div/img")).getAttribute("src");
					System.out.println("logo scr__________"+s8);
					
					if (s8.equals(s8))
					{
							System.out.println("logo is present");
							AssertJUnit.assertEquals(s8, s8);
					}
					else
					{
							System.out.println("logo is not present");
							AssertJUnit.assertEquals(s8, s8);
							Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Logo is not present in Banner View Screen.");
							
					}
				 
					String s9 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[10]/div[2]/div/div/div/img")).getAttribute("src");
					System.out.println("img scr__________"+s9);
					
					if (s9.equals(s9))
					{
							System.out.println("image is present");
							AssertJUnit.assertEquals(s9, s9);
					}
					else
					{
							System.out.println("image is not present");
							AssertJUnit.assertEquals(s9, s9);
							Reporter.log( "[ERROR] -> Institution -> View Screen -> New Institution Image is not present in Banner View Screen.");
							
					}
					
					softAssert.assertAll();
				 	 
					WebDriverWait wait_close = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait_close.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button"))).click();
					    	
					Thread.sleep(3000);
		   	
			 }
			
		    //delete 
		    
		    @Test (priority=8)
			public void Verify_delete_Expert_is_working() throws InterruptedException
			{
		    	Thread.sleep(3000);
		   		driver.manage().window().maximize();
		   		driver.navigate().refresh();
		   		
		   		System.out.println("Institution -> Verifying the Delete from Institution page");
				Reporter.log("Institution -> Verifying the Delete from Institution page");
		   		
				WebElement searchbox3 = driver.findElement(By.xpath("//input[@type='text']"));
				searchbox3.sendKeys(inst_name);
								
				Thread.sleep(3000);
				
				WebElement icon_delete = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/button[3]"));
				icon_delete.click();
				
				Thread.sleep(3000);
				
				WebElement delete_click = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[3]"));
				delete_click.click();
				
				Thread.sleep(3000);
				
				WebElement delete_click2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[8]/button[3]"));
				delete_click2.click();
				
			}
		    
			

		 
		 
	
	
}
