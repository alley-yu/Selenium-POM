package Selenium.Webdriver.Basic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;





public class ForSeleniumPrac {
	
	WebDriver driver;
	
	public void getChar() {
		String myString = "abcadefghijklamnopqarstuvwxyz";
		System.out.println(myString.indexOf("a"));
		System.out.println(myString.indexOf("a", 3));
	}
	
	public void controlFlow() {
		//try while loop
		int i = 1;
		
		while (i<3) {
			i=i+1;
		}
		System.out.println("Now i is: " + i);
		
		//try for loop
		int j=1;
		int k=0;
		
		while (j<=4) {
			k=k+1;
			j++;
		}
		System.out.println("j is: " + j);
		System.out.println("k is: " + k);
	}
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
	}
	
	public void testWithAlert() throws InterruptedException {
		driver.get("https://www.rediff.com/");
		WebElement signIn = driver.findElement(By.linkText("Sign in"));
		signIn.click();
		String title = driver.getTitle();
		//System.out.println(title);
		if (title.contains("Rediffmail")) {
			WebElement signInButton = driver.findElement(By.name("proceed"));
			signInButton.click();
			Alert myAlert = driver.switchTo().alert();
			System.out.println("Message comes from Alert: " + myAlert.getText());
			
			Thread.sleep(2000);
			
			myAlert.accept(); //Click OK button.
			//myAlert.dismiss(); //Click Cancel button if any.
		} else {
			System.out.println("Something is wrong.");
		}
		driver.quit();
		
	}
	
	public void uploadFile(){
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.xpath("//*[@id=\"fileupload\"]")).sendKeys("/users/alleyyu/Documents/testfile.txt");
	}

	//This method cannot run since login doesn't work. But it's good to learn frame switch here.
	public void frameHandling() throws InterruptedException {
		driver.get("https://classic.freecrm.com/");
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(), 'Contacts')]"));
	}
	
	public void mouseMovement() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.ebay.com/");
		
		
		Thread.sleep(1000);
		
		WebElement category = driver.findElement(By.linkText("Fashion"));
		Actions action = new Actions(driver); //Actions is a class, import from selenium
		action.moveToElement(category).perform(); //action is an object.
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Jewelry")).click();
		
		driver.quit();
		
	}
	
	public void dragDropHandling() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://jqueryui.com/droppable/");
		
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		
		WebElement source = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement target = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		Actions action = new Actions(driver);
		//action.clickAndHold(source).moveToElement(target).release().build().perform();
		source.click();
		Thread.sleep(2000);
		action.dragAndDrop(source, target).release().build().perform();
		
		Thread.sleep(3000);
		
		driver.quit();
	}
	
	public void implicitWait() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.ebay.com/");
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void customXpath() {
		driver.get("https://www.ebay.com/");
		//driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("test");
		
		//constains() is a function.
		driver.findElement(By.xpath("//input[contains(@class, 'gh-tb ui-autocomplete-input')]")).sendKeys("test1");
		driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")).click();
		
		
		//If the id is dynamic, like starting with test_, but ending number is changing as below.
		//id = test_123
		//id = test_456
		//id = test_789
		
		//Use xPath to find element which is an input type, it's id contains "test_"
		//driver.findElement(By.xpath("//input[contains(@id, 'test_')]")).sendKeys("test");
		//driver.findElement(By.xpath("//input[starts-with(@id, 'test_')]")).sendKeys("test");
		//driver.findElement(By.xpath("//input[ends-with(), '_test']")).sendKeys("test");
		
		//For links: Custom xPath
		//All links are represented by <a> html tag.
		driver.findElement(By.xpath("//a[contains(text(), 'Sell')]")).click();
		
		driver.quit();
	}
	
	public void findElements() {
		driver.get("https://www.ebay.com/");
		
		//1. get the total count of link on the page
		//2. get the text of each link on the page
		
		//all links are represented by <a> html tag
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		
		//get the size of the list webelement, linklist
		System.out.println("There are " + linkList.size() + " links on the page.");
		
		//Only print out the link with text
		for (int i=0; i < linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			if (linkText != null && linkText.length() !=0) {
				System.out.println(linkText);
			}
		}
		
		List<WebElement> buttonList = driver.findElements(By.tagName("button"));
		System.out.println("There are " + buttonList.size()+ " buttons on the page.");
		
		driver.quit();
	}
	
	public void takeScreenshot() throws IOException {
		
		driver.get("https://www.ebay.com/");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File ("./Screenshot/testScreenshot1.jpg");
		Files.copy(source, dest);
		
		driver.quit();
		
	}
	
	//Specify 3 inputs. To the webdriver waiting for some time, ignore exception until the locator turns clickable.
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
	public void explicitWaitConcept() {
		
		driver.get("https://www.facebook.com/");
		WebElement firstName = driver.findElement(By.xpath("//input[@class = 'inputtext _58mg _5dba _2ph-']"));
		clickOn (driver, firstName, 20);
		firstName.sendKeys("Alley");
		
		driver.quit();
	
	}
	
	public void handleWindowPopup() throws InterruptedException {
		
		driver.get("http://popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//a[contains(text(), 'PopUp #3')]")).click();
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		System.out.println("The parent window: Title is " + driver.getTitle());
		
		//In order to get the very 1st window handle, make new iterator move to next.
		String parentWinID = it.next();
		String childWinID = it.next();
		
		driver.switchTo().window(childWinID);
		System.out.println("Switched to child window: Title is " + driver.getTitle());
		
		Thread.sleep(2000);
		driver.close();
		
		driver.switchTo().window(parentWinID);
		System.out.println("Now the title is " + driver.getTitle());
		
		driver.quit();
		
	}
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		ForSeleniumPrac obj = new ForSeleniumPrac();
		
		obj.launchBrowser();
		
		//obj.getChar();
		
		//obj.controlFlow();
		
		//javascript popup
		//obj.testWithAlert();
		
		//obj.uploadFile();
		
		//obj.frameHandling(); //This method cannot run since the login step cannot be passed.
		
		//obj.mouseMovement();
		
		//obj.dragDropHandling();
		
		//obj.implicitWait();
		
		//obj.customXpath();
		
		// obj.findElements();
		
		//obj.takeScreenshot();
		
		//obj.explicitWaitConcept();
		
		obj.handleWindowPopup();
		

	}

}
