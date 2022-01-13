package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept2 {

	static WebDriver driver;
	
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //launch chrome
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		//1. id : id is Unique
		//2.name: can be duplicate
//		driver.findElement(By.name("email")).sendKeys("demo@gmail.com");
//		driver.findElement(By.name("password")).sendKeys("demo123");
//		
		
		//3.classname: can be duplicate
		//driver.findElement(By.className("form-control")).sendKeys("Mac");
		
		//4.xpath: is not an attribute
		//address of element in HTML DOM
		//absolute xpath
		//relative xpath
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("qa@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("qatest123");
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
//		By emailId = By.xpath("//*[@id=\"input-email\"]");
//		By pwd = By.xpath("//*[@id=\"input-password\"]");
//		By LoginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		
//		doSendKeys(emailId,"qa@gmail.com");
//		doSendKeys(pwd,"qatest123");
//		doClick(LoginBtn);
		
		
		//5.CSS selector: is not an attribute
		//cascaded style sheet
//		By emailId = By.cssSelector("#input-email");
//		By pwd = By.cssSelector("#input-password");
//		By LoginBtn = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
//		
//		doSendKeys(emailId,"qa@gmail.com");
//		doSendKeys(pwd,"qatest123");
//		doClick(LoginBtn);
		
//		//6. LinkText : only for links <a>	
//		driver.findElement(By.linkText("Register")).click();
		
		//7.PartialLinkText: only for links <a>	
//		driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//8.tagName: html tag
//		String header = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(header);
		
		By register = By.linkText("Register");
		By header = By.tagName("h2");
		
		System.out.println(doGetText(register));
		System.out.println(doGetText(header));
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
