package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchSuggestion {

	// without forloop directly click on search list

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch chrome
		driver.get("http://automationpractice.com/index.php");

		driver.findElement(By.id("search_query_top")).sendKeys("Dresses");
		Thread.sleep(3000);

		selectSuggestion("T-shirts > Faded Short Sleeve T-shirts");

	}
	
	//below code is using "driver.findElements with enchanced forloop":
//		List<WebElement> suggestionList = driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));
//		System.out.println(suggestionList.size());
//
//		for (WebElement e : suggestionList) {
//			String text = e.getText();
//			if (text.contains("Evening Dresses")) {
//				e.click();
//			}
//		}

	public static void selectSuggestion(String suggestion) {
		WebElement ele = driver
				.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'" + suggestion + "')]"));

		ele.click();

	}

}
