package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BootStrapDropdownTest {
	
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	WebDriver driver;
	
	@BeforeMethod
	public void launchPage() {
		System.setProperty(WEBDRIVER_CHROME_DRIVER, System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		
	}
	
	@Test (priority = 1, groups = "findDropdown")
	public void findDropdownBox() {
		boolean dropdownBoxFound = driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).isDisplayed();
		Assert.assertTrue(dropdownBoxFound);
	}
	
	@Test (priority = 2, dependsOnMethods = "findDropdownBox", groups = "Valid data")
	public void less3SelectedFromDropdown() throws InterruptedException, IOException {
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/alleyyu/eclipse-workspace/TryTestNG/src/test/java/com/test/bootStrapConfig.properties");
		prop.load(ip);
		String skillsInput = prop.getProperty("3lessSkillsInput");
		
		Map<String, Object> result = selectedFromDropdown(skillsInput);
		
		Object expectedSkillsObj = result.get("SKILLSPICKEDLIST");
		Object skillsSelectedTextObj = result.get("SKILLSPICKEDTEXT");
		

		List expectedSkillsList = (List) expectedSkillsObj;
		String expectedSkillsStr = String.join(", ", expectedSkillsList);

		String skillsSelectedTextStr = (String) skillsSelectedTextObj;
		
		Assert.assertEquals(expectedSkillsStr, skillsSelectedTextStr);
			
	}
	
	@Test (priority = 3, groups = "Valid data")
	public void more3SelectedFromDropdown() throws InterruptedException, IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/alleyyu/eclipse-workspace/TryTestNG/src/test/java/com/test/bootStrapConfig.properties");
		prop.load(ip);
		String skillsInput = prop.getProperty("3moreSkillsInput");
		
		Map<String, Object> result = selectedFromDropdown(skillsInput);
		
		Object expectedSkillsObj = result.get("SKILLSPICKEDLIST");
		Object skillsSelectedTextObj = result.get("SKILLSPICKEDTEXT");
		

		List expectedSkillsList = (List) expectedSkillsObj;
		String expectedSkillsStr = expectedSkillsList.size() + " selected";

		String skillsSelectedTextStr = (String) skillsSelectedTextObj;
		
		Assert.assertEquals(expectedSkillsStr, skillsSelectedTextStr);
			
	}
	
	@Test(dependsOnMethods = "more3SelectedFromDropdown", groups = "Valid data")
	public void simpleTestDependsOnMethod() {
		System.out.println("This case depends on method: more3SelectedFromDropdown. It won't be executed only more3SelectedFromDropdown is successful.");
	}
	
	@Test (priority = 4, groups = "Invalid data")
	//Inputtin any unlisted skill will be treated as none skill selected.
	public void noneSelectedFromDropdown1() throws InterruptedException, IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/alleyyu/eclipse-workspace/TryTestNG/src/test/java/com/test/bootStrapConfig.properties");
		prop.load(ip);
		String skillsInput = prop.getProperty("noneSkillInput1");
		
		Map<String, Object> result = selectedFromDropdown(skillsInput);
		
		Object skillsSelectedTextObj = result.get("SKILLSPICKEDTEXT");

		String skillsSelectedTextStr = (String) skillsSelectedTextObj;
		
		Assert.assertEquals("None selected", skillsSelectedTextStr);
			
	}
	
	@Test (priority = 4, groups = "Invalid data")
	//Inputting any unlisted skill will be treated as none skill selected.
	public void noneSelectedFromDropdown2() throws InterruptedException, IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/alleyyu/eclipse-workspace/TryTestNG/src/test/java/com/test/bootStrapConfig.properties");
		prop.load(ip);
		String skillsInput = prop.getProperty("noneSkillInput2");
		
		Map<String, Object> result = selectedFromDropdown(skillsInput);
		
		Object skillsSelectedTextObj = result.get("SKILLSPICKEDTEXT");

		String skillsSelectedTextStr = (String) skillsSelectedTextObj;
		
		Assert.assertEquals("None selected", skillsSelectedTextStr);
			
	}
	
	@Test (priority = 4 , groups = "Invalid data")
	//Inputtin any unlisted skill will be treated as none skill selected.
	public void noneSelectedFromDropdown3() throws InterruptedException, IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/alleyyu/eclipse-workspace/TryTestNG/src/test/java/com/test/bootStrapConfig.properties");
		prop.load(ip);
		String skillsInput = prop.getProperty("noneSkillInput3");
		
		Map<String, Object> result = selectedFromDropdown(skillsInput);
		
		Object skillsSelectedTextObj = result.get("SKILLSPICKEDTEXT");

		String skillsSelectedTextStr = (String) skillsSelectedTextObj;
		
		Assert.assertEquals("None selected", skillsSelectedTextStr);
			
	}
	
	@Test(expectedExceptions = NumberFormatException.class, groups = "Misc")
	public void testExpectedExceptionsPara() {
		String x = "100A";
		Integer.parseInt(x);
	}

	
	@AfterMethod
	public void closePage(){
		driver.quit();
	}
	

	public Map<String, Object> selectedFromDropdown(String skillsInput) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
		
		//Reset options
		List<WebElement> defaultSelected = driver.findElements(By.xpath("//ul[@class = 'multiselect-container dropdown-menu']//li[@class = 'active']"));
		int defaultSelNum = defaultSelected.size();
		for (int i = 0; i < defaultSelNum; i++) {
			defaultSelected.get(i).click();
		}
		Thread.sleep(3000);
		
		List<String> skillsPickedList = new ArrayList<String>(); //for return selected skills
		
		
		if (skillsInput != null) {
		
			//Choose new options
			String skillsInputArr[] = skillsInput.split(",");
			for (int i = 0; i < skillsInputArr.length; i++) {
				skillsInputArr[i] = skillsInputArr[i].trim();
			}
			
			List<WebElement> allSkills = driver.findElements(By.xpath("//ul[@class = 'multiselect-container dropdown-menu']//li//a//label[@class = 'checkbox']"));
	
			for (int i = 0; i < skillsInputArr.length; i++) {
				for (int j = 0; j < allSkills.size(); j++) {
					if (skillsInputArr[i].equalsIgnoreCase(allSkills.get(j).getText())) {
						allSkills.get(j).click();
						break;
					}
				}
			}
	
			List<WebElement> skillsPicked = driver.findElements(By.xpath("//ul[@class = 'multiselect-container dropdown-menu']//li[@class = 'active']"));
			//skillsPicked.forEach(action);
			
//			for (int i = 0; i < skillsPicked.size(); i++) {
//				String skillPicked = skillsPicked.get(i).getText();
//				skillsPickedList.add(skillPicked);
//			}
			
			//For each webelement in WebElement List skillsPicked, do the loop, same as for (i) loop.
			for (WebElement el: skillsPicked) {
				String skillPicked = el.getText();
				skillsPickedList.add(skillPicked);
			}
			
		}
		
		String skillsPickedText = driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).getText();
		
		Map<String, Object> returnMap = new HashMap();
		returnMap.put("SKILLSPICKEDLIST", skillsPickedList);
		returnMap.put("SKILLSPICKEDTEXT", skillsPickedText);
		return returnMap;
		

	}
}
