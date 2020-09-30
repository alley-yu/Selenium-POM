package SeleniumInterviewQuestions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumInterviewQuest1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();

		
//		WebDriver driver;
//  	WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
	}
	
//	@Test
	public void switchWindow() {
		
//		QAD Blog is a popup window. Try to switch to that window.
		
		driver.navigate().to("https://www.qad.com/");
		driver.findElement(By.cssSelector(".icon-reorder")).click();

		List<WebElement> menuList = driver.findElements(By.cssSelector("div.menupage.menupage--menu>ul>li.menuitem "));
		
		for(WebElement menu: menuList) {
			if(menu.getText().equalsIgnoreCase("blog")) {
				menu.click();
				break;
			}
		}
		
		Set<String> winHandler = driver.getWindowHandles();
		Iterator<String> it = winHandler.iterator();
		
		String parentWinId = it.next();
		String childWinId = it.next();
		
		driver.switchTo().window(childWinId);
		System.out.println(driver.getTitle());
		
		driver.close();
		driver.switchTo().window(parentWinId);
		System.out.println(driver.getTitle());
				
	}
	
	@Test
	public void findFurtherElementByElement() {
		
//		Based on menu's text "About", try to find further menu, keep using cssSelector
		
		driver.navigate().to("https://www.qad.com/");
		driver.findElement(By.cssSelector(".icon-reorder")).click();

		List<WebElement> menuList = driver.findElements(By.cssSelector("div.menupage.menupage--menu>ul>li.menuitem "));
		
		for(WebElement menu: menuList) {
			if(menu.getText().equalsIgnoreCase("About")) {
				menu.findElement(By.cssSelector("label.menulabel__action")).click();
				break;
			}
		}
	}
	
//	@Test
	public void findElememts() throws InterruptedException {
		
		driver.navigate().to("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("testing");
		
		Thread.sleep(2000);
		
		List<WebElement> suggestionList = driver.findElements(By.cssSelector("ul.erkvQe>li.sbct")); 
		
		for (WebElement suggestion: suggestionList) {
//			System.out.println(suggestion.getText());
			if (suggestion.getText().equalsIgnoreCase("testing sites")) {
				suggestion.click();
				break;
			}
		}
		
	}
		
	
	@AfterMethod
	public void quit() {
//		driver.quit();
	}
	
	

}
