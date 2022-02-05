package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept { //Saclar Vector Graph

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // launch chrome
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		Thread.sleep(5000);
		String svgXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']/*[name()='g']/*[name()='path']";
		List<WebElement>graphList = driver.findElements(By.xpath(svgXpath));
		
		Actions act = new Actions(driver);
		for(WebElement e : graphList) {
			act.moveToElement(e).perform();
			Thread.sleep(1000);
			String stateName = e.getAttribute("name");
			System.out.println(stateName);
			if(stateName.equals("New York")) {
				act.click(e).perform();
				break;
		}
			Thread.sleep(2000);		
			String svgpath= "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='g' and @id='new-york']//*[name()='g' and @class='counties']/*[name()='path']";
			List<WebElement>countyList = driver.findElements(By.xpath(svgpath));
			
			for(WebElement ele: countyList) {
				act.moveToElement(ele).perform();
				Thread.sleep(1000);
				String countyName= ele.getAttribute("data-v-cdc99cd0");
				System.out.println(countyName);
				
			}
			
		}
		
		//flipkart.com search button svg element xpath
		//*[local-name()='svg']//*[name()='g' and @fill-rule='evenodd']
	}
	}


