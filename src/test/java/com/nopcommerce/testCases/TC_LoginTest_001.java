package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;


public class TC_LoginTest_001 extends BaseClass
{
	
	
@Test
public void LoginTest() throws InterruptedException, IOException
{
	logger.info("***********Starting TC_LoginTest_001 ***********");
	driver.get(configPropObj.getProperty("baseURL"));
	//driver.get("http://admin-demo.nopcommerce.com");
	LoginPage lp=new LoginPage(driver);
	
	logger.info("***********Passing UserData ***********");
	
	lp.setupEmail(configPropObj.getProperty("Username"));
	lp.setupPassword(configPropObj.getProperty("Password"));
	//lp.setupEmail("admin@yourstore.com");
	//lp.setupPassword("admin");

	lp.setupClkLogin();
	Thread.sleep(5000);
	
	
	logger.info("***********Login Validation ***********");
	String exp_title="Dashboard / nopCommerce administration";
	String act_title=driver.getTitle();
	
	if(exp_title.equals(act_title))
	{
		logger.info("***********TC_LoginTest_001 Passed ***********");
		Assert.assertTrue(true);
	}
	else
	{
		captureScreenshot(driver, "LoginTest");
		logger.info("***********TC_LoginTest_001 Failed ***********");
		Assert.assertTrue(false);

	}
	
	


}

}
