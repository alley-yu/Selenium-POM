package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;

public class ExtraLocatorTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//by using ByAll, find webelement from left to right by each By until finding it
		driver.findElement(new ByAll(By.name("firstname"), By.id("u_0_m"), 
				By.xpath("//input[@name = 'firstname']"))).sendKeys("Alley");
		
		driver.findElement(new ByIdOrName("u_0_o")).sendKeys("Yu");

	}

}
