package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSwitchCase {
	private static WebDriver driver;
	
	public static WebDriver launchbrowser(String browser) {	
	
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); //launch chrome
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			 driver = new ChromeDriver(); //launch chrome
			break;
			
		case "safari":
			 driver = new SafariDriver(); //launch chrome
			break;
		
		default:
			System.out.println("Please enter valid browser...");
			break;
		}
		
		return driver;
	}

	public static void main(String[] args) {
		BrowserSwitchCase.launchbrowser("Safari");
		driver.get("https://www.amazon.ca/");
		
	}
	
	
}
