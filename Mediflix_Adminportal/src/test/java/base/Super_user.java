package base;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class Super_user 
{
	    
	public static ChromeDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	 
	    
	@BeforeTest 
	public void Local_Storage() throws InterruptedException, IOException
	{
		FileInputStream objfile = new FileInputStream("C:\\Users\\Prasad_aute\\git\\Mediflix-Admin-Automation\\Mediflix_Adminportal\\src\\test\\resources\\Properties\\mediflix.properties");									
        prop.load(objfile);		
        
		System.setProperty("webdriver.chrome.driver", "C://Users//Prasad_aute//Downloads//selenium/108/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://admin-portal.us-east-1.dev.mediflix.com");

	    LocalStorage local = ((WebStorage) driver).getLocalStorage();    
	    local.setItem("persist:root","{\"user\":\"{\\\"data\\\":{\\\"sub\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"cognito:groups\\\":[\\\"admin\\\",\\\"patient\\\"],\\\"iss\\\":\\\"https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Queq8DO0E\\\",\\\"cognito:username\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"origin_jti\\\":\\\"286bbd17-c847-4f54-bb6f-8c36d03b1d93\\\",\\\"aud\\\":\\\"16vn2ni6d429tfd3mi86refk2p\\\",\\\"event_id\\\":\\\"52a06452-f2f1-4e06-9e70-3fab713163ef\\\",\\\"token_use\\\":\\\"id\\\",\\\"auth_time\\\":1665722626,\\\"name\\\":\\\"shivraj2\\\",\\\"phone_number\\\":\\\"+919834330981\\\",\\\"exp\\\":1665735231,\\\"iat\\\":1665731631,\\\"jti\\\":\\\"2da99bab-1d2e-4f71-abe2-5f03de5d3ccd\\\",\\\"email\\\":\\\"shivrajtech37@gmail.com\\\"},\\\"logged\\\":true,\\\"logging\\\":false,\\\"loginError\\\":null,\\\"validating\\\":false,\\\"getOtp\\\":false,\\\"retrievingAll\\\":false,\\\"retrievingAllError\\\":{\\\"message\\\":\\\"Response not JSON\\\",\\\"status\\\":401},\\\"updating\\\":false,\\\"updateError\\\":null,\\\"updated\\\":false,\\\"updatedPassword\\\":false,\\\"updatingPassword\\\":false,\\\"updatePasswordError\\\":null}\",\"_persist\":\"{\\\"version\\\":-1,\\\"rehydrated\\\":true}\"}");
	    
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.316c0afc-19df-4c87-ae0a-0f61bb60a6b4.clockDrift","0");
	    local.setItem("amplify-signin-with-hostedUI","false");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.316c0afc-19df-4c87-ae0a-0f61bb60a6b4.userData","{\"PreferredMfaSetting\":\"SMS_MFA\",\"UserAttributes\":[{\"Name\":\"sub\",\"Value\":\"316c0afc-19df-4c87-ae0a-0f61bb60a6b4\"},{\"Name\":\"name\",\"Value\":\"Saurav Anand\"},{\"Name\":\"phone_number\",\"Value\":\"+918340328513\"},{\"Name\":\"email\",\"Value\":\"anandsaurav6@gmail.com\"}],\"UserMFASettingList\":[\"SMS_MFA\"],\"Username\":\"316c0afc-19df-4c87-ae0a-0f61bb60a6b4\"}");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.316c0afc-19df-4c87-ae0a-0f61bb60a6b4.idToken","eyJraWQiOiIrMDBqWVZCZVhOQVwvTkpVa1FEa0dkUHdzM1NJSjNkVVRYTUI4VGNGa3VGZz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzMTZjMGFmYy0xOWRmLTRjODctYWUwYS0wZjYxYmI2MGE2YjQiLCJjb2duaXRvOmdyb3VwcyI6WyJzdXBlcmFkbWluIiwiYWRtaW4iLCJwYXRpZW50Il0sImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX1F1ZXE4RE8wRSIsImNvZ25pdG86dXNlcm5hbWUiOiIzMTZjMGFmYy0xOWRmLTRjODctYWUwYS0wZjYxYmI2MGE2YjQiLCJvcmlnaW5fanRpIjoiMGNkMmMyMzItZGRhYy00YWFkLWEzMjAtNTBkN2IwNDc4ZDUwIiwiYXVkIjoiMTZ2bjJuaTZkNDI5dGZkM21pODZyZWZrMnAiLCJldmVudF9pZCI6ImFiYTM1MTkwLTY3NjUtNDM1OS04NmVkLWIzZTkyOWUxMzkyOSIsInRva2VuX3VzZSI6ImlkIiwiYXV0aF90aW1lIjoxNjcwNDA1MzcxLCJuYW1lIjoiU2F1cmF2IEFuYW5kIiwicGhvbmVfbnVtYmVyIjoiKzkxODM0MDMyODUxMyIsImV4cCI6MTY3MDQ4MDc3MywiaWF0IjoxNjcwNDc3MTczLCJqdGkiOiIyM2FkNGU3MS1jY2MwLTQyZmEtOGYyMi05YmJlM2NlNTU1ZGIiLCJlbWFpbCI6ImFuYW5kc2F1cmF2NkBnbWFpbC5jb20ifQ.rfqbbYgyEYOJDdJsw9zE3mkSx8bESUguPE5u86NIj-X9yFd41RXpsIQDcJBU0v2JCBkxzzifapa97HTs6dBMWiaPCFM4_yAZZ-Fd51QKmyyElFG7wn98LnnFtXbp9Leo37YxYxlYVWSpXs6dHX-9qnYfHJfj-VOspNFICNOLjSBUvGlKLLWmDXoGZEg4fpcLbSMAs8MolDmpl5M8xCQRWGbb-q4du4LZDBxcd7mC83AY2VdUmswkr50zH6r3jHa8Tfdktogj2HxfgvsUIbTemmFhvT7hm_Q9560jXIWWt6ipJrEbUtW6aqOz6G63zwmIZIurz7dBQnVVvG9ez7LGmw");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.LastAuthUser","316c0afc-19df-4c87-ae0a-0f61bb60a6b4");
	    local.setItem("accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzMTZjMGFmYy0xOWRmLTRjODctYWUwYS0wZjYxYmI2MGE2YjQiLCJjb2duaXRvOmdyb3VwcyI6WyJzdXBlcmFkbWluIiwiYWRtaW4iLCJwYXRpZW50Il0sImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX1F1ZXE4RE8wRSIsImNsaWVudF9pZCI6IjE2dm4ybmk2ZDQyOXRmZDNtaTg2cmVmazJwIiwib3JpZ2luX2p0aSI6IjBjZDJjMjMyLWRkYWMtNGFhZC1hMzIwLTUwZDdiMDQ3OGQ1MCIsImV2ZW50X2lkIjoiYWJhMzUxOTAtNjc2NS00MzU5LTg2ZWQtYjNlOTI5ZTEzOTI5IiwidG9rZW5fdXNlIjoiYWNjZXNzIiwic2NvcGUiOiJhd3MuY29nbml0by5zaWduaW4udXNlci5hZG1pbiIsImF1dGhfdGltZSI6MTY3MDQwNTM3MSwiZXhwIjoxNjcwNDgwNzczLCJpYXQiOjE2NzA0NzcxNzMsImp0aSI6IjUyNGFlY2YyLTM0MTMtNDQ2Mi1hNzFmLTRlNWQyNTk3ZGNiZiIsInVzZXJuYW1lIjoiMzE2YzBhZmMtMTlkZi00Yzg3LWFlMGEtMGY2MWJiNjBhNmI0In0.Ixvcxnp4awqb6r8MHMvH5R_554QZuk_AwwTDDPeM463o2XbvrnT2zpIdYvwV0jgUy39mKvL_ps8obGl6UKPZkIWqBEfT3A1OVrSAtRAAi5ANG6UWAa7tCJj3k7hrrj93MGt45gB_ZQpv5SYUe11G-8nTyA3Xh5MTVYJQy2mdLx6cyjvsZBoYz6ze82QU9tL5KyFSKHShWI7G2c6SV_NrCvz5_xD9ONnKROtyN3iCrHzvFgIMz4bkYax7Z0VUbwK_7CCWmhWdXl1z8Wvt-HGHO2TZPuQ9dJsg4ZplFZ8ksRMWoIpizrH820IE44HPl1yF9peXV1b5OloPSCQ33AJztg");
	    local.setItem("userRole","superadmin");
	    local.setItem("userPhoneNumber","+********8513");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.316c0afc-19df-4c87-ae0a-0f61bb60a6b4.accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzMTZjMGFmYy0xOWRmLTRjODctYWUwYS0wZjYxYmI2MGE2YjQiLCJjb2duaXRvOmdyb3VwcyI6WyJzdXBlcmFkbWluIiwiYWRtaW4iLCJwYXRpZW50Il0sImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX1F1ZXE4RE8wRSIsImNsaWVudF9pZCI6IjE2dm4ybmk2ZDQyOXRmZDNtaTg2cmVmazJwIiwib3JpZ2luX2p0aSI6IjBjZDJjMjMyLWRkYWMtNGFhZC1hMzIwLTUwZDdiMDQ3OGQ1MCIsImV2ZW50X2lkIjoiYWJhMzUxOTAtNjc2NS00MzU5LTg2ZWQtYjNlOTI5ZTEzOTI5IiwidG9rZW5fdXNlIjoiYWNjZXNzIiwic2NvcGUiOiJhd3MuY29nbml0by5zaWduaW4udXNlci5hZG1pbiIsImF1dGhfdGltZSI6MTY3MDQwNTM3MSwiZXhwIjoxNjcwNDgwNzczLCJpYXQiOjE2NzA0NzcxNzMsImp0aSI6IjUyNGFlY2YyLTM0MTMtNDQ2Mi1hNzFmLTRlNWQyNTk3ZGNiZiIsInVzZXJuYW1lIjoiMzE2YzBhZmMtMTlkZi00Yzg3LWFlMGEtMGY2MWJiNjBhNmI0In0.Ixvcxnp4awqb6r8MHMvH5R_554QZuk_AwwTDDPeM463o2XbvrnT2zpIdYvwV0jgUy39mKvL_ps8obGl6UKPZkIWqBEfT3A1OVrSAtRAAi5ANG6UWAa7tCJj3k7hrrj93MGt45gB_ZQpv5SYUe11G-8nTyA3Xh5MTVYJQy2mdLx6cyjvsZBoYz6ze82QU9tL5KyFSKHShWI7G2c6SV_NrCvz5_xD9ONnKROtyN3iCrHzvFgIMz4bkYax7Z0VUbwK_7CCWmhWdXl1z8Wvt-HGHO2TZPuQ9dJsg4ZplFZ8ksRMWoIpizrH820IE44HPl1yF9peXV1b5OloPSCQ33AJztg");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.316c0afc-19df-4c87-ae0a-0f61bb60a6b4.refreshToken","eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.VKWGOoIs0WQ7x31_tKC5nVDn6YGxSTMheChXOFvEexHwtBVDlbvCf4a9_rFCrUIOJW5Hy5-3JVF8iyyqW--DUIK05BbjRmm6kiM4P1ZwgU6F-0dydVIcvH1yYV-5HxxocjHciZBhCokSj5EYi6ZUoT_JkS-P8bGd65Dr2-kidHOI_pWwsTSoNKiktO9ACEAnbHKP8i4GXSXEDq9nxqmQDI6HEiVMsAuqe_Dk4_GD0dD6ekmFrTmII1XBrJnBmMtuEJRXymdqyOqaAOobFH1J331n_KmQOdFz1mbMlPeMoSwSIkVtO_Ce4wjXzEUa2dQ216bV8Y_YGmNHob1wcqvNQg.OLCceA2bsw_6coBi.5JEblvvkktSFaOneSde0o6T1JMfFyfbVPxrgH6ntmd2zeiFOUZSxDsg5CzK-98NUhMdkfL2-KCwKQCKp_f7VNz1mg-qZaZPvidP_dLWhH526oJAjqrIwSJdjVnQekgNgujvNXYmk2kzKyWyjKxPrKtX7wUW7dg97bgND880URBvDiqJw8GgOrH8QJawQFxxPmy8rNo8rwWtJDzRl1xhEovMI87wff5s2id2eBimViceYe1ZBUeyiU5QpMe3L2hLHQ_CpxDoE6O1H4OtbKchcbtKg1JwiDNkH6WX2TdtAVBvghEfVFstmia4ayr0bfU6DnDpYOp74xhFENK-whC455FfLxgcVg-x_A9PGos9niFYL1Niv1HowplOzb7WWITyFn4mIGxCKmAgB6u6hffx6fq3tK_3Ky9zJm0pbI8OeFSKVHksNQ2HArBZG_dlt99o37whGwDSk1RuuVHCwz4zOATAo9Sg_wn4fSiGiqn-3qNRb0lxIYfYxT3nB93tp8LAyicXeI5lFse4ZfjVcB4Ga2S1D3tOayXoONYrdBRhKaLQG-SnphNT8UovIPQnDLl8Tzz3nqY11_FWe1rB1GFCqFfehEtAY0Owq8udCeI6EPmJ_R35H7YTzJEBdm9TgDoSLCw617wzhQXZZFWE9M805ZTsYJvAP8GDWR74P-3t_I12alE5sqWkios2AUmJFUmpcvo_IjG7-xMUkcpBWC1evy1Y7dR8JqR6tolleOeahQCjHnvQzoR0nuiIbOFmEWcx_9mLNqQe9h9Xgy4pLAmtPKlW2PVZeTK3P-r7TkkuS1fqITRpDVkKGoHOH6MdRo1FRVjc--nIXuNHmfGL9UStWt3jSSGtAvbJ22mzjFpRuuE6pusgmNbP5tmynRh4rN2KA_XLiGZIGqlPPsJ4TewoUg5fDcGorUBn9eAVgHVD0HDRpYRDfkUXqcznlkpe9v9_n9S1b7XqhS0XPb8_RnAPgdIV24ujLYFmw6Sd_J8Rj2i3Fmgnks8385VcjDiw9c7VJEmMvG9HHkCe5IvRPGtT5FKyy3FWqkX5FyrtRzitkbA7Jx7ayQV7EQdi5r0PPRQZdGGINfCme4QK83x7M8FTUJ7W3K-cV0dKwjuwENG0MQE9zjUjhe1WbW5Dt0csARiYTz_tR6H5Iqn7HcLL7EsULJYgjZU00pLvdasCtOptzbatAxec_jAZhQHt1oDUv7zXQsluoXJuKrBUM_7CJOVkdbvnTsjXpSTUBWgOR4OLwf2WQwJ7_pV_ld6Q4lkPS8xg2wWPw5q6TW5tuYiTTAaPaA7SFP4wvF9J7XEOaGr11ncdrD6SREu6qXaWB6A.6ZVY7QZfQAVG73jj4nPAgQ");
	    
	    driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com/");
	       	    
	 }
	 
	
	@AfterTest
	 public void closeBrowser() 
	 {
	 	driver.quit();
	 	
	 }
	

}
