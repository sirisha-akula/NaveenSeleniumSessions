package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); // launch chrome
			driver.get("https://jqueryui.com/droppable/");
			Thread.sleep(3000);
			
			WebElement frameEle = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
			driver.switchTo().frame(frameEle);
			
			WebElement sourceEle = driver.findElement(By.xpath("//div[@id='draggable']"));
			WebElement targetEle = driver.findElement(By.xpath("//div[@id='droppable']"));
			
			Actions act = new Actions(driver);
			 act.clickAndHold(sourceEle)
			       .moveToElement(targetEle)
			          .release()
			            .build()
			              .perform();

		//	act.dragAndDrop(sourceEle, targetEle).perform();
	}

}
