package practice;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFrmPropFIle {

	@Test
	public void readData() throws Exception{

		
		 String filePath = System.getProperty("user.dir") + "//data" + "//data.properties";
		 /* 
		 * File file = new File(filePath);
		 * 
		 * FileInputStream fIp = new FileInputStream(file);
		 */
		
		
		FileInputStream fIp = new FileInputStream(new File(filePath));
		
		Properties prop = new Properties();
		prop.load(fIp);
		
		
		String name = prop.getProperty("name");
		System.out.println(name);
	}
}
