package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorvalue) {
		By locator = null;

		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorvalue);
			break;

		case "name":
			locator = By.name(locatorvalue);
			break;

		case "classname":
			locator = By.className(locatorvalue);
			break;

		case "xpath":
			locator = By.xpath(locatorvalue);
			break;

		case "css":
			locator = By.cssSelector(locatorvalue);
			break;

		case "linktext":
			locator = By.linkText(locatorvalue);
			break;

		case "partiallinktext":
			locator = By.partialLinkText(locatorvalue);
			break;

		case "tagname":
			locator = By.tagName(locatorvalue);
			break;

		default:
			break;
		}

		return locator;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doClick(String locatorType, String locatorvalue) {
		getElement(getBy(locatorType, locatorvalue)).click();
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doSendKeys(String locatorType, String locatorvalue, String value) {
		getElement(getBy(locatorType, locatorvalue)).sendKeys(value);
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();

	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getElementCount(By locator) {
		return getElements(locator).size();
	}

	public void getElementText(By locator) {
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
		}
	}

	/**
	 * this method will return the list of elements text
	 * 
	 * @param locator
	 * @return List<String>
	 */

	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	/**
	 * this method will return the list of element's attribute value
	 * 
	 * @param locator
	 * @param attrName
	 * @return List<String>
	 */
	public List<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttributeList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttributeList.add(attrValue);
		}
		return eleAttributeList;
	}

	public void clickOnLink(By locator, String linkText) {
		List<WebElement> langList = getElements(locator);
		System.out.println(langList.size());
		for (WebElement e : langList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(linkText)) {
				e.click();
				break;
			}
		}

	}

	/**************************** Drop Down Utils *************************/

	public void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> allOptions = select.getOptions();
		return allOptions.size();
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

	public List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> allOptions = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : allOptions) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	
	/********************ActionsSendKeysAndClick******************/
	
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();
	}
	
	/**
	 *Clicks in the middle of the given element. 
	 *Equivalent to: Actions.moveToElement(onElement).click() 
	 * @param locator
	 */
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	

}
