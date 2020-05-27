package Selenium.Webdriver.Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeTest {
	
	WebDriver driver;
	
	
	public void headlessAmazon() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size = 1400, 800");
		options.addArguments("headless");
		
		driver = new ChromeDriver(options);
		
		//driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		System.out.println("Launching Amazon title is: " + driver.getTitle());
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Masks");
		driver.findElement(By.xpath("//input[@class = 'nav-input' and @ tabindex = '20']")).click();
		
		System.out.println("Now you are launching: " + driver.getTitle());
		
		//driver.findElement(By.linkText("Whole Foods")).click();
		
	}

	public static void main(String[] args) {
		HeadlessChromeTest obj = new HeadlessChromeTest();
		obj.headlessAmazon();

	}

}
