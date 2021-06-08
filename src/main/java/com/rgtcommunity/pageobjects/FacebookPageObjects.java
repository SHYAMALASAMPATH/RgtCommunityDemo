package com.rgtcommunity.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rgtcommunity.basesteps.Base;

public class FacebookPageObjects
{
public WebDriver driver;

public FacebookPageObjects(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//a[text()='Create New Account']")
private WebElement CREATE_NEW_ACCOUNT;

@FindBy(xpath = "//input[@name='firstname']")
private WebElement FIRST_NAME;

@FindBy(xpath = "//input[@name='lastname']")
private WebElement LAST_NAME;

@FindBy(xpath = "//input[@name='reg_email__']")
private WebElement EMAIL;

@FindBy(xpath = "//input[@name='reg_email_confirmation__']")
private WebElement RE_ENTER_EMAIL;

@FindBy(xpath = "//input[@id='password_step_input']")
private WebElement SET_PASSWORD;

@FindBy(xpath ="//select[@id='day']")
private WebElement DAY;

@FindBy(xpath = "//select[@id='month']")
private WebElement MONTH;

@FindBy(xpath = "//select[@id='year']")
private WebElement YEAR;

@FindBy(xpath = "//input[@name='sex'][@value='2']")
private WebElement MALE;

@FindBy(xpath ="//button[@name='websubmit']")
private WebElement SIGNUP;

//locators
//By CREATE_NEW_ACCOUNT=By.xpath("//a[text()='Create New Account']");
//By FIRST_NAME=By.xpath("//input[@name='firstname']");  //input[@name='firstname']
//By lastnametxtele=By.xpath("//input[@name='lastname']");
//By emailaddresstxtele=By.xpath("//input[@name='reg_email__']");
//By remailtxtele=By.xpath("//input[@name='reg_email_confirmation__']");
//By setpasswordtxtele=By.xpath("//input[@id='password_step_input']");
//By daydropele=By.xpath("//select[@id='day']");
//By monthdropele=By.xpath("//select[@id='month']");
//By yeardropele=By.xpath("//select[@id='year']");
//By maleradiobtnele=By.xpath("//input[@name='sex'][@value='2']");
//By signupbtnele=By.xpath("//button[@name='websubmit']");

public WebElement clickCreateAccount()
{
	return CREATE_NEW_ACCOUNT;
}
public WebElement enterFirstName()
{
	return FIRST_NAME;
}
public WebElement enterLastName()
{
	return LAST_NAME;
}
public WebElement enterEmail()
{
	return EMAIL;
}
public WebElement selectDay()
{
	return DAY;
}
public WebElement selectMonth()
{
	return MONTH;
}
public WebElement selectYear()
{
	return YEAR;
}
public WebElement clickMale()
{
	return MALE;
}
public WebElement clickSignUp()
{
	return SIGNUP;
}
public WebElement enterPassword()
{
	return SET_PASSWORD;
}
public void enterReEmail(String text)
{
	Base.waitvisibletoelelocate(driver, RE_ENTER_EMAIL);
	RE_ENTER_EMAIL.sendKeys(text);
}
}