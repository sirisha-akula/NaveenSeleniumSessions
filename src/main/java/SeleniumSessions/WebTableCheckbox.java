package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckbox {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // launch chrome
		driver.get("https://selectorshub.com/xpath-practice-page/");

		selectEmployee("Joe.Root");
		List<String> empInfo = getEmployeeInfo("Joe.Root");
		System.out.println("Employee inforrmation is : " + empInfo);

		selectEmployee("Jasmine.Morgan");
		List<String> empInfo1 = getEmployeeInfo("Jasmine.Morgan");
		System.out.println("Employee inforrmation is : " + empInfo1);

	}

	public static void selectEmployee(String empName) {
		// a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']
		WebElement checkBox = driver.findElement(
				By.xpath("//a[text()='" + empName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"));
		Actions act = new Actions(driver);
		act.click(checkBox).perform();

	}

	public static List<String> getEmployeeInfo(String empName) {
		List<String> actList = new ArrayList<String>();
		// a[text()='Joe.Root']/parent::td/following-sibling::td
		List<WebElement> infoList = driver
				.findElements(By.xpath("//a[text()='"+empName+"']/parent::td/following-sibling::td"));
		for (WebElement e : infoList) {
			String text = e.getText();
			actList.add(text);
		}
		return actList;
	}

}
