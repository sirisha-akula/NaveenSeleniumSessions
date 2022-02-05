package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrl {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch firefox
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		driver.findElement(By.linkText("Register")).click();
		String url = waitForUrlToBe("https://demo.opencart.com/index.php?route=account/register",15);
		System.out.println(url);
	
	}
	
	public static String waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlContains(urlFraction))){
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	public static String waitForUrlToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlToBe(url))){
			return driver.getCurrentUrl();
		}
		return null;
	}

}
