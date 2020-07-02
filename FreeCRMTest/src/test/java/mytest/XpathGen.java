package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathGen {
	
	//input[@id = "{0}"]
	//input[@id = "{0}" and @name = "{1}"]
	public static String createXpath(String xpathExp, Object ...args ) {
		
		for (int i = 0; i < args.length; i++) {
			xpathExp = xpathExp.replace("{" +i + "}", (CharSequence) args[i]);
		}
		return xpathExp;		
	}
	

	public static void main(String[] args) {
		String firstName = createXpath("//input[@id = '{0}']", "u_0_m");
		System.out.println(firstName);
		
		String lastName = createXpath("//input[@id = '{0}' and @name = '{1}']", "u_0_o", "lastname");
		System.out.println(lastName);
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath(firstName)).sendKeys("Alley");
		driver.findElement(By.xpath(lastName)).sendKeys("Yu");
		

	}

}
