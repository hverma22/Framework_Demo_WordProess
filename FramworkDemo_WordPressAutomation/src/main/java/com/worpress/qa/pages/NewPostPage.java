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
 * @author Hitendra
 *
 */
public class NewPostPage extends TestBase {
	
	@FindBy(xpath="//*[@id='post-title-0']")
	@CacheLookup
	WebElement postTitle;
	
	@FindBy(xpath="//*[@id='content-html']")
	@CacheLookup
	WebElement clickOnTextButton;
	
	@FindBy(xpath="//*[@id='content']")
	@CacheLookup
	WebElement enterMatter;
	
	@FindBy(xpath="//*[@id='publish']")
	@CacheLookup
	WebElement publishButton;
	
	@FindBy(xpath="//*[@id='qt_content_dfw']")
	@CacheLookup
	WebElement distractFreeBtn;
	
	@FindBy(xpath="//*[@id='message']/p")
	@CacheLookup
	WebElement postPublished;
	
	
	public NewPostPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addNewPost() throws Throwable{
		Action.mouseHoverByJavaScript(postTitle);
		Action.type(postTitle, "This is a New Test Title");
		Action.click(driver, clickOnTextButton);
		Action.type(enterMatter, "This is new post, i am adding my comments here");
		Thread.sleep(2000);
		//Action.implicitlyWait(driver);
		Action.click(driver, distractFreeBtn);
		
		Action.click(driver, publishButton);
		Thread.sleep(2000);
		//Action.implicitlyWait(driver);
	}
	
	public boolean postTitleIsdisplayed()
	{
		postTitle.isDisplayed();
		return true;
		
	}
	
	public boolean postPublishedIsdisplayed()
	{
		postPublished.isDisplayed();
		return true;
		
	}

}
