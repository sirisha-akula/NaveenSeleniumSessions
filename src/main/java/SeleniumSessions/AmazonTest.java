package SeleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {

		String browser = "FireFox";
		Browserutil br = new Browserutil();

		br.init_WebDriver(browser);
		br.enterUrl("https://www.amazon.ca/");
		String title = br.getPageTitle();
		
		if (title.contains("Amazon")) {
			System.out.println("Title is correct");
		}
		if (br.getPageUrl().contains("amazon")) {
			System.out.println("Page URL is correct");
		}
		br.closeBrowser();
	}

}
