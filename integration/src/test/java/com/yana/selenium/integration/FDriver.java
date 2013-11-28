package com.yana.selenium.integration;

import java.io.File;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

import org.openqa.selenium.chrome.ChromeDriver;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class FDriver {
	  WebDriver driver;
	 
	 static SeleniumServer server = null;
	 Selenium browser=null;
	 
	
	
	public WebDriver create(String strDriver)
	{
	
		if (strDriver.toUpperCase().contains("FIREFOX")){
			driver = new FirefoxDriver(new FirefoxProfile(new File("C:/Users/vijaya.sekhar/AppData/Local/Mozilla/Firefox/Profiles/g7ah3c04.default")));
		}/*else if(strDriver.toUpperCase().contains("OPERA")){
			driver = new com.opera.core.systems.OperaDriver();
		}*/else if (strDriver.toUpperCase().contains("CHROME")){
			driver = new org.openqa.selenium.chrome.ChromeDriver();
		}else if (strDriver.toUpperCase().contains("IE")){
			driver = new org.openqa.selenium.ie.InternetExplorerDriver();
		}

		
		return driver;
	}
	
	public Selenium create(String strDriver,String baseURL) throws Exception
	{
		
		if (strDriver.toUpperCase().contains("FIREFOXB")){
		// driver = new FirefoxDriver();
		 driver = new FirefoxDriver(new FirefoxProfile(new File("../IGaruda/FFSSL")));
			Selenium browser  = new WebDriverBackedSelenium(driver, baseURL);
			return browser;
		/*}else if(strDriver.toUpperCase().contains("OPERAB")){
		 driver = new com.opera.core.systems.OperaDriver();
			Selenium browser  = new WebDriverBackedSelenium(driver, baseURL);
			return browser;
		*/}else if (strDriver.toUpperCase().contains("CHROMEB")){
		 driver = new org.openqa.selenium.chrome.ChromeDriver();
			Selenium browser  = new WebDriverBackedSelenium(driver, baseURL);
			return browser;
		}else if (strDriver.toUpperCase().contains("IEB")){
		 driver = new org.openqa.selenium.ie.InternetExplorerDriver();
			Selenium browser  = new WebDriverBackedSelenium(driver, baseURL);
			return browser;
		} else {
			new CustomException("Invalid driver instance name , please give any of the valid driver instance " +
					"name as follows.."+"\n"+"safarib,ieb,firefoxb,operab,chromeb");
			return null;
		}
	
	}
	
	public Selenium create(String strDriver,String baseURL,String host) throws Exception
	{
		
		if (strDriver.toUpperCase().contains("FIREFOXD")){
		// driver = new FirefoxDriver();
			
			 server=new SeleniumServer(false);
			 RemoteControlConfiguration rcc =  server.getConfiguration();
			// rcc.setFirefoxProfileTemplate(new File("../IGaruda/FFSSL"));
			 server.start();
		
			    browser=new DefaultSelenium(host, 4444, "*firefox C:\\Program Files\\Mozilla Firefox\\firefox.exe", baseURL);
				browser.start();
				return browser;
		
		}else if (strDriver.toUpperCase().contains("SAFARID")){
			    
			
			    server=new SeleniumServer(false);
			    server.start();
			    browser=new DefaultSelenium(host, 4444, "*safari", baseURL);
				browser.start();
				return browser;
		
		} else {
			new CustomException("Invalid driver instance name , please give any of the valid driver instance " +
					"name as follows.."+"\n"+"safarid,ied,firefoxd,operad,chromed");
			return null;
		}
	
	}
	
	
	public void destroy(WebDriver webdriver){
		
		webdriver.quit();
	}
	
	public void destroy(Selenium browser,String strDriver)
	{
		
		System.out.println("In  destroy driver method .....");
		if(strDriver.toUpperCase().contains("FIREFOXB")|| strDriver.toUpperCase().contains("OPERAB") || strDriver.toUpperCase().contains("CHROMEB")|| strDriver.toUpperCase().contains("IEB") ){
		WebDriver driverInstance;
		driverInstance = ((WebDriverBackedSelenium) browser).getWrappedDriver();
		browser.stop();
		}else if(strDriver.toUpperCase().contains("FIREFOXD")||  strDriver.toUpperCase().contains("CHROMED")|| strDriver.toUpperCase().contains("OPERAD")|| strDriver.toUpperCase().contains("IED") ){
		browser.stop();
		server.stop();			
		}
		}
	
	
	}
	
	
	

