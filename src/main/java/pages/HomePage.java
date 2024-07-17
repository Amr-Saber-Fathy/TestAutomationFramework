package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}

	@FindBy(linkText = "Register")
	WebElement registerButtonlink;
	
	@FindBy(linkText = "Log in")
	WebElement loginButtonlink;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutButtonlink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
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
	
}
