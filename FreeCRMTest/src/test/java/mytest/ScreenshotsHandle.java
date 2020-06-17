package mytest;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ScreenshotsHandle {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		Thread.sleep(2000);
		takeScreenshot("Google_Homepage");

	}
	
	public static void takeScreenshot(String fileName) throws IOException {
		//1. take screenshot and store it as a file format
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//2. copy the screenshot to desired location using copyfile method
		FileUtils.copyFile(file, new File("/Users/alleyyu/Selenium-POM/FreeCRMTest/src/test/java/mytest/Screenshots/" + fileName + ".JPG"));
	}

}
