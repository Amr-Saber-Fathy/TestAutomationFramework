package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="strong.current-item")
	public WebElement productLinkTitle;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailFriendButton;
	
	@FindBy(css = "div.prices")
	public WebElement productPriceValue;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewButton;
	
	@FindBy(css = "button#add-to-wishlist-button-4.button-2.add-to-wishlist-button")
	WebElement addToWishListButton;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareListButton;
	
	public void openEmailFriendPage() 
	{
		clickButton(emailFriendButton);
	}
	
	public void openAddReviewPage() 
	{
		clickButton(addReviewButton);
	}
	
	public void addProductToWishList() 
	{
		clickButton(addToWishListButton);
	}
	
	public void addProductToCompareList() 
	{
		clickButton(addToCompareListButton);
	}
}
