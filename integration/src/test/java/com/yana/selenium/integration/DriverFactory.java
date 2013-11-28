package com.yana.selenium.integration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class DriverFactory {
	String strDriver;
	String baseURL;
	String host;
	WebDriver webdriver=null;
	Selenium browser=null;
	String getDriver=null;
	
	public  DriverFactory(String strDriver,String baseURL){
		this.strDriver = strDriver;
		this.baseURL=baseURL;
		this.getDriver="seleniumb";
	}
	public  DriverFactory(String strDriver,String baseURL,String host){
		this.strDriver = strDriver;
		this.baseURL=baseURL;
		this.getDriver="seleniumd";
		this.host=host;
	}
	public  DriverFactory(String strDriver){
		this.strDriver = strDriver;
		this.getDriver="webdriver";
	
	}
	
	public  Object getDriver() throws Exception
	{
		
		
	    if(getDriver.equals("seleniumb")){
	    	
	    	browser = new FDriver().create(strDriver, baseURL);
	    	 
	    } else if (getDriver.equals("seleniumd")){
	    	browser = new FDriver().create(strDriver, baseURL,host);
	    } else if (getDriver.equals("webdriver")){
	    	webdriver = new FDriver().create(strDriver);
	    } else {
	    	new CustomException("Invalid driver instance name , please give any of the valid driver instance " +
					"name as follows.."+"\n"+"safarib,ieb,firefoxb,operab,chromeb");
			browser = null ;
	    }
	    if(browser != null){
	    	String speed   = "400";// = GetProperties.getProperty("setSpeed");
	    	browser.setSpeed(speed);
	    	browser.windowMaximize();
	    }
	    return browser;
	    }
	
	   
	}
	
	


