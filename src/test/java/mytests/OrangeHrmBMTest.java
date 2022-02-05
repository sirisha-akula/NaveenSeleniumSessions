package mytests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmBMTest {
	
WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test(priority = 1)
	public void logoTest() {
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		Assert.assertTrue(driver.findElement(By.className("nav-logo")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void contactSalesLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("CONTACT SALES")).isDisplayed());
	}
	
	
	@Test(priority = 4)
	public void requiredMessageTest() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String message = driver.findElement(By.xpath("//div[@id='Form_submitForm_subdomain_Holder']/span[text()='You must supply a valid name for the trial.']")).getText();
		Assert.assertTrue(message.contains("valid name"));
	}
	
	@Test(priority = 3)
	public void headerTest() {
		String header = driver.findElement(By.cssSelector("div .try-it-text h1")).getText();
		Assert.assertTrue(header.contains("free trial"));
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
		
	}



}
