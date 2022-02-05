package mytests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	// Global pre conditions
	// pre conditions
	// test steps + assertions (act vs exp results)
	// post steps

	/**
	 * 	BS -- Create User
		BT -- connect With DB
		BC -- launch Browser
			
			BM -- login to app
			homePageTest
			AM -- logout

			BM -- login to app
			priceTest
			AM -- logout
			
			BM -- login to app
			searchTest
			AM -- logout
		
		BC -- close Browser
		BT -- Disconnect With DB
		BS --Delete User
	 * 
	 * 
	 */
	@BeforeSuite
	public void createuser() {
		System.out.println("BS -- Create User");
	}

	@BeforeTest
	public void connectWithDB() {
		System.out.println("BT -- connect With DB");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC -- launch Browser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM -- login to app");
	}

	@Test
	public void homePageTest() {
		System.out.println("homePageTest");
	}

	@Test
	public void searchTest() {
		System.out.println("searchTest");
	}

	@Test
	public void priceTest() {
		System.out.println("priceTest");
	}

	@AfterMethod
	public void logout() {
		System.out.println("AM -- logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("BC -- close Browser");
	}

	@AfterTest
	public void disconnectWithDB() {
		System.out.println("BT -- Disconnect With DB");
	}

	@AfterSuite
	public void deleteuser() {
		System.out.println("BS --Delete User");
	}

}
