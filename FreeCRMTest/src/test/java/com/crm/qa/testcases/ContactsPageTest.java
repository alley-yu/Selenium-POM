package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@Test (priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){

		homePage.clickOnNewContactLink();
		//contactsPage.newContact("Mrs.", "Allie", "Yu", "Apple");
		contactsPage.newContact(title, firstName, lastName, company);
		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
