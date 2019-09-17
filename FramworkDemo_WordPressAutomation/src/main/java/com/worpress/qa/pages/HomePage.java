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
public class HomePage extends TestBase {
	
	@FindBy(xpath = "//*[@id='wp-admin-bar-my-account']/a/span[contains(text(),'opensourcecms')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@id='menu-posts']//a[contains(text(),'Add New')]")
	WebElement addNewPostLink;
	
	@FindBy(xpath="//*[@id='menu-posts']/a/div[contains(text(),'Posts')]")
	WebElement PostLink;
	
	@FindBy(xpath="//*[@id='menu-users']/a")
	WebElement usersLink;
	
	@FindBy(xpath="//*[@id='menu-users']/ul/li[3]/a")
	WebElement addNewUserLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCorrectUsername() {
		return userNameLabel.isDisplayed();
	}
	
	public NewPostPage clickOnAddNewLink() throws Throwable{
		Action.click(driver, PostLink);
		addNewPostLink.click();
		return new NewPostPage();
	}
	
	public AddNewUserPage clickOnAddNewUser() throws Throwable{
		Action.click(driver, usersLink);
		Action.click(driver, addNewUserLink);
		return new AddNewUserPage();
	}
	
	public PostPage clickOnPostLink() throws Throwable{
		Action.click(driver, PostLink);
		return new PostPage();
	}
	
	public boolean postLinkIsdisplayed()
	{
		PostLink.isDisplayed();
		return true;
		
	}

}
