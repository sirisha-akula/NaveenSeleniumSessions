package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Apptests.BaseTest;

public class OrangeHrmTest extends BaseTest {
	WebDriver driver;
	
	
	@Test(priority = 1)
	public void logoTest() {
		
		Assert.assertTrue(driver.findElement(By.className("nav-logo")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void contactSalesLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("CONTACT SALES")).isDisplayed());
	}
	
	
	@Test(priority = 4)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, "Sign Up for a Free HR Software Trial | OrangeHRM");
	}
	
	@Test(priority = 3)
	public void headerTest() {
		String header = driver.findElement(By.cssSelector("div .try-it-text h1")).getText();
		Assert.assertTrue(header.contains("free trial"));
	}
	
	

}
