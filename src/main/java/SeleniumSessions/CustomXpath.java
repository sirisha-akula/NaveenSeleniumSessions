package SeleniumSessions;

public class CustomXpath {

	public static void main(String[] args) {
		
		// Xpath: address of the element in HTML DOM
		//absolute xpath: /html/body/div[2]/div/div[1]/ul[3]/li[2]/a
		//relative xpath: custom xpath: functions, prop, xpath axes
		
		// '//' -->poinitng to specific node;
		//htmltag[@attr ='attrvalue']
		//input[@id='input-email']
		
		//htmltag[@attr1 ='value' and @attr2 ='value']
		//input[@id='input-email' and @name='email']
		//input[@id='input-email' or @name='email']
		
		//input[@value='Login' or @type='submit']
		
		//*[@attr ='attrvalue']
		//*[@id='input-email'] --300  here it searches all tag where id = input-email	
		//input[@id='input-email'] --10 here it searches for input tag where id = input-email
		
		
		//input[@class='form-control'] --2
		//(//input[@class='form-control'])[1] --index based xpath
		//(//input[@class='form-control'])[2]
		//(//input[@class='form-control'])[position()=1]
		//(//input[@class='form-control'])[last()]
		//((//div[@class='navFooterLinkCol navAccessibility'])[last()]//li/a)[last()]
		
		//text():
		//htmltag[text()='value']
		//a[text()='Press Releases']
		//label[text()='First Name']
		//h1[text()='Register Account']
		
		//@attr and text():
		//htmltag[@attr1 ='value' and text()='value' and @attr2 ='value']
		//a[@href and text()='login page']
		//label[@for='input-firstname' and text()='First Name']
		//label[text()='First Name' and @for='input-firstname']
		
		//contains() with attr:
		//htmltag[contains(@attr,'value')]
		//input[contains(@id,'input-firstname')]
		
		//input-firstname
		//123-firstname
		//456-firstname
		//input[contains(@id,'-firstname')]
		
		//contains() with attr1 and attr2 with no contains():
		//input[contains(@id,'input-firstname') and @name='firstname']
		
		//contains() with text():
		//h2[contains(text(),'beauty')]
		//p[contains(text(),'SaaS solutions')]
		//a[contains(text(),'Fresh')]
		
		
		//starts-with():
		//a[starts-with(text(),'Fresh')]
		//*[starts-with(text(),'Fresh')]
		
		//ends-with: is deprecated
		
		//parent to child:
		//form[@id='Form_submitForm']//input --15 (direct +indirect child elements)
		//form[@id='Form_submitForm']/input --0 (direct)
		//div[@id='Form_submitForm_Name_Holder']//input[@name='Name']
		//div[@id='Form_submitForm_Name_Holder']//child::input[@name='Name']
		//select[@id='Form_submitForm_Country']/option
		//select[@id='Form_submitForm_Country']/child::option
		
		//select[@id='Form_submitForm_Country']/* -->select all children
		
		//child to parent:
		//option[@value='Afghanistan']/..--> it goes to immediate parent tag.
		//option[@value='Afghanistan']/../.. -->goes to grandparent
		//option[@value='Afghanistan']//parent::select
		//option[@value='Afghanistan']//parent::select/parent::div
		
		//input[@id='Form_submitForm_Name']/ancestor::form[@id='Form_submitForm']
		//(//input[@id='Form_submitForm_Name']//ancestor::div)[last()]
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
