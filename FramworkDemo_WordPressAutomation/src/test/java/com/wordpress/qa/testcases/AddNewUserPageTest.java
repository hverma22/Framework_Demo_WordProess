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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wordpress.qa.base.TestBase;
import com.wordpress.qa.util.ExtentClass;
import com.wordpress.qa.util.TestUtil;
import com.worpress.qa.pages.AddNewUserPage;
import com.worpress.qa.pages.HomePage;
import com.worpress.qa.pages.LoginPage;
import com.worpress.qa.pages.NewPostPage;

/**
 * @author Hitendra ----
 *
 */
public class AddNewUserPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	NewPostPage newpostpage;
	AddNewUserPage addnewuserpage;

	public AddNewUserPageTest() {
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
		//driver.manage().window().maximize();
		addnewuserpage = homePage.clickOnAddNewUser();
	}

	@Test(dataProvider = "getWordPressNewUserData", groups = { "Regression","SytemTest" })
	public void addNewUserTest(String username, String email, String fname, String lname, String url) throws Throwable {
		ExtentClass.extentTest = ExtentClass.extent.startTest("verifyaddNewUserTest");
		addnewuserpage.addNewUser(username, email, fname, lname, url);
		boolean verifyUser = addnewuserpage.validateNewUserID();
		Assert.assertTrue(verifyUser);
	}

	@DataProvider()
	public Object[][] getWordPressNewUserData() throws IOException {
		Object data[][] = TestUtil.readExcel(prop.getProperty("filePath"), prop.getProperty("fileName"),
				prop.getProperty("sheetName"));
		return data;
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
