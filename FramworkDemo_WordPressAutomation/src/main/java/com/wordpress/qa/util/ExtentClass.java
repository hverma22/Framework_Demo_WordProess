package com.wordpress.qa.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentClass {
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public static void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Project Name", "WordPress Automation Testing");
		extent.addSystemInfo("Host Name", "Hitendra V");
		extent.addSystemInfo("User Name", "HitendraVerma");
		extent.addSystemInfo("Environment", "QA");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

	public static void endExtent() {
		extent.flush();
		//extent.close();
	}
	
	public static void closeExtent() {
		extent.close();
	}

	public static void setResult(WebDriver driver, ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentClass.extentTest.log(LogStatus.FAIL, "FAILED TEST CASE IS: ", result.getName());
			ExtentClass.extentTest.log(LogStatus.FAIL, "FAILED TEST CASE IS: ", result.getThrowable());
			String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
			ExtentClass.extentTest.log(LogStatus.FAIL, ExtentClass.extentTest.addScreencast(screenshotPath));
			ExtentClass.extentTest.log(LogStatus.FAIL, ExtentClass.extentTest.addScreenCapture(screenshotPath));
			// driver.quit();
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentClass.extentTest.log(LogStatus.SKIP, "SKIPPED TEST CASE IS:", result.getName());
			// driver.quit();
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentClass.extentTest.log(LogStatus.PASS, "PASSED TEST CASE IS:", result.getName());
			// driver.quit();
		}
		ExtentClass.extent.endTest(ExtentClass.extentTest);
	}

}