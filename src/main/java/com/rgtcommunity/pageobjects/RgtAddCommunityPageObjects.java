package com.rgtcommunity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RgtAddCommunityPageObjects 
{
	public WebDriver driver;

	public  RgtAddCommunityPageObjects(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Add Community')]")
	private WebElement ADDCOMMUNITY;
	public WebElement addCommunity() 
	{
		return ADDCOMMUNITY;
	}
	public  void clickAddCommunity() 
	{
		ADDCOMMUNITY.click();
	}
	@FindBy(xpath = "//h3[@class='page-title']")
	private WebElement PAGETITLE;
	public WebElement pageTitle() 
	{
		return PAGETITLE;
	}
}
