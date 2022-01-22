package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class WebTableConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // launch chrome
		driver.get("https://www.w3schools.com/html/html_tables.asp");

//		System.out.println(getCountryName("Maria Anders"));
//		System.out.println(getCompName("Maria Anders"));
//
//		System.out.println(getCountryName("Roland Mendel"));
//		System.out.println(getCompName("Roland Mendel"));
//		
//		System.out.println("columCount: "+ getColCount());
//		System.out.println("rowCount: "+ getRowCount());
//		System.out.println(getColList());
//		
		// table[@id='customers']//tr[2]/td[1]
		// table[@id='customers']//tr[3]/td[1]
		// table[@id='customers']//tr[4]/td[1]

		// to print the first column values:
//		String before_xpath = "//table[@id='customers']//tr[";
//		String after_xpath = "]/td[1]";
//		
//		for(int i =2; i<=getRowCount(); i++) {
//			String actualXpath = before_xpath+i+after_xpath;
//			String text = driver.findElement(By.xpath(actualXpath)).getText();
//			System.out.println(text);
//		}

		Boolean b = getContactList("Maria Anders");
		System.out.println("data is found " + ":" + b);

		Boolean b1 = getContactList("abacd");
		System.out.println("data is found " + ":" + b1);

		Boolean b2 = getContactList("Giovanni Rovelli");
		System.out.println("data is found " + ":" + b2);

//		//to print entire table
//		String before_xpath = "//table[@id='customers']//tr[";
//		String after_xpath = "]/td[";
//		
//		for(int col = 1; col<=getColCount(); col++) {
//			for(int row = 2; row<=getRowCount(); row++) {
//				String actualXpath = before_xpath+row+after_xpath+col+"]";
//				String text = driver.findElement(By.xpath(actualXpath)).getText();
//				System.out.print(text+ " ");
//				if(text.equals("Maria Anders")) {
//					System.out.println("data is found");
//					break;
//					
//				}
//	
//			}
//			System.out.println();
//		}

	}

	public static int getRowCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//tr")).size();

	}

	public static int getColCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//tr[1]/th")).size();

	}

	public static List<String> getColList() {
		List<String> actColList = new ArrayList<String>();
		List<WebElement> colList = driver.findElements(By.xpath("//table[@id='customers']//tr[1]/th"));
		for (WebElement e : colList) {
			String text = e.getText();
			actColList.add(text);
		}
		return actColList;
	}

	public static boolean getContactList(String value) {
		boolean flag = false;
		List<String> acttext = new ArrayList<String>();
		// table[@id='customers']//tr[2]/td[2]
		// table[@id='customers']//tr[3]/td[2]
		String before_xpath = "//table[@id='customers']//tr[";
		String after_xpath = "]/td[2]";
		for (int row = 2; row <= getRowCount(); row++) {
			String actXpath = before_xpath + row + after_xpath;
			String text = driver.findElement(By.xpath(actXpath)).getText();
			acttext.add(text);
			if (acttext.contains(value)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static String getCountryName(String name) {
		return driver.findElement(By.xpath("//td[text()='" + name + "']/following-sibling::td")).getText();

	}

	public static String getCompName(String name) {
		WebElement element = driver.findElement(By.xpath("//td[text()='" + name + "']/preceding-sibling::td"));
		String text = element.getText();
		return text;
	}

}
