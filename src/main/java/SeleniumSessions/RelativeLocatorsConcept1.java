package SeleniumSessions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsConcept1 {

		
		public static void main(String[] args) {

			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://www.aqi.in/dashboard/canada");
			By ele = By.linkText("Calgary, Canada");
			
//			String aqiIndex = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
//			System.out.println(aqiIndex);
//			
//			String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
//			System.out.println(rank);
//			
//			String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
//			System.out.println(aboveCity);
//			
//			String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
//			System.out.println(belowCity);
//			
//			String name = driver.findElement(with(By.tagName("p")).near(ele)).getText();
//			System.out.println(name);
			
			List<WebElement> city = driver.findElements(By.xpath("//a[text()='New Brunswick']/parent::th/following-sibling::td"));
			for(WebElement e: city) {
				System.out.println(e.getText());
			}
			
			
			
	}

}
