package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSwitchCase {
	
	private WebDriver driver;
	
	public WebDriver launchbrowser(String browser) {	
	
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); //launch chrome
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver(); //launch firefox
			break;
			
		case "safari":
			 driver = new SafariDriver(); //launch safari
			break;
		
		default:
			System.out.println("Please enter valid browser...");
			break;
		}
		
		return driver;
	}

	public void enterUrl(String url) {
		System.out.println("url is : " + url);
		
		if (url.contains("http") || url.contains("https")) {
			driver.get(url);
		} else {
			System.out.println("Incorrect url....");
			try {
				throw new Exception("INCORRECT URL MISSING HTTP OR HTTPS");
			} catch (Exception e) {

			}
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	
	
}
