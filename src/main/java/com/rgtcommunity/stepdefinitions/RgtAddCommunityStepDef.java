package com.rgtcommunity.stepdefinitions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.rgtcommunity.basesteps.Base;
import com.rgtcommunity.basesteps.DriverFactory;
import com.rgtcommunity.pageobjects.RgtAddCommunityPageObjects;
import com.rgtcommunity.pageobjects.RgtHomePageObjects;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RgtAddCommunityStepDef 
{
	public WebDriver driver=DriverFactory.initilizeDriver();
//	RgtHomePageObjects rgthomepageobjects=new RgtHomePageObjects(driver);
//	RgtAddCommunityPageObjects rgtaddcommunitypageobjects=new RgtAddCommunityPageObjects(driver);
	
	
	@When("user clicks on communities")
	public void user_clicks_on_communities() throws InterruptedException 
	{
		//rgthomepageobjects.communities().click();
	 driver.findElement(By.xpath("//span[contains(text(),'Communities')]")).click();
	 Thread.sleep(3000);
	}

	@Then("user should view addcommunity button")
	public void user_should_view_addcommunity_button()
	{
	 
	}

	@When("user clicks addcommunity")
	public void user_clicks_addcommunity()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Add Community')]")).click();
//		rgtaddcommunitypageobjects.clickAddCommunity();
	}

	@Then("user should view addcommunity popup")
	public void user_should_view_addcommunity_popup() {
	 
	}

	@When("user add community with following details and click save")
	public void user_add_community_with_following_details_and_click_save(DataTable dataTable) throws InterruptedException
	{
	List<String> communitydata= dataTable.asList();
	driver.findElement(By.xpath("//input[@id='communityName']")).sendKeys(communitydata.get(0));
	 WebElement dropselectcategory= driver.findElement(By.xpath("//form[@name='communityForm']//select[@id='category']"));
	 Select s=new Select(dropselectcategory);
	 s.selectByValue("General Community");
	 Thread.sleep(2000);
	WebElement dropstatus= driver.findElement(By.xpath("//form[@name='communityForm']//select[@id='status']"));
	dropstatus.click();
	 Select s1=new Select(dropstatus);
	 s1.selectByVisibleText("Active");
	WebElement contactname=driver.findElement(By.xpath("//form[@name='communityForm']//input[@id='inputContactName']"));
	contactname.sendKeys("SAMPATH SHYAMALA");
	Thread.sleep(2000);
	WebElement dropdesignation=driver.findElement(By.xpath("//form[@name='communityForm']//select[@id='communityDesignation']"));
	dropdesignation.sendKeys("Admin");
	 Select s2=new Select(dropdesignation);
	 s2.selectByVisibleText("Admin");
	WebElement primarycontact= driver.findElement(By.xpath("//form[@name='communityForm']//input[@id='primaryContactNumber']"));
	primarycontact.sendKeys("8106353557");
	
	WebElement secondarycontact= driver.findElement(By.xpath("//form[@name='communityForm']//input[@id='secondaryContactNumber']"));
	secondarycontact.sendKeys("8715254675");
	
	WebElement primaryemail= driver.findElement(By.xpath("//form[@name='communityForm']//input[@id='primaryEmail']"));
	primaryemail.sendKeys("sai.484484@gmail.com");
	
	WebElement secondaryemail=driver.findElement(By.xpath("//form[@name='communityForm']//input[@id='secondaryEmail']"));
	secondaryemail.sendKeys("sai48448.4@gmail.com");
	
	WebElement address1= driver.findElement(By.xpath("//form[@name='communityForm']//input[@id='input-address']"));
	address1.sendKeys("kukatpally");
	
   WebElement address2=driver.findElement(By.xpath("//form[@name='communityForm']//input[@id='input-address02']"));
   address2.sendKeys("hyderabad");
    
 WebElement dropcountry=  driver.findElement(By.xpath("//form[@name='communityForm']//select[@id='country']"));
 dropcountry.sendKeys("India");
 Select s3=new Select(dropcountry);
 s3.selectByVisibleText("India");
 Thread.sleep(3000);
 WebElement dropstate=driver.findElement(By.xpath("//form[@name='communityForm']//select[@id='state']"));
 Select s4=new Select(dropstate);
 s4.selectByVisibleText("Andhra Pradesh");
 
 WebElement city= driver.findElement(By.xpath("//form[@name='communityForm']//input[@id='input-city']"));
 city.sendKeys("Hyderabad");
 
 WebElement landmark=driver.findElement(By.xpath("//form[@name='communityForm']//input[@id='landmark']"));
 landmark.sendKeys("near by temple");
 
 WebElement postalcode=driver.findElement(By.xpath("//*[@id=\"pinCode\"]"));
 postalcode.sendKeys("500072");
 
 WebElement overviewcommunity=driver.findElement(By.xpath("//form[@name='communityForm']//textarea[@id='overview']"));
 overviewcommunity.sendKeys("good community for all");
 
 WebElement Save= driver.findElement(By.xpath("//*[@id=\"addNewCommunity\"]/div/div/div[3]/button[2]"));
 Save.click();
 
	 
	}

	@Then("verify community name in communities view")
	public void verify_community_name_in_communities_view() {
	   
	}


}
