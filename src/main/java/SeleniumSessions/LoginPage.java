package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static void main(String[] args) {
		
		Browserutil br = new Browserutil();
		WebDriver driver = br.init_WebDriver("chrome");
		br.enterUrl("https://demo.opencart.com/index.php?route=account/login");
		
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId, "testdemo@gmail.com");
		eleUtil.doSendKeys(password, "test123");
		
		
		br.closeBrowser();
		
		

	}

}
