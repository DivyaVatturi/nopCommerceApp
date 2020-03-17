package com.nopcommerce.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass 


{
	public WebDriver driver;
	public Properties configPropObj;
	
	public Logger logger=LogManager.getLogger(this.getClass());

	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws IOException
	{
		
		configPropObj=new Properties();
		FileInputStream configfile=new FileInputStream(System.getProperty("user.dir") +"\\Configuration\\Config.Properties");
		configPropObj.load(configfile);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		/*if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		
	
		else if(br.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		*/
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


@AfterClass
public void tearDown()
{
	driver.quit();
}

public void captureScreenshot(WebDriver driver, String tname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"\\Screenshots\\" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot Captured");
}

public String randomestring()
{
	String generatedString1=RandomStringUtils.randomAlphabetic(5);
	return (generatedString1);
}

public String randomeNum()
{
	String generatedString2=RandomStringUtils.randomNumeric(2);
	return (generatedString2);
}

}
