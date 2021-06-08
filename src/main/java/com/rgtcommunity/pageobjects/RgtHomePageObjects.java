package com.rgtcommunity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.rgtcommunity.basesteps.Base;

public class RgtHomePageObjects 
{
	public WebDriver driver;

	public  RgtHomePageObjects(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement HOME;
	@FindBy(xpath = "//div[@class='nav-profile-text']/p")
	private WebElement USEREMAIL;
	@FindBy(xpath = "//a[text()=' Signout ']")
	private WebElement SIGNOUT;
	@FindBy(xpath = "//a[@id='profileDropdown']")
	private WebElement PROFILEDROPDOWN;
	@FindBy(xpath = "//*[@class='nav-profile-img']")
	private WebElement PROFILEIMAGE;
	@FindBy(xpath = "//span[contains(text(),'Communities')]")
	private WebElement COMMUNITIES;
	@FindBy(xpath = " //h3[@class='page-title']")
	private WebElement PAGETITLE;
	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	private WebElement SETTINGS;
	@FindBy(xpath = "//a[text()='Services']")
	private WebElement SERVICES;
	@FindBy(xpath = "//a[text()='Transactions']")
	private WebElement TRANSACTIONS;
	@FindBy(xpath = "//a[text()='Complaints']")
	private WebElement COMPLAINTS;
	@FindBy(xpath = "//a[text()='All services']")
	private WebElement ALLSERVICES;
	@FindBy(xpath = "//a[text()='Add service to community']")
	private WebElement ADDSERVICETOCOMMUNITY;
	
	
	public WebElement allServices()
	{
		return ALLSERVICES;
	}	
	public WebElement addServiceToCommunity()
	{
		return ADDSERVICETOCOMMUNITY;
	}
	public WebElement services()
	{
		return SERVICES;
	}
	public WebElement transactions()
	{
		return TRANSACTIONS;
	}
	public WebElement complaints()
	{
		return COMPLAINTS;
	}
	
	
	
	public WebElement setttings()
	{
		return SETTINGS;
	}
	public WebElement pageTitle() 
	{
		return PAGETITLE;
	}
	public WebElement communities() 
	{
		return COMMUNITIES;
	}
	public void clickCommunities()
	{
		COMMUNITIES.click();
	}
	public String getHomeTitle() 
	{
		return HOME.getText();
	}
	public void clickHome() 
	{
		HOME.click();
	}
	public WebElement Home() 
	{
		return HOME;
	}
	public WebElement userEmail()
	{
		Base.waitvisibletoelelocate(driver, USEREMAIL);
		return USEREMAIL;
	}
	public void clickUserEmail() 
	{
		USEREMAIL.click();
	}
	public String getUserEmail()
	{
		Base.waitvisibletoelelocate(driver, USEREMAIL);
		return USEREMAIL.getText();
	}
	public void clickSignOut()
	{
		Base.waitvisibletoelelocate(driver, SIGNOUT);
		SIGNOUT.click();
	}
	public void clickProfileDropDown() 
	{
		PROFILEDROPDOWN.click();
	}
	public WebElement profileImage() 
	{
		return PROFILEIMAGE;
	}
	public WebElement signOut() {
		// TODO Auto-generated method stub
		Base.waitvisibletoelelocate(driver, SIGNOUT);
		return SIGNOUT;
	}

}
