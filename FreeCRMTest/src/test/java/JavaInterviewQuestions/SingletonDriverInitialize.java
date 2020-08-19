package JavaInterviewQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//In real case, this class can be testBase class for initialization
//Singleton design pattern used in Selenium

public class SingletonDriverInitialize {
	
	private static SingletonDriverInitialize instanceDriver = null;
	private WebDriver driver;
	
	private SingletonDriverInitialize(){
		
	}
	
	public WebDriver openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	//Write a public static method which returns the object of the singleton class.
	public static SingletonDriverInitialize getInstance(){
		if (instanceDriver == null) {
			instanceDriver  = new SingletonDriverInitialize();
		}
		return instanceDriver;
	}
	

}
