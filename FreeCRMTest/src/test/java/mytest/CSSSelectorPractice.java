package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelectorPractice {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		Use Custom CSS Selector to findelement
//		1. id --> htmltag#id, #id
//		2. class --> htmltag.classname, .classname, .c1.c2.c3...
//		3. parenttag>childtag
//		   e.g. span._5k_2._5dba>input#u_0_6 (parent by classes, child by id)
//		4. htmltag[id = 'value']
//		   Compare with xPath: //input[@id = "username"]
//		   htmltag[id = 'value1'][class = 'value2']
//		5. contains text in CSS: using *
//		   e.g. input[name*= 'year'] name contains "year"
//		6. starts text in CSS: using ^
//		   e.g. input[id^='password']
//		7. ends with text in CSS: using $
//		   e.g. input[id$= 'name']
//		8. comma in CSS
//		   e.g. input#u_0_m, select[name*= 'year'] (give out multipe results, input#u_0_m is firstname, select[name*= 'year' is Year dropdown box )
//		9. first-of-type
//		   e.g. ul.erkvQe>li:first-of-type first of the list in like google suggestion list
//		9. last-of-type
//		   e.g. ul.erkvQe>li:last-of-type last of the list in like google suggestion list
//		10.nth-of-type(indexno) use n for indexno to get a list of results
//		   e.g. ul.erkvQe>li:nth-of-type(2) 2nd child of type li
//		        ul.erkvQe>li:nth-of-type(n) use findElements by to get a list of elements
//		11.nth-child(indexno)
//		   e.g. ul.erkvQe>li:nth-child(2) 2nd child under ul, no matter of types
//		12.sibling of element, use +
//		   e.g. div.class = 'abcd'+div this will find the sibling of div.class = 'abcd', or you can also specify the class of the sibling, which will be more specific.
//		13.not to exclude certain class
//		   e.g. input.c1.c2:not(.c3) the element with class c1 and c2 but no c3
		
		
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.cssSelector("input#u_0_m")).sendKeys("Alley"); //By htmltag#id
		driver.findElement(By.cssSelector("#u_0_o")).sendKeys("Yu"); //By #id
		driver.findElement(By.cssSelector("input#u_0_r.inputtext._58mg._5dba._2ph-")).sendKeys("alley.yu@hotmail.com"); //By htmltag#id.class1.class2.class3
		driver.findElement(By.cssSelector("input[id^= 'password']")).sendKeys("testtest");
		
		WebElement month = driver.findElement(By.cssSelector("select[id = 'month']")); //with 1 attribute
		Select monthSel = new Select(month);
		monthSel.selectByVisibleText("Jun");
		WebElement day = driver.findElement(By.cssSelector("select[class = '_9407 _5dba _8esg'][id = 'day']")); //with 2 attributes
		Select daySel = new Select(day);
		daySel.selectByVisibleText("21");
		WebElement year = driver.findElement(By.cssSelector("select[name*= 'year']")); //name contains "year"
		Select yearSel = new Select(year);
		yearSel.selectByVisibleText("1979");

		driver.findElement(By.cssSelector("span._5k_2._5dba>input#u_0_6")).click(); //By parenttag.class1.class2>childtag#id
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("a._8esh")).click(); //By htmltag.class
		
		driver.navigate().to("https://www.google.com/");
		
		driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("software testing");
		Thread.sleep(2000);
		
		System.out.println("2nd suggested option: " + driver.findElement(By.cssSelector("ul.erkvQe>li:nth-of-type(2)")).getText());
		WebElement suggestedOptionToClick = driver.findElement(By.cssSelector("ul.erkvQe>li:nth-of-type(2)+li"));
		System.out.println("Now go click the 3rd suggested option: " + suggestedOptionToClick.getText());
		suggestedOptionToClick.click();
		

	}

}
