package SeleniumSessions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerydropdDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch firefox
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();

		By choiceList = By.xpath("//span[@class='comboTreeItemTitle']");

		// tc_1: Single choice selection
		//selectChoice(choiceList,"choice X");

		// tc_2: Multiple choice selection
		selectChoice(choiceList, "choice 2","choice 6 2 3", "choice X");

		// tc_3: Select All choices
		//selectChoice(choiceList, "select_all");
	}

	public static void selectChoice(By locator, String... value) { // String...value means-> String value[](string value
																	// array)
		List<WebElement> allOptions = driver.findElements(locator);
		boolean flag = false;
		
		if (!value[0].equalsIgnoreCase("select_all")) { // here if value[0] is not equal to "select_all"
			for (WebElement e : allOptions) {
				String text = e.getText();

				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						flag = true;
						e.click();
						break;
					} else if(!text.equals(value[i]))   //here if text is not equal to String[] values
						 {
						flag = false;
						//System.out.println(value[i]);
						
				
					}
				}

			}
		} else {
			// select all_options
			try {
				for (WebElement e : allOptions) {
					e.click();
					flag = true;
				}
			} catch (ElementNotInteractableException e) {
				System.out.println("all choices are over...");
			}

		}
		if (flag == false) {
			System.out.println("choice is not available" + ":" + Arrays.toString(value)); //value[0]; it prints first value
		}

	}
}
