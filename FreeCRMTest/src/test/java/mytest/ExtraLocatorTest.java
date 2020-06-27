package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class ExtraLocatorTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//by using ByAll, find WebElement from left to right by each By until finding it
		driver.findElement(new ByAll(By.name("firstname"), By.id("u_0_m"), 
				By.xpath("//input[@name = 'firstname']"))).sendKeys("Alley");
		
		driver.findElement(new ByIdOrName("u_0_o")).sendKeys("Yu");
		
		//Using ByChained is to allow using parent-child-chaining relation to find WebElement.
		driver.findElement(new ByChained(By.id("u_0_q"), 
				By.xpath("//div[@class = 'uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']"), 
				By.name("reg_email__"))).sendKeys("alley.yu@hotmail.com");
				

	}

}
