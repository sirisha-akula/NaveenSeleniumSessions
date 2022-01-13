package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {

	static WebDriver driver;

	// WAP
	// Total images on the page
	// print the alt of the each img
	// print src value of the each image

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch chrome
		driver.get("https://www.amazon.ca");

		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		System.out.println("total images: " + imagesList.size());

		for (WebElement e : imagesList) {
			String altVal = e.getAttribute("alt");
			String srcVal = e.getAttribute("src");
			System.out.println(altVal + ":" + srcVal);

		}
		driver.close();
	}

}
