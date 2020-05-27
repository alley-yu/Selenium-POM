import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class YouTubeVideoTest {

	WebDriver driver;

	public void launchYouTube() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.youtube.com/watch?v=jqyRzyZq-Rk");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='text' and @class = 'style-scope ytd-button-renderer style-text size-default']")).click();
		//Thread.sleep(2000);
		
	}
	
	public void handleVideoOnYT() throws FindFailed {
		//Create an object of Screen class, Sikuli
		Screen s = new Screen();
		
		//Create Pattern for specific image
		Pattern playImg = new Pattern("YT_play_new.png");
		s.wait(playImg, 2000);
		s.click();
		
		
		
//		//Create Pattern for specific image
//		Pattern pauseImg = new Pattern("YT_pause.png");
//		s.wait(pauseImg, 2000);
//		s.click();
		
	}
	
	public static void main(String[] args) throws FindFailed, InterruptedException {
		
		//This code cannot be run because of YouTube has exceptional handling.
		YouTubeVideoTest obj = new YouTubeVideoTest();
		obj.launchYouTube();
		obj.handleVideoOnYT();

	}

}
