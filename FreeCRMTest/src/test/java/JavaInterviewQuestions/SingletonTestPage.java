package JavaInterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class SingletonTestPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		SingletonDriverInitialize instanceDriver = SingletonDriverInitialize.getInstance();
		driver = instanceDriver.openBrowser();
	}
	
	@Test
	public void testMethod() {
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.findElement(By.cssSelector("img#hplogo")).isDisplayed(), "No Google logo found.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}