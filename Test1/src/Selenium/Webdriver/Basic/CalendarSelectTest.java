package Selenium.Webdriver.Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

WebDriver driver;
	
	public void CalendarSelectHandling() throws InterruptedException {
		
		//Scenario: Select the row with name as "test2 test2" in Contacts table
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/");
		
		//after login
		driver.switchTo().frame("mainpanel");
		Thread.sleep(1000);
		
		String date = "18-September-2017";
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String mon = dateArr[1];
		String year = dateArr[2];
		
		Select selectMon = new Select(driver.findElement(By.name("slctMonth")));
		selectMon.selectByValue(mon);
		
		Select selectYear = new Select(driver.findElement(By.name("slctYear")));
		selectYear.selectByVisibleText(year);
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[4]/td[4]
		
		String xPathBegin = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String xPathMid= "]/td[";
		String xPathEnd = "]";
		
		final int totalWeekdays = 7;
		boolean flag = false;
		
		//rowNum max could be 7.
		for (int rowNum = 2; rowNum <=7; rowNum++) {
			for (int colNum = 1; colNum <= totalWeekdays; colNum ++) {
				WebElement daySel = driver.findElement(By.xpath(xPathBegin + rowNum + xPathMid + colNum + xPathEnd));
				if (day.equals(daySel.getText())) {
					daySel.click();
					flag = true; //Change this flag to true is to make sure the day has been found.
					break;
				}
			}
			if (flag) {
				break; //Break the outter loop until the day has been found.
			}
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		CalendarSelectTest test = new CalendarSelectTest();
		test.CalendarSelectHandling();
		//This code cannot be run since there is no testing environment.
	}

}
