package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.InvalidArgumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUtil {
	
	 static Workbook book;
	 static Sheet sheet;
	 static FileInputStream file = null;
	 static String TESTDATA_SHEET_PATH ="C:\\Users\\admin\\git\\gsbank\\gsbank\\src\\test\\java\\testdata\\DropdownExcel.xlsx";
	// static String sheetName="Country";
	
	 
	 
		public static List<String> getTestData(String sheetName) {
		  
		  try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidArgumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sheet = book.getSheet(sheetName);
			
			//String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			List<String> data = new ArrayList<String>();
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data.add(sheet.getRow(i).getCell(k).toString());
				}
			}
		return data;
	 }
}
	 
	 


