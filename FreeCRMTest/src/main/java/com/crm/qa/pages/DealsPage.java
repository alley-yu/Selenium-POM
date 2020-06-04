package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	//Page factory
	@FindBy(xpath = "//td[contains(text(), 'Deals')]")
	WebElement dealsLabel;
	
	@FindBy(xpath = "//td[@class = 'datatitle']//strong[contains(text(), 'No.')]//parent::td/a[2]")
	WebElement dealsDesc;
	
	@FindBy(xpath = "//td[@class = 'datatitle']//strong[contains(text(), 'No.')]//parent::td/a[1]")
	WebElement dealsAsc;
	
	@FindBy(name = "cs_keyword")
	WebElement keyword;
	
	@FindBy(xpath = "//input[@type = 'submit' and @name = 'cs_submit' ]")
	WebElement searchDealBtn;
	
	@FindBy(name = "title")
	WebElement title;
		
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(name = "amount")
	WebElement amount;
	
	@FindBy(xpath = "//form[@id = 'prospectForm']//preceding::input[@value = 'Save' and @class = 'button']")
	WebElement saveBtn;
	

	
	
	
	//Initialize page objects
	public DealsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String checkPageTitle() {
		//Use javascript executor to get title
		
		//To initialize the JS object
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		
		//To get the site title
		String currTitle = (String)JS.executeScript("return document.title");
		System.out.println("*********** Deal Page Title**********");
		System.out.println("The title of current page is: " + currTitle);
		
		return currTitle;
	}
	
	public boolean checkDealsLabel() {
		return dealsLabel.isDisplayed();
	}
	
	public void dealsOrderDesc() {
		dealsDesc.click();
	}
	
	public void dealsOrderAsc() {
		dealsAsc.click();
	}
	
	public void createNewDeal(String titleStr, String companyStr, String amountInt) {
		title.sendKeys(titleStr);
		company.sendKeys(companyStr);
		amount.sendKeys(amountInt);
		saveBtn.click();
	}
	
	public List<String> searchCheckDeal(String dealNo) {
		keyword.sendKeys(dealNo);
		searchDealBtn.click();
		
		List<String> dealDetailsList = new ArrayList<String>();
		WebElement titleEle = driver.findElement(By.xpath("//a[contains(text(), '" + dealNo + "')]//parent::td//parent::tr/td[2]"));
		String titleStr = titleEle.getText().trim();
		dealDetailsList.add(titleStr);
		WebElement compEle = driver.findElement(By.xpath("//a[contains(text(), '" + dealNo + "')]//parent::td//parent::tr/td[3]"));
		String compStr = compEle.getText().trim();
		dealDetailsList.add(compStr);
		
		return dealDetailsList;
	}
	
	
	


}
