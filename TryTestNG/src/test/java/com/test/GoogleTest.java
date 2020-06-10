package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTest {

	private final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	WebDriver driver;
	
	
	@BeforeMethod (alwaysRun = true)
	public void setUp() {
		
		System.out.println("SetupXXXXXx");
		
		System.setProperty(WEBDRIVER_CHROME_DRIVER, System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		
		System.out.println("*********XXXXXXXXX" + driver);
		
		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	
	//Test Cases will be executed at random order. But we can use priority to specify the running sequence.
	@Test(priority = 1, groups = "GoogleTest")
	public void googleTitleTest() {
		System.out.println("*********" + driver);
		String title = driver.getTitle();
		System.out.println(title);
	}
	
//	@Test(priority = 2, groups = "GoogleTest")
	public void googleLogoTest() {
		boolean logoDisplay = driver.findElement(By.xpath("//div[@id = 'hplogo']")).isDisplayed();
		System.out.println("Logo Displayed: " + logoDisplay);
	}
	
	@Test(priority = 3, groups = "GoogleTest")
	public void googleGmailLinkTest() {
		boolean gmailLinkDisplay = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println("Gmail Link Displayed: " + gmailLinkDisplay);
	}
	
	
	@Test(priority = 4, groups = {"GoogleTest", "GoogleTestWithParameteras"})
	@Parameters({"searchInput1", "searchInput2"})
	public void googleSearch(String searchInput1, String searchInput2) {
		
		driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys(searchInput1);
		List<WebElement> suggestionList1 = driver.findElements(By.xpath("//ul[@role = 'listbox']//li/descendant::div[@class = 'sbtc' and @role = 'option']"));
		
		for (WebElement el: suggestionList1) {
			if (searchInput1.equalsIgnoreCase(el.getText())) {
				el.click();
				break; //Once find the result, break the finding loop.
			}
		}
		
//		for (int i = 0; i < suggestionList1.size(); i++) {
//			if ("Software Testing".equalsIgnoreCase(suggestionList1.get(i).getText())) {
//				System.out.println("******: " + suggestionList1.get(i).getText());
//				suggestionList1.get(i).click();
//			}
//		}

		driver.findElement(By.xpath("//input[@name = 'q']")).clear();
		driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys(searchInput2);
		List<WebElement> suggestionList2 = driver.findElements(By.xpath("//ul[@role = 'listbox']//li/descendant::div[@class = 'sbtc' and @role = 'option']"));
		
		for (WebElement el: suggestionList2) {
			if (searchInput2.equalsIgnoreCase(el.getText())) {
				el.click();
				break;
			}
		}
	}
	
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
