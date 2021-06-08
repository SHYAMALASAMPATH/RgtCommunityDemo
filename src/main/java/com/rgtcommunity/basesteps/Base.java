package com.rgtcommunity.basesteps;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rgtcommunity.pageobjects.FacebookPageObjects;



public class Base
{
	public static WebDriver driver;
    public static Properties prop;
    public static FacebookPageObjects facebookpageobjects;
	public static WebDriver initilization() throws IOException
	{
		String projectpath=System.getProperty("user.dir");
		prop=new Properties();
		FileInputStream fis=new FileInputStream(projectpath+"\\src\\test\\resources\\config\\config.properties");
		prop.load(fis);
      System.setProperty("webdriver.chrome.driver", projectpath+"\\drivers\\chromedriver.exe");
//      ChromeOptions options = new ChromeOptions(); 
//      options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
//      WebDriver driver = new ChromeDriver(options); 
//
//      ChromeOptions options = new ChromeOptions();
//     options.addArguments("disable-infobars");
//     WebDriver driver = new ChromeDriver(options);
   	 driver=new ChromeDriver();
   	 driver.manage().window().maximize();
   	 driver.manage().deleteAllCookies();
   	driver.get(prop.getProperty("url"));
   	 //driver.get();
//   	 driver.get(prop.getProperty("url"));
   	 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
   	 return driver;
		
	}
	public static void waitvisibletoelelocate(WebDriver driver,WebElement ele)
	{
		WebDriverWait wdw=new WebDriverWait(driver, 30);
		wdw.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void scrollToFindSpecificEle(WebDriver driver,WebElement ele)
	{
		//JavascriptExecutor jse=(JavascriptExecutor) driver;
		//jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	public static void dropselectByValue(WebElement ele, String value)
	{
		 Select s=new Select(ele);
		 s.selectByValue(value);
	}
	public static void dropselectByIndex(WebElement ele,int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	public static void dropselectByVisualText(WebElement ele,String value)
	{
		 Select s=new Select(ele);
		 s.selectByValue(value);
	}
}
