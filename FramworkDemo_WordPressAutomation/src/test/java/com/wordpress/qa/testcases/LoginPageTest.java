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

/**
 * @author Hitendra--
 *
 */
public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeTest(groups = { "Smoke", "Regression" })
	public void startTest() {
		ExtentClass.setExtent();
	}

	@BeforeMethod(groups = { "Smoke", "Regression" })
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(groups = { "Smoke" })
	public void loginPageTitleTest() {
		ExtentClass.extentTest = ExtentClass.extent.startTest("VerifyloginPageTitleTest");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Log In ‹ opensourcecms — WordPress");

	}

	@Test(groups = { "Regression" })
	public void loginWordPresslogoTest() throws Throwable {
		ExtentClass.extentTest = ExtentClass.extent.startTest("VerifyloginWordPresslogoTest");
		boolean flag = loginPage.logo();
		Assert.assertTrue(flag);
	}

	@Test(groups = { "Smoke" })
	public void loginTest() throws Throwable {
		ExtentClass.extentTest = ExtentClass.extent.startTest("VerifyloginTest");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.postLinkIsdisplayed());
	}

	@AfterMethod(groups = { "Smoke", "Regression" })
	public void tearDown(ITestResult result) throws IOException {
		ExtentClass.setResult(driver, result);
		driver.quit();
	}

	@AfterTest(groups = { "Smoke", "Regression" })
	public void endTest() {
		ExtentClass.endExtent();
	}
}
