package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductReviewPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchBarObject;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage userRegistrationObject;
	UserLoginPage userloginObject;
	SearchBarObject searchBar;
	ProductDetailsPage productDetailsObject;
	AddProductReviewPage addProductReviewObject;
	String productName = "Apple MacBook Pro 13-inch";
	String email = "Test81@gmail.com";

	
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
	}
	
	@Test(dependsOnMethods = {"userCanSearchUsingProductFullName"})
	public void userCanReviewProduct() 
	{
		productDetailsObject.openAddReviewPage();
		addProductReviewObject = new AddProductReviewPage(driver);
		addProductReviewObject.addReview("Test", "Test Review");
		Assert.assertTrue(addProductReviewObject.successReviewMessage.getText().contains("Product review is successfully added."));
		addProductReviewObject.closeSuccessReviewMessage.click();
		homeObject.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homeObject.waitforElement(homeObject.logoutButtonlink);
	}
	
	@Test(dependsOnMethods = {"userCanReviewProduct"})
	public void userRegisteredCanLogout() 
	{
		userRegistrationObject.logOutUser();
	}
}
