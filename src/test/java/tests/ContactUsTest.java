package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage homeObject;
	ContactUsPage contactUsObject;
	
	String firstName = "Ali";
	String userEmail = "Test123@gmail.com";
	String userMessage = "Hi, This message for test";
	String successMessage = "Your enquiry has been successfully sent to the store owner.";
	
	@Test
	public void userCanContactUs() 
	{
		homeObject = new HomePage(driver);
		homeObject.openContactUsPage();
		contactUsObject = new ContactUsPage(driver);
		contactUsObject.sendEnquiryMessage(firstName, userEmail, userMessage);
		
		Assert.assertTrue(contactUsObject.resultMesssage.getText().contains(successMessage));
	}
}
