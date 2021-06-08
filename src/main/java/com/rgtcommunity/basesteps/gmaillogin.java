package com.rgtcommunity.basesteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class gmaillogin 
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\RGT_WorkSpace\\rgtcommunity\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.gmail.com");
	    Thread.sleep(2000);
	    //driver.findElement(By.xpath("//body/div[2]/div[1]/div[4]/ul[1]/li[2]/a[1]")).click();
	    driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("sai484484@gmail.com");
	    driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("8919709070");
	    driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/div[2]")).click();
	    Thread.sleep(3000);
	    
  }

}
