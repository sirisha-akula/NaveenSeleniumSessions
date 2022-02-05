package mytests;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	
	@Test
	public void loginTest() {
		System.out.println("login into app");
		int i = 9/0;
	}

	
	@Test(dependsOnMethods = "loginTest")
	public void homeTest() {
		System.out.println("login into app");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("login into app");
	}
	
	//test should be independent....not be dependent
	//try to avoid priority
	//always defines the assertions (act vs exp) -- validation point/check point
	//CRUD
	
	//@Test t1
	//1.Create the user
	//2.assert the user id 
	
	//@Test t2 (depends = t1) //we should always avoid dependency each @test should be indepenedent
	//Update User.
	//1.Create a new User
	//2. take the User id from the new user (user id = 3)
	//3. pick the same User id to update the User
	//4. delete the  user(id = 3)
	//5. check user is deleted
}
