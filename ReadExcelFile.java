package seleniumbootcamp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {


	/*
	 * public static void main(String[] args) {
	 * 
	 * Strfor(int i=1;i<excelData.length;i++) { for(int j=0;j<excelData.length;j++) {
	 * 
	 * System.out.println(""+excelData[i][j]); }
	 * 
	 * }ing[][] excelData =
	 * get("C:\\Selenium_BC\\FirstSeleniumProject\\Testdata\\TestData.xlsx");
	 * 
	 *  }
	 */


	public static String[][] get(String filename) throws IOException {
		
		String[][] data = null;		
		XSSFWorkbook wb= new XSSFWorkbook(filename);

		// 2. get in to the worksheet
		XSSFSheet ws = wb.getSheet("Employee");
		int rowCount= ws.getLastRowNum();

		//	System.out.println(rowCount);
		//to get the cellcount
		int cellCount = ws.getRow(0).getLastCellNum();
		data=new String[rowCount][cellCount];

		for(int i=1; i<=rowCount;i++)
		{
			for (int j=0; j<cellCount;j++)
			{
				String text = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i-1][j]=text;
			}	

		}

		//last step
		wb.close();
		return data;

		}	
	}

