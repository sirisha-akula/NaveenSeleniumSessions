package mytests;

import org.testng.annotations.Test;

public class EcommTest {
	
	@Test(priority = -1)
	public void loginTest() {
		System.out.println("Login test");
	}

	@Test(priority = 0)
	public void homeTest() {
		System.out.println("Home test");
	}
	
	@Test(priority = 3)
	public void cartTest() {
		System.out.println("Cart test");
	}
	
	@Test(priority = -2)
	public void searchTest() {
		System.out.println("Search test");
	}
	
	@Test(priority = 0)
	public void m3Test() {
		System.out.println("m3 test");
	}
	
	@Test
	public void m1Test() {
		System.out.println("m1 test");
	}
	
	@Test
	public void m2Test() {
		System.out.println("m2 test");
	}
}


