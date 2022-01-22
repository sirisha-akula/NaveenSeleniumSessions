package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopup {

	public static void main(String[] args) {

		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(); // launch firefox
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		
		//html file : file= type
		driver.findElement(By.name("upfile")).sendKeys("/Users/sirishaakula/Downloads/TestPlan.doc");
	}

}
