package org.techAltum.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class YouTubeTest extends BaseClass{

	@Test
	public void youTubeTest() throws Exception{
		driver.get("https://www.youtube.com/watch?v=t9yqsxvtT-Y");
		Thread.sleep(5000);
		
		WebElement playerContainer = driver.findElement(By.id("container"));
		
		//Assignment
		
	}
}
