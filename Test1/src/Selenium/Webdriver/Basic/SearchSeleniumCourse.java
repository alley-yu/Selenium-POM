package Selenium.Webdriver.Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchSeleniumCourse {

	
	WebDriver driver;
	
	// Create 3 methods
	
	// Launching the chome browser
	public void LaunchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com");
		
	}
	
	
	// Searching Selenium training and clicking it
	public void Searching() throws InterruptedException {
		
		driver.findElement(By.id("header_srch")).sendKeys("Selenium");
		Thread.sleep(3000);
		driver.findElement(By.className("search_icon")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[contains(text(), 'Selenium 3.0 Training')]")).click();
		
		
		WebElement findSeleniumCourse = driver.findElement(By.xpath("//*[contains(text(), 'Selenium 3.0 Training')]"));
		if (findSeleniumCourse.isEnabled()){
			System.out.println("Test Passed");
			
			
		} else {
			
			System.out.println("Test Failed");		
		}
		
		findSeleniumCourse.click();
		System.out.println("The page title is: " + driver.getTitle());

	}
	
	public void navigationTest() throws InterruptedException {
		
		driver.navigate().to("https://www.ebay.com/");
		Thread.sleep(1000);
		System.out.println("Now we are on:" + driver.getTitle());
		driver.navigate().back();
		Thread.sleep(1000);
		System.out.println("Now we are on:" + driver.getTitle());
		
	}
	
	// Close the browser
	public void closebrowser() {
		
		driver.quit();
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		SearchSeleniumCourse obj = new SearchSeleniumCourse();
		obj.LaunchBrowser();
		obj.Searching();
		obj.navigationTest();
		//obj.closebrowser();
	

	}

}
