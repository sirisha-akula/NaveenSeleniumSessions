package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) {

		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(); // launch firefox
		driver.get("http://londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(2);
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.name("main")));		
		
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		
		driver.switchTo().defaultContent(); //switch to main page or next available frame
		
		driver.switchTo().parentFrame(); //switch to immdeiate parent frame
		
		//main purpose for frames on any application is for security, or to hide complete implementation of WebElements
		//it provides extra secuirty layer for UI components, we write certain components inside the frame eg:login
		
	
	}

}
