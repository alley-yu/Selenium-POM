package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty(WEBDRIVER_CHROME_DRIVER, System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	
	//Test Cases will be executed at random order. But we can use priority to specify the running sequence.
	@Test(priority = 1, groups = "GoogleTest")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority = 2, groups = "GoogleTest")
	public void googleLogoTest() {
		boolean logoDisplay = driver.findElement(By.xpath("//div[@id = 'hplogo']")).isDisplayed();
		System.out.println("Logo Displayed: " + logoDisplay);
	}
	
	@Test(priority = 3, groups = "GoogleTest")
	public void googleGmailLinkTest() {
		boolean gmailLinkDisplay = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println("Gmail Link Displayed: " + gmailLinkDisplay);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
