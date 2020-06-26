package mytest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFReaderTest {
	
	@Test
	public void readPDFTest() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf");
		String currentURL = driver.getCurrentUrl();
		
		URL url = new URL(currentURL);
		
		InputStream is = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;
		
		document = PDDocument.load(fileParse);
		String pdfContent = new PDFTextStripper().getText(document);
		
		System.out.println(pdfContent);
		
		Assert.assertTrue(pdfContent.contains("PDF Bookmark Sample Page 1 of 4"));
		Assert.assertTrue(pdfContent.contains("PDF BOOKMARK SAMPLE"));
		Assert.assertTrue(pdfContent.contains("Sample Date: May 2001"));
	}
	
	

}
