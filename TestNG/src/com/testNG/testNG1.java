package com.testNG;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNG1
{
	WebDriver driver ;
  @Test
  public void loginwithvaiddetails() 
  {
	  System.out.println("login with valid details under test");
	  driver.findElement(By.xpath( "//input[@name='userName']")).sendKeys("Meghna");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("meghnabisen");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("In get all cookies method under before method");
	  Set<Cookie> cookies = driver.manage().getCookies();
	  for (Cookie cookie:cookies)
	  {
		  System.out.println("The name of cooke is:"+cookie.getName());
	  }
	  
  }

  @AfterMethod
  public void capturescreenshot() throws IOException 
  {
	  System.out.println("ScreenShot method under afterMethod ");
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile (src,new File("C:\\Users\\ab\\Desktop\\Screenshot\\Megha.jpg"));
	  System.out.println("Capture Screen Shot");
	  
  }

  @BeforeClass
  public void maximizebrowser() 
  {
	  driver.manage().window().maximize();
	  System.out.println("maximize Sucessfully");
	  
  }

  @AfterClass
  public void deletcookie() 
  {
	  System.out.println("delet all cookie");
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void Enterapplicationurl() 
  {
	  System.out.println("Url is entered");
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  
  }

  @AfterTest
  public void afterTest()
  {
	  System.out.println("Connections are close");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
        driver = new ChromeDriver();
       System.out.println("Chrome Browser open Successfully");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("In CloseBrowser method under aftersuite");
	  driver.close();
	  System.out.println("The Chrome Browser close Sucessfully");
  }

}
