package SeleniumSessions;

import org.openqa.selenium.By;

public class CssSelectorConcept {

	public static void main(String[] args) {

		//{id} -->#id, tag#id
		//{class}--> .class
		// #input-email
		// .form-control
		// input.form-control
		// input.form-control#input-email
		// input#input-email.form-control
		// #input-email.form-control
		
		By.cssSelector("#input-email");
		
		// tag[type='Submit']
		// input[type='Submit'] --Css 
		//input[@type='Submit'] --xpath
		By.cssSelector("input[type='Submit']");
		// input[type='Submit'][value='Login'] --css
		//input[@type='Submit']and[@value='Login']--xpath
		
		//url--https://app.hubspot.com/login --this url is used for below css selectors
		
		// form-control private-form__control login-email
		// form-control private-form__control login-password m-bottom-3
		// c1.c2.c3....cn
		// .form-control.private-form__control.login-email
		// input.form-control.private-form__control.login-email
		// input.form-control.private-form__control.login-email#username
		
		By.cssSelector(".form-control.private-form__control.login-email"); //correct css selector
		By.className(".form-control.private-form__control.login-email"); //wrong--as className uses multiple class values
		By.xpath("//input[@class='form-control private-form__control login-email']"); //correct Xpath
		By.className("login-email"); //correct as className uses only one class value
		
		
		//url--https://demo.opencart.com/index.php?route=account/login
		
		// input[id*='input'] --contains
		// input[id^='input'] --starts-with
		// input[id$='email'] --ends-with
		
		
		//parent to child:
		// div.form-group > input#input-email
		// div#content > div(Only direct child elements)--1
		// div#content div(direct + indirect child elements)--7
		
		//child to parent: Backward Traversing not allowed
		//NA
		
		//siblings in css: only following sibling allowed, preceding-siblings not allowed in css
		// div.form-group label + input
		
		//indexing:
		// ul.footer-nav li:nth-of-type(2)
		
		//Note: SVG elements does not support css, it only supports xpath

		
	}

}
