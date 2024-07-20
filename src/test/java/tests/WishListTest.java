package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchBarObject;
import pages.WishListPage;

public class WishListTest extends TestBase{

	SearchBarObject searchBar;
	ProductDetailsPage productDetailsObject;
	WishListPage wishListObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void userCanSearchUsingAutoSuggest() 
	{
		searchBar = new SearchBarObject(driver);
		searchBar.searchForProductWithAutoSuggest("Mac");
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productLinkTitle.getText().equalsIgnoreCase(productName));
	}
	
	@Test(dependsOnMethods = {"userCanSearchUsingAutoSuggest"})
	public void userCanAddProductToWishList() 
	{
		wishListObject = new WishListPage(driver);
		productDetailsObject.addProductToWishList();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		Assert.assertTrue(wishListObject.wishListTitle.getText().equalsIgnoreCase("Wishlist"));
		Assert.assertTrue(wishListObject.productNameCell.getText().equalsIgnoreCase(productName));
	}
	
	@Test(dependsOnMethods = {"userCanAddProductToWishList"})
	public void userCanRemoveProductFromWishList() 
	{
		wishListObject.removeProductFromWishList();
		Assert.assertTrue(wishListObject.emptyWishListLabel.getText().equalsIgnoreCase("The wishlist is empty!"));
	}
}
