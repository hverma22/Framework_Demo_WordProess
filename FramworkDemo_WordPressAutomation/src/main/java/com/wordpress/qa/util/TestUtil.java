/**
 * 
 */
package com.wordpress.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import com.wordpress.qa.base.TestBase;

/**
 * @author Hitendra
 *
 */
public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 10;

	public static Object[][] readExcel(String filePath, String fileName, String sheetName) throws IOException {

		// Create an object of File class to open xlsx file

		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = null;

		// Find the file extension by splitting file name in substring and
		// getting only extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			workbook = new XSSFWorkbook(inputStream);

		}

		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of XSSFWorkbook class

			workbook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name

		Sheet excelSheet = workbook.getSheet(sheetName);

		// Find number of rows in excel file

		// int rowCount = excelSheet.getLastRowNum();

		// Create a loop over all the rows of excel file to read it

		Object[][] data = new Object[excelSheet.getLastRowNum()][excelSheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < excelSheet.getLastRowNum(); i++) {

			// Row row = excelSheet.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < excelSheet.getRow(0).getLastCellNum(); j++) {

				// Print Excel data in console

				// System.out.print(row.getCell(j).getStringCellValue() + "|| ");
				data[i][j] = excelSheet.getRow(i + 1).getCell(j).toString();

			}
		}
		return data;
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File scr = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenShots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(scr, finalDestination);
		return destination;

	}

}
