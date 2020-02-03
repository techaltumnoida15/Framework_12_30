package org.techAltum.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UploadFIleUsingAutoIT_Parameter extends BaseClass{

	@Test
	public void uploadFileUsingAutoIT() throws Exception{
		String autoITexePath = System.getProperty("user.dir") + "\\autoIT\\UploadFile_32bit.exe";
		driver.get("https://convertonlinefree.com/PDFToWORDEN.aspx");
		
		Thread.sleep(4000);
		
		WebElement chooseFile = driver.findElement(By.id("MainContent_fuDOCX"));
		//WebElement chooseFile = driver.findElement(By.xpath("//input[@name='uploaded_file']"));
		//chooseFile.click();
		
		Actions act = new Actions(driver); 
		//act.doubleClick(chooseFile);
		act.click(chooseFile);
		act.build().perform(); 
		Thread.sleep(4000);
		
		
		//Pass parameter in .exe at run time
		//Call .exe to upload file
		Runtime.getRuntime().exec(autoITexePath);
	}
}
