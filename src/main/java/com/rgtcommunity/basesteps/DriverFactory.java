package com.rgtcommunity.basesteps;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import com.rgtcommunity.commonutils.ConfigReader;
import com.rgtcommunity.commonutils.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	Properties properties;
	ConfigReader configreader;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * 5*.
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) 
	{

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();

			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
		} 
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} 
		else if (browser.equals("msedge")) 
		{
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new SafariDriver());
		} 
		else 
		{
			System.out.println("Please pass the correct browser value: " + browser);
		}

		initilizeDriver().manage().deleteAllCookies();
		initilizeDriver().manage().window().maximize();
    	configreader=new ConfigReader();
    	properties=configreader.init_prop();
    	initilizeDriver().get(properties.getProperty("rgtqaurl"));
    	initilizeDriver().manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
    	initilizeDriver().manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return initilizeDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver initilizeDriver() {
		return tlDriver.get();
	}
}
