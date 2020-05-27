package Selenium.Webdriver.Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {
	
	//WebDriver driver;
	
	public void launchBrowserWithHtmlUnitDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		//driver = new ChromeDriver();
		
		//htmlunitdriver is not available in Selenium 3.x version.
		//htmlunitdriver JAR file needs to be downloaded and added.
		
		//advantages of htmlunitdriver
		//1. The testing is happening behind the scene. No browser needed. Ghost driver or headless browser.
		//2. Case execution is very fast. Inprove the performance.
		
		//disadvantages:
		//not suitable for Action class, mousemovement, doubleclick, drap and drop
		
		WebDriver driver = new HtmlUnitDriver();
		
		driver.get("https://www.amazon.com/");
		System.out.println("Homepage title is " + driver.getTitle());
		
		driver.findElement(By.xpath("//a[contains(text(), 'Whole Foods')]")).click();
		System.out.println("Now navigate to " + driver.getTitle());
		
		
	}

	public static void main(String[] args) {
		
		HtmlUnitDriverConcept obj = new HtmlUnitDriverConcept();
		obj.launchBrowserWithHtmlUnitDriver();
		

	}

}
