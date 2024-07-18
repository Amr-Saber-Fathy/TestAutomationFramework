package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchBarObject;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage userRegistrationObject;
	UserLoginPage userloginObject;
	SearchBarObject searchBar;
	ProductDetailsPage productDetailsObject;
	EmailFriendPage emailFriendObject;
	String productName = "Apple MacBook Pro 13-inch";
	String friendEmail = "Test@gmail.com";
	String sentMessage = "Hi, this message for Test";
	
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
	public void userCanSearchUsingProductFullName() 
	{
		searchBar = new SearchBarObject(driver);
		searchBar.searchForProduct(productName);
		searchBar.openProductDetails();
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productLinkTitle.getText().equalsIgnoreCase(productName));
		productDetailsObject.openEmailFriendPage();
	}
	
	@Test(dependsOnMethods = {"userCanSearchUsingProductFullName"})
	public void userCanEmailFriend() 
	{
		emailFriendObject = new EmailFriendPage(driver);
		emailFriendObject.sendFriendMessage(friendEmail, sentMessage);
		Assert.assertTrue(emailFriendObject.emailSentSuccessMessage.getText().contains("Your message has been sent."));
	}
	
	@Test(dependsOnMethods = {"userCanEmailFriend"})
	public void userRegisteredCanLogout() 
	{
		userRegistrationObject.logOutUser();
	}
}
