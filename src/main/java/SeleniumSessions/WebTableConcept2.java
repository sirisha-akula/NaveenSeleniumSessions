package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept2 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // launch chrome
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		List<String> countryList = getColValues("country");
		System.out.println(countryList);
		if(countryList.contains("Italy")) {
			System.out.println("data is found");
		}else {
			System.out.println("data is not found");
		}
		
//		List<String> companyList = getColValues("company");
//		System.out.println(companyList);
//		
//		List<String> contactList = getColValues("contact");
//		System.out.println(contactList);

	//	getColValues("contact123"); //invalid company name

	}
	
	/**
	 * This method will return the List of values of the specific Column(Eg: company, country, contact columns)
	 * @param columnName
	 * @return List<String> : list of values
	 */

	public static List<String> getColValues(String columnName) {
		List<String> acttext = new ArrayList<String>();

		if (columnName.equalsIgnoreCase("Company")) {
			String before_xpath = "//table[@id='customers']//tr[";
			String after_xpath = "]/td[1]";

			for (int i = 2; i <= getRowCount(); i++) {
				String actualXpath = before_xpath + i + after_xpath;
				String text = driver.findElement(By.xpath(actualXpath)).getText();
				acttext.add(text);
			}

		} else if (columnName.equalsIgnoreCase("Contact")) {
			String before_xpath = "//table[@id='customers']//tr[";
			String after_xpath = "]/td[2]";

			for (int i = 2; i <= getRowCount(); i++) {
				String actualXpath = before_xpath + i + after_xpath;
				String text = driver.findElement(By.xpath(actualXpath)).getText();
				acttext.add(text);
			}
		} else if (columnName.equalsIgnoreCase("Country")) {
			String before_xpath = "//table[@id='customers']//tr[";
			String after_xpath = "]/td[3]";

			for (int i = 2; i <= getRowCount(); i++) {
				String actualXpath = before_xpath + i + after_xpath;
				String text = driver.findElement(By.xpath(actualXpath)).getText();
				acttext.add(text);
			}
		} else {

			System.out.println("you have entered incorrect Column Name: " + columnName);

		}
		return acttext;
	}

	public static int getRowCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//tr")).size();

	}

	public static int getColCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//tr[1]/th")).size();

	}
}
