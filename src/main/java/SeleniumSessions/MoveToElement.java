package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch chrome
		driver.get("http://mrbool.com/");
		WebElement menu = driver.findElement(By.xpath("//a[@class='menulink']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(menu).perform();  //-->Correct
		// act.moveToElement(menu).build().perform(); //-->Correct
		// act.moveToElement(menu).build(); //-->Not Correct
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("COURSES")).click();
		
	}

}
