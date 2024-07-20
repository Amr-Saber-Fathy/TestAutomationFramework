package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends PageBase{

	public CompareProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "table.compare-products-table")
	WebElement productsTable;
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	WebElement firstProductlinkName;
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	WebElement secondProductlinkName;
	
	@FindBy(css = "a.clear-list")
	WebElement clearListButton;
	
	@FindBy(css = "h1")
	public WebElement compareListTitle;
	
	@FindBy(css = "div.no-data")
	public WebElement emptyCompareListLabel;
	
	public void clearCompareProductsList() 
	{
		clickButton(clearListButton);
	}
	
	public String getFirstProductName() 
	{
		List<WebElement> rows = productsTable.findElements(By.tagName("tr"));
		WebElement specificRow = rows.get(2);
		List<WebElement> cells = specificRow.findElements(By.tagName("td"));
		WebElement specificCell = cells.get(2);
		return specificCell.getText();
	}
	
	public String getSecondProductName() 
	{
		List<WebElement> rows = productsTable.findElements(By.tagName("tr"));
		WebElement specificRow = rows.get(2);
		List<WebElement> cells = specificRow.findElements(By.tagName("td"));
		WebElement specificCell = cells.get(1);
		return specificCell.getText();
	}
	
	
}
