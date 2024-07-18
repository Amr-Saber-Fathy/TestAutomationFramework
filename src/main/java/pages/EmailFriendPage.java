package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
	WebElement friendEmailTextBox;
	
	@FindBy(id = "YourEmailAddress")
	WebElement userEmailTextBox;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMessageTextBox;
	
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement sendEmailButton;
	
	@FindBy(css = "div.result")
	public WebElement emailSentSuccessMessage;
	
	public void sendFriendMessage(String friendEmail, String message) 
	{
		setTextBoxTest(friendEmailTextBox, friendEmail);
		setTextBoxTest(personalMessageTextBox, message);
		clickButton(sendEmailButton);
	}
}
