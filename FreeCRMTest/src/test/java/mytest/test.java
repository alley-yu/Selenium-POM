package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	@Test
	public void openWebsite() {
		
		//System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		
		//System.out.println(System.getProperty("user.home")+"/bin/chromedriver");
		///Users/alleyyu/bin
		System.getProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		
		WebDriver driver = new ChromeDriver();

//		
////		WebDriver driver;
//  		WebDriverManager.chromedriver().setup();
////		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
//		System.out.println("iamhere");
//		
//		driver.findElement(By.name("q")).sendKeys("test");
//		
//		driver.navigate().to("https://www.qad.com/");
		
	}
	
	

}
