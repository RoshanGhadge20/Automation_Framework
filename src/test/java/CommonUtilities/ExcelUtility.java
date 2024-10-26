package CommonUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.RowId;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseTest.Base_Test;

public class ExcelUtility extends Base_Test
{
	
	  public ExcelUtility() throws IOException, FileNotFoundException { 
		  super(); 
		  }
	 
	public void excelutil(String sheetname) throws IOException
	{
		FileInputStream fin= new FileInputStream(pr.getProperty("excelpath"));
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		
		int row_count = sheet.getPhysicalNumberOfRows();
		System.out.println("Total Number of Rows"+ row_count);
		XSSFRow row = sheet.getRow(0);
		
		XSSFCell cell = row.getCell(0);
		int col_count = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Total Number of Columns"+ col_count);

		//Reading all values from excel 
		for ( int i =0 ;i<=row_count;i++)
		{
			XSSFRow row2 = sheet.getRow(i);
			for(int j=0;j<col_count;j++)
			{
				XSSFCell cell2 = row2.getCell(j);
				System.out.print(" "+ cell2.getStringCellValue());
 			}
			System.out.println();
		}
	}
}
