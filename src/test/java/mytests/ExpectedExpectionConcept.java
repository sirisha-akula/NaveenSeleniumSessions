package mytests;

import org.testng.annotations.Test;

public class ExpectedExpectionConcept {
	
	
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void homeTest() {
		System.out.println(" home page ");
		int i = 9/0;
	}
	
	@Test(expectedExceptions = Exception.class)
	public void searchTest() {
		ExpectedExpectionConcept obj;
		//new ExpectedExpectionConcept();
		System.out.println("search page "); 
	}

}
