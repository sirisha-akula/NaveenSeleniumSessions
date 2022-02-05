package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch firefox

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailID = By.id("input-email11");
		By password = By.id("input-password");
//		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//								.withTimeout(Duration.ofSeconds(10))
//								.pollingEvery(Duration.ofSeconds(2))
//								.ignoring(NoSuchElementException.class)
//								.ignoring(StaleElementReferenceException.class);
//    WebElement email_ele =  wait.until(ExpectedConditions.visibilityOfElementLocated(emailID));
		
		 waitForVisibilityOfElementLocatedWithFluentWait(emailID, 10,2).sendKeys("test@gmail.com");
		 driver.findElement(password).sendKeys("test1234");
     
	}

	public static WebElement waitForVisibilityOfElementLocatedWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage(locator + " is not found within given time....");
return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	public static WebElement waitForVisibilityOfElementLocatedWithWebDriverWait(By locator, int timeOut, int pollingTime) {	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage(locator + " is not found within given time....");
	return	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				
				
		
	}
}
