package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		// Français

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch chrome
		driver.get("https://www.freshworks.com/");

		By footerlinks = By.xpath("//ul[@class='footer-nav']//a");
		By termsServiceLinks = By.xpath("//div[@class='footer-nav copyrights-nav hide-in-mobile']/a");
		
		//clickOnLink(footerlinks, "Freshteam");
		clickOnLink(termsServiceLinks, "GDPR");

	}

	public static void clickOnLink(By locator, String linkText) {
		List<WebElement> langList = driver.findElements(locator);
		System.out.println(langList.size());
		for (WebElement e : langList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(linkText)) {
				e.click();
				break;
			}
		}

	}

}
