package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //launch chrome
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		
		//Create a webelement
		//WE= By Locator
		//Create webelement + action(click, sendkeys, isDisplayed....)
		
		//1.
//		driver.findElement(By.id("input-email")).sendKeys("Arjun@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("kittubro");
		
		//2.
//	WebElement emailId	= driver.findElement(By.id("input-email"));
//	WebElement password	= driver.findElement(By.id("input-password"));
//	
//	emailId.sendKeys("Arjun@gmail.com");
//	password.sendKeys("kittubro");
		
		//3.By locator approach:
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement emailID = 	driver.findElement(emailId);
//		WebElement pwd = 	driver.findElement(password);
//	
//		emailID.sendKeys("Arjun@gmail.com");
//		pwd.sendKeys("kittubro");
		
		
		//4. by locator with generic method
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(emailId).sendKeys("Arjun@gmail.com");
//		getElement(password).sendKeys("kittubro");
		
		//5.By locator with getElement and action generic method:
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(emailId,"Arjun@gmail.com" );
//		doSendKeys(password,"kittubro");
		
		
		//6.By locator with getElement and action generic method with Util class:
		
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		ElementUtil eleutil = new ElementUtil(driver);
//		eleutil.doSendKeys(emailId, "vihaan@gmail.com");
//		eleutil.doSendKeys(password, "vihaan@test");
		
	//	7.String locator with getElement and action generic method with Util class:
//		
//		String emailId = "input-email";
//		String password = "input-password";
//		
//		doSendKeys("id", emailId, "siri@gmail.com");
//		doSendKeys("id", password, "test122");
//	
		
		//8.
		
		String emailId = "input-email";
		String password = "input-password";
		
		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.doSendKeys("ID", emailId, "vishnu@test.com");
		eleutil.doSendKeys("ID", password, "vishnu@test");
	}
	
	
	public static By getBy(String locatorType, String locatorvalue) {
		By locator = null;
		
		switch (locatorType.toLowerCase()) {
		case "id":
		locator = By.id(locatorvalue);
			
			break;

		default:
			break;
		}
		
		return locator;
	}
	
	public static WebElement getElement(By locator) {
	  return driver.findElement(locator);
	}
	
		public static void doSendKeys(By locator, String value) {
			getElement(locator).sendKeys(value);
		}
		
		public static void doSendKeys(String locatorType, String locatorvalue, String value) {
			getElement(getBy(locatorType, locatorvalue)).sendKeys(value);
		}
			
		
	
}
