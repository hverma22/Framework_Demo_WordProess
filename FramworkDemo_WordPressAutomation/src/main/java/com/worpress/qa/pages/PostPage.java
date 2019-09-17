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
 * @author Hitendra
 *
 */
public class PostPage extends TestBase {
	
	@FindBy(xpath = "//*[@id='post-1']/td[1]/strong/a")
	WebElement helloWorldPost;
	
	@FindBy(xpath = "//*[@id='post-search-input']")
	WebElement searchPostTextBox;
	
	@FindBy(xpath = "//*[@id='search-submit']")
	WebElement searchButton;
	
	public PostPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String searchPost() throws Throwable{
		Action.type(searchPostTextBox, "Hello world!");
		Action.click(driver, searchButton);
		String post=helloWorldPost.getText();
		return post;
	}

}
