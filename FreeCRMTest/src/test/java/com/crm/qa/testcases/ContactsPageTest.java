package com.crm.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		//Initialize the objects
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
//	@Test (priority = 1)
	public void verifyContactsLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLable(), "Contacts label is missing on the page.");
	}
	
//	@Test (priority = 2)
	public void verifySelectSingleContact() {
		contactsPage.selectContacts("Alley Yu");
	}
	
//	@Test (priority = 3)
	public void verifySelectMutiContacts() {
		contactsPage.selectContacts("Alley Yu");
		contactsPage.selectContacts("1 Jon Shen");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
//	@Test (priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){

		homePage.clickOnNewContactLink();
		//contactsPage.newContact("Mrs.", "Allie", "Yu", "Apple");
		contactsPage.newContact(title, firstName, lastName, company);
		
	}
	
	
//	@Test (priority = 5)
	public void selectMultipleContacts() {
		contactsPage.searchContacts("Alley%");
		
		//Use for loop to choose multiple contacts, containing "Alley1"
		String beforePath = "//form[@id = 'vContactsForm']/table/tbody/tr[";
		String afterPath1 = "]/td[2]"; //for finding contact
		String afterPath2 = "]/td/input[@name = 'contact_id']"; //for checking checkbox in front of the contact
		
		for (int i = 4; i <=20; i++) {
			if (driver.findElement(By.xpath(beforePath + i + afterPath1)).getText().contains("Alley1")) {
				driver.findElement(By.xpath(beforePath + i + afterPath2)).click();
			}
		}

	}
	
	@Test (priority = 6)
	public void deleteSingleContact() {
		contactsPage.searchContacts("Alley3 Shen");
		
		//Use custom xPath to choose single contact, "Alley3 Shen"
		driver.findElement(By.xpath("//a[@_name = 'Alley3 Shen']//parent::td[@class = 'datalistrow']//preceding-sibling::td[@class = 'datalistrow']//input[@name = 'contact_id']")).click();
		
		WebElement actionList = driver.findElement(By.name("do_action"));
		Select chooseAction = new Select(actionList);
		chooseAction.selectByVisibleText("Delete Checked");
		driver.findElement(By.xpath("//input[@class = 'button' and @ value = 'DO']")).click();
		
		Alert myAlert = driver.switchTo().alert();
		myAlert.accept();
		
		contactsPage.searchContacts("Alley3 Shen");
				
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
