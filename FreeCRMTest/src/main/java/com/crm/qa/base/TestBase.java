/*

 * @Author: Alley Yu
 * 2020-06-05
 */

package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop; //can be used globally, like test case classes
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	String HOVER_JS = "var evObj = document.createEvent('MouseEvents');" +
            "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
            "arguments[0].dispatchEvent(evObj);";
	
	
	//Constructor, usually define all initial stuff, with the same name as the class.
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/alleyyu/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		String browserName = prop.getProperty("browser");
		if ("chrome".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
			driver = new ChromeDriver();
		} //If there is other browser to use, it can be specified here with else if statment.
		
		//User WebEventListener class to make good log with each WebElement's action
		e_driver = new EventFiringWebDriver(driver);
		//Create object of EventListenerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //The waiting time was defined in TestUtil.java and can be used globally
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	public void hover(WebElement ele) {
		((JavascriptExecutor)driver).executeScript(HOVER_JS, ele);
	}
	

}
