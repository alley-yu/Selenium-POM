package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory, Object Repositry
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@class = 'btn btn-small']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement signUpLink;
	
	@FindBy(xpath = "//img[@class = 'img-responsive' and @src = 'https://classic.freecrm.com/img/logo.png']")
	WebElement crmLogo;

	
	//Contractor, to initialize the page objects
	public LoginPage() {
		//initialize all above WebElements with driver
		PageFactory.initElements(driver, this); //driver comes from test base class. "this" points to current class object.
	}
	
	//Actions:
	public String validateLoginPageTitle() throws InterruptedException {
		return driver.getTitle();
	}
	
	public Boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String user, String pwd) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage(); //After login, this class will return to homepage, which is the landing page.
	}
}
