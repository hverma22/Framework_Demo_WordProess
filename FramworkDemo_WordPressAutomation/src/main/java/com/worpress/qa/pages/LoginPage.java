/**
 * 
 */
package com.worpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.qa.actiondriver.Action;
import com.wordpress.qa.base.TestBase;

/**
 * @author Hitendra Verma
 *
 */
public class LoginPage extends TestBase {

	// Page Factory - Method

	@FindBy(id = "user_login")
	WebElement username;

	@FindBy(name = "pwd")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'Lost your password?')]")
	WebElement lostyourPassrd;

	@FindBy(xpath = "//a[contains(text(),'Powered by WordPress')]")
	WebElement wordpressLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean logo() throws Throwable {

		//return wordpressLogo
		return Action.isDisplayed(driver, wordpressLogo);
		//return wordpressLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws Throwable {

		Action.type(username, un);
		Action.type(password, pwd);
		Action.click(driver, loginButton);
		return new HomePage();

	}

}
