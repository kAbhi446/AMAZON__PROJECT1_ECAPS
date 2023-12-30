package com.Amazon.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentClass {
	
	ExtentReports report = null;
	ExtentTest test = null;
		
	
	public ExtentReports getExtentReportInstance(String filepath)
	{
		report = new ExtentReports(filepath);
		return report;
	}
	
	public ExtentTest startTest(String testName, ExtentReports report)
	{
		return test = report.startTest(testName);
	}
	
	public void endTest(ExtentTest testName, ExtentReports report)
	{
		report.endTest(testName);
	}
	
	public void flushReport(ExtentReports report)
	{
		report.flush();
	}
}