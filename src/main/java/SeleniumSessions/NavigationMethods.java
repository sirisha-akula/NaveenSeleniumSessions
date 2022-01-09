package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) {
		
		/*driver.get() and driver.navigate().to() both methods are synomyons used to open the url
		 * navigate().back() and forward() will also work with driver.get().
		 * in real time we use driver.navigate().to() to navigate to  3rd party domain from main domain just to differinate 
		 */

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); //launch chrome
		driver.get("https://oldnavy.gapcanada.ca/"); //enter the url
		String title = driver.getTitle();//get the title
		System.out.println(title);
		
		
		//driver.navigate().to("https://www.amazon.ca");
		try {
			driver.navigate().to(new URL("https://www.amazon.ca"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		//driver.get("https://www.amazon.ca");
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh(); //refresh the page
	}

}
