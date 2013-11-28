package com.yana.selenium.integration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class GetProperties {
	private static Properties bp;
	private static Properties bc;
	

  public static String getProperty(String property) throws FileNotFoundException, IOException {
	  
	   bp = new Properties();
	   bp.load(new FileInputStream("../integration/src/main/resources/IGaruda.properties"));
	   String value=bp.getProperty(property);
	   return  value;
  }
 
}
