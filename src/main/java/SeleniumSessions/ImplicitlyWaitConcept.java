package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		// ImplicitlyWait
		//Dynamic wait
		//its only applicable for WebElements : FE, FEs
		//not applicable for non WebElements: url, title, alerts
		//global wait: once it is defined it will be applicable for all upcoming webelements.
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch firefox
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//login page: 10 secs
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		//10secs
		WebElement emailID = driver.findElement(By.id("input-email"));
		emailID.sendKeys("test@gmail.com");
		
		//10secs
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("test123");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//5secs
		WebElement loginBtn = driver.findElement(By.id("//input[@value='Login']"));
		loginBtn.click();
		
		//e4 -->5secs
		//e5 -->5secs
		
		
		//homepage: 20 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//HE1 -- 20 secs
		//HE2 -- 20 secs
		//HE3 -- 20 secs
		//click on logout --landing on login page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//click on reg page : 0 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		//RE1
		//RE2
		
		
	}

}
