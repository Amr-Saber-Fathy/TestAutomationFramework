package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchBarObject;

public class ChangeCurrencyTest extends TestBase{

	HomePage homeObject;
	SearchBarObject searchBar;
	ProductDetailsPage productDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	
	@Test(priority = 1)
	public void userCanChangeCurrency() 
	{
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
	}
	
	@Test(priority = 2)
	public void userCanSearchUsingProductFullName() 
	{
		searchBar = new SearchBarObject(driver);
		searchBar.searchForProduct(productName);
		searchBar.openProductDetails();
		productDetailsObject = new ProductDetailsPage(driver);
		//Assert.assertTrue(productDetailsObject.productLinkTitle.getText().equalsIgnoreCase(productName));
		System.out.println(productDetailsObject.productPriceValue.getText());
		Assert.assertTrue(productDetailsObject.productPriceValue.getText().contains("€"));
	}
}
