package Apptests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class GoogleTest extends BaseTest{
	
	
	@Test(priority= 1)
	public void googletTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test(priority= 2)
	public void googleSearch() {
		driver.findElement(By.name("q")).sendKeys("Canada");
		Assert.assertTrue(true);
	}
	


}
