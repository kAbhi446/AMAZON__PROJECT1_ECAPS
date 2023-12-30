package com.Amazon.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.Amazon.action.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		 
	public static WebDriver driver;
	public static Properties prop;

		public String loadconfig(String key)  
		{
			String value = "";
			try {
				File file = new File("./src/main/resources/config/config.properties");
				FileInputStream fileInput =  new FileInputStream(file);
				prop = new Properties();
				prop.load(fileInput);
				value = prop.getProperty(key);
			} catch (IOException i)
			{
			}
			return value;
		}
		
		public static WebDriver getDriver()
		{
			return driver;
		}

		public void browserLaunch()
		{
			String browserName = loadconfig("browser");
			
			if(browserName.contains("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(); 
			}
			else if(browserName.contains("FireFox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browserName.contains("Edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else
			{
				System.out.println("Invaild browser name");
				Assert.assertTrue(false);
			}
				
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Action.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Action.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
	}
	
	

}