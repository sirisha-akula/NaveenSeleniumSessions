package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetValueAttribute {
	
	static WebDriver driver;

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //launch chrome
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
	//By emailId = By.id("input-email");
//		doSendKeys(emailId,"test@123.com");
//	String att = driver.findElement(emailId).getAttribute("value");
//	System.out.println(att);
	
String para = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/p[2]")).getText();
System.out.println(para);
		
		
//		String text = doGetText(emailId);
//		System.out.println(text);

//doGetAttribute(emailId,"value");

	}
	
	public static String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
}
