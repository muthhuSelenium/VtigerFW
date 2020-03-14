package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileData {


	public String fetchDataFromProperty(String key) throws IOException
	{
		FileInputStream file = new FileInputStream
								("./src/test/resources/commondata.properties");
		Properties p = new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
	}
	
	public String fetchDataFromExcel(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream
							("./src/test/resources/TestCaseData.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
	}

}
