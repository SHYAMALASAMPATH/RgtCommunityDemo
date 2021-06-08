package com.rgtcommunity.basesteps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo 
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\RGT_WorkSpace\\rgtcommunity\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://qa.ratnaglobaltech.net:8181");
		driver.findElement(By.xpath("//a[contains(text(),'LogIn')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("globaladmin@ratnaglobaltech.com");
		driver.findElement(By.id("password")).sendKeys("Letmecall@143");
		driver.findElement(By.id("login")).click();
		//driver.findElement(By.xpath("//div[@class='nav-profile-text']")).click();
		Thread.sleep(5000);
		WebElement element =driver.findElement(By.xpath("//*[@class='nav-profile-img']"));//*[@class='nav-profile-img']
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("global admin");
		Thread.sleep(3000);
		// WebElement webElement = driver.findElement(By.xpath("//*[@class='nav-profile-img']")); //id("Your ID Here")
		// Actions builder = new Actions(driver);
		// builder.moveToElement(webElement).click(webElement);
		// builder.perform();
		// driver.findElement(By.xpath("//*[@class='nav-profile-img']")).sendKeys(Keys.RETURN);
		// Actions action = new Actions(driver);
		// WebElement we = driver.findElement(By.xpath("//*[@class='nav-profile-img']"));
		// action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@class='nav-profile-img']"))).click().build().perform();
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//*[@class='nav-profile-img']"))).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()=' Signout ']")).click();

	}

}
