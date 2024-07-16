package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(id = "gender-male")
	WebElement genderRadiobtn;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTextBox;
	
	@FindBy(id = "LastName")
	WebElement lastNameTextBox;
	
	@FindBy(id = "Email")
	WebElement emailTextBox;
	
	@FindBy(id = "Password")
	WebElement passwordTextBox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextBox;
	
	@FindBy(id = "register-button")
	WebElement rigisterButton;
	
	@FindBy(css = "div.result")
	public WebElement rigistrationMessage;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutButtonlink;
	
	@FindBy(linkText = "My account")
	public WebElement myAccountButtonlink;
	
	public void userRegisteration(String firstName, String lastName, String email, String password) 
	{
		clickButton(genderRadiobtn);
		setTextBoxTest(firstNameTextBox, firstName);
		setTextBoxTest(lastNameTextBox, lastName);
		setTextBoxTest(emailTextBox, email);
		setTextBoxTest(passwordTextBox, password);
		setTextBoxTest(confirmPasswordTextBox, password);
		clickButton(rigisterButton);
	}
	
	public void logOutUser() 
	{
		clickButton(logoutButtonlink);
	}

	public void openMyAccount() 
	{
		clickButton(myAccountButtonlink);
	}
}
