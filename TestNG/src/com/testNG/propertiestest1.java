package com.testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class propertiestest1 
{
	public WebDriver driver;
	
	Properties prop = new Properties();
	Properties prop1 = new Properties();
	
	@Test (priority=1)
	public void openbrowser() throws IOException
	{
		FileInputStream fis1 = new FileInputStream("E:\\MEGHA\\CJC new\\Megha Eclips\\TestNG\\src\\com\\testNG\\config.properties");
	    prop.load(fis1);
	    
	    FileInputStream fis = new FileInputStream("E:\\MEGHA\\CJC new\\Megha Eclips\\TestNG\\src\\com\\testNG\\parameter.properties");
	     prop.load(fis);
	     
	     System.out.println("Chrome exe path is:" + prop1.getProperty("chromeexepath"));
	     System.out.println("Browser is:"+ prop1.getProperty("browser"));
	     System.out.println("Url is:"+ prop1.getProperty("url"));
	     System.out.println("Username is:"+ prop1.getProperty("username"));
	     System.out.println("password is :" + prop1.getProperty("password"));
	}

}
