package mytest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarcodeTest {
	
	@Test
	public void openWebsite() {
		
		//System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		
		//System.out.println(System.getProperty("user.home")+"/bin/chromedriver");
		///Users/alleyyu/bin
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		
	
		WebDriver driver = new ChromeDriver();

//		
////		WebDriver driver;
//  		WebDriverManager.chromedriver().setup();
////		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
//		System.out.println("iamhere");
//		
//		driver.findElement(By.name("q")).sendKeys("test");
//		
//		driver.navigate().to("https://www.qad.com/");
		
	}
	
	

	@Test
	public void barCodeTest() throws IOException, NotFoundException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://barcode.tec-it.com/en");
		
//		String inputForBarCode = "AlleyYu";
		
//		WebElement dataInput = driver.findElement(By.name("Data"));
//		dataInput.clear();
//		dataInput.sendKeys(inputForBarCode);
//		driver.findElement(By.linkText("Refresh")).click();
		
		
		String barCodeURL = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(barCodeURL);
		
		URL url = new URL(barCodeURL);
		BufferedImage bufferedImage = ImageIO.read(url);
		
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result = new MultiFormatReader().decode(binaryBitmap);
		System.out.println(result.getText());
		
		Assert.assertEquals(result.getText(), "ABC-abc-1234");
		
	}

}
