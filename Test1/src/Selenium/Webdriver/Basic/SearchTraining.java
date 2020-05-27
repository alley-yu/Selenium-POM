package Selenium.Webdriver.Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTraining {
	
	//ChromeDriver driver;
	
	// Launching the chrome browser
	
	public void launchBrowser() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.simplilearn.com");
		
		String pageTitle = driver.getTitle();
		
		 if (pageTitle.contains("Certification")){
	            System.out.println("Test Passed!");
         } else {
        	 	System.out.println("Test Failed");
         }
		 
		 Thread.sleep(1000);
		 
	
		 
		// find the search button on the page
		WebElement searchField = driver.findElement(By.id("header_srch"));
		searchField.sendKeys("java");
		
		 Thread.sleep(1000);
		
		searchField.submit();
		
		WebElement foundJavaCourse  = driver.findElement(By.xpath("//*[contains(text(), 'Java Certification Training')]"));
		if (foundJavaCourse.isEnabled()){
			 System.out.println("Test2 Passed!");
		} else {
			System.out.println("Test2 Failed");
		}
		 
		 
		// wait 5 seconds and close the browser
		Thread.sleep(5000);
		driver.quit();

	}
	
	
	// Search selenium training and clicking it
	
	// Close the browser

	public static void main(String[] args) throws Exception {
		SearchTraining searchTraining = new SearchTraining();
		searchTraining.launchBrowser();


	}

}
