package JavaBasic_Collections;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HashMapInSelenium {

	//Login by user role, the user name/pwd can be stored in HashMap
	//Srore username and password together, separated by _
	
	public static void main(String[] args) {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		String userRole = "Customer";
		
		driver.findElement(By.name("username")).sendKeys(getUserName(userRole));
		driver.findElement(By.name("password")).sendKeys(getUserPwd(userRole));

	}
	
	public static HashMap<String, String> getUserCredentials() {
		HashMap<String, String> credentialMap = new HashMap<String, String>();
		credentialMap.put("Admin", "admin_adminpwd");
		credentialMap.put("Customer", "customer_customerpwd");
		credentialMap.put("Seller", "seller_sellerpwd");
		credentialMap.put("Shipper", "shipper_shipperpwd");
		credentialMap.put("Delivery", "deliver_deliverpwd");
		
		return credentialMap;
		
	}
	
	public static String getUserName(String role) {
		String userName = getUserCredentials().get(role).split("_")[0];
		return userName;
	}
	
	public static String getUserPwd(String role) {
		String userPwd = getUserCredentials().get(role).split("_")[1];
		return userPwd;
	}

}
