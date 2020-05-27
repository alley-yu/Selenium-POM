package Selenium.Webdriver.Basic;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestTitleDisplay {
	
	WebDriver driver;
	
	//launch chrome browser with amazon.com
	
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		//driver.get("https://www.amazon.com/");
		driver.get("https://www.qad.com/");
		
	}
	
	//Enter Lei's Amazon.com to check the title "amazon.com" or "Your Amazon.com", without new tab popup
	
	public void enterYourAmazon() throws Exception {
		System.out.println("test starts...");
		driver.findElement(By.xpath("//*[@id=\"nav-orders\"]/span[1]")).click();
		System.out.println("The title is: " + driver.getTitle());
	}
	
	//Enter QAD Blog to check the title "Cloud ERP" or "QAD BLOG", with new tab popup
	public void enterQADBLOG() throws Exception {
		System.out.println("Test starts...");
		String parentGUID = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//*[@id=\"layout_66\"]/a/span")).click();
		System.out.println("The parent window title is: " + driver.getTitle());
		
		Thread.sleep(1000);
		
		//get list of GUIDs of windows
		Set<String> allGUID = driver.getWindowHandles();
		
		for(String guid : allGUID){
			// one enter into if block if the GUID is not equal to parent window's GUID
			if(! guid.equals(parentGUID)){
				
				driver.switchTo().window(guid);
				System.out.println("The popup window title is: " + driver.getTitle());
				
			}
		}
		
		
	}
	

	
	public void CloseBrowser() {
		driver.quit();
	}

	public static void main(String[] args) throws Exception {
		TestTitleDisplay obj = new TestTitleDisplay();
		obj.launchBrowser();
		//obj.enterYourAmazon();
		obj.enterQADBLOG();
		//obj.CloseBrowser();


	}

}
