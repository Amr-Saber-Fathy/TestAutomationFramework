package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage userRegistrationObject;
	UserLoginPage userloginObject;
	
	@Test(priority = 1)
	public void userRegisterSucessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		userRegistrationObject = new UserRegistrationPage(driver);
		userRegistrationObject.userRegisteration("Amr", "Saber", email, oldPassword);
		
		Assert.assertTrue(userRegistrationObject.rigistrationMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = {"userRegisterSucessfully"})
	public void userRegisteredCanLogout() 
	{
		userRegistrationObject.logOutUser();
	}
	
	@Test(dependsOnMethods = {"userRegisteredCanLogout"})
	public void userRegisteredCanLogin() 
	{
		homeObject.openLoginPage();
		userloginObject = new UserLoginPage(driver);
		userloginObject.userlogin(email, oldPassword);
		Assert.assertTrue(homeObject.logoutButtonlink.getText().contains("Log out"));
		userRegistrationObject.logOutUser();
	}
}
