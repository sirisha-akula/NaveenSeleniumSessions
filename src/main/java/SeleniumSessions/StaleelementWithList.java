package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleelementWithList {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://demo.opencart.com");
		
		//v1
		List<WebElement> footerLinks = driver.findElements(By.xpath("//nav[@id='top']/following-sibling::footer//a"));
		
		for(int i = 0; i<footerLinks.size(); i++) {
			//v2 v3 v4
			footerLinks.get(i).click();
			Thread.sleep(1000);
			driver.navigate().back();
			//v2 v3 v4
			footerLinks = driver.findElements(By.xpath("//nav[@id='top']/following-sibling::footer//a"));
	
		}
	}

}
