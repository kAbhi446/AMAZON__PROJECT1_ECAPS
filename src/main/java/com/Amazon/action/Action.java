package com.Amazon.action;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Amazon.base.BaseClass;

public class Action  extends BaseClass{
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 20;
	
	public void AppLaunch(String url)
	{
		driver.get(url);
	}
	
	
	public static void findElement(WebDriver driver, WebElement element)
		{
			 element.isDisplayed();
		} 
	
	public void selectByVisibleText(String visibletext, WebElement ele)
	{
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
	}
	
	public void selectByIndex(WebElement element, int index)
	{
		
			Select s = new Select(element);
			s.selectByIndex(index);
	}
	
	public void ClickOnElement(WebElement element)
	{
		if(element.isDisplayed())
		element.click();	
	}
	
	public void click(WebDriver driver, WebElement ele) 
	{

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}
	
	public static void javaScriptClick(WebDriver driver, WebElement element)
	{ 
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	
	}
	
	public void moveToElement(WebDriver driver, WebElement ele) 
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
		
	}

	public void mouseover(WebDriver driver, WebElement ele) 
	{
			new Actions(driver).moveToElement(ele).build().perform();
	}
	
	
	public static void scrollByVisibility(WebDriver driver, WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeAsyncScript("arguments[0].scrollIntoView();",element);
	}
	
	public String getText(WebElement element)
	{
		 return element.getText();
	}
	
	public void StoregetText(WebElement element, String Value)
	{
		Value =   element.getText();
		 
	}
	
	public void switchToAnotherWindow(String WindowID)
	{
		driver.switchTo().window(WindowID);
	}
	
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String id)
	{
		driver.switchTo().frame(id);
	}
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public String getWindowId()
	{
		return driver.getWindowHandle();
	}
	
	public Set<String> getAllWindowsId()
	{
		return driver.getWindowHandles();
	}
	
	public Alert switchToAlert()
	{
		 return driver.switchTo().alert();
	}
	
	public void  acceptAlert()
	{
		switchToAlert().accept();
	}
	
	public void cancelAlert()
	{
		switchToAlert().dismiss();
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "./screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public void Zoomout() {
		browserLaunch();
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 String zoomoutchrome = "document.body.style.zoom = '40.0%";
	 js.executeScript(zoomoutchrome);
	}
	
	
	public void closeBrowser()
	{
		driver.close();
	}
	
	public void closeAllBrowser()
	{
		driver.quit();
	}

}

