package Selenium.Webdriver.Basic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class BootStrapDropBoxHandle {
	
	WebDriver driver;

	public void launchEnv() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
	}
	
	/**
	 * @deprecated - Use multiSelectFromBootStrapDropdownNew() instead, with input and return
	 * @throws InterruptedException
	 */
	public void multiSelectFromBootStrapDropdown() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
		
		//Use Custom xPath to find those options to choose
		List<WebElement> skillsSelections = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect')]//li//a//label[@class = 'checkbox']"));
		//Use Custom xPath to find all default selected options
		List<WebElement> skillsSelected = driver.findElements(By.xpath("//ul[@class = 'multiselect-container dropdown-menu']//li[@class = 'active']"));

		boolean flag = false;
		
		//Try to find skill to select inside the dropdown list
		for (int i = 0; i < skillsSelections.size(); i++) {
			
			if ("HTML".equalsIgnoreCase(skillsSelections.get(i).getText())){
				//Check if this skill has been selected already. If yes, do nothing. If not, select it.
				//Cannot use isSelected() since this is not Select obj.
				for (int j = 0; j < skillsSelected.size(); j++) {
					String skillSelected = skillsSelected.get(j).getText();
					if (skillsSelections.get(i).getText().equalsIgnoreCase(skillSelected)) {
						flag = true;
						break;
					}
				}
				if (flag == true) {
					break;
				}
				skillsSelections.get(i).click();
					
			}
		}
	}
	
	/** Multiple selection from BootStrap Dropdown box with resetting function
	 * 
	 * @param skillsInput
	 * @return skillsSelected
	 * @throws InterruptedException 
	 */
	public String multiSelectFromBootStrapDropdownNew(String skillsInput) throws InterruptedException {
		driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
		Thread.sleep(3000);
		
		System.out.println("Default skills are: "+ driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).getText());
		
		//Reset options
		List<WebElement> defaultSelected = driver.findElements(By.xpath("//ul[@class = 'multiselect-container dropdown-menu']//li[@class = 'active']"));
		int defaultSelNum = defaultSelected.size();
		for (int i = 0; i < defaultSelNum; i++) {
			defaultSelected.get(i).click();
		}
		Thread.sleep(3000);
		
		//Choose new options
		String skillsInputArr[] = skillsInput.split(",");
		for (int i = 0; i < skillsInputArr.length; i++) {
			skillsInputArr[i] = skillsInputArr[i].trim();
		}
		
//		List<String> skillsInputList = new ArrayList<String>();
//		skillsInputList = Arrays.asList(skillsInputArr);
//		
//		System.out.println("test list: " + skillsInputList);
		
		
		List<WebElement> allSkills = driver.findElements(By.xpath("//ul[@class = 'multiselect-container dropdown-menu']//li//a//label[@class = 'checkbox']"));

		for (int i = 0; i < skillsInputArr.length; i++) {
			for (int j = 0; j < allSkills.size(); j++) {
				if (skillsInputArr[i].equalsIgnoreCase(allSkills.get(j).getText())) {
					allSkills.get(j).click();
					break;
				}
			}
		}
		
		//Close the dropdown box
		driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
		String skillsSelected = driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).getText();
		System.out.println("Now selected skills are: " + skillsSelected);
		
		return skillsSelected;
		
	}
	
	@SuppressWarnings("deprecation")
	public void validateSkillsSelected(String skillsToSel) throws InterruptedException {
		String skillsSelected = multiSelectFromBootStrapDropdownNew(skillsToSel);
		if (skillsToSel.equalsIgnoreCase(skillsSelected)){
			System.out.println("Skills are selected correctly.");
		}
		else {
			Assert.assertEquals(skillsToSel, skillsSelected);
		}
		
	}
	
	public void BootStrapDropdownButton() throws InterruptedException {
		
		driver.navigate().to("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1000);");
		
		driver.findElement(By.xpath("//button[contains(text(), 'Dropdown button')]")).click();
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class = 'dropdown-menu' and @aria-labelledby = 'dropdownMenuButton']//a"));
		for (int i = 0; i < list.size(); i++) {
			if ("Another action".equalsIgnoreCase(list.get(i).getText())) {
				list.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		BootStrapDropBoxHandle obj = new BootStrapDropBoxHandle();
		obj.launchEnv();
		//obj.multiSelectFromBootStrapDropdown();
		
		//Reset, then select options
		//obj.multiSelectFromBootStrapDropdownNew("HTML, CSS, Java");
		
		//Use above method, then do validation of the actual result and expected result
		obj.validateSkillsSelected("HTML, CSS, Java");
		
		//obj.BootStrapDropdownButton();
		
		

	}

}
