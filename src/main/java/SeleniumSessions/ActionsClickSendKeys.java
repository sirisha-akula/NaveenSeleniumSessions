package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickSendKeys {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // launch chrome
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By fn = By.id("input-firstname");
		By ln = By.id("input-lastname");
		By email = By.id("input-email");
		By phone = By.id("input-telephone");
		By pwd = By.id("input-password");
		By cnfrmPwd = By.id("input-confirm");
		By subsrb = By.xpath("//input[@name='newsletter' and @value='1']");
		By privacyChck = By.name("agree");
		By ctnBtn = By.xpath("//input[@value='Continue']");
		//org.openqa.selenium.interactions.MoveTargetOutOfBoundsException: this issue occurs firefox browser only.
		
		By headerText = By.xpath("//*[@id=\"content\"]/h1");
		
//		Actions act = new Actions(driver);
//		act.sendKeys(driver.findElement(fn), "demo1@gmail.com").perform();
//		act.sendKeys(driver.findElement(ln), "demo1").perform();
//		
//		act.click(driver.findElement(ctnBtn)).perform();
		
		actionsDoSendKeys(fn, "stage1");
		actionsDoSendKeys(ln, "stage1");
		actionsDoSendKeys(email, "stage@gmail.com");
		actionsDoSendKeys(phone, "9057890987");
		actionsDoSendKeys(pwd, "test1234");
		actionsDoSendKeys(cnfrmPwd, "test1234");
		actionsDoClick(subsrb);
		actionsDoClick(privacyChck);
		actionsDoClick(ctnBtn);
		
		String actualText =	eleUtil.doGetText(headerText);
		if(actualText.equalsIgnoreCase("your account has been created!")) {
			System.out.println("Account is created successfully");
		}else {
			System.out.println("Account is not created...Try Next Time");

		}
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void actionsDoSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();
	}
	
	/**
	 *Clicks in the middle of the given element. 
	 *Equivalent to: Actions.moveToElement(onElement).click() 
	 * @param locator
	 */
	public static void actionsDoClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

}
