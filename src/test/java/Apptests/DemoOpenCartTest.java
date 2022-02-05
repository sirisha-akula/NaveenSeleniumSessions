package Apptests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoOpenCartTest extends BaseTest{

	
	@Test(priority= 1, enabled = false)
	public void openCartTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Your Store");
	}
	
	@Test(priority= 2)
	public void openCartHeaderTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Your Store']")).isDisplayed());
	}
	


}
