package org.techAltum.com;

import org.openqa.selenium.By;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class UploadFileUsingSikuli extends BaseClass{

	@Test
	public void naukriTest() throws Exception{
		driver.get("http://www.tinyupload.com/");
		Thread.sleep(2000);
		
		String projectPath = System.getProperty("user.dir");
		
		String chooseFileButtonImage = projectPath + "\\sikuliImages\\ChooseFile.jpg";
		String writeFileNameTextBox = projectPath + "\\sikuliImages\\FilePathTextBox.jpg";
		String openButtonImage = projectPath + "\\sikuliImages\\OpenButton.jpg";
		
		String fileNeedToUpload = projectPath + "\\sikuliImages\\Selenium Training Course Content.pdf";
		
		Screen screen = new Screen();
		
		//Click on choose file
		Pattern chooseFile = new Pattern(chooseFileButtonImage);
		screen.wait(chooseFile, 2000);
		screen.click();
		
		//Type file name
		Pattern writeFileName = new Pattern(writeFileNameTextBox);
		screen.wait(writeFileName, 2000);
		screen.type(fileNeedToUpload);
		
		//Click on Open button
		Pattern clickOnOpen = new Pattern(openButtonImage);
		screen.wait(clickOnOpen, 2000);
		screen.click();
	}
}
