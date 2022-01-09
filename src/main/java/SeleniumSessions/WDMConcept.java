package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WDMConcept {

	public static void main(String[] args) {

		
			WebDriverManager.chromedriver().setup();
			//WebDriverManager.chromedriver().browserVersion("87.0").setup();
			WebDriver driver = new ChromeDriver(); //launch chrome
			
			driver.get("https://www.walmart.com"); //enter the url
			String title = driver.getTitle();//get the title
			System.out.println(title);
			driver.close();
			

//			WebDriverManager.firefoxdriver().setup();
//			WebDriver driver1 = new FirefoxDriver();
//			driver.get("https://www.google.com/");
//			System.out.println(driver1.getTitle());
//			driver1.close();
//			
			

	}

}
