package Selenium.Webdriver.Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {
	
	WebDriver driver;
	
	public void dynamicWebTablehandling() throws InterruptedException {
		
		//Scenario: Select the row with name as "test2 test2" in Contacts table
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/");
		
		//after login
		driver.switchTo().frame("mainpanel");
		Thread.sleep(1000);
		
		//switch to and activate Contacts table area
		driver.findElement(By.xpath("//a[contains(text(), 'contacts')]")).click();
		
		//In Contacts Table, data starts on the 4th row. 1st column has checkbox to select record, 2nd column having name.
		//Below are the xpath for all names in 2nd column.
		//*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[6]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[7]/td[2]/a
		
		
//		//Method 1:
//		//Use two strings to make a full xpath for the name value. 
//		//In the middle of number part, use "for" loop.
//		String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
//		String after_xpath = "]/td[2]/a";
//		
//		for (int i=4; i<=7; i++) {
//			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//			if(name.contains("test2 test2")) {
//				//Select the checkbox before name "test2 test2", which column number is 1. So td[1].
//				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[" + i + "]/td[1]/a")).click();
//			}
//		}
		
		//Method 2:
		driver.findElement(By.xpath("//a[contains(text(), 'test2 test2')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'ui uiii')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}
	

	public static void main(String[] args) {
		//This code cannot be run since it has no testing environment.

	}

}
