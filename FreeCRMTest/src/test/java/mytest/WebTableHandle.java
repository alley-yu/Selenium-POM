package mytest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	public static void main(String[] args) throws FileNotFoundException {
		
		Workbook wb = null;
		Sheet sh = null;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement> customerList = driver.findElements(By.xpath("//table[@id = 'customers']//tr"));
		int customerNum = customerList.size();
		
		try {
			wb = new XSSFWorkbook();
//			CreationHelper creationHelper = wb.getCreationHelper();
			sh = wb.createSheet("MyNewSheet");
			
			 // Create a row and put some cells in it. Rows are 0 based.
            Row row = sh.createRow(0);
            // Create a cell and put a value in it.
            Cell cell = row.createCell(0);
//            RichTextString custName = creationHelper.createRichTextString("CustomerName");
//            Font font = wb.createFont();
//            font.setBoldweight((short) 2);
//            font.setItalic(true);
//            custName.applyFont(font);
            cell.setCellValue("CustomerName");
            
            sh.getRow(0).createCell(1).setCellValue("CustomerContact");
            
            sh.getRow(0).createCell(2).setCellValue("CustomerCountry");
			
            for (int i = 2; i <= customerNum; i++ ) {
				
				String beforeXpath = "//*[@id='customers']/tbody/tr[";
				String afterXpath_customer = "]/td[1]";
				String afterXpath_contact = "]/td[2]";
				String afterXpath_country = "]/td[3]";
				
				String customerName = driver.findElement(By.xpath(beforeXpath + i + afterXpath_customer)).getText();
				System.out.println("CustomerName: " + customerName);
				Row custRow = sh.createRow(i-1);
	            custRow.createCell(0).setCellValue(customerName);
				
				String customerContact = driver.findElement(By.xpath(beforeXpath + i + afterXpath_contact)).getText();
				System.out.println("CustomerContact: " + customerContact);
				custRow.createCell(1).setCellValue(customerContact);
				
				String customerCountry = driver.findElement(By.xpath(beforeXpath + i + afterXpath_country)).getText();
				System.out.println("CustomerCountry: " + customerCountry);
				custRow.createCell(2).setCellValue(customerCountry);
				System.out.println();
				
			}
			
			wb.write(new FileOutputStream("/Users/alleyyu/Selenium-POM/FreeCRMTest/src/main/resources/WebTableData1.xlsx"));
		
		} catch(Exception e1) {
			e1.printStackTrace();
		}

		driver.quit();
		
	}

}
