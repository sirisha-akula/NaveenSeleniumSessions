package SeleniumSessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorConcept {
	
	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.aqi.in/dashboard/canada");
		
		WebElement ele = driver.findElement(By.linkText("Hope, Canada"));
		
		String index = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(index);
		
		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(rank);
		
		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);
		
		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowCity);
		
		String name = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(name);
		
		
		List<WebElement> aboveList = driver.findElements(with(By.tagName("p")).above(ele));
		for(WebElement e : aboveList) {
			System.out.println(e.getText());
		}
	
		
	}
	

}
