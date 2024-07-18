package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBarObject extends PageBase{

	public SearchBarObject(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(id="small-searchterms")
	public WebElement searchTextBox;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement searchButton;
	
	@FindBy(id="ui-id-1")
	public List<WebElement> searchSuggestlist;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productcardlink;
	
	
	public void searchForProduct(String productName) 
	{
		setTextBoxTest(searchTextBox, productName);
		clickButton(searchButton);
	}
	
	public void openProductDetails() 
	{
		clickButton(productcardlink);
	}
	
	public void searchForProductWithAutoSuggest(String searchtxt) 
	{
		setTextBoxTest(searchTextBox, searchtxt);
		action.click(searchTextBox).keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(searchSuggestlist.get(0)));
		clickButton(searchSuggestlist.get(0));
	}
}
