package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage userRegistrationObject;
	
	@Test
	public void userRegisterSucessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		userRegistrationObject = new UserRegistrationPage(driver);
		userRegistrationObject.userRegisteration("Amr", "Saber", "test124@gmail.com", "123456");
		
		Assert.assertTrue(userRegistrationObject.rigistrationMessage.getText().contains("Your registration completed"));
	}
}
