package Selenium.Webdriver.Basic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class JavaScriptExecutorConcept {
	
	WebDriver driver;
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver; //convert webDriver to JavascriptExecutor
		
		//Use setAttributes to set multile attributes
		//js.executeScript("arguments[0].setAttribute('style', 'background: "+ color +";')", element);
		//js.executeScript("arguments[0].setAttribute('style', 'background: "+ color +"; border: 2px solid red;')", element);
		js.executeScript("arguments[0].style.background = '" +  color + "'", element);
		
        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
		
	}
	
	public static void flash(WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgColor = element.getCssValue("backgroundColor");
		//System.out.println("Sign In color: " + bgColor);
		String loginColor = driver.findElement(By.xpath("//*[@id='u_0_b']")).getCssValue("backgroundColor");
		for (int i=0; i<10; i++) {
			changeColor (loginColor, element, driver);
			Thread.sleep(100);
			changeColor (bgColor, element, driver);
		}
	}
	
	public void JavaScriptExecution() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//*[@id='u_0_m']")).sendKeys("Alley");
		driver.findElement(By.xpath("//*[@id='u_0_o']")).sendKeys("Yu");

		//driver.findElement(By.xpath("//*[@id=\"u_0_13\"]")).click();
		
		WebElement signIn = driver.findElement(By.xpath("//*[@id='u_0_13']"));
		flash (signIn, driver);
		
		//draw a border for Sign In button after flashing
		drawBorder(signIn, driver); 
		
		//take screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File ("./Screenshot/testScreenshot3.jpg");
		FileUtils.copyFile(src, dest);
		
		generateAlert(driver, "Sign Up button does not work.");
		Thread.sleep(1000);
		Alert myAlert = driver.switchTo().alert();
		myAlert.accept();
		
		
		//Use Javascript to sendKeys
		WebElement email = driver.findElement(By.xpath("//*[@id = 'u_0_r']"));
		sendKeysToElementByJS (driver, email, "alley.yu@gmail.com");
		
		//Use Javascript to click element
		WebElement gender = driver.findElement(By.xpath("//*[@id = 'u_0_7']"));
		clickElementByJS(driver, gender);
		
		//1. Use Selenium to refresh browser
		driver.navigate().refresh();
		WebElement genderCustom = driver.findElement(By.xpath("//*[@id = 'u_0_8']"));
		clickElementByJS (driver, genderCustom);
		
		//2. Use Javascript executor to refresh browser
		refreshBrowserByJS(driver);
		
		//Use JS to get title
		System.out.println("The title got by JS is: " + getTitleByJS(driver));
		
		//get all text from the page with JS executor
		//System.out.println("Here comes all the text on the page.");
		//System.out.println(getPageInnerText(driver));
		
		
		//Use JS to scroll page to the bottom
		driver.get("https://www.amazon.com/");
		//pageScrollDownByJS(driver);
		
		//Use JS to scroll page until get the element.
		WebElement languageSel = driver.findElement(By.xpath("//*[@id = 'icp-touch-link-language']"));
		scrollIntoView(driver, languageSel);
		
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border = '2px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("alert('test')");
		js.executeScript("alert('" + message + "')");
	}
	
	public static void clickElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void sendKeysToElementByJS(WebDriver driver, WebElement element, String values) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '"+ values + "'", element);
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
		
	}
	
	public static void pageScrollDownByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)" );
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		JavaScriptExecutorConcept obj = new JavaScriptExecutorConcept();
		obj.JavaScriptExecution();

	}

}
