package dataProviders;

import org.testng.annotations.DataProvider;

import helper.ExcelUtility;

public class DataProviders {
	@DataProvider(name = "testData")
	public Object[][] readingTestData() {
		Object obj[][] = ExcelUtility.readExcelData("sheet1");
		return obj;
	}
}
