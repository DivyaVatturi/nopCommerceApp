package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddNewCustomer;
import com.nopcommerce.pageObjects.Email_NameVerification;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_Email_NameVerification_004 extends BaseClass
{

	@Test(priority=1)
	
	public void EmailVerification() throws InterruptedException	
	{
		logger.info("**********Starting TC_Email_NameVerification_004 **********");
		
		logger.info("**********Providing URL and LoginDetails **********");
		
	driver.get(configPropObj.getProperty("baseURL"));
	LoginPage lp=new LoginPage(driver);
	lp.setupEmail(configPropObj.getProperty("Username"));
	lp.setupPassword(configPropObj.getProperty("Password"));
	lp.setupClkLogin();
	Thread.sleep(3000);
	
	logger.info("********** Entering into Customers menu **********");
	AddNewCustomer cust=new AddNewCustomer(driver);
	cust.ClkCustomersMenu();
	cust.ClkCustomersMenuItem();
	
	logger.info("********** Providing Email for Search **********");
	Email_NameVerification verify=new Email_NameVerification(driver);
	verify.SetEmail("brenda_lindgren@nopCommerce.com");
	verify.clkSearchbtn();
	verify.NumofRows();
	verify.NumofColumns();
	
	Thread.sleep(3000);
	
	logger.info("********** Verifying Email if already exists **********");
	boolean Status=verify.ByEmailVerification("brenda_lindgren@nopCommerce.com");
	Assert.assertEquals(true, Status);
	lp.setupClkLogout();
	logger.info("********** Finished Email Verification **********");
}
	
	@Test(priority=2)
	
	public void NameVerification() throws InterruptedException, IOException	
	{
		logger.info("********** Entering URL and LoginDetails **********");	
	driver.get(configPropObj.getProperty("baseURL"));
	LoginPage lp=new LoginPage(driver);
	lp.setupEmail(configPropObj.getProperty("Username"));
	lp.setupPassword(configPropObj.getProperty("Password"));
	lp.setupClkLogin();
	Thread.sleep(3000);
	
	logger.info("********** Providing Email for Search **********");
	AddNewCustomer cust=new AddNewCustomer(driver);
	cust.ClkCustomersMenu();
	cust.ClkCustomersMenuItem();
	
	logger.info("********** Providing Name for Search **********");
	Email_NameVerification verify=new Email_NameVerification(driver);
	verify.SetFirstName("Brenda");
	verify.SetLastName("Lindgren");
	verify.clkSearchbtn();
	verify.NumofRows();
	verify.NumofColumns();
	Thread.sleep(3000);
	
	logger.info("********** Verifying Name if already exists **********");
	
		boolean Status=verify.ByNameVerification("Brenda Lindgren");
		Assert.assertEquals(true, Status);
		captureScreenshot(driver,"NameVerification");
		lp.setupClkLogout();
	
	logger.info("********** Finished Name Verification **********");
	
	logger.info("********** Finished TC_Email_NameVerification_004 **********");
	}
	
	
	
	
	
}
