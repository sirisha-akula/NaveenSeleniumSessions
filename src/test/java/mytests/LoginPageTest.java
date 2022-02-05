package mytests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {

	@DataProvider
	public Object[][] loginTestData() {

		return new Object[][] { { "admin@gmail.com", "admin1234" }, { "cust@gmail.com", "cust1234" },
				{ "user1@gmail.com", "user12323" }, { "user2@gmail.com", "@343434" }, {"", "test121212"}};

	}

	@Test(dataProvider = "loginTestData")
	public void loginTest(String userName, String password) {
		Assert.assertTrue(doLogin(userName, password));

	}

//	@Test
//	public void loginTest1() {
//		Assert.assertTrue(doLogin("cust@test.com", "cust1234"));
//		
//	}

	public boolean doLogin(String userName, String password) {
		System.out.println("user name : " + userName);
		System.out.println("password : " + password);
		return true;
	}
}
