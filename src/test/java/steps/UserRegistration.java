package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase{

	HomePage homeObject;
	UserRegistrationPage userRegistrationObject;
	
	@Given("User is on the main page")
	public void user_is_on_the_main_page() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
	}
	@When("User click on Register")
	public void user_click_on_register() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("User enters valid {string}, {string}, {string}, {string}")
	public void user_enters_valid(String firstName, String lastName, String email, String password) {
		userRegistrationObject = new UserRegistrationPage(driver);
		userRegistrationObject.userRegisteration(firstName, lastName, email, password);
	}
	@Then("Successful Registration page appear")
	public void successful_registration_page_appear() {
		Assert.assertTrue(userRegistrationObject.rigistrationMessage.getText().contains("Your registration completed"));
		userRegistrationObject.logOutUser();
	}
}
