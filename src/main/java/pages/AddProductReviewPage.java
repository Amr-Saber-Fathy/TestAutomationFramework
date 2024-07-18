package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase{

	public AddProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTextBox;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTextBox;
	
	@FindBy(id = "addproductrating_4")
	WebElement ratingRadioButton;
	
	@FindBy(id = "add-review")
	WebElement submitReviewButton;
	
	@FindBy(css = "p.content")
	public WebElement successReviewMessage;
	
	@FindBy(css = "span.close")
	public WebElement closeSuccessReviewMessage;
	
	public void addReview(String title, String review) 
	{
		setTextBoxTest(reviewTitleTextBox, title);
		setTextBoxTest(reviewTextBox, review);
		clickButton(ratingRadioButton);
		clickButton(submitReviewButton);
	}
}
