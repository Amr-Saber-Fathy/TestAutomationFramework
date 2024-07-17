package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	protected WebDriver driver;
	public JavascriptExecutor jse;
	
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickButton(WebElement button) 
	{
		button.click();
	}
	
	public void setTextBoxTest(WebElement textBox, String value) 
	{
		textBox.sendKeys(value);
	}
	
	public void scrollToButtom()
	{
		jse.executeScript("scrollBy(0,2500)");
	}
}
