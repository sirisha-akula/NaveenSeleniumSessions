package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooterLinks {

	public static void main(String[] args) {

		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(); // launch firefox
		driver.get("https://www.amazon.ca");
		
	List<WebElement> footerLinks = driver.findElements(By.xpath("//div[contains(@class,'navFooterCopyright')]//li/a"));
	
	for(WebElement e: footerLinks) {
		String text = e.getText();
		System.out.println(text);
		if(text.equals("Interest-Based Ads")) {
			e.click();
		}
	}

	}

}
