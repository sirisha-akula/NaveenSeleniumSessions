package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // launch firefox
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		//Browser-page--iframe--shadowDOM--input
		driver.switchTo().frame("pact");
		//driver.findElement(By.id("tea")).sendKeys("GingerTea"); as its a ShadowDomElement it will not work and gives exception "NOSuchElement"
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement tea = (WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		tea.sendKeys("GingerTea");
		

	}

}
