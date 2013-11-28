package com.yana.selenium.integration.qa.testscripts.web.sanity;



import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.thoughtworks.selenium.Selenium;
import com.yana.selenium.integration.DriverFactory;
import com.yana.selenium.integration.FDriver;
import com.yana.selenium.integration.GetProperties;

public class VerifyLinksTest {
	
	Selenium browser;
	String baseurl;
	 
	 @BeforeTest
	 public void before() throws Exception{
	   
		 baseurl = GetProperties.getProperty("BASE_URL");
		 browser = (Selenium) new DriverFactory("firefoxd",baseurl,"localhost").getDriver();
		 browser.deleteAllVisibleCookies();	 
	
	 }
	 
	 @AfterTest
	 public void aftermethod() throws Exception{
    
	  new FDriver().destroy(browser,"firefoxd");
	
	 }
	 
	 
  @Test
  public void VerifyTestLinksOnIGarudaHomePage() throws Exception {
	 
	  browser.open(baseurl+"/MyEagle/login.action"); 
	  this.threadSleep(1000);
	  browser.click("css=div.MyEIndianEagleLogo");
	  browser.waitForPageToLoad("30000");
	  browser.click("link=Who We Are");
	  
	 if ( browser.isElementPresent("css=div.Right_image")){
		 Assert.assertTrue(true, "Right Image Exists");
	 }
	  browser.click("css=span.close-window");
	  browser.click("link=IE Blog");
	  browser.click("link=Rewards Program");
	  browser.click("css=span.closeHowToEarnEPWindow");
  }
  protected void threadSleep(long milliSecond){
		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e) {
			
		}
}
}
