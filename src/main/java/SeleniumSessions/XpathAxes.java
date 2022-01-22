package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // launch firefox
		driver.get(
				"https://www.espncricinfo.com/series/india-in-south-africa-2021-22-1277060/south-africa-vs-india-1st-odi-1277082/full-scorecard");

//		System.out.println(getWickterTakerName("Temba Bavuma"));
//		System.out.println(getPlayerScoreCard("Aiden Markram"));

		System.out.println(getBlowerScoreCard("Aiden Markram"));
		System.out.println(getBlowerScoreCard("Jasprit Bumrah"));

	}

	/**
	 * This method gets both batting and bowling score card of the player eg: Aiden
	 * Markram is bowler and batsman it gets both his batting and bowling
	 * scorecards.
	 * 
	 * @param playerName
	 * @return List<String>
	 */
	public static List<String> getPlayerScoreCard(String batsmanName) {
		List<String> actScoreList = new ArrayList<String>();
		List<WebElement> scoreList = driver
				.findElements(By.xpath("//a[text()='" + batsmanName + "']/parent::td/following-sibling::td"));
		System.out.println(scoreList.size());

//    int c= 0;
//	for(WebElement e: scoreList) {
//		String text = e.getText();
//		c++;
//		actScoreList.add(text);	
//	}

		for (int i = 1; i < scoreList.size(); i++) {
			String text = scoreList.get(i).getText();
			actScoreList.add(text);
		}
		return actScoreList;

	}

	/**
	 * This method gets only bowling score card of the player
	 * 
	 * @param playerName
	 * @return List<String>
	 */

	public static List<String> getBlowerScoreCard(String playerName) {
		List<String> actScoreList = new ArrayList<String>();
		List<WebElement> bowlerScore = driver
				.findElements(By.xpath("//table[@class='table bowler']/child::tbody//td/a[text()='" + playerName
						+ "']/parent::td/following-sibling::td"));
		System.out.println(bowlerScore.size());
		for (WebElement e : bowlerScore) {
			String text = e.getText();
			actScoreList.add(text);
		}
		return actScoreList;
	}

	public static String getWickterTakerName(String batsmanName) {
		WebElement element = driver
				.findElement(By.xpath("//a[text()='" + batsmanName + "']/parent::td/following-sibling::td/span"));
		String text = element.getText();
		return text;
	}

}
