package Selenium.Webdriver.Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicGoogleSearch {

	WebDriver driver;
	
	//In google search, input "testing" and pick "testing engineers" from the suggestion list.
	public void dynamicGoogleSearchHandle() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testing");
		
		//Put wait time to make system grab data from server.
		Thread.sleep(2000);
		
		//Use this way, two buttons won't be included in the WebElement list, because these two buttons have no attribute like "class = 'sbl1'"
		//In this way, locate the listbox level first, then, find its following elements.
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role ='listbox']//li/descendant::div[@class = 'sbl1']"));
		
		//Use this way still can find all suggestions, but two buttons won't be excluded, because they also have the attribute "role = 'presentation'".
		//So the size would have 2 more than the real suggestions number.
		
		//List<WebElement> list = driver.findElement(By.xpath("//ul[@role='listbox']")).findElements(By.xpath("//li[@role = 'presentation']"));

		System.out.println("Total num of Suggestions: " + list.size());
		
		for (int i = 0; i < list.size(); i++){
			//System.out.println("test" + list.get(i).getText());
			if (list.get(i).getText().equalsIgnoreCase("testing engineers")) {
				list.get(i).click();
				break;
			}
		}
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		dynamicGoogleSearch obj = new dynamicGoogleSearch();
		obj.dynamicGoogleSearchHandle();

	}

}
