package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownWithoutUsingSelectClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch chrome
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		driver.manage().window().maximize();

		// html tag : select tag
		By country = By.xpath("//select[@id='Form_submitForm_Country']/option");

		List<WebElement> countryList = driver.findElements(country);
		for (WebElement e : countryList) {
			String text = e.getText();
			if (text.equalsIgnoreCase("japan")) {
				e.click();
				break;
			}
		}
		
		driver.close();
	}

}
