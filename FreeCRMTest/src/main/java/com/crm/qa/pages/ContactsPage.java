/*
 * @Author: Alley Yu
 * 
 */

package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//Page Factory
	@FindBy(xpath = "//td[contains(text(), 'Contacts')]")
	@CacheLookup
	//Store the webelement into cache memory. 
	//When calling the webelement, just get it from cache, instead of finding it from browser every time. Improve performance.
	//But if page gets refreshed, the cache memory collapes. It doesn't exist any more. All elements will be stale.
	//So @CacheLookup cannot be used if page could have refreshed.	
	WebElement contactsLabel;
	
	@FindBy(name = "title")
	WebElement titleSel;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//form[@name = 'contactForm']//preceding::input[@type = 'submit' and @value = 'Save']")
	WebElement saveBtn;
	
	@FindBy(name = "cs_name")
	WebElement byName;
	
	@FindBy(xpath = "//input[@name = 'cs_submit' and @value = 'Search']")
	WebElement searchBtn;
	
	
	//Initialize page objects
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactsLable() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContacts(String name) {
		WebElement selectContact = driver.findElement(By.xpath("//a[@_name ='" + name + "']//parent::td[@class = 'datalistrow']//preceding-sibling::td[@class = 'datalistrow']//input[@name = 'contact_id' ]"));
		selectContact.click();
	}
	
	public void newContact(String title, String ftName, String ltName, String comp ) {
		Select select = new Select(titleSel);
		select.selectByValue(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	public void searchContacts(String nameWildcard) {
		byName.sendKeys(nameWildcard);
		searchBtn.click();
		
	}


}
