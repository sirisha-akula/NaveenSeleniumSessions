package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleFooterLinks {

	static WebDriver driver;

	public static void main(String[] args) {
	

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch chrome
		driver.get("https://www.google.com/");
		
		By footerLinks = By.xpath("//div[@class='KxwPGc SSwjIe']//a");
		clickOnLink(footerLinks, "Business");
		
	}
		public static void clickOnLink(By locator, String linkName) {
		List<WebElement> footerLinks = driver.findElements(locator);
		System.out.println(footerLinks.size());

		for(WebElement e : footerLinks) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(linkName)) {
				e.click();
				break;
			}
		}
		
		
		driver.close();
	}

}
