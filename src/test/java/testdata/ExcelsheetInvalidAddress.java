package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelsheetInvalidAddress {
	
	public static Workbook book;
	public static Sheet sheet;
	public static Object [][] readdata(String sheetname){
		
		FileInputStream file=null;
		try
		{			//reading excel file
			file=new FileInputStream("C:\\Users\\shahz\\eclipse-workspace\\Amazon\\src\\test\\java\\testdata\\invalidAddressDetails.xlsx");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try  
		{    		//creating workbook
		book=WorkbookFactory.create(file);
		}
		catch(IOException a) {
			a.printStackTrace();
		}
		sheet=book.getSheet(sheetname);  // reading sheets in the workbook
		  			// to fetch data from 2d array :
		Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				if(sheet.getRow(i+1).getCell(j) != null)
					data[i][j]=sheet.getRow(i+1).getCell(j).toString(); // to get data from the cells
				else
					data[i][j]= "";
			}
			
		}
		return data;
}

}
