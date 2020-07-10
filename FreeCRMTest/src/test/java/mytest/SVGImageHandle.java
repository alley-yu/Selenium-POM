package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGImageHandle {
	
//	SVG Image:
//	Use xpath to locate, //*[name() = 'svg']//*[local-name() = 'path']  -->//* means going to child-level
//	If more elements found, use attribute to narrow down the element locate
//	e.g. //*[name() = 'svg' and @viewBox = '0 0 16 27'  and @ class = '_2gp_O1']
	


	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/index.html");
		Thread.sleep(3000);
		WebElement open = driver.findElement(By.xpath("//*[name() = 'svg' and @viewBox = '0 0 28 32']//*[local-name() = 'path' ]"));
		open.click();
		WebElement close = driver.findElement(By.xpath("//*[name() = 'svg' and @viewBox = '0 0 16 14']//*[local-name() = 'path' ]"));
		close.click();
		
		driver.navigate().to("https://www.flipkart.com/");
		driver.findElement(By.cssSelector("button._2AkmmA._29YdH8")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[name() = 'svg' and @viewBox = '0 0 16 27'  and @ class = '_2gp_O1']")).click();
		driver.findElement(By.cssSelector("input.LM6RPg")).sendKeys("iPhone 11");
//		driver.findElement(By.cssSelector("button.vh79eN")).click(); //use cssselector to find button and click
		driver.findElement(By.xpath("//*[name() = 'svg' and @viewBox = '0 0 17 18']")).click(); //use xpath to find svg image and click
		
	}

}
