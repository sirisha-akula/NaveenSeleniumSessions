package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		// WAP
		// Total links n the page
		// print the text of the each link(ignore blank space/empty links)
		// print href value of the each link

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // launch chrome
		driver.get("https://www.amazon.ca");

//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//		System.out.println("total links: " + linksList.size());
		
		By links = By.tagName("a");
		By images = By.tagName("img");
		
		System.out.println(getElementCount(links));
		System.out.println(getElementCount(images));
		
		if(getElementsTextList(links).contains("Customer Service")){
			System.out.println("Customer Service is present");
		}else {
			System.out.println("Customer Service is not present");

		}
		
		System.out.println(getElementAttributeList(images,"src"));

//	int c =0;
//	for(WebElement e : linksList) {
//		String text  = e.getText();
//		if(!text.isEmpty()) { //text is not empty then print text
//		System.out.println(c+":"+ text);
//	
//		}
//		
//		String hrefVal=e.getAttribute("href");
//		System.out.println(hrefVal);
//		c++;
//	}

//		for (int i = 0; i < linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//			if (!text.isEmpty()) {
//				System.out.println(i + ":" + text);
//			}
//			String hrefValue = linksList.get(i).getAttribute("href");
//			System.out.println(hrefValue);
//		}
		
		
		driver.close();

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static int getElementCount(By locator) {
		return getElements(locator).size();
	}

	public static void getElementText(By locator) {
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
		}
	}
	
	 /**
	  * this method will return the list of elements text
	  * @param locator
	  * @return List<String>
	  */
	
	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if(!text.isEmpty()) {
			eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	

	 /**
	  * this method will return the list of element's attribute value
	  * @param locator
	  * @param attrName
	  * @return List<String>
	  */
	public static List<String> getElementAttributeList(By locator , String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttributeList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttributeList.add(attrValue);
		}
		return eleAttributeList;
	}
}
