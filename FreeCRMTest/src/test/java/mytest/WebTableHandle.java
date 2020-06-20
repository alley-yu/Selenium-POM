package mytest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement> customerList = driver.findElements(By.xpath("//table[@id = 'customers']//tr"));
		int customerNum = customerList.size();
		
		XLS_Reader reader = new Xls_Reader("/Users/alleyyu/Selenium-POM/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx");
		
		for (int i = 2; i <= customerNum; i++ ) {
			
			String beforeXpath = "//*[@id='customers']/tbody/tr[";
			String afterXpath_customer = "]/td[1]";
			String afterXpath_contact = "]/td[2]";
			String afterXpath_country = "]/td[3]";
			
			String customerName = driver.findElement(By.xpath(beforeXpath + i + afterXpath_customer)).getText();
			System.out.println("CustomerName: " + customerName);
			
			String customerContact = driver.findElement(By.xpath(beforeXpath + i + afterXpath_contact)).getText();
			System.out.println("CustomerContact: " + customerContact);
			
			String customerCountry = driver.findElement(By.xpath(beforeXpath + i + afterXpath_country)).getText();
			System.out.println("CustomerCountry: " + customerCountry);
			System.out.println();
			
		}

	}

}
