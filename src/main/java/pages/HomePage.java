package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(linkText = "Register")
	WebElement registerButtonlink;
	
	@FindBy(linkText = "Log in")
	WebElement loginButtonlink;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutButtonlink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencyList;
	
	@FindBy(linkText = "Computers")
	WebElement computersMenue;
	
	@FindBy(linkText = "Notebooks")
	WebElement notebooksMenue;
	
	public void openRegistrationPage() 
	{
		clickButton(registerButtonlink);
	}
	
	public void openLoginPage() 
	{
		clickButton(loginButtonlink);
	}
	
	public void openContactUsPage() 
	{
		scrollToButtom();
		clickButton(contactUsLink);
	}
	
	public void changeCurrency() 
	{
		select = new Select(currencyList);
		select.selectByVisibleText("Euro");
	}
	
	public void selectMainTiltleByHovering() 
	{
		action.moveToElement(computersMenue).perform();
	}
	
	public void selectSubTiltleByHoveringTheMainTitles() 
	{
		action.moveToElement(notebooksMenue).click().build().perform();
	}
	
}
