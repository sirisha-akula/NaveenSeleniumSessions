package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlerPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		
		
		//alert : JS Alert pop-up //modal dialogue pop-up//modal pop-up
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(); // launch firefox
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(3000);
		
		//alert pop up will come
		
		Alert alt =	driver.switchTo().alert();
		String text = alt.getText();
		System.out.println(text);
		
		alt.accept();
	
	//alt.dismiss(); --to cancel the alert
	//alt.sendKeys("test"); --to enter text into alert box.
		
	}

}
