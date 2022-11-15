package base;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class admin_user 
{
	public static ChromeDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;

	@BeforeTest
	public void Local_Storage()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Prasad_aute//Downloads//selenium/106/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://admin-portal.us-east-1.dev.mediflix.com");

	    LocalStorage local = ((WebStorage) driver).getLocalStorage();    

	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.LastAuthUser","saurav.anand@mediflix.com");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.deviceGroupKey","-9b0ne3AP");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.refreshToken","eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.WMVv2mDiJg1pCm4kcpMGlFPuUWwQLnSgqS2XOmN4CltuLicmpdgx8oqbRFP6pSg17orOnGrPzyTzmoiKQ5kgDpaAerBooReA56ZRlhnIuzCaPgyHzcvfUqRajtpdjX5UyYVFuNajowLnNkOk9TktDLuR57efcTusld0gR7QfFL7e0V_QbiCPeutkvdB-wWnhz2ZnECGKiw5eGIwQZLt7PwIKBR3jt7i49eFD0APqbE6p4GqJijBerdoz0wOsyVE4juG6BeQrhEHUwReLPlhja_RnS0lxOB_hSPeF0s7J05Zy0QCrRkiu0Czdy01Wv0IWmkeSPBiipf4u7e9aDbSPDw.YNv_gfqiqIBEdKlX.uz8aa-BH7P-ltcEa-AxSVsEPkvSFGIQbKa2Ep1Ek8XyyfRC_xO8K_JjTBKl1lkCSnG5EC7441b1vufDQeLjM0wo72EZQ4u8M3_AN9RN9YQamm-4ogg9EZ1iPDHcrlZKcC6SW-lxmBZMVXcPiBZRChAdoISXubbVPupBKOl_scIb0HckqE1ed9hkb2N19v63tgqQHp3Ag5kwpiCqm0ph0jp0UqDM8BHAbl_hfSoGb9RsVDK2csI9c9QGxWqjSA0CohWNDjVQyak-5TMqa60jFxc8UdVVfXOKrriS9ZrWhpTREYLM8ZCJ-PHY9HnWoV8n5o_burZw6JypbtWOio8PailtiJD6odLZzQyaairYXIxRamEled56MxUQy0X0D3qBe7xk490HbNdMrNlum_sS04A9tnIeEjCNyFFOmB9qbrfkLNl-nPIhr7f14ZhTuXlmKz23_tfL3QOVwWGoFczbFZ_q8C2bMthqdGrDBLPmcQXBeJFENCsXGW_gJ6FVxbMcm17Oe2rhPmtHfaSKqrSDlVd9o5UCk6S5rkR-ZFMJsBLIcHl72RxEakuM6I3DOxlMYJLELdYBP31EyMZs9b5F8CqVG-3I0Hzs9meYREtV84HwVM5xSx237WoB-W_6Tlwua3J0ysfmEEReaHJUN1b_9jmvgyWfj5TPW2UA3FqODkwQniAXGtEtdsgfv8yrxl6MsMF7XUXK0VpRsFiNNiSQtFswQTOz4fJ29GOdAajkeF2w23viNS-ayJ5Dp6ANWYbLLBqDU2KPJdT6sPPTI2Mo7DoQLUBtWIiYFKqIhtO1jFwGBJJequgQifKr7ODI0JM8IDuScstFcVG6UOEpkJGpkag1kfA46rGl8OG2NfsOi00osgiUdCcGFaoL1M4PuzSanVlo2jqq_5dPe-id9MyjlzkgoJ7gmSM_7Oe08jyxWeAvAnbzpxZxgZYP09TNHE_qnfuLEkFknaCgyvcJEvqCJzKZdXKGqM14iwWBxsmkaTU1xKGZOkSFrBnJbMHGJgxdqhLhZVo3Z1fviYPIvRyMRJ3TjtD1nzo_Oys9nh27q3npqn9-5L5p5rY0lRRmGq5CD6MZj_4Vdy-wiEUCN-0H58Rld-CztADv_s9p2hF61Y1psRcecW7VMb_ECJRZD30AoLrnU6RGC8aqXk9OTVw7pv1UBksk3afcKvpo9IRLA4U_Wa6z23QyqZdQ3hhz8-rK2zDFphn1WC6Pa00kw4urz00-gg1W9e1FVfzumn_f-r8ZIBAjVcDzDQqlO_AHWVZQdJiVqhY4tBj9uHMM8JUZ3N_CzEAi8XeTrdm_IbUP6mIFC5Cy2IPEGr9pNjQ.gp58TqGSS72b5w1KXu7Fbg");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJjb2duaXRvOmdyb3VwcyI6WyJhZG1pbiIsInBhdGllbnQiXSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfUXVlcThETzBFIiwiY2xpZW50X2lkIjoiMTZ2bjJuaTZkNDI5dGZkM21pODZyZWZrMnAiLCJvcmlnaW5fanRpIjoiZjhmNGE4MTItYmJhNy00ZWEwLThmZTUtMGI3NjZkZGEwYzgzIiwiZXZlbnRfaWQiOiJiNTg3MWNjYi1kZjc1LTQyOTAtOGFkNy0xM2MwNDgwYjVmNDkiLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6ImF3cy5jb2duaXRvLnNpZ25pbi51c2VyLmFkbWluIiwiYXV0aF90aW1lIjoxNjY4NTEyMTAyLCJleHAiOjE2Njg1MjAyOTQsImlhdCI6MTY2ODUxNjY5NCwianRpIjoiZDRlNzQ5YjktMjkxNC00YTg1LWJlM2EtYzgxYjFjODNhNzQxIiwidXNlcm5hbWUiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QifQ.fzvE7-W8PQuiXecV7SB1Um6zvvvDMtGUYx1XmYC7OYP7CqRcRVkTlEqKYo0kBJLRJeS_L66RJPeKTztgk3qs34R1nw5kk3NvNnhe6w-nMsCzTWAJVYK3giSW4PoT9ByYQoOzQdD5Hium7MGbVdt64dTP2WeKzUkXB-7fDErHQSkC0YANXxOiMEp9-vgFiJPGVzFHLVk7DZ1FmWBNo7cFqPB1qcvO13uJvcGG0kt2MLQ6RUwr4PlzBMqpGW-TY-BdsSX31pvH6F1Tvsf7LApVV6WnOTtF170bqKKK5GAqk0u__dmyuq2YCBUVSfiQ5xOzYsFKxAj-MOe8c_jMKz00Xw");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.refreshToken","eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.Hx7p23V3Iqqk4nSNbIK-zzqct84fZfNe2jbZxnqyBs6AqeG_2a4hp1QkyZ8t6wKHEDskLmElkyzi4W4gUht4AKQMMEjdOoccb_IGA6TUbYPBKambcY5zOxWizdEv_wig1Gj5wy5EHBpV3neNetWJnDPPLV_tIYZEvgTeEvNIq57EdFbdwCo-mo_FZXjHByvs9JJ92uEgzaN5tQQTWmeDKX4vmZT0Qtcs39RNh0nxXDbbbpiDW64VCHoAftd1gG-jAYrHWnIN_BhVSyL0aETHuDhu5d_LLp0xBCbBEJztextK6ihZwDwB6sCeTwqryrOWekcO7YnbkI4-R8_MVNWRpQ.vVdm-qtf3WimDqbt.bQbimb6IXOhMHyQBkgwTNTgxcHOZDskU-UBaHx7KkoNKqMYxNOxgu1YqOB8NCOs6oEwQQm4t3GvWa3r58fhSwi-SKaGB_vn97TK7DnxbIiMhwXUnFUssbZqg1JUYTlMccYZcl5u_gSmHYdm2D2LpIBCHNXpCEyCY8gZC388RI7IqhtO5vNITpeJ2MuGU5ZmtlKglhGpM-vUA8Q6OZtUQ0_nNKbwHLtpPiavE967KnoXmjXiJSzu-1HVSP5fMvsmoRQ5XIz_OIpqgVeLW8IYUNOJYBEXyImybo2IJDEBf-MLJTFo0LGbR2wFsK4_B-Ew3X8lnTdNBWamiMiEDk12OUAYLskBgCRCjb2hvpwYX2c8Kkf9E5sWE3oNQoeyjG0t-wAX01iH1PzzW2d03is39O0sD8sxYBRHSCjDpf35Tzw-8n0UpYOECMMm1vm72xySChbx1-mb8PFcZo4VXhIs_dNaPVNXMSS_e6OaC3nTbD5ZkFL_Nnun4q2IhPSzLANjOHvVQlmxomublZkmGW_fp30iE9LGx3kqkCbf14HYr_6StaC2n4tjOYnuj8rUKLJciy_yMl0dX331jYJAZarhzWpV4FbcS1ra3mQQrhEiUk0hPv9JolOB6tHDpysCHIy7p-8h5WgRoeESESCxPED2HdYztDbid540i-h-FTBNXFVfsaWaXAi0Ob2fpbsokjgmQI9mj4zGvxamLqujedoL-_mSmTXbwLadETvVsa5Jsv3q8nAwbz06WCY6Wbr8NeYdVH2iUR6CBWNrz5Eoywxzv8lxxeT-rb2oyIaBK_xHLMkQkVMxMzqLj8yuBgBeajylpbZLoZl8JBx6vlvzFrBeHgRsxmL6ncFTehmIRBEsl5qQxEvx88ZWBrzctxG6eBdtWUEY7OPB-1YyEoPB31mrT26DFFMyL2WBKZaT9Aio2-1N3UNq7Mzq6OKyegq3XX-ylzxznYgxx8Js-691M6t486Hk-Q4Nn5iVAaWuoYA53BuPB_FdqZYmjrrqUNqz6uD83MOYOkXL8zM2CZX9jCyxwGSwennUQvu_j-h6mm1O1iBDpBDDbZa9tbiNPXWftVViIs9TWi-AKtXQXlqgS1ROc6Im1G33Bt0EEaJ_raHqMx7bU8sw0c764r_zuiVhTkT-lvqpcpjckUe1EJVgJA75R6stclHCm0aJAW-BD2RHbKFtj5YaSUNn18lpL7xEMKkvGDwvmT8OOqDB9d7fB8lgImeTuXBi1hbgIWid57VXBaXF-wVNfkdNFbji-6tWORe7du00M7CsncDN-rJSRGueZAOFaBwkFBj-8tyAJMDw.NwuAlhQ-MxUlYnRFT7TgYA");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.clockDrift","0");
	    local.setItem("amplify-signin-with-hostedUI","false");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.LastAuthUser","38eaef6d-6a98-454c-b3df-861c17cd1fcd");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.idToken","eyJraWQiOiIrMDBqWVZCZVhOQVwvTkpVa1FEa0dkUHdzM1NJSjNkVVRYTUI4VGNGa3VGZz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJjb2duaXRvOmdyb3VwcyI6WyJhZG1pbiIsInBhdGllbnQiXSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfUXVlcThETzBFIiwiY29nbml0bzp1c2VybmFtZSI6IjM4ZWFlZjZkLTZhOTgtNDU0Yy1iM2RmLTg2MWMxN2NkMWZjZCIsIm9yaWdpbl9qdGkiOiJmOGY0YTgxMi1iYmE3LTRlYTAtOGZlNS0wYjc2NmRkYTBjODMiLCJhdWQiOiIxNnZuMm5pNmQ0Mjl0ZmQzbWk4NnJlZmsycCIsImV2ZW50X2lkIjoiYjU4NzFjY2ItZGY3NS00MjkwLThhZDctMTNjMDQ4MGI1ZjQ5IiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2Njg1MTIxMDIsIm5hbWUiOiJzaGl2cmFqMiIsInBob25lX251bWJlciI6Iis5MTk4MzQzMzA5ODEiLCJleHAiOjE2Njg1MjAyOTQsImlhdCI6MTY2ODUxNjY5NCwianRpIjoiYzVjYjgyMjctMjc0YS00NjU0LWI0NjAtZjBkZTA5NzA4ODFmIiwiZW1haWwiOiJzaGl2cmFqdGVjaDM3QGdtYWlsLmNvbSJ9.nTxMyZ9D_Nzod9b4g3aQuPqmCDYuF43NovssuoDz_zvdTq1LjRykjBcQ-dJTBTERMjowXogGuPJKvjZye7HbMMnP2yJ817F1OQzZB0efjLrj3_l1VZRdWBtk-g9X_tQWSSrApoNcI5G-8SneLedwKcVrava4La_mTxw6zcsv0j8TXPzvRf3BdZli9Q3wd-6-gMpY20wKVrNyln5OiM3WlHLceloL7uVrZqKpPn6TPJ424wFJWsW-fdqdcYvlMMccqbfFK7ZpMX5Q4acFH8zZuBV6WvFID7MNK335ss0SQQAdp33vjsX9aaMWfFpTdRqe4q4VX3WISanrErGtWkA1UA");
	    local.setItem("accessToken","eyJraWQiOiIwdlNjWTFmajFXVTQrQUsxYzN4dFdubWJ3T3hpZkpxRkthZ0pIcWwyYXJ3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QiLCJjb2duaXRvOmdyb3VwcyI6WyJhZG1pbiIsInBhdGllbnQiXSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfUXVlcThETzBFIiwiY2xpZW50X2lkIjoiMTZ2bjJuaTZkNDI5dGZkM21pODZyZWZrMnAiLCJvcmlnaW5fanRpIjoiZjhmNGE4MTItYmJhNy00ZWEwLThmZTUtMGI3NjZkZGEwYzgzIiwiZXZlbnRfaWQiOiJiNTg3MWNjYi1kZjc1LTQyOTAtOGFkNy0xM2MwNDgwYjVmNDkiLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6ImF3cy5jb2duaXRvLnNpZ25pbi51c2VyLmFkbWluIiwiYXV0aF90aW1lIjoxNjY4NTEyMTAyLCJleHAiOjE2Njg1MjAyOTQsImlhdCI6MTY2ODUxNjY5NCwianRpIjoiZDRlNzQ5YjktMjkxNC00YTg1LWJlM2EtYzgxYjFjODNhNzQxIiwidXNlcm5hbWUiOiIzOGVhZWY2ZC02YTk4LTQ1NGMtYjNkZi04NjFjMTdjZDFmY2QifQ.fzvE7-W8PQuiXecV7SB1Um6zvvvDMtGUYx1XmYC7OYP7CqRcRVkTlEqKYo0kBJLRJeS_L66RJPeKTztgk3qs34R1nw5kk3NvNnhe6w-nMsCzTWAJVYK3giSW4PoT9ByYQoOzQdD5Hium7MGbVdt64dTP2WeKzUkXB-7fDErHQSkC0YANXxOiMEp9-vgFiJPGVzFHLVk7DZ1FmWBNo7cFqPB1qcvO13uJvcGG0kt2MLQ6RUwr4PlzBMqpGW-TY-BdsSX31pvH6F1Tvsf7LApVV6WnOTtF170bqKKK5GAqk0u__dmyuq2YCBUVSfiQ5xOzYsFKxAj-MOe8c_jMKz00Xw");
	    local.setItem("userRole","admin");
	    local.setItem("userPhoneNumber","+********0981");
	    local.setItem("persist:root","{\"user\":\"{\\\"data\\\":{\\\"sub\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"cognito:groups\\\":[\\\"admin\\\",\\\"patient\\\"],\\\"iss\\\":\\\"https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Queq8DO0E\\\",\\\"cognito:username\\\":\\\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\\\",\\\"origin_jti\\\":\\\"f8f4a812-bba7-4ea0-8fe5-0b766dda0c83\\\",\\\"aud\\\":\\\"16vn2ni6d429tfd3mi86refk2p\\\",\\\"event_id\\\":\\\"b5871ccb-df75-4290-8ad7-13c0480b5f49\\\",\\\"token_use\\\":\\\"id\\\",\\\"auth_time\\\":1668512102,\\\"name\\\":\\\"shivraj2\\\",\\\"phone_number\\\":\\\"+919834330981\\\",\\\"exp\\\":1668520294,\\\"iat\\\":1668516694,\\\"jti\\\":\\\"f6de65d5-33ed-47da-a3c3-38e21c94386c\\\",\\\"email\\\":\\\"shivrajtech37@gmail.com\\\"},\\\"logged\\\":true,\\\"logging\\\":false,\\\"loginError\\\":null,\\\"validating\\\":false,\\\"getOtp\\\":false,\\\"retrievingAll\\\":false,\\\"retrievingAllError\\\":{\\\"message\\\":\\\"Response not JSON\\\",\\\"status\\\":401},\\\"updating\\\":false,\\\"updateError\\\":null,\\\"updated\\\":false,\\\"updatedPassword\\\":false,\\\"updatingPassword\\\":false,\\\"updatePasswordError\\\":null}\",\"_persist\":\"{\\\"version\\\":-1,\\\"rehydrated\\\":true}\"}");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.clockDrift","0");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.deviceKey","us-east-1_7c73b54d-fc32-4e8b-90c6-2edfd4623a0d");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.accessToken","eyJraWQiOiJEc28rS0YyK1Y5M0NSK0FtYTRzXC94Z0FuXC9VdTdBcjdhZ044SXh1SWF3cGc9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJjNGQ2ZjE4ZS1lNGU5LTQ1MGItOTllZC03MzNiOTJiYjAwNDUiLCJjb2duaXRvOmdyb3VwcyI6WyJBZG1pbiJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9qMER5M3FYOE4iLCJjbGllbnRfaWQiOiIzMW5xNGNzcG5nanUycnRzdmVrZm84b2o3ZyIsIm9yaWdpbl9qdGkiOiJmZDJjNTYzOS03Yzc1LTRjNjItOWJlYS1mMWM4OGU0MzcyMDQiLCJldmVudF9pZCI6IjA0ODg1YzgwLWQ2OTUtNGRkYy1hN2QyLTcxMTI3ODQ0ZmVkMCIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2NTI0NDQzNjYsImV4cCI6MTY1NDIzNDgyNSwiaWF0IjoxNjU0MjMxMjI1LCJqdGkiOiIzNzlkNGM5MS00NjE2LTRmNzQtOWU0ZC00ODIxZTg1Y2Y1MGQiLCJ1c2VybmFtZSI6InNhdXJhdi5hbmFuZEBtZWRpZmxpeC5jb20ifQ.OIyxA5gzWlUUaIXttHx7NyGj3GR17YcCRR_pJ4VXvovga-jGRnPsGKz6Fvv4yG0SrvCWNe12PltaxTRuo1192AAr_jm__GFjIczjhr3B4l__BMJ1eMahMqsVArAAvjjik9VvGZsX61frfBsTu11MmjceoGYscoJzBKqufE91zWEv0xMRqNNQGlg-q4DiUV3Cu52zgQ-7mBaCOwVa_J63MlcWfG7WSUgr47ix4LAmbi8H94J-9RnGOyw_22rgRX5TB54ix0INmpnOyh8bKMLJEskTJ6MtJObS8TYzsJrazBlrurqCdlWOqFDx2n24K8Obtv74Sg5Pwssm4icNk6SQ5w");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.randomPasswordKey","mlvQreD0BeNzhYmuIThPelqazmNg0Lx9ibk3OO+72Hremdj3FfPJdg==");
	    local.setItem("CognitoIdentityServiceProvider.16vn2ni6d429tfd3mi86refk2p.38eaef6d-6a98-454c-b3df-861c17cd1fcd.userData","{\"PreferredMfaSetting\":\"SMS_MFA\",\"UserAttributes\":[{\"Name\":\"sub\",\"Value\":\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\"},{\"Name\":\"name\",\"Value\":\"shivraj2\"},{\"Name\":\"phone_number\",\"Value\":\"+919834330981\"},{\"Name\":\"email\",\"Value\":\"shivrajtech37@gmail.com\"}],\"UserMFASettingList\":[\"SMS_MFA\"],\"Username\":\"38eaef6d-6a98-454c-b3df-861c17cd1fcd\"}");
	    local.setItem("CognitoIdentityServiceProvider.31nq4cspngju2rtsvekfo8oj7g.saurav.anand@mediflix.com.idToken","eyJraWQiOiIzNkZrcURhRWt1eU9WcVo3V2JMaE15UVZ2UFRNY1Z5QVJ3N2IzYUJIdXU4PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJjNGQ2ZjE4ZS1lNGU5LTQ1MGItOTllZC03MzNiOTJiYjAwNDUiLCJjb2duaXRvOmdyb3VwcyI6WyJBZG1pbiJdLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX2owRHkzcVg4TiIsImNvZ25pdG86dXNlcm5hbWUiOiJzYXVyYXYuYW5hbmRAbWVkaWZsaXguY29tIiwiZ2l2ZW5fbmFtZSI6IlNhdXJhdiIsIm9yaWdpbl9qdGkiOiJmZDJjNTYzOS03Yzc1LTRjNjItOWJlYS1mMWM4OGU0MzcyMDQiLCJhdWQiOiIzMW5xNGNzcG5nanUycnRzdmVrZm84b2o3ZyIsImV2ZW50X2lkIjoiMDQ4ODVjODAtZDY5NS00ZGRjLWE3ZDItNzExMjc4NDRmZWQwIiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2NTI0NDQzNjYsImV4cCI6MTY1NDIzNDgyNSwiaWF0IjoxNjU0MjMxMjI1LCJmYW1pbHlfbmFtZSI6IkFuYW5kIiwianRpIjoiNDk2YTZkYWEtYjU1NS00MTBmLWIwYzYtNTgwZjUxYmVjNzQwIiwiZW1haWwiOiJzYXVyYXYuYW5hbmRAbWVkaWZsaXguY29tIn0.h3BOXh2CIjvlBX0y7M-r4YTVOJBagj390V0EprKTER9xfVTB5coHFZ9Y84-2tqbn_3VYO5SJwLOe9sSx_CfdhxcnNNnmAnXvycAPq5NaylrebPxtS-BMprhqWwxHvThmjAPGbSRqvWf9OGKOMCnFtvuJVv6LhN_1KB2k_UR3qgjZ223BQvF0iKvetmS8gfJHwPebDrT3l1Wctlau3dt_PmTEF4yv_ccdC-g1pAtVUM64857RjNT1cG-W_dezzd0jabjZHzzYlQ5sQ6DbzgU91xWkQynlLfkrhWlxxvorzk1F8vaT3NvO2eeJg-6kDJjtSsRjF-thV4qEZjtANwVvEA");
	    
	    driver.navigate().to("https://admin-portal.us-east-1.dev.mediflix.com");
	    
	 }
	
	
	
//	 @AfterTest
//	 public void closeBrowser() 
//	 {
//	 	driver.quit();
//	 	
//	 }

	
	
}
