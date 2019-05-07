package com.com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class TestNGassert {
	WebDriver driver;
  @Test
  public void Loginwithvaliddetails() {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("p@ssword1");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  Set<Cookie> Cookies =driver.manage().getCookies();
		 for (Cookie Cookie:Cookies)
		 {
						 System.out.println("The name"); 
			 System.out.println("The name of cookie is:"+Cookie.getName());
		 }
  }

  @AfterMethod
  public void afterMethod() throws IOException 
  {
	  File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src, new File("E:\\MEGHA\\CJC new\\Megha Eclips\\MVNdemo2\\src\\test\\resource\\MavnScreenShot\\.jpg"));
	  
  }

  @BeforeClass
  public void beforeClass() 
  {
	System.out.println("Delete all cookies");
	driver.manage().deleteAllCookies();
  }

  @AfterClass
  public void Connection() 
  {
	  System.out.println("DB Connections");
	  
  }

  @BeforeTest
  public void beforeTest() 
  {
	  driver.get("https://www.facebook.com/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void DeleteCookies() {
	  driver.manage().deleteAllCookies();
	  System.out.println("Delete all Cookies");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
        driver  = new ChromeDriver();
        System.out.println("Chrome Driver Open Successfully");
        
  }

}
