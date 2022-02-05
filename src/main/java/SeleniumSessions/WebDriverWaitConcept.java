package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch firefox

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailID = By.id("input-email11");
		By password = By.id("input-password");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailID));
//		email_ele.sendKeys("test123@gmail.com");
//		
//		driver.findElement(password).sendKeys("test1234");

		waitForElementPresence(emailID, 10).sendKeys("test@gmail.com");
		getElement(password).sendKeys("test1234");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible on the page.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible. 
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
