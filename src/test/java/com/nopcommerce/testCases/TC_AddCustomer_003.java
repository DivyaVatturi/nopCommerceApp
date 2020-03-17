package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddNewCustomer;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_AddCustomer_003 extends BaseClass
{

@Test
public void AddCustomer() throws InterruptedException, IOException
{
	logger.info("********** Starting TC_AddCustomer_003 **********");
	
	logger.info("********** Opening URL **********");
	driver.get(configPropObj.getProperty("baseURL"));
	LoginPage lp=new LoginPage(driver);
	
	logger.info("********** Providing LoginDetails **********");
	lp.setupEmail(configPropObj.getProperty("Username"));
	lp.setupPassword(configPropObj.getProperty("Password"));
	lp.setupClkLogin();
	Thread.sleep(3000);
	
	logger.info("**********Adding Customer  **********");
	AddNewCustomer cst=new AddNewCustomer(driver);
	cst.ClkCustomersMenu();
	cst.ClkCustomersMenuItem();
	cst.ClkAddCustomer();
	Thread.sleep(3000);
	
	
	String email=randomestring()+"@gmail.com";
	cst.setEmail(email);
	
	String pswd=randomestring()+randomeNum();
	cst.setPassword(pswd);
	
	
	cst.setFirstName("Divya");
	cst.setLastName("Vatturi");
	cst.setGender("Female");
	cst.setDOB("3/13/1992");
	//cst.setDatePick("March","1992", "13");
	cst.setCompany("SDET");
	cst.setChkBx_Tax();
	cst.setCustomerRoles("Vendors");
	//Thread.sleep(3000);
	cst.setVendor("Vendor 2");
	cst.setupActiveBox();
	cst.setCommentBox("Testing");
	//Thread.sleep(3000);
	cst.ClkSaveBtn();
	Thread.sleep(5000);
	
	
	if(cst.SuccessVerificationMethod())
	{
		logger.info("********** Verifying Success **********");
		Assert.assertTrue(true);
		System.out.println("Successfully added new customer");
		
	}
	
	else if(cst.FailureVerificationMethod())
	{
		logger.info("********** Verifying failure **********");
		captureScreenshot(driver, "AddCustomer");
		System.out.println("Error in adding new customer");
		Assert.assertTrue(true);
		
		
	}
	
	else
	{
		logger.info("********** Not Succesfully added **********");
		
		Assert.assertTrue(false);	
		
		
	}
	
	
}
}
