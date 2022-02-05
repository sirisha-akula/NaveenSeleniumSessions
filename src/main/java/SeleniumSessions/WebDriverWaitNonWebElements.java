package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitNonWebElements {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch firefox

		driver.get("https://www.amazon.ca");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.titleContains("Amazon"));

//		System.out.println(driver.getTitle());
		String title = doGetPageTitle("Amazon", 5);
		System.out.println(title);
		
		String titleIs = doGetPageTitleIs("Amazon.ca: Low Prices – Fast Shipping – Millions of Items", 5);
		System.out.println(titleIs);
	}

	public static boolean waitForPageTitle(String titleVal, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleVal));
	}

	public static String doGetPageTitle(String titleVal, int timeOut) {
		if (waitForPageTitle(titleVal, timeOut)) {
			return driver.getTitle();

		}
		return null;
	}

	public static boolean waitForPageActTitle(String titleVal, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(titleVal));
	}

	public static String doGetPageTitleIs(String titleVal, int timeOut) {
		if (waitForPageActTitle(titleVal, timeOut)) {
			return driver.getTitle();

		}
		return null;
	}
}
