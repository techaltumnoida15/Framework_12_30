package practice;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.Test;

public class ReadDataFrmXL {

	//@Test
	public String[][] readDataFrmXL(int sheetIndex) throws Exception{
		
		String filePath = System.getProperty("user.dir") + "//data" + "//TestData.xls";
		
		File file = new File(filePath);
		FileInputStream fIp = new FileInputStream(file);
		
		//http://seletesting.blogspot.com/2013/04/reading-excel-data-with-apache-poi-team.html
		
		//https://poi.apache.org/components/spreadsheet/quick-guide.html
		
		//https://stackoverflow.com/questions/3571223/how-do-i-get-the-file-extension-of-a-file-in-java
		
		HSSFWorkbook wb = new HSSFWorkbook(fIp);
		HSSFSheet sheet = wb.getSheetAt(sheetIndex);
		
		int xRows = sheet.getLastRowNum() + 1;
		System.out.println("Total rows are = " + xRows);
		
		int xCols = sheet.getRow(0).getLastCellNum();
		System.out.println("Total cols are = " + xCols);
		
		String[][] xData = new String[xRows][xCols];
		
		//Rows
		for(int i = 1; i<xRows; i++) {
			HSSFRow row = sheet.getRow(i);
			
			for(int j = 0; j<xCols; j++) {
				HSSFCell cell = row.getCell(j);
				
				String value = cellToString(cell);
				
				xData[i][j] = value;
				
				System.out.print(value); 
                System.out.print("##");
			}
			System.out.println("@");
		}
		return xData;
	}

	private String cellToString(HSSFCell cell) throws Exception {
		
		CellType cellType = cell.getCellType();
		Object result;

		switch (cellType) {
		case NUMERIC:
			result = cell.getNumericCellValue();
			break;

		case STRING:
			result = cell.getStringCellValue();
			break;
		
		case BOOLEAN:
			result = cell.getBooleanCellValue();
			break;
			
		case FORMULA:
			throw new Exception("There is formula in cell.");
		
		case ERROR:
			throw new Exception("There is some error in cell.");
		
		case BLANK:
			result = "";
			break;
			
		default:
			
			throw new Exception("default");
		}
	
		return result.toString();
	}
}
