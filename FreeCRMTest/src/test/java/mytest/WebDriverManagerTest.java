package mytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		
//		You can specify the browser version to run
//		WebDriverManager.chromedriver().driverVersion("2.26").setup();
		driver = new ChromeDriver();
		
	}

	@Test
	public void checkTitle() {
		
		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Facebook - Log In or Sign Up");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
