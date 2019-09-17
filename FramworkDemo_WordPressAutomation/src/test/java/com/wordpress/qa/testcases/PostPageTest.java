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
import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.qa.base.TestBase;
import com.wordpress.qa.util.ExtentClass;
import com.wordpress.qa.util.TestUtil;
import com.worpress.qa.pages.HomePage;
import com.worpress.qa.pages.LoginPage;
import com.worpress.qa.pages.PostPage;

/**
 * @author Hitendra
 *
 */
public class PostPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PostPage postPage;

	public PostPageTest() {
		super();
	}

	@BeforeTest(groups = { "Functional" })
	public void startTest() {
		ExtentClass.setExtent();
	}

	@BeforeMethod(groups = { "Functional" })
	public void setup() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().window().maximize();
		postPage = homePage.clickOnPostLink();
	}

	@Test(groups = { "Functional" })
	public void searchPostTest() throws Throwable {
		ExtentClass.extentTest = ExtentClass.extent.startTest("VerifyPostSearch");
		Assert.assertEquals(postPage.searchPost(), "Hello world!");
	}

	@AfterMethod(groups = { "Functional" })
	public void tearDown(ITestResult result) throws IOException {
		ExtentClass.setResult(driver, result);
		driver.quit();
	}

	@AfterTest(groups = { "Functional" })
	public void endTest() {
		ExtentClass.endExtent();
	}

}
