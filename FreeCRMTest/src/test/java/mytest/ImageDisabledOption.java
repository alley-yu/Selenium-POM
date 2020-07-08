package mytest;

import java.sql.Driver;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ImageDisabledOption {
	
	//This method can be in Util package and can be used everywhere in the whole package.
	public static void disabledImageChrome(ChromeOptions options) {
		HashMap<String, Object> images = new HashMap<String, Object>();
		images.put("images", 2); //2 could be the value of disable image in chrome
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values", images);
		
		options.setExperimentalOption("prefs", prefs);
		
	}

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		disabledImageChrome(options);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		

	}

}
