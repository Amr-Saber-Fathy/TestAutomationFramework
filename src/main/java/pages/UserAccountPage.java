package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccountPage extends PageBase{

	public UserAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "OldPassword")
	WebElement oldPasswordTextBox;
	
	@FindBy(id = "NewPassword")
	WebElement newPasswordTextBox;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement conNewPasswordTextBox;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement changePassButton;
	
	@FindBy(css = "div.bar-notification.success")
	public WebElement successfullChangeMessage;
	
	@FindBy(linkText = "Change password")
	WebElement changePassButtonlink;
	
	@FindBy(css = "span.close")
	public WebElement closeMessageButton;
	
	public void openChangePassPage() 
	{
		clickButton(changePassButtonlink);
	}
	
	public void changeUserPassword(String oldPassword, String newPassword) 
	{
		setTextBoxTest(oldPasswordTextBox, oldPassword);
		setTextBoxTest(newPasswordTextBox, newPassword);
		setTextBoxTest(conNewPasswordTextBox, newPassword);
		clickButton(changePassButton);
	}
	
	public void closeSuccessMessage() 
	{
		clickButton(closeMessageButton);
	}
}
