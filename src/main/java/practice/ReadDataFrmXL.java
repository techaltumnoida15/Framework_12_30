package practice;

import java.io.File;
import java.io.FileInputStream;

import org.testng.annotations.Test;

public class ReadDataFrmXL {

	@Test
	public void readDataFrmXL() throws Exception{
		
		String filePath = System.getProperty("user.dir") + "//data" + "//TestData.xls";
		
		File file = new File(filePath);
		FileInputStream fIp = new FileInputStream(file);
		
		//http://seletesting.blogspot.com/2013/04/reading-excel-data-with-apache-poi-team.html
		
		//https://poi.apache.org/components/spreadsheet/quick-guide.html
		
		
	}
}
