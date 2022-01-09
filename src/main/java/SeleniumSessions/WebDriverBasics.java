package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/sirishaakula/Documents/Selenium/BrowserDrivers/chromedriver");
		//automation steps
		//top casting:
		WebDriver driver = new ChromeDriver(); //launch chrome
		
		driver.get("https://www.walmart.com"); //enter the url
		String title = driver.getTitle();//get the title
		System.out.println(title);
		
		//+
		
		//verification point/check point /act vs exp result
		if(title.equals("Walmart")) {
			System.out.println("correct title");
		}else {
			System.out.println("Incorrect title");
		}

		//Automation testing
		System.out.println(driver.getCurrentUrl()); //to get page Url
		System.out.println(driver.getPageSource());
		
		if(driver.getPageSource().contains("holiday-christmas")) {
			System.out.println("is present");
		}
		driver.quit();//close browser
	}

}
