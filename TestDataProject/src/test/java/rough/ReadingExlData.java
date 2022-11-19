package rough;

import java.lang.invoke.ConstantCallSite;

import utilities.Constants;
import utilities.ExcelReader;

public class ReadingExlData {

	public static void main(String[] args) {

		ExcelReader excel = new ExcelReader("./Excel/BankManageSuite.xlsx");
		int rows = excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows are: " + rows);

		String testName = "OpenAccountTest"; //AddCustomerTest
		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
			String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);

			if (testCaseName.equalsIgnoreCase(testName)) {
				break;
			}
		}

		System.out.println("Test Case starts from row num: " + testCaseRowNum);

		System.out.println("Checking total rows in test case");

		int dataStartRowNum = testCaseRowNum + 2;
		int testRows = 0;
		while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {
			testRows++;

		}
		System.out.println("Total number of rows data are: " + testRows);

		// Checking total no. of cols are:
		int testCols = 0;
		int dataStartColNum = testCaseRowNum + 1;
		while (!excel.getCellData(Constants.DATA_SHEET, testCols, dataStartRowNum).equals("")) {

			testCols++;
		}
		System.out.println("Total columns are: " + testCols);

		System.out.println("Print data");
		
		for(int rNum=dataStartRowNum;rNum<=(dataStartColNum+testRows);rNum++) {
			
			for(int cNum=0;cNum<testCols;cNum++) {
				System.out.print(excel.getCellData(Constants.DATA_SHEET, cNum, rNum)+" : ");
			}
			System.out.println();
		}
	}
}
