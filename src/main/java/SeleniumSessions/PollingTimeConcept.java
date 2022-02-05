package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PollingTimeConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch firefox

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailID = By.id("input-email11");
		By password = By.id("input-password");

		// Default polling time in selenium is 500 milliseconds = 0.5 seconds
		//1.
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.pollingEvery(Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(emailID));
		
		//2. 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailID));

	}

}
