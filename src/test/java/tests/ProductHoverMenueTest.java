package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenueTest extends TestBase{

	HomePage homeObject;
	
	@Test
	public void userCanHoverTheMainMenue() 
	{
		homeObject = new HomePage(driver);
		homeObject.selectMainTiltleByHovering();
		homeObject.selectSubTiltleByHoveringTheMainTitles();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
