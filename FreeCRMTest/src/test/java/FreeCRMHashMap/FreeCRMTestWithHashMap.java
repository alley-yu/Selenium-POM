package FreeCRMHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMTestWithHashMap {
	
	WebDriver driver;
	Data data = new Data();
	String credential;
	String credentialInfo[];
	
	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
	}
	
	//Admin user login info is not available now. So skip this case.
//	@Test
	public void adminLogin() {
		
		credential = data.getUserLoginInfo().get("admin");
		credentialInfo = credential.split("_");
		
		driver.findElement(By.name("username")).sendKeys(credentialInfo[0]);
		driver.findElement(By.name("password")).sendKeys(credentialInfo[1]);
//		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		//Use JavascriptExecutor to click the Login button
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type = 'submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		
	}
	
	@Test
	public void regularUserLogin() {
		
		credential = data.getUserLoginInfo().get("customer");
		credentialInfo = credential.split("_");
		
		driver.findElement(By.name("username")).sendKeys(credentialInfo[0]);
		driver.findElement(By.name("password")).sendKeys(credentialInfo[1]);
//		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		//Use JavascriptExecutor to click the Login button
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type = 'submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}

