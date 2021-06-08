package com.rgtcommunity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.rgtcommunity.basesteps.Base;
import com.rgtcommunity.commonutils.TestUtil;

public class RgtLoginPageObjects
{
	
	public WebDriver driver;

	public  RgtLoginPageObjects(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h3[contains(text(),'Sign into your account')]")
	private WebElement SIGNINTOYOURACCOUNT;
	@FindBy(xpath = "//a[contains(text(),'LogIn')]")
	private WebElement HLOGIN;
	@FindBy(id = "email")
	private WebElement EMAIL;
	@FindBy(id="password")
	private WebElement PASSWORD;
	@FindBy(id="login")
	private WebElement LOGIN;
//	By emailtxt=By.id("email");
//	By passtxt=By.id("password");
//	By loginbtn=By.id("login");
	public String getSignintoyouraccountTitle() 
	{
		Base.waitvisibletoelelocate(driver, SIGNINTOYOURACCOUNT);
		return SIGNINTOYOURACCOUNT.getText();
	}
	public void clickHlogin()
	{
		Base.waitvisibletoelelocate(driver, HLOGIN);
		HLOGIN.click();
	}

	public void enterEmail(String input)
	{
		EMAIL.clear();
		EMAIL.sendKeys(input);
	}
	public void enterPassword(String input)
	{
		
		PASSWORD.clear();
		PASSWORD.sendKeys(input);
		
	}
	public void clickLogin()
	{
		LOGIN.click();

	}
	public String getLoginPageTitle() 
	{
		return driver.getTitle();
	}
	public WebElement homeLogin() {
		// TODO Auto-generated method stub
		return HLOGIN;
	}
	
}
