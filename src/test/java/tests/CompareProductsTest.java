package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareProductsPage;
import pages.ProductDetailsPage;
import pages.SearchBarObject;

public class CompareProductsTest extends TestBase{

	SearchBarObject searchBar;
	ProductDetailsPage productDetailsObject;
	CompareProductsPage compareListObject;
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	
	@Test(priority = 1)
	public void userCanAddProductsToCompareList() 
	{
		searchBar = new SearchBarObject(driver);
		searchBar.searchForProductWithAutoSuggest("Mac");
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productLinkTitle.getText().equalsIgnoreCase(firstProductName));
		productDetailsObject.addProductToCompareList();
		
		searchBar.searchForProductWithAutoSuggest("Asus");
		Assert.assertTrue(productDetailsObject.productLinkTitle.getText().equalsIgnoreCase(secondProductName));
		productDetailsObject.addProductToCompareList();
	}
	
	@Test(dependsOnMethods = {"userCanAddProductsToCompareList"})
	public void userCanCheckProductsInCompareList() 
	{
		compareListObject = new CompareProductsPage(driver);
		try {
			Thread.sleep(Duration.ofSeconds(5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Assert.assertTrue(compareListObject.compareListTitle.getText().equalsIgnoreCase("Compare products"));
		System.out.println(compareListObject.getFirstProductName());
		System.out.println(compareListObject.getSecondProductName());
		Assert.assertTrue(compareListObject.getFirstProductName().equalsIgnoreCase(firstProductName));
		Assert.assertTrue(compareListObject.getSecondProductName().equalsIgnoreCase(secondProductName));
	}
	
	@Test(dependsOnMethods = {"userCanCheckProductsInCompareList"})
	public void userCanClearCompareList() 
	{
		compareListObject.clearCompareProductsList();
		Assert.assertTrue(compareListObject.emptyCompareListLabel.getText().contains("You have no items to compare."));
	}
}
