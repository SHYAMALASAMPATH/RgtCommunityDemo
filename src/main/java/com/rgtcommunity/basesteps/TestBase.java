package com.rgtcommunity.basesteps;
    import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

import com.rgtcommunity.commonutils.TestUtil;
    
	public class TestBase {

	 

	    
	    public static WebDriver driver;
	    public static Properties prop;
	    
	    public TestBase() {
	        try {
	            prop = new Properties();
	            FileInputStream fis = new FileInputStream("C:\\RGT_WorkSpace\\rgtcommunity\\src\\test\\resources\\config\\config.properties"
	                    );
	                    prop.load(fis);
	        } catch (IOException e) {
	            e.getMessage();
	        }
	    }
	    public static void initialization() {
	        String browserName = prop.getProperty("browser");
	        
	        if(browserName.equals("chrome")) {
	            System.setProperty("webdriver.chrome.driver", "C:\\RGT_WorkSpace\\rgtcommunity\\drivers\\chromedriver.exe");
	            driver = new ChromeDriver();
	        }
	        else if(browserName.equals("firefox")) {
	            System.setProperty("webdriver.gecko.driver", "C:\\RGT_WorkSpace\\rgtcommunity\\drivers\\geckodriver.exe");
	            driver = new FirefoxDriver();
	        }
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	        
	        driver.get(prop.getProperty("url"));
	    }
	}
