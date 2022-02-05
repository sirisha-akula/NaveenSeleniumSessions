package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch firefox
		driver.get("http://londonfreelance.org/courses/frames/index.html");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));

		//waitForFrameByIndex(2, 5);
		//waitForFrameByName("main", 5);
		
//		By name = By.name("main");
//		waitForFrameByLocator(name, 5);
		
		WebElement frame_ele = driver.findElement(By.name("main"));
		waitForFrameByElement(frame_ele, 10);
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
	
	}

	
	public static WebDriver waitForFrameByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
		return driver;
	}
	
	public static WebDriver waitForFrameByName(String frameName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		return driver;
	}
	
	public static WebDriver waitForFrameByLocator(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		return driver;
	}
	
	public static WebDriver waitForFrameByElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
		return driver;
	}

}
