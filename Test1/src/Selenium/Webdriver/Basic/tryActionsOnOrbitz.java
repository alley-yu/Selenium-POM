package Selenium.Webdriver.Basic;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class tryActionsOnOrbitz {
	
	WebDriver driver;
	
	public void launchOrbitz() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.orbitz.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 600);");
	}
	
	public void pickAirport(WebElement fromOrTo, String airportCode) throws InterruptedException {
		fromOrTo.sendKeys(airportCode);
		Thread.sleep(2000);
		List<WebElement> flyFromTo = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class = 'multiLineDisplay details']"));
		for (int i=0; i<flyFromTo.size(); i++) {
			if (flyFromTo.get(i).getText().contains(airportCode)){
				flyFromTo.get(i).click();
				break;
			}
		}
	}
	
	public void pickFlightDate(String flightType, WebElement pickDateEle, String dateInput) throws InterruptedException {
		
		String dateInputArr[] = dateInput.split("-");
		String inputMon = dateInputArr[0];
		String inputDay = dateInputArr[1];
		String inputYear = dateInputArr[2];
		
		//String xPathBegin = "//*[@id='flight-departing-wrapper-hp-flight']/div/div[2]/div[2]/table/tbody/tr[";
		String XPATH_BEGIN_1 = "//*[@id='flight-departing-wrapper";
		String XPATH_BEGIN_2 = "-hp-flight']/div/div[2]/div[2]/table/tbody/tr[";
		String XPATH_BEGIN = XPATH_BEGIN_1 + XPATH_BEGIN_2;
		if (pickDateEle.getAttribute("id").contains("single")) {
			XPATH_BEGIN = XPATH_BEGIN_1 + "-single" + XPATH_BEGIN_2;
		}
		String XPATH_MID = "]/td[";
		String XPATH_END = "]";
		
		
		//To check Calendar header "Mon Year" is same as departMon + departYear. If not, click next button, until fine it.
		while (true) {
			String MonYearShown = driver.findElement(By.className("datepicker-cal-month-header")).getText();
			if (MonYearShown.contains(inputMon + " " + inputYear)) {
				break;
			} else {
				WebElement nextMonButton = driver.findElement(By.xpath("//button[@class = 'datepicker-paging datepicker-next btn-paging btn-secondary next']"));
				nextMonButton.click();
				Thread.sleep(1000);
			}
			
		}
		
		//Try to build xPath for day picking with 3 parts when different departing or returning date is chosen.
		String pickWhichDate = pickDateEle.getAttribute("name");
		//System.out.println(pickWhichDate);
		
		if (pickWhichDate.equalsIgnoreCase("endDate")){
			XPATH_BEGIN = "//*[@id='flight-returning-wrapper-hp-flight']/div/div[2]/div[2]/table/tbody/tr[";
		}
		
		boolean Flag = false;
		for (int i = 1; i <=6; i++) {
			for (int j = 1; j<=7; j++) {
				WebElement daySel = driver.findElement(By.xpath(XPATH_BEGIN + i + XPATH_MID + j + XPATH_END));
				if (daySel.getText().contains(inputDay)) {
					daySel.click();
					Flag = true;
					break;
				}
			}
			if (Flag) {
				break;
			}
		}
	}
	
	
	public void seachFlightOnOrbitz() throws InterruptedException {
		
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		
		//driver.findElement(By.id("flight-type-roundtrip-label-hp-flight")).click();
		List<WebElement> flightTypeList = driver.findElements(By.name("flight-type"));
		int flightTypeIndex = new Random().nextInt(2);
		
		WebElement flightTypePicked = flightTypeList.get(flightTypeIndex);
		String flightTypeID = flightTypePicked.getAttribute("id");
		//flightTypePicked.click();
		//driver.findElement(By.id("flight-type-roundtrip-label-hp-flight")).click();
		
		String flightType = "R";
		String flightTypeLabelID = "flight-type-roundtrip-label-hp-flight";
		
		if (flightTypeID.contains("one-way")) {
			flightType = "S";
			flightTypeLabelID = "flight-type-one-way-label-hp-flight";
		}
		
		driver.findElement(By.id(flightTypeLabelID)).click();
		
		
		Thread.sleep(1000);
		//driver.findElement(By.id("flight-type-one-way-label-hp-flight")).click();
		
		pickAirport(driver.findElement(By.id("flight-origin-hp-flight")), "SFO");
		
		pickAirport(driver.findElement(By.id("flight-destination-hp-flight")), "JFK");
		

		//---------Choose departure date------------//
		String pickDepartDateID = "flight-departing-hp-flight";
		//WebElement pickDepartDate = driver.findElement(By.id("flight-departing-hp-flight"));
		if (flightType.equals("S")) {
			pickDepartDateID = "flight-departing-single-hp-flight";
		}
		WebElement pickDepartDate = driver.findElement(By.id(pickDepartDateID));
		
		//WebElement pickDepartDate = driver.findElement(By.id("flight-departing-hp-flight"));
		
		//List<WebElement> flightTypeDepartDate = driver.findElements(By.name("starDate"));
		//System.out.println("DepartDate Num: " + flightTypeDepartDate.size());
		
		pickDepartDate.click();
		pickFlightDate(flightType, pickDepartDate, "May-12-2020");

		
		//---------Choose returning date------------//
		if(flightType.equals("R")) {
			WebElement pickReturnDate = driver.findElement(By.id("flight-returning-hp-flight"));
			pickReturnDate.click();
			pickFlightDate(flightType, pickReturnDate, "Jun-21-2020");
		}
		

		//---------Pick passengers------------------//
		
		Select adultsSel = new Select(driver.findElement(By.id("flight-adults-hp-flight")));
		int adultsNum = new Random().nextInt(adultsSel.getOptions().size());
		adultsSel.selectByIndex(adultsNum);;
		
		Select kidsSel = new Select(driver.findElement(By.id("flight-children-hp-flight")));
		int pickKidsNum = new Random().nextInt(kidsSel.getOptions().size());
		kidsSel.selectByIndex(pickKidsNum);
		if (pickKidsNum != 0) {
			
			for (int i = 1; i <= pickKidsNum; i++) {
				WebElement ageSel = driver.findElement(By.id("flight-age-select-" + i + "-hp-flight"));
				Select kidsAgeSel = new Select (ageSel);
				int pickKidsAge = new Random().nextInt(kidsAgeSel.getOptions().size()-1)+1;
				kidsAgeSel.selectByIndex(pickKidsAge);
			}

//				while (true) {
//					int pickKidsAge = new Random().nextInt(kidsAgeSel.getOptions().size());
//					if (pickKidsAge != 0) {
//						kidsAgeSel.selectByIndex(pickKidsAge);
//						break;
//					}
//				}
	
			}
			
		}
		
		
		
	
	

	public static void main(String[] args) throws InterruptedException {
		tryActionsOnOrbitz obj = new tryActionsOnOrbitz();
		obj.launchOrbitz();
		obj.seachFlightOnOrbitz();
		

	}

}
