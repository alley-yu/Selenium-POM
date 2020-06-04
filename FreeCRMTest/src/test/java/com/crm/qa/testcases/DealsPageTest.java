package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	TestUtil testUtil;
	
	String sheetName = "Deals";
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		dealsPage = new DealsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test
	public void checkPageTitle() {
		Assert.assertEquals(dealsPage.checkPageTitle(), "CRMPRO :: 3.0", "The page title is not as expected.");
	}
	
	@Test
	public void checkDealsLabel() {
		Assert.assertTrue(dealsPage.checkDealsLabel(), "Deals label is not correct.");
	}
	
	@Test
	public void clickDealsOrderByDesc() {
		dealsPage.dealsOrderDesc();
	}
	
//	@Test
	public void createNewDeal() {
		homePage.clickOnNewDealLink();
		WebElement newDealNo = driver.findElement(By.xpath("//input[@name = 'sequence']"));
		String newDealNoValue = newDealNo.getAttribute("value");
		
		dealsPage.createNewDeal("AlleyTitle1", "Apple", "10");
		List<String>dealDetailListToInput = new ArrayList<String>();
		dealDetailListToInput.add("AlleyTitle1");
		dealDetailListToInput.add("Apple");
		
		homePage.clickOnDealsLink();
		List<String>dealDetailList = dealsPage.searchCheckDeal(newDealNoValue);
		Assert.assertEquals(dealDetailList, dealDetailListToInput, "The deal detail doesn't match with the input.");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getCRMTestData")
	public void createNewDealWithData(String titleStr, String compStr, String amountStr) {
		homePage.clickOnNewDealLink();
		WebElement newDealNo = driver.findElement(By.xpath("//input[@name = 'sequence']"));
		String newDealNoValue = newDealNo.getAttribute("value");
		
		dealsPage.createNewDeal(titleStr, compStr, amountStr);
		List<String> dealDetailListToInput = Arrays.asList(titleStr, compStr);
//		List<String>dealDetailListToInput = new ArrayList<String>();
//		dealDetailListToInput.add(titleStr);
//		dealDetailListToInput.add(compStr);
		
		homePage.clickOnDealsLink();
		List<String> dealDetailList = dealsPage.searchCheckDeal(newDealNoValue);
		Assert.assertEquals(dealDetailList, dealDetailListToInput, "The deal detail doesn't match with the input.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
