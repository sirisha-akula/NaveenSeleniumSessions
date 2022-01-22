package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAllOptions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch chrome
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		driver.manage().window().maximize();

		// html tag : select tag
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		WebElement country_ele = driver.findElement(country);
		WebElement state_ele = driver.findElement(state);

//		Select select  = new Select(country_ele);
//		List<WebElement> allOptions = select.getOptions();
//		
//		int c = 0;
//		for(WebElement e : allOptions) {
//			System.out.println(c+":"+e.getText());
//			c++;
//		}
//	}

		if (getDropDownOptionsList(country).contains("Canada")) {
			System.out.println("Canada is present in the Country List");
		}
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void selectValueFromDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> allOptions = select.getOptions();

		for (WebElement e : allOptions) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
			}
		}
	}

	public static List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> allOptions = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : allOptions) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

}
