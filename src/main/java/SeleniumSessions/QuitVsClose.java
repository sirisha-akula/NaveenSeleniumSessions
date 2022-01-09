package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuitVsClose {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); //launch chrome
		
		driver.get("https://www.walmart.com"); //enter the url
		String title = driver.getTitle();//get the title
		System.out.println(title);
		
		if(title.equals("Walmart")) {
			System.out.println("correct title");
		}else {
			System.out.println("Incorrect title");
		}
		System.out.println(driver.getCurrentUrl());
		
		//1.
		//driver.quit(); 
		//after driver.quit() session becomes null and in below statement it gives session id null exception 
		// System.out.println(driver.getTitle()); //NoSuchSessionException Session ID is null. Using WebDriver after calling quit()?
		
		//2.
		driver.close(); 
		//after driver.close() session id is available but it is invalid or exipred,and below statement it gives session id invalid 
		System.out.println(driver.getTitle()); ////NoSuchSessionException: invalid session id
		
		//solution: we need to create an object of chromeDriver once again to start new session id.
		driver = new ChromeDriver();
		System.out.println(driver.getTitle());
	}

}
