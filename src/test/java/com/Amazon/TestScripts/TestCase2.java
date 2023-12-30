package com.Amazon.TestScripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Amazon.action.Action;
import com.Amazon.pages.HomePage;
import com.Amazon.utilities.ExtentClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(com.Amazon.utilities.Listener.class)
public class TestCase2 {
	
	HomePage homepageObj = new HomePage();
	ExtentClass extentObj = new ExtentClass();
	ExtentReports extent = null;
	ExtentTest test = null;
	String screenshotspath = null;
	
		
	@BeforeClass
	public void reports()
	{
		extent = extentObj.getExtentReportInstance(homepageObj.loadconfig("testCaseReportPath")+this.getClass().getName()+".html");
	}
	
	@BeforeMethod
	public void launch()
	{
		test = extentObj.startTest("Dropdown list verification", extent);
		homepageObj.browserLaunch();
		test.log(LogStatus.PASS, "Browser is launched");
		homepageObj.initElements();
		screenshotspath = homepageObj.loadconfig("screenshotspath");
	}
	
	@Test
	public void TC2() throws IOException
	{
		try {
		homepageObj.AppLaunch(homepageObj.loadconfig("url"));
		test.log(LogStatus.PASS, "Amazon application is launched");
		homepageObj.dropdownInterface();
		}catch(Exception i)
		{
			Action.takeScreenshotAtEndOfTest();
		}
		test.log(LogStatus.PASS, "Validated dropdown list");
		System.out.println("Dropdown list is displayed");
	}
	
	@AfterClass
	public void teardwn()
	{
		homepageObj.closeBrowser();
		test.log(LogStatus.PASS, "Browser is closed");
		extentObj.endTest(test, extent);
		extentObj.flushReport(extent);
	}
	

}
