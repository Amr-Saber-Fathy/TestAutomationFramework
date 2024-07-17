package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchBarObject;

public class SearchBarTest extends TestBase{

	SearchBarObject searchBar;
	ProductDetailsPage productDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void userCanSearchUsingProductFullName() 
	{
		searchBar = new SearchBarObject(driver);
		searchBar.searchForProduct(productName);
		searchBar.openProductDetails();
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productLinkTitle.getText().equalsIgnoreCase(productName));
	}
	
	@Test(priority = 2)
	public void userCanSearchUsingAutoSuggest() 
	{
		//searchBar = new SearchBarObject(driver);
		searchBar.searchForProductWithAutoSuggest("Mac");
		//productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productLinkTitle.getText().equalsIgnoreCase(productName));
	}
}
