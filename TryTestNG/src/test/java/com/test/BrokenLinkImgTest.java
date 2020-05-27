package com.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkImgTest {
	
	WebDriver driver;
	
	public void launchEnv() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
	}
	
	public void checkBrokenLinkImg() throws MalformedURLException, IOException {
		List<WebElement> linksList = driver.findElements(By.tagName("a")); //since all links start with <a> tag.
		linksList.addAll(driver.findElements(By.tagName("img"))); //find all images starting with <img> and attach them to the linksList
		
		System.out.println("The size of full links is: " + linksList.size());
		
		List<WebElement> activeList = new ArrayList<WebElement>();
		
		for (int i = 0; i < linksList.size(); i++) {
			if (linksList.get(i).getAttribute("href") != null && !linksList.get(i).getAttribute("href").contains("javascript")) {
				activeList.add(linksList.get(i));
			}
		}
		
		System.out.println("The size of active links is: " + activeList.size());
		
		//Check all active link/image's href url with httpconnection API:
		//200: ok
		//404: not found
		//500: internal error
		//400: bad request
		
		for (int i = 0; i < activeList.size(); i++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeList.get(i).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeList.get(i).getAttribute("href") + "--->" + response);
		}
		
	}
	
	public void quitEnv() {
		driver.quit();
	}
	

	public static void main(String[] args) throws MalformedURLException, IOException {
		BrokenLinkImgTest obj = new BrokenLinkImgTest();
		obj.launchEnv();
		obj.checkBrokenLinkImg();
		obj.quitEnv();
		

	}

}
