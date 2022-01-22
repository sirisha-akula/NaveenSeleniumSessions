package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class RegistrationPage {

	static WebDriver driver;
	
	public static void main(String[] args) {

		BrowserSwitchCase br = new BrowserSwitchCase();
		WebDriver driver = br.launchbrowser("FireFox");
		br.enterUrl("https://demo.opencart.com/index.php?route=account/login");
		
		By RegisterLink = By.linkText("Register");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doClick(RegisterLink);
		
		String pageTitle = br.getPageTitle();
		System.out.println("This Page is a : " + pageTitle );
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.name("email");
		By phone = By.xpath("//*[@id=\"input-telephone\"]");
		By password = By.cssSelector("#input-password");
		By confirmpwd = By.cssSelector("#input-confirm");
		By sbscrbBtn = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");	
		By agreeChkbox = By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)");	
		By cntnBtn = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		By headerText = By.xpath("//*[@id=\"content\"]/h1");
		
		eleUtil.doSendKeys(firstName, "test1");
		eleUtil.doSendKeys(lastName, "a");
		eleUtil.doSendKeys(email, "atest1@gmail.com");
		eleUtil.doSendKeys(phone, "9989950802");
		eleUtil.doSendKeys(password, "siridemo1234");
		eleUtil.doSendKeys(confirmpwd, "siridemo1234");
		eleUtil.doClick(sbscrbBtn);
		eleUtil.doClick(agreeChkbox);
		eleUtil.doClick(cntnBtn);
		
	String actualText =	eleUtil.doGetText(headerText);
	if(actualText.equalsIgnoreCase("your account has been created!")) {
		System.out.println("Account is created successfully");
	}else {
		System.out.println("Account is not created...Try Next Time");

	}


				
	}
	
	

}
