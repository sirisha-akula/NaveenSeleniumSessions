package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	static WebDriver driver;

	public static void main(String[] args) {
	
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch chrome
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");
		try {
			Thread.sleep(3000);
			List<WebElement> suggList = driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span"));
			System.out.println(suggList.size());
			for(WebElement e:suggList ) {
				String text = e.getText();
				System.out.println(text);
				if(text.equals("naveen automation labs udemy")) {
					e.click();
					break;
					
				}
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.close();
		
	}

}
