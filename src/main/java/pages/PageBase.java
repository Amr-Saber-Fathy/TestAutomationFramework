package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver driver;
	public JavascriptExecutor jse;
	public WebDriverWait wait;
	public Actions action;
	public Select select;
	
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
	
	public void waitforElement(WebElement element) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitforTime(long time) 
	{
		wait.withTimeout(Duration.ofSeconds(time));
	}
}
