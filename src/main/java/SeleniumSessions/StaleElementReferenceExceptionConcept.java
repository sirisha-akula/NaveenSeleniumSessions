package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementReferenceExceptionConcept {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		//DOM --V1
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		//DOM - V1
		//WebElement fn = driver.findElement(By.id("Form_submitForm_Name"));
		By name= By.id("Form_submitForm_Name");
		//DOM - V1
		driver.findElement(name).sendKeys("ArjunMacha");
		
		
		driver.navigate().refresh();
		//back //forward
		
		//DOM --V2
		//fn = driver.findElement(By.id("Form_submitForm_Name")); //we have to reintiliaze the webelement
		//DOM --v1
		
		FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10))
									.pollingEvery(Duration.ofSeconds(10))
									.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys("VihaanMacha");
		
		
	//	fn.sendKeys("VihaanMacha");//StaleElementReferenceException: stale element reference; 
		// the element is no longer attached to the DOM
	}

}
