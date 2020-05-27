package Selenium.Webdriver.Basic;

//Use reading property file to find webelement and fill in with testing data

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class ReadPropFile {
	
	WebDriver driver;
	
	public void launchBrower(String browser) {
		
		if ("chrome".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
			driver = new ChromeDriver();
		}
	}
	
	public void readPropFile() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/alleyyu/eclipse-workspace/Test1/src/Selenium/Webdriver/Basic/config.properties");
		
		prop.load(ip);
		
		String getBrowser = prop.getProperty("browser");
		launchBrower(getBrowser);
		
		String getUrl = prop.getProperty("URL");
		driver.get(getUrl);
		
		String getFirstname = prop.getProperty("firstname_xpath");
		String getFirstnameInput = prop.getProperty("firstname");
		driver.findElement(By.xpath(getFirstname)).sendKeys(getFirstnameInput);
		
		String getLastname = prop.getProperty("lastname_xpath");
		String getLastnameInput = prop.getProperty("lastname");
		driver.findElement(By.xpath(getLastname)).sendKeys(getLastnameInput);
		
		String getEmail = prop.getProperty("email_xpath");
		String getEmailInput = prop.getProperty("email");
		driver.findElement(By.xpath(getEmail)).sendKeys(getEmailInput);
		
		String birthMon = prop.getProperty("birth_month_xpath");
		String birthDay = prop.getProperty("birth_day_xpath");
		String birthYear = prop.getProperty("birth_year_xpath");
		WebElement getBirthMon = driver.findElement(By.xpath(birthMon));
		WebElement getBirthDay = driver.findElement(By.xpath(birthDay));
		WebElement getBirthYear = driver.findElement(By.xpath(birthYear));
		
		Select birthMon_sel = new Select(getBirthMon);
		Select birthDay_sel = new Select(getBirthDay);
		Select birthYear_sel = new Select(getBirthYear);
		birthMon_sel.selectByIndex(6);
		birthDay_sel.selectByValue("21");
		birthYear_sel.selectByVisibleText("1979");
		
		String getGenderFemale = prop.getProperty("gender_female_xpath");
		driver.findElement(By.xpath(getGenderFemale)).click();
		
		//driver.quit();
		
		
	}

	public static void main(String[] args) throws IOException {
		
		ReadPropFile obj = new ReadPropFile();
		
		obj.readPropFile();
		
	}

}
