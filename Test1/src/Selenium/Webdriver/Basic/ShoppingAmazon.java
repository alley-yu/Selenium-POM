package Selenium.Webdriver.Basic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

//import com.sun.tools.javac.util.Assert;

public class ShoppingAmazon {
	
	private static final String DISCOVER_KEY = "Discover";
	
	WebDriver driver;
	
	//launch chrome browser with amazon.com
	public String launchBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		System.out.println("Launch Amazon now.");
		String pageTitle = driver.getTitle();
		return pageTitle;
		}
	
	//Check Today's hot deals
	public void checkDeal() {
		System.out.println("What's the hot deal today?");
		String tagClicked = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).getText();
		System.out.println("It's going to display " + tagClicked);
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[3]/div[2]/div/a[1]")).click();
		if (driver.getTitle().contains("Gold Box Deal")) {
			System.out.println("Deals, here we are. Please choose the thing you want.");
		}
		driver.findElement(By.xpath("//*[@id=\"101 5a0a1c94-announce\"]")).click();
		System.out.println(driver.getTitle());
	}
	
	//Navigate Account & Lists
	public String navigateAccountLists() throws InterruptedException {
		System.out.println("Start navigate Account & Lists...");
		WebElement accountLists = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(accountLists).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText(DISCOVER_KEY)).click();
		String currentPageTitle = driver.getTitle();
		return currentPageTitle;
	}
	
	//Navigate Category with action
	public void navigateCategory() throws InterruptedException {
			WebElement category = driver.findElement(By.xpath("//*[@id=\"top-left-menu\"]/span"));
			Actions action = new Actions(driver);
			action.moveToElement(category).perform();
			Thread.sleep(1000);
			
			WebElement patio = driver.findElement(By.cssSelector("#hamburger-menu-category-list > div:nth-child(7) > span"));
			action.moveToElement(patio);
			action.click();
			action.perform();
			Thread.sleep(2000);
			
			WebElement subCategory = driver.findElement(By.linkText("CHAIRS"));
			String subCategoryFont = subCategory.getCssValue("font-size"); //retrieve CSS property
			System.out.println("Font is "+ subCategoryFont);
			
			subCategory.click();
			if (driver.getTitle().contains("Chair")) {
				System.out.println(driver.getTitle() + " - Successful!");
				Thread.sleep(2000);
			}else {
				System.out.println("The title: "+ driver.getTitle() + "is not expected.");
			}
			
	}
	
	//Use JavascriptExecutor instead of sendkeys()
	public void searchItem() {
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bench");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('twotabsearchtextbox').value='bench'");
		driver.findElement(By.className("nav-input")).click();
		
	}
	
	public void selectDrop() {
		driver.navigate().to("https://www.facebook.com/");
		
		WebElement selMon = driver.findElement(By.name("birthday_month"));
		WebElement selDay = driver.findElement(By.name("birthday_day"));
		WebElement selYear = driver.findElement(By.name("birthday_year"));
		
		Select mon_sel = new Select(selMon);
		Select day_sel = new Select(selDay);
		Select year_sel = new Select(selYear);
		
		//Choose the birthday: Jan-9-1779
		
		mon_sel.selectByIndex(1);
		System.out.println("The selected month is: " + mon_sel.getFirstSelectedOption().getText());
		
		day_sel.selectByValue("9");
		System.out.println("The selected day is: " + day_sel.getFirstSelectedOption().getText());
		
		year_sel.selectByVisibleText("1979");
		System.out.println("The selected year is: " + year_sel.getFirstSelectedOption().getText());
		
	}
	
	public void findElements() {
		List<WebElement> elementsList = driver.findElements(By.xpath("//input[starts-with(@class, 'input')]"));
		
		for (WebElement element:elementsList) {
			System.out.println(element.getAttribute("name"));
		}
	}
	
	//Shift Tab Control: Navigate to qad.com-->Blog(new tab)
	public void shiftTabControl() throws InterruptedException {
		driver.navigate().to("https://www.qad.com/");
		Thread.sleep(2000);
		String currentTitle = driver.getTitle();
		if (currentTitle.contains("QAD")) {
			System.out.println("We are on QAD Website.");
		}
		driver.findElement(By.linkText("BLOG")).click();
		
		//Shift Tab Control
		Set<String> handles = driver.getWindowHandles();
		String winHandle1 = driver.getWindowHandle(); // Get current WindowHandle "Amazon" and store it in winHandle1
		handles.remove(winHandle1); //Remove current WindowHandle of "Amazon"
		
		String winHandle = handles.iterator().next(); //Move WindowHandle to next tab "QAD" and store it in winHandle
		String winHandle2 = "";
		if (winHandle!=winHandle1) {
			winHandle2 = winHandle; //Make winHandle2 referring to "QAD" tab
			driver.switchTo().window(winHandle2); //Switch to winHandle2 "QAD" tab
			
			//Check shifting is successful.
			String currentTabTitle = driver.getTitle(); //Get current title "QAD"
			String expectedTabTitle = "QAD Blog | Cloud ERP Software for Manufacturing";
			if (currentTabTitle.equalsIgnoreCase(expectedTabTitle)) {
				System.out.println("Current Title is " + currentTabTitle + ". " + "Title matches. Shifting successful.");
			} else {
				System.out.println("Current Title is " + currentTabTitle + ". " + "Title doesn't match.");
			}
			
			Assert.assertEquals("TabTitle", currentTabTitle, expectedTabTitle);
			
			//if (currentTabTitle.contains("QAD Blog")) {
			//System.out.println("Current Title is " + currentTabTitle + ". " + "- Shifting Tab Successful!");
			//}
		}
		
	}
	
	//--------------
	
	public void shiftTabControlNew() throws InterruptedException {
		
		driver.get("https://www.qad.com/");
		Thread.sleep(2000);
		String currentTitle = driver.getTitle();
		if (currentTitle.contains("QAD")) {
			System.out.println("We are on QAD Website.");
		}
		
		driver.findElement(By.linkText("BLOG")).click();
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		String homeID = it.next();
		String blogID = it.next();
		
		driver.switchTo().window(blogID);
		System.out.println("Now the title is " + driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		
		driver.switchTo().window(homeID);
		System.out.println("Back to home page " + driver.getTitle());
		
		//String blogID 
		
	}
	
	
	
	//--------------
	
	
	
	
	public void scrollTest() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 600);");
		WebElement sectionName = driver.findElement(By.xpath("//*[contains(text(),'TRENDING TOPICS')]"));
		if (sectionName.isEnabled()){
			 System.out.println("Scrolling successful.");
		}
	}
	
	//take screenshot when testing
	public void takeScreen() throws IOException {
		System.out.println("starting screenshot test.");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/QADBlog1.png");
		Files.copy(source, dest);
		System.out.println("screenshot test done.");
		
	}
	
	//Switch to frame
	public void switchFrame() throws InterruptedException {
		driver.navigate().to("http://demo.automationtesting.in/Frames.html");
		Thread.sleep(2000);
		WebElement frame = driver.findElement(By.xpath("//*[@id='singleframe']"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Test");
		System.out.println("Switched to a frame.");
	}
	
	
	
	//Login amazon with userid/pwd
	public void getLoginPage() throws InterruptedException {
		System.out.println("Try to login...");
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
		Thread.sleep(1000);
		String checkPageTitle = driver.getTitle();
		if (checkPageTitle.contains("Amazon Sign-In")) {
			System.out.println("Get into Login Page now...");
		} else {
			System.out.println("Cannot get Login.");
		}
	}
	
	public void loginAmazon() {
		driver.findElement(By.id("ap_email")).sendKeys("ayy.qad@gmail.com");
		driver.findElement(By.id("continue")).click();
		System.out.println("Input password ...");
		WebElement foundPasswordLabel = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
		if (foundPasswordLabel.isEnabled()) {
			driver.findElement(By.id("ap_password")).sendKeys("56310649");
			driver.findElement(By.id("signInSubmit")).click();
		} else {
			System.out.println("Cannot input password.");
		}
	}
	
	//Check login successful or not with label "Lei's Amazon"
	public void checkLoginSuccessful() {
		driver.findElement(By.xpath("//*[@id=\"nav-your-amazon-text\"]")).click();
		WebElement loginSuccessful = driver.findElement(By.xpath("//*[contains(text(), 'Recommended for you, LEI')]"));
		if (loginSuccessful.isEnabled()) {
			System.out.println("It's my Amazon Account.");
		} else {
			System.out.println("It's not my Amazon Account.");
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		ShoppingAmazon obj = new ShoppingAmazon();
		if	(obj.launchBrowser().contains("Amazon.com: Online Shopping")){
			System.out.println("Launching Amazon is successful.");
			
			//obj.checkDeal();
			
			if (obj.navigateAccountLists().contains(DISCOVER_KEY)){
				System.out.println("Try to find Chairs for Patio...");
				obj.navigateCategory();
			}else {
				System.out.println("No Category dropdown found now.");
				
			}
			
			//obj.searchItem();
			
			//obj.selectDrop();
			
			//obj.findElements();
			
			//obj.shiftTabControl();
			
			obj.shiftTabControlNew();
			
			//obj.scrollTest();
			
			//obj.takeScreen();

			//obj.switchFrame();
			//obj.getLoginPage();
			//obj.loginAmazon();
			//obj.checkLoginSuccessful();
		} else {
			System.out.println("This is not Amazon. The current title is: " + obj.launchBrowser());
		}

	}

}
