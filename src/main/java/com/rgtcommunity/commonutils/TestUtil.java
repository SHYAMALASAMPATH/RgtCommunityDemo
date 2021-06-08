package com.rgtcommunity.commonutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil 
{
	public static int IMPLICITLY_WAIT = 50;
	public static int PAGE_LOAD_TIMEOUT = 50;
	public static void waitvisibletoelelocate(WebDriver driver,WebElement ele)
	{
		WebDriverWait wdw=new WebDriverWait(driver, 50);
		wdw.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void scrollToFindSpecificEle(WebDriver driver,WebElement ele)
	{
		//JavascriptExecutor jse=(JavascriptExecutor) driver;
		//jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
}
