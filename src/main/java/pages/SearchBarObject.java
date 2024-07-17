package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBarObject extends PageBase{

	public SearchBarObject(WebDriver driver) {
		super(driver);
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
		try {
			Thread.sleep(Duration.ofSeconds(3));
			clickButton(searchSuggestlist.get(0));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
