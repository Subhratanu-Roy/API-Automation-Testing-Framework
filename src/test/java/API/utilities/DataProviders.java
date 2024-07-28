package API.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	int rowno;
	int colno;
	XLUtilities xlUtilities;
	String sheetname = "Testdata";

	public DataProviders() throws IOException {
		String path = System.getProperty("user.dir") + "//testdata//Testcases.xlsx";
		xlUtilities = new XLUtilities(path);

		rowno = xlUtilities.getRowCount(sheetname);
		colno = xlUtilities.getColumnCount(sheetname);

	}

	@DataProvider(name = "all")
	public Object[][] getAllData() throws IOException {

		Object[][] inputData = new Object[rowno][colno];
		for (int row = 1; row <= rowno; row++) {
			for (int col = 0; col < colno; col++) {
				inputData[row - 1][col] = xlUtilities.getCellData(sheetname, row, col);
				// System.out.println("Data: "+inputData[row-1][col]);
			}
		}
		return inputData;
	}

	@DataProvider(name = "username")
	public String[] getUsernames() throws IOException {

		String[] inputData = new String[rowno];
		for (int row = 1; row <= rowno; row++) {
			inputData[row - 1] = xlUtilities.getCellData(sheetname, row, 1);
			// System.out.println(inputData[row-1]);
		}

		return inputData;
	}

}
