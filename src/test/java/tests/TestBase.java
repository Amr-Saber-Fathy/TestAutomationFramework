package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	public static WebDriver driver;
	
	public String email = "test165@gmail.com";
	public String oldPassword = "123456";
	
	@BeforeSuite
	@Parameters({"browserName"})
	public void startDriver(@Optional("chrome") String browserType) 
	{
		System.out.println("Running browser is : " + browserType);
		
		if(browserType.equalsIgnoreCase("chrome")) {
			String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",chromePath);
			driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("firefox")) {
			String firefoxPath = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",firefoxPath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	@AfterSuite
	public void stopDriver() 
	{
		driver.quit();
	}
}
