package org.techAltum.com;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import practice.ReadDataFrmXL;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class NaukriTest02 extends BaseClass{

	@Test
	public void naukriTest() throws Exception{
		//Get data from XL
		ReadDataFrmXL excelReader = new ReadDataFrmXL();
		String[][] excelData = excelReader.readDataFrmXL(0);
		
		
		extentTest = extentReport.createTest("Naukri Test", "Searching jobs");   //Mandatory
		extentTest.assignCategory("Regression Test");
		
		//driver.get("http://www.naukri.com");
		System.out.println("URL is = " + getData("url"));
		driver.get(getData("url"));
		
		extentTest.info("url is entered.");
		//Reporter.log("url is entered.");    //TestNG report
		extentTest.createNode("URL is entered.");
		
		//Click on search job text box
		//WebElement searchJobTestBox = driver.findElement(By.id("qsbClick"));
		WebElement searchJobTestBox = driver.findElement(By.id(getData("id_searchJobTestBox")));
		searchJobTestBox.click();
		extentTest.info("Click on search job text box.");
		extentTest.createNode("Click is done");
		
		//Enter skills  
		//WebElement skillsTextBox = driver.findElement(By.name("qp"));
		WebElement skillsTextBox = driver.findElement(By.name(getData("name_skillsTextBox")));
		System.out.println("Skill is = " + excelData[1][0]);
		skillsTextBox.sendKeys(excelData[1][0]);
		extentTest.info("Skill is entered..");
		extentTest.createNode("Skill is entered..");
		
		//Take screenshot of a specific element
		
		//Screenshot specificElement = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,skillsTextBox); 
		//String scrrenshotPath = System.getProperty("user.dir") + "\\failureScreenshot\\" + "SkillTextBox"  + "_" + currentDateTime + ".jpeg";
		  
		//ImageIO.write(specificElement.getImage(),"JPEG",new File(scrrenshotPath));
		 
	}
}
  