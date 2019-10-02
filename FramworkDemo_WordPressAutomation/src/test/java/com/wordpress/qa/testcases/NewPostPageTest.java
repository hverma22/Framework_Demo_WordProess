/**
 * 
 */
package com.wordpress.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wordpress.qa.base.TestBase;
import com.wordpress.qa.util.ExtentClass;
import com.worpress.qa.pages.HomePage;
import com.worpress.qa.pages.LoginPage;
import com.worpress.qa.pages.NewPostPage;

/**
 * @author Hitendra
 *
 */
public class NewPostPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	NewPostPage newpostpage;

	public NewPostPageTest() {
		super();
	}

	@BeforeTest(groups = { "Regression","SytemTest" })
	public void startTest() {
		ExtentClass.setExtent();
	}

	@BeforeMethod(groups = { "Regression","SytemTest" })
	public void setup() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().window().maximize();
		newpostpage = homePage.clickOnAddNewLink();
	}

	@Test(groups = { "Regression","SytemTest" })
	public void addNewPostTest() throws Throwable {
		ExtentClass.extentTest = ExtentClass.extent.startTest("VerifyaddNewPostTest");
		newpostpage.addNewPost();
		Assert.assertTrue(newpostpage.postPublishedIsdisplayed());
	}

	@AfterMethod(groups = { "Regression","SytemTest" })
	public void tearDown(ITestResult result) throws IOException {
		ExtentClass.setResult(driver, result);
		driver.quit();
	}

	@AfterTest(groups = { "Regression","SytemTest" })
	public void endTest() {
		ExtentClass.endExtent();
		ExtentClass.closeExtent();
	}

}
