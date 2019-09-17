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

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.qa.base.TestBase;
import com.wordpress.qa.util.ExtentClass;
import com.wordpress.qa.util.TestUtil;
import com.worpress.qa.pages.HomePage;
import com.worpress.qa.pages.LoginPage;
import com.worpress.qa.pages.NewPostPage;

/**
 * @author Hitendra
 *
 */
public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	NewPostPage newpostpage;

	public HomePageTest() {
		super();
	}

	@BeforeTest(groups = { "Smoke", "Regression" })
	public void startTest() {
		ExtentClass.setExtent();
	}

	@BeforeMethod(groups = { "Regression", "Smoke" })
	public void setup() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(groups = { "Regression" })
	public void homePageTitleTest() {
		ExtentClass.extentTest = ExtentClass.extent.startTest("VerifyhomePageTitleTest");
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Dashboard ‹ opensourcecms — WordPress");
	}

	@Test(groups = { "Regression" })
	public void verifyUserNameTest() {
		ExtentClass.extentTest = ExtentClass.extent.startTest("verifyUserNameTest");
		boolean title = homePage.validateCorrectUsername();
		Assert.assertTrue(title);
	}

	@Test(groups = { "Smoke" })
	public void verifyAddNewPostLinkTest() throws Throwable {
		ExtentClass.extentTest = ExtentClass.extent.startTest("verifyAddNewPostLinkTest");
		newpostpage = homePage.clickOnAddNewLink();
		Assert.assertTrue(newpostpage.postTitleIsdisplayed());
	}

	@AfterMethod(groups = { "Regression", "Smoke" })
	public void tearDown(ITestResult result) throws IOException {
		ExtentClass.setResult(driver, result);
		driver.quit();
	}

	@AfterTest(groups = { "Smoke", "Regression" })
	public void endTest() {
		ExtentClass.endExtent();
	}
}
