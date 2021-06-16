package HandsOnTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Visit www.worldometers.info/world-population/ to display world population for 20 seconds.
//Tricky part: all numbers keeps changing. Very possible to get stale element error.
//Solution: try to find the part which doesn't change.

public class DisplayWorldPopulation {
	
	static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {
		
		String xpath_current_pop = "//div[@class = 'maincounter-number']/span[@class = 'rts-counter']";
		String xpath_today_pop = "//div[text() = 'Today']//parent::div//span[@class = 'rts-counter']";
		String xpath_thisyear_pop = "//div[text() = 'This year']//parent::div//span[@class = 'rts-counter']";
		// Use or to combine two xpaths
		String xpath_today_thisyear_pop = "//div[text() = 'Today' or text() = 'This year']//parent::div//span[@class = 'rts-counter']";
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		
		Thread.sleep(2000);
		
		int disp_count = 1;
		while(disp_count <= 20) {
			System.out.println("---------- World Current Population ------------");
			printPopulationData(xpath_current_pop);
//			System.out.println("---------- World Today's Data ------------");
//			printPopulationData(xpath_today_pop);
//			System.out.println("---------- World This Year's Data ------------");
//			printPopulationData(xpath_thisyear_pop);
			
			System.out.println("---------- World Today or This Year's Data ------------");
			printPopulationData(xpath_today_thisyear_pop);
			
			
			System.out.println("==================================================");
			
			
			Thread.sleep(1000);
			disp_count ++;
		}
		
	}
		
		
	public static void printPopulationData(String locator) throws InterruptedException {
		
//		int disp_count = 1;
//		while(disp_count <= 20) {
				List<WebElement> popList = driver.findElements(By.xpath(locator));
				for(WebElement e: popList) {
					System.out.println(e.getText());
				}
//				Thread.sleep(1000);
//				disp_count ++;
//		}
	}
		
		
//		WebElement popList = driver.findElement(By.xpath(locator));
//		System.out.println(popList.getText());
		

}
