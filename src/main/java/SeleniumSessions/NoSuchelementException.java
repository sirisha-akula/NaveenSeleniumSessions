package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchelementException {
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //launch chrome
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		
		driver.findElement(By.id("input-email1")).sendKeys("test@gmail.com");
		//NoSuchElementException: no such element: Unable to locate element
	}

}
