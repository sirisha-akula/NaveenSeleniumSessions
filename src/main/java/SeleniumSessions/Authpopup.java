package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Authpopup {

	public static void main(String[] args) {
		 
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(); // launch firefox
		
		String username= "admin";
		String password= "admin"; //admin@123 will not work as we have '@' in pwd.
		
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		
		//CDP tool - in selnium 4 to handle authentications.

	}

}
