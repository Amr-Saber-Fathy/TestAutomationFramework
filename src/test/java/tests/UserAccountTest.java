package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserAccountPage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserAccountTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage userRegistrationObject;
	UserLoginPage userloginObject;
	UserAccountPage userAccountObject;
	
	String email = "test151@gmail.com";
//	String oldPassword = "123456";
	String newPassword = "12345678";
	
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
	public void userRegisteredCanChangePass() 
	{
		userRegistrationObject.openMyAccount();
		userAccountObject = new UserAccountPage(driver);
		userAccountObject.openChangePassPage();
		userAccountObject.changeUserPassword(oldPassword, newPassword);
		
		Assert.assertTrue(userAccountObject.successfullChangeMessage.getText().contains("Password was changed"));
		
		userAccountObject.closeSuccessMessage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
	}
	
	@Test(dependsOnMethods = {"userRegisteredCanChangePass"})
	public void userRegisteredCanLogout() 
	{
		userRegistrationObject.logOutUser();
	}
	
	@Test(dependsOnMethods = {"userRegisteredCanLogout"})
	public void userRegisteredCanLogin() 
	{
		homeObject.openLoginPage();
		userloginObject = new UserLoginPage(driver);
		userloginObject.userlogin(email, newPassword);
		Assert.assertTrue(homeObject.logoutButtonlink.getText().contains("Log out"));
		userRegistrationObject.logOutUser();
	}
}
