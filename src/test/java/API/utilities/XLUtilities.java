package API.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilities {

	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	String path;
	public FileInputStream fis;
	public FileOutputStream fos;

	public XLUtilities(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetname) throws IOException {

		fis = new FileInputStream(new File(path));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetname);
		fis.close();
		wb.close();
		return sheet.getLastRowNum();

	}

	public int getColumnCount(String sheetname) throws IOException {

		fis = new FileInputStream(new File(path));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetname);
		fis.close();
		wb.close();
		return sheet.getRow(0).getLastCellNum();

	}

	public String getCellData(String sheetname, int rowno, int colno) throws IOException {
		fis = new FileInputStream(new File(path));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetname);
		DataFormatter dataFormatter = new DataFormatter();
		String cellvalue = dataFormatter.formatCellValue(sheet.getRow(rowno).getCell(colno));
		fis.close();
		wb.close();
		return cellvalue;
	}

	public void writeCellValue(String sheetname, int rowno, int colno, String value) throws Exception {

		fis = new FileInputStream(new File(path));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetname);
		sheet.getRow(rowno).createCell(colno).setCellValue(value);
		fis.close();
		fos = new FileOutputStream(new File(path));
		wb.write(fos);
		fos.close();
		wb.close();

	}

}
