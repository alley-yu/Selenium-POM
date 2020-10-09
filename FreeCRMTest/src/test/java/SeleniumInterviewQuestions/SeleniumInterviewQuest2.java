package SeleniumInterviewQuestions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumInterviewQuest2 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
	}
	
//	@Test
	public void findBrokenLinkImg() throws MalformedURLException, IOException {
		
		driver.get("https://www.amazon.com/");
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("There are " + linkList.size() + " links and images on the page.");
		
		List<WebElement> activeList = new ArrayList<WebElement>();
		
		for (WebElement link: linkList) {
			if (link.getAttribute("href") != null && !link.getAttribute("href").contains("javascript")) {
				activeList.add(link);
			}
		}
		
		System.out.println("There are " + activeList.size() + " active links and images on the page.");
		
		//Check all active link/image's href url with httpconnection API:
		//200: ok
		//404: not found
		//500: internal error
		//400: bad request
		
		List<WebElement> exceptionList = new ArrayList<WebElement>();
		
		for (WebElement aLink: activeList) {
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(aLink.getAttribute("href")).openConnection();
				connection.connect();
				String response = connection.getResponseMessage();
				int resCode = connection.getResponseCode();
				connection.disconnect();
				System.out.println(aLink.getAttribute("href") + "--->" + resCode + "--->" + response);
			} catch(Exception e) {
				System.out.println(aLink.getAttribute("href") + "---Wrong---");
				exceptionList.add(aLink);
			}
		}
		
		System.out.println("There are " + exceptionList.size() + " wrong links or images on the page.");
		
//		for (WebElement errLink: exceptionList) {
//			System.out.println(errLink.);
//		}
	}
	
//	@Test
	public void resizeWindow() {
		driver.get("https://www.amazon.com/");
		Dimension d = new Dimension(480, 620);
		driver.manage().window().setSize(d);
	}
	
//	@Test
	public void scrollDown() {
		driver.get("https://www.amazon.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, 3000)");
	}
	
//	@Test
	public void scrollIntoView() {
		driver.get("https://www.amazon.com/");
		WebElement backToTop = driver.findElement(By.cssSelector("span.navFooterBackToTopText"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", backToTop);
		System.out.println(backToTop.getText());
		backToTop.click();
	}
	
	@Test
	public void scrollIntoView1() {
		
		driver.get("https://www.amazon.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollheight)");
		
		List<WebElement> bottomMenus = driver.findElements(By.cssSelector("div.navFooterColHead"));
		List<WebElement> bottomSubMenus = new ArrayList<WebElement>();
		
		for (WebElement menu: bottomMenus) {
			if (menu.getText().equalsIgnoreCase("Let Us Help You")) {
				bottomSubMenus = menu.findElements(By.xpath("./..//ul//li")); //Use ./.. to back the parent of current element
				break;
			}
		}
		
		for (WebElement subMenu: bottomSubMenus) {
			if (subMenu.getText().equalsIgnoreCase("Amazon Assistant")) {
				subMenu.click();
				System.out.println(driver.getTitle());
				break;
			}
		}
	}
	
	
//	@AfterMethod
	public void quit() {
		driver.quit();
	}
	

}
