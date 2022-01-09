package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public By getBy(String locatorType, String locatorvalue) {
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
	
	
	public WebElement getElement(By locator) {
		  return driver.findElement(locator);
		}
		
			public void doSendKeys(By locator, String value) {
				getElement(locator).sendKeys(value);
			}
			
			public void doSendKeys(String locatorType, String locatorvalue, String value) {
				getElement(getBy(locatorType, locatorvalue)).sendKeys(value);
			}
			
			

}
