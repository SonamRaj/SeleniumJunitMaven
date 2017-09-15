package com.seleniumJuint.proj.JunitMaven;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.jmx.snmp.Timestamp;

import java.io.File;

import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class LaunchwebsitesTest {
//
	//new comment
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void testW3schools() throws Exception {
		this.driver.get("http://www.w3schools.com");
		assertEquals("W3Schools Online Web Tutorials", this.driver.getTitle());
		getscreenshot();
	}
	
	@Test
	public void testGoogle() throws Exception {
		this.driver.get("http://www.google.com");
		assertEquals("Google", this.driver.getTitle());
		getscreenshot();
	}
	
	@Test
    public void openBrowser() throws Exception {  	   
  	  driver.get("http://www.google.com");
  	  try{
              //the below statement will throw an exception as the element is not found, Catch block will get executed and takes the screenshot.
  		  driver.findElement(By.id("testing")).sendKeys("test");
               
                 //if we remove the below comment, it will not return exception and screen shot method will not get executed.
  		  //driver.findElement(By.id("gbqfq")).sendKeys("test");
  	  }
  	  catch (Exception e){
  		  System.out.println("I'm in exception");
//calls the method to take the screenshot.
  		  getscreenshot();
   	  }
    }
    
    public void getscreenshot() throws Exception 
    {		Date d = new Date();
    		Timestamp t = new Timestamp(d.getTime());
    		String timeStamp = t.toString();
    		timeStamp = timeStamp.replace(' ', '_');
    		timeStamp = timeStamp.replace(':', '_');
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("src/test/resources/"+"screenshot"+ timeStamp +".png"));
    }

	@After
	public void tearDown() throws Exception {
		this.driver.quit();
	}

}
