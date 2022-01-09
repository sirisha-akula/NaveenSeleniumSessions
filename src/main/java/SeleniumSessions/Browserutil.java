package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserutil {

	private WebDriver driver;

	/**
	 * This method is used to initialize the driver on basis of browser name
	 * 
	 * @param browser
	 * @return this return webdriver
	 */
	public WebDriver init_WebDriver(String browser) {

		System.out.println("Browser name is : " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// "/Users/sirishaakula/Documents/Selenium/BrowserDrivers/chromedriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); // launch chrome
		} else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					"/Users/sirishaakula/Documents/Selenium/BrowserDrivers/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();

		} else {
			System.out.println("please pass the right browser...." + browser);
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
