package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

/*
 * Sequence to run below annotations
1. Setup system property for Chrome
2. Launch Chrome Browser
3. Login to App
4. Enter URL
5. Google Title Test
6. Logout from App
7. Close Browser
8. Delete All Cookies
PASSED: googleTitleTest
 * 
 */
	
/*
 * if more than one test case, step 4 and 6 will be repeated with each test cases.
1. Setup system property for Chrome
2. Launch Chrome Browser
3. Login to App
4. Enter URL
5. Google Search Test
6. Logout from App
7. Enter URL
8. Google Title Test
9. Logout from App
10.Close Browser
11.Delete All Cookies
PASSED: googleSearchTest
PASSED: googleTitleTest
 * 
 */
	
	
	@BeforeSuite//1
	public void setUp() {
		System.out.println("Setup system property for Chrome");
	}
	
	@BeforeTest//2
	public void launchBrowser() {
		System.out.println("Launch Chrome Browser");
	}
	
	@BeforeClass//3
	public void logIn() {
		System.out.println("Login to App");
	}
	
	@BeforeMethod//4
	public void enterURL() {
		System.out.println("Enter URL");
	}
	
	@Test (groups = "TestNGBasics")
	public void googleTitleTest() {
		System.out.println("Google Title Test");
	}
	
	@Test (groups = "TestNGBasics")
	public void googleSearchTest() {
		System.out.println("Google Search Test");
	}
	
	@AfterMethod//6
	public void logOut() {
		System.out.println("Logout from App");
	}
	
	@AfterClass//7
	public void closeBrowser() {
		System.out.println("Close Browser");
	}
	
	@AfterTest//8
	public void deleteAllCookies() {
		System.out.println("Delete All Cookies");
	}
	
	@AfterSuite//9
	public void generateTestReport() {
		System.out.println("Generate Test Report");
	}
}
