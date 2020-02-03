package org.techAltum.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {

	protected WebDriver driver;
	public ExtentHtmlReporter htmlReporter ;    //for look and feel of report
	public ExtentReports extentReport ;         //To create entry of test in report
	public ExtentTest extentTest;               //To update status of test in report
	String currentDateTime;
	Properties prop = new Properties();
	
	@BeforeClass
	public void beforeClass() throws Exception{
		currentDateTime = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/extentReport/TestAutomationReport_" + currentDateTime + ".html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("HostName", System.getProperty("user.name"));
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Environment", "LIVE");
	}
	
	@BeforeMethod
	public void openBrowser() {
		//Open Browser
		String projectPath = System.getProperty("user.dir");
		String browserDriverEXE = projectPath + "\\browserDriverEXE\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", browserDriverEXE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void quitBrowser(ITestResult result) throws Exception {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "Test case failed is = " + result.getName());
			extentTest.log(Status.FAIL, "Test case failed is = " + result.getThrowable());
			
			String testMethodName = result.getMethod().getMethodName();
			currentDateTime = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
			
			String scrrenshotPath = System.getProperty("user.dir") + "\\failureScreenshot\\" + testMethodName  + "_" + currentDateTime + ".jpeg";
			
			Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
			ImageIO.write(fpScreenshot.getImage(),"JPEG",new File(scrrenshotPath));
			
			
			
			//File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//String screenshotPath = System.getProperty("user.dir") + "\\failureScreenshot\\" + testMethodName  + "_" + currentDateTime + ".jpeg";
			
			//FileUtils.moveFile(screenShot, new File(screenshotPath));
			 
			
			extentTest.addScreenCaptureFromPath(scrrenshotPath);
			extentTest.info("Test is fail.");
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test case skiped is = " + result.getName());
			extentTest.info("Test is skiped.");
		}
		else {
			extentTest.log(Status.PASS, "Test case passed is = " + result.getName());
			extentTest.info("Test is pass.");
		}

		driver.quit();
	}

	@AfterClass
	public void afterClass() throws Exception{
		extentReport.flush();
	}

	public String getData(String key) throws Exception {
		
		String filePath = System.getProperty("user.dir") + "//data" + "//data.properties";
		FileInputStream fIp = new FileInputStream(new File(filePath));

		prop.load(fIp);
		
		String value = prop.getProperty(key);
		
		return value;
	}
}
