package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;

public class UserLoginTest extends TestBase{

	HomePage homeObject;
	UserLoginPage userloginObject;
	
//	String email = "test155@gmail.com";
//	String oldPassword = "123456";
	
	@Test
	public void userLoginSuccessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		userloginObject = new UserLoginPage(driver);
		userloginObject.userlogin(email, oldPassword);
		
		Assert.assertTrue(homeObject.logoutButtonlink.getText().contains("Log out"));
		
		userloginObject.logoutAccount();
	}
}
