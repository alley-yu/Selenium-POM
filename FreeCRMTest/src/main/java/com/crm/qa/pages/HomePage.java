package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory, Object Repositry
	@FindBy(xpath = "//td[contains(text(), 'User: Demo User')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(), 'New Deal')]")
	WebElement newDealLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	//Contractor, to initialize the page objects
	public HomePage() {
		PageFactory.initElements(driver,this); //driver comes from test base class. "this" points to current class object.
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean checkUserNameLabel() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink(){
		hover(contactsLink);
		
		//action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewDealLink(){
		hover(dealsLink);
		newDealLink.click();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
}
