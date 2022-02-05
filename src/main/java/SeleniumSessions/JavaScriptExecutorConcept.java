package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class JavaScriptExecutorConcept {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch firefox
		driver.get("https://www.amazon.ca");
		
	
		//JavascriptExecutor is an Interface	
//		JavascriptExecutor js = (JavascriptExecutor)driver;//Here converting driver to JSExecutor
//		String title = js.executeScript("return document.title").toString();
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//		String title = jsUtil.getTitleByJS();
//		System.out.println(title);
		
//		String pageInnerText = jsUtil.getPageInnerText();
//		if(pageInnerText.contains("FREE TRIALS CONTACT SALES")) {
//			System.out.println("testcase passed");
//		}
//		jsUtil.generateAlert("This is KittuArjun ALERT"); 
//		jsUtil.refreshBrowserByJS();
		
//		WebElement ele=  driver.findElement(By.xpath("//h1[text()='Delight made easy']"));
//		WebElement ele=  driver.findElement(By.cssSelector("div#content form"));
//		jsUtil.drawBorder(ele);

//		WebElement email=  driver.findElement(By.id("input-email"));
//		WebElement password=  driver.findElement(By.id("input-password"));
		
//		jsUtil.flash(email);
//		email.sendKeys("test@gmail.com");
//		jsUtil.flash(password);
//		password.sendKeys("tes123");
		
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		jsUtil.scrollPageDown("700");
		
//		WebElement ele=  driver.findElement(By.xpath("//span[text()='Explore everyday essentials']"));
//		jsUtil.scrollIntoView(ele);
//		jsUtil.drawBorder(ele);
//		jsUtil.flash(ele);
		

		WebElement ele= driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
		jsUtil.clickElementByJS(ele);
		
	}
	
	

}
