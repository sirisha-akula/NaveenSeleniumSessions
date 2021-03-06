package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch chrome
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		driver.manage().window().maximize();
		
		//html tag : select tag
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		WebElement country_ele = driver.findElement(country);
		WebElement state_ele = driver.findElement(state);
		
//		Select select = new Select(country_ele);
//		select.selectByIndex(7);
//		select.selectByValue("India");
//		//select.selectByVisibleText("Hong Kong");
//		
//		Select select1 = new Select(state_ele);
//		select1.selectByVisibleText("Telangana");
		
		//doSelectDropDownByIndex(country, 4);
		doSelectDropDownByVisibleText(country,"India");
		Thread.sleep(2000);
		doSelectDropDownByVisibleText(state,"Telangana");

		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	
	public static void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
	
	



}
