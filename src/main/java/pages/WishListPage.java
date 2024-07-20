package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "h1")
	public WebElement wishListTitle;
	
	@FindBy(css = "td.product")
	public WebElement productNameCell;
	
	@FindBy(css = "td.remove-from-cart")
	WebElement removeProductButton;
	
	@FindBy(css = "div.no-data")
	public WebElement emptyWishListLabel;
	
	@FindBy(id = "updatecart")
	WebElement udateWishlistButton;
	
	public void removeProductFromWishList() 
	{
		clickButton(removeProductButton);
	}
	
	
}
