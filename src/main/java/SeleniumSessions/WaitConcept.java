package SeleniumSessions;

public class WaitConcept {

	public static void main(String[] args) {
		
		//wait:
		//1. static: Thread.sleep(1000)...e1--3 secs
		//2. dynamic: timeout = 10secs...e1...3secs...7secs are ignored
		//2.a. Implicitly Wait
		//2.b. Explicit Wait:
		       //2.a.1: WebDriverWait (Class)
			   //2.b.1: FluentWait (Class)
		
		//WebDriverWait(C) --> extends --> FluentWait(C)-->implements-->Wait(I) --until();
										   //until(){}
										   //other methods
		
		//never use imp wait in framework
		//case:
		//mix imp wait + exp wait together : never use both waits
		//imp wait : 20 secs
		//e1 --> WebDriverwait : 10secs
		
		
		//imp wait        |           exp wait
		//20			  |			  10
//0--> 0                  |            0 --> 0 sec
//x--> 2                  |            5 --> 7 secs
//x--> 0                  |            5 --> 5 secs
//x--> 5			      |		       0 --> 5 secs
//x--> 20                 |            NA --> 20 secs
//x--> 0 				  |			   10(max) --> 10 secs
//x--> 20		          |            10(max) --> 30 secs
//x--> 20		          |            10(max) --> 30 secs  timeout
	
	}

}
