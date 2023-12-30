package com.Amazon.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener  implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test Start: " + result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test is passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Failed: " + result.getName());
	}
	
	public void onTestSkip(ITestResult result)
	{
		System.out.println("Test Skiped: " + result.getName());
	}


}