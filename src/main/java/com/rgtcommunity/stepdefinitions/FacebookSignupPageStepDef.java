package com.rgtcommunity.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.rgtcommunity.basesteps.Base;
import com.rgtcommunity.basesteps.DriverFactory;
import com.rgtcommunity.commonutils.ConfigReader;
import com.rgtcommunity.commonutils.ExcelReader;
import com.rgtcommunity.pageobjects.FacebookPageObjects;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FacebookSignupPageStepDef extends Base
{
	ConfigReader configreader;
	Properties prop;
	private FacebookPageObjects facebookpageobjects=new FacebookPageObjects(DriverFactory.initilizeDriver());;
	
	   @Given("^user on facebook landing page$")
	    public void user_on_facebook_landing_page() throws Throwable {
			 //initilization();
			configreader=new ConfigReader();
	    	prop=configreader.init_prop();
	        DriverFactory.initilizeDriver().get(prop.getProperty("url"));
	    }


	    @When("^user clicked  on create new account$")
	    public void user_clicked_on_create_new_account() throws InterruptedException 
	    {
	       facebookpageobjects.clickCreateAccount().click();
	       Thread.sleep(3000);
	    }

//	    @When("^user created account with following details and clicks signup$")
//	    public void user_created_account_with_following_details_and_clicks_signup(DataTable dt) throws InterruptedException 
//	    {
////	      List<String> data= dt.asList();
////	      System.out.println(data.get(0));
////	      //driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("sampath");
////	      //fpo=new FacebookPageObjects(driver);
////	      facebookpageobjects.enterFirstName().sendKeys(data.get(0));
////	      facebookpageobjects.enterLastName().sendKeys(data.get(1));
////	     facebookpageobjects.enterEmail().sendKeys(data.get(2));
////	     Thread.sleep(3000);
////	     facebookpageobjects.enterReEmail(data.get(2));
////	     facebookpageobjects.setpasswordtxtEle().sendKeys(data.get(3));
////	     Select s= new Select(facebookpageobjects.daydropEle());
////	     s.selectByValue(data.get(4));
////	     // fpo.daydropEle().sendKeys(data.get(4));
////	      facebookpageobjects.monthdropEle().sendKeys(data.get(5));
////	      facebookpageobjects.yeardropEle().sendKeys(data.get(6));
////	      facebookpageobjects.maleradiobtnEle().click();
////	      facebookpageobjects.signupbtnEle().click();
//	      
//	    }
	    @When("user created account with following details {string} and {int} and clicks signup")
	    public void user_created_account_with_following_details_and_and_clicks_signup(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException
	    {
			ExcelReader reader = new ExcelReader();
			List<Map<String,String>> testData = 
					reader.getData("C:\\RGT_WorkSpace\\rgtcommunity\\src\\main\\java\\com\\rgtcommunity\\excelutility\\Facebooksignupdata.xlsx", sheetName);
		     Thread.sleep(2000);
			facebookpageobjects.enterFirstName().sendKeys(testData.get(0).get("FirstName"));
		      facebookpageobjects.enterLastName().sendKeys(testData.get(0).get("LastName"));
		     facebookpageobjects.enterEmail().sendKeys(testData.get(0).get("Email"));
		     //Thread.sleep(4000);
		     facebookpageobjects.enterReEmail(testData.get(0).get("ConfirmEmail"));
		     facebookpageobjects.enterPassword().sendKeys("sampath@123");
		     Select s= new Select(facebookpageobjects.selectDay());
		     s.selectByValue(testData.get(0).get("Date"));
		     // fpo.daydropEle().sendKeys(data.get(4));
		      facebookpageobjects.selectMonth().sendKeys(testData.get(0).get("Month"));
		      facebookpageobjects.selectYear().sendKeys(testData.get(0).get("Year"));
		      facebookpageobjects.clickMale().click();
		      facebookpageobjects.clickSignUp().click();
	    }

	    @Then("^user should view signup popup$")
	    public void user_should_view_signup_popup() 
	    {
	             System.out.println("user viewed signup successfully");
	    }

	    @Then("^user should view user created sucessfully$")
	    public void user_should_view_user_created_sucessfully() throws InterruptedException
	    {
	    	Thread.sleep(4000);
	     System.out.println("user viewed user created successfully");
	    }

}
