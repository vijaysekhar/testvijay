package com.yana.selenium.integration.qa.testscripts.web.sanity;


import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.thoughtworks.selenium.Selenium;

public class FirstTest {
	
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	//Seconds to wait for timeout
      public static final int TIMEOUT=5;
      WebDriverWait wait; 
      Selenium selenium;
      
      @BeforeMethod
      public void beforeMethod() {
    	driver = new FirefoxDriver();
    	baseUrl = "http://ie.yanasoftware.com/";
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	wait  = new WebDriverWait(driver, TIMEOUT);
    	
   	 
 	   driver.get(baseUrl + "Flights/index.action");
      }

      @AfterMethod
      public void afterMethod() {
    	    driver.quit();
    	    String verificationErrorString = verificationErrors.toString();
    	    if (!"".equals(verificationErrorString)) {
    	    	System.out.println(verificationErrorString);
    	      Assert.fail(verificationErrorString);
    	    }
      }
  @Test
  public void firstTestCase() {
	
	driver.manage().window().maximize();
	this.waitForPageLoaded(driver);
	
//	((JavascriptExecutor)driver).
//    executeScript("window.onload=null;");
	
	driver.findElement(By.linkText("Who We Are")).click();
	this.waitForPageLoaded(driver);
	
	

	//driver.switchTo().activeElement().sendKeys(Keys.ENTER); 
    driver.switchTo().frame(driver.findElement(By.tagName("iframe")).getText());  //.getWindowHandle();
	//driver.switchTo().window(handle);
	
   
 
	 System.out.println(driver.findElement(By.className("close-window")).getText());
	 System.out.println(driver.findElement(By.className("AboutusSkyTxt")).getText());
	System.out.println(driver.findElement(By.className("AboutusNormalTxt")).getText());
	System.out.println(driver.findElement(By.className("AboutusNormalTxt_para")).getText());
	driver.findElement(By.className("link_blue")).click();
	this.threadSleep(5000);
	System.out.println("closed ");
	driver.switchTo().defaultContent();
	 	 
  }
  
  public  WebElement waitForVisibility(By by) {			
		WebElement divElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));					
		return divElement;
	}
	
	public void waitForPagetoLaod(){
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	}
	protected void threadSleep(long milliSecond){
		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e) {
			
		}
	}
	
	public boolean isTextPresent(String text) {
		boolean x = false; 
	     int size  = driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size();
	     if ( size == 0 ) {
	    	 
	    	 x = true ;
	     }
		return x;
	}
	public void waitForPageLoaded(WebDriver driver) {

	     ExpectedCondition<Boolean> expectation = new
	ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	          return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	      };

	     Wait<WebDriver> wait = new WebDriverWait(driver,30);
	      try {
	              wait.until(expectation);
	      } catch(Throwable error) {
	              Assert.fail("Timeout waiting for Page Load Request to complete.");
	      }
	 } 
}
