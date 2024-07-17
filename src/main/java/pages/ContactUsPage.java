package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id = "FullName")
	WebElement firstNameTextBox;
	
	@FindBy(id = "Email")
	WebElement emailTextBox;
	
	@FindBy(css = "textarea#Enquiry.enquiry")
	WebElement userMessageTextBox;
	
	@FindBy(css = "button.button-1.contact-us-button")
	WebElement contactUsButton;
	
	@FindBy(css = "div.result")
	public WebElement resultMesssage;
	
	public void sendEnquiryMessage(String firstName, String email, String message) 
	{
		setTextBoxTest(firstNameTextBox, firstName);
		setTextBoxTest(emailTextBox, email);
		setTextBoxTest(userMessageTextBox, message);
		clickButton(contactUsButton);
	}
}
