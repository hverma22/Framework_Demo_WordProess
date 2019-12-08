/**
 * 
 */
package com.worpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.qa.actiondriver.Action;
import com.wordpress.qa.base.TestBase;

/**
 * @author Hitendra Verma
 *
 */
public class AddNewUserPage extends TestBase {
	
	@FindBy(name = "user_login")
	@CacheLookup
	WebElement userName;
	
	@FindBy(name = "email")
	@CacheLookup
	WebElement email;
	
	@FindBy(name = "first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(name = "last_name")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(name = "url")
	@CacheLookup
	WebElement enterUrl;
	
	@FindBy(xpath = "//*[@id='createusersub']")
	@CacheLookup
	WebElement createUserButton;
	
	
	@FindBy(xpath = "//*[@id='message']/p")
	@CacheLookup
	WebElement checkUser;
	
	@FindBy(xpath = "//button[contains(text(),'Show password')]")
	WebElement showPassword;
	
	@FindBy(xpath = "//*[@id='pass1-text']")
	WebElement enterPassword;
	
	
	public AddNewUserPage() {
		PageFactory.initElements(driver, this);
	}

	public void addNewUser(String username, String Email,String firstname,String lastname,String url) throws Throwable{
		
		userName.sendKeys(username);
		email.sendKeys(Email);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		enterUrl.sendKeys(url);
		/*Action.click(driver, showPassword);
		Thread.sleep(2000);
		Action.scrollByVisibilityOfElement(enterPassword);
		Thread.sleep(2000);
		Action.type(enterPassword, "Password@1234");*/
		Action.scrollByVisibilityOfElement(createUserButton);
		//Thread.sleep(3000);
		Action.click(driver, createUserButton);
		System.out.println("clicked on submit button: ");
	}
	
	public boolean validateNewUserID(){
		return checkUser.isDisplayed();
	}
}
