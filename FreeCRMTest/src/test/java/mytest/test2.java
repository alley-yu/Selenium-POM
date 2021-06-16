package mytest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("iphone12");
		Thread.sleep(2000);
		List<WebElement> optionList = driver.findElements(By.cssSelector("ul.erkvQe li div.sbl1 span"));
		System.out.println(optionList.size());

		
		List<WebElement> optionLinks = driver.findElements(By.cssSelector("div.gb_h.gb_i a.gb_g"));
		System.out.println(optionLinks.size());
		for(WebElement link: optionLinks){
			System.out.println(link.getText());
		}

	}

}
