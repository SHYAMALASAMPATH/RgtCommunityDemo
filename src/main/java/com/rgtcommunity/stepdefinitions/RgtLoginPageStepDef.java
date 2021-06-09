package com.rgtcommunity.stepdefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.rgtcommunity.basesteps.Base;
import com.rgtcommunity.basesteps.DriverFactory;
import com.rgtcommunity.commonutils.ConfigReader;
import com.rgtcommunity.commonutils.ExcelReader;
import com.rgtcommunity.commonutils.ExcelReader2;
import com.rgtcommunity.pageobjects.RgtAddCommunityPageObjects;
import com.rgtcommunity.pageobjects.RgtHomePageObjects;
import com.rgtcommunity.pageobjects.RgtLoginPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RgtLoginPageStepDef 
{
	public WebDriver driver;
	RgtLoginPageObjects rgtloginpageobjects=new RgtLoginPageObjects(DriverFactory.initilizeDriver());
	RgtHomePageObjects rgthomepageobjects=new RgtHomePageObjects(DriverFactory.initilizeDriver());
	RgtAddCommunityPageObjects rgtaddcommunitypageobjects=new RgtAddCommunityPageObjects(DriverFactory.initilizeDriver());
	List<String> rowdata;
	String useremail;
	SoftAssert sa=new SoftAssert();
	
    @Given("^user on R&D login page$")
    public void user_on_rd_login_page() throws Throwable 
    {
        DriverFactory.initilizeDriver();
        System.out.println("driver initilization");
    }
    @When("user clicks on homepage login")
    public void user_clicks_on_homepage_login() throws InterruptedException 
    {
      rgtloginpageobjects.clickHlogin();
      System.out.println("hlogin");
    }
    @When("^user clicks on login$")
    public void user_clicks_on_login() throws Throwable
    {
    
        rgtloginpageobjects.clickLogin();       
    }
    @Then("user login with {string} and {int}")
    public void user_login_with_and(String sheetname, Integer row) throws InvalidFormatException, IOException, InterruptedException {
    	
        ExcelReader2 er=new ExcelReader2(".\\src\\main\\java\\com\\rgtcommunity\\excelutility\\RgtLogin.xlsx");
          rowdata= er.getSingleRowData(sheetname, row);
    	 rgtloginpageobjects.enterEmail(rowdata.get(0));
         rgtloginpageobjects.enterPassword(rowdata.get(1));
    	System.out.println(sheetname+"---ROW  IS--"+row);
    }
//    @When("user login with <username> and <password>")
//    public void user_login_with_username_and_password() throws EncryptedDocumentException, InvalidFormatException, IOException 
//    {
//    	   ExcelReader2 er=new ExcelReader2(".\\src\\main\\java\\com\\rgtcommunity\\excelutility\\RgtLogin.xlsx");
//    	   Sheet sheet=er.getSheetFromWorkbook("rgtlogincredentials");
//    	  int lastrowno= sheet.getLastRowNum();
//    	  rowdata= er.getSingleRowData("rgtlogincredentials",1);//rgtlogincredentials
//           rgtloginpageobjects.enterEmail(rowdata.get(0));
//           rgtloginpageobjects.enterPassword(rowdata.get(1));
//           rgtloginpageobjects.clickLogin(); 
//    }

    @Then("user should verify the user email")
    public void user_should_verify_the_user_email() 
    {
//    	WebDriverWait wait=new WebDriverWait(DriverFactory.initilizeDriver(),50);
//        wait.until(ExpectedConditions.visibilityOf(rgthomepageobjects.userEmail()));
    	  String actualuseremail=  rgthomepageobjects.getUserEmail();
    	  String expecteduseremail=useremail;
    	  System.out.println(expecteduseremail);
    	  sa.assertEquals(actualuseremail, expecteduseremail);
    }
    @Then("user should sign out")
    public void user_should_sign_out() throws InterruptedException 
    {
    	// WebElement webElement = driver.findElement(By.xpath("//*[@class='nav-profile-img']")); //id("Your ID Here")
    	Actions builder = new Actions(DriverFactory.initilizeDriver());
    	builder.moveToElement(rgthomepageobjects.profileImage()).click(rgthomepageobjects.profileImage()).build().perform();
    	Actions ac=new Actions(DriverFactory.initilizeDriver());
    	ac.moveToElement(rgthomepageobjects.profileImage()).click().build().perform();
    	WebDriverWait wait=new WebDriverWait(DriverFactory.initilizeDriver(),50);
    	wait.until(ExpectedConditions.visibilityOf(rgthomepageobjects.signOut()));//
    	 //driver.findElement(By.xpath("//a[text()=' Signout ']")).click();
    	rgthomepageobjects.clickSignOut();
    }
    @When("user login with {string} and {string}")
    public void user_login_with_and(String uid, String pwd) 
    {
    	useremail=uid;
        rgtloginpageobjects.enterEmail(uid);
        rgtloginpageobjects.enterPassword(pwd);
        rgtloginpageobjects.clickLogin(); 
    }
    @Then("user should view login button")
    public void user_should_view_login_button() 
    {
    	WebDriverWait wait=new WebDriverWait(DriverFactory.initilizeDriver(),50);
    	wait.until(ExpectedConditions.visibilityOf(rgtloginpageobjects.homeLogin()));
    	String loginbuttonexceptedtext ="LOGIN" ;
    	String loginbuttonactualtext = rgtloginpageobjects.homeLogin().getText();
    	System.out.println(loginbuttonactualtext);
    	sa.assertEquals(loginbuttonactualtext, loginbuttonexceptedtext);
    	sa.assertAll();
    }
  //h3[@class='page-title']/text()
    @Then("verify hometitle {string}")
    public void verify_hometitle(String expectedhome) 
    {
    	String actualhome= rgthomepageobjects.getHomeTitle();
    	sa.assertEquals(actualhome, expectedhome);
    	sa.assertAll();
    
    }

    @Then("verify Dashboardtitle {string}")
    public void verify_dashboardtitle(String expecteddashboard) 
    {
     String actualdashboard= rgthomepageobjects.pageTitle().getText();
     sa.assertEquals(actualdashboard,expecteddashboard);
 	 sa.assertAll();
    }

    @When("user clicks communites")
    public void user_clicks_communites() 
    {
    rgthomepageobjects.clickCommunities();
    
    }
    @Then("verify Communitiestitle {string}")
    public void verify_communitiestitle(String expecctedcommunitiestitle) throws InterruptedException
        {
    	Thread.sleep(2000);
    String actualcommunitiestitle=rgtaddcommunitypageobjects.pageTitle().getText();
    sa.assertEquals(actualcommunitiestitle,expecctedcommunitiestitle);
   	sa.assertAll();
    }

    @Then("user verify AddCommunity Button")
    public void user_verify_add_community_button() 
    {
   boolean  actualstatus=rgtaddcommunitypageobjects.addCommunity().isEnabled();
   boolean expectedstatus=true;
   sa.assertEquals(actualstatus,expectedstatus);
   sa.assertAll();
   
    }
    @Then("user verify Settingstitle {string}")
    public void user_verify_settingstitle(String expectedsettingstitle) 
    {
    	
    	  String actualsettingstitle=rgthomepageobjects.setttings().getText();
    	    sa.assertEquals(actualsettingstitle,expectedsettingstitle);
    	   	sa.assertAll();
    }
    @Then("user verify  Servicestitle {string}")
    public void user_verify_servicestitle(String expectedservicestitle) 
    {
    	Actions ac=new Actions(DriverFactory.initilizeDriver());
    	ac.moveToElement(rgthomepageobjects.setttings()).build().perform();
    	  String actualservicestitle=rgthomepageobjects.services().getText();
  	    sa.assertEquals(expectedservicestitle, actualservicestitle);
  	   	sa.assertAll();
    }
    @Then("user verify Transactionstitle {string}")
    public void user_verify_transactionstitle(String expectedtransactiontitle) 
    {
    	Actions ac=new Actions(DriverFactory.initilizeDriver());
    	ac.moveToElement(rgthomepageobjects.setttings()).build().perform();
    	  String actualtransactiontitle=rgthomepageobjects.transactions().getText();
  	    sa.assertEquals(expectedtransactiontitle, actualtransactiontitle);
  	   	sa.assertAll();
    }

    @Then("user verify Complaintstitle {string}")
    public void user_verify_complaintstitle(String expectedcomplaintstitle) 
    {
    	Actions ac=new Actions(DriverFactory.initilizeDriver());
    	ac.moveToElement(rgthomepageobjects.setttings()).build().perform();
    	  String actualcomplaintstitle=rgthomepageobjects.complaints().getText();
  	    sa.assertEquals(expectedcomplaintstitle, actualcomplaintstitle);
  	   	sa.assertAll();
    }

   
}