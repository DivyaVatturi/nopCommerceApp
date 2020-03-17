package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pwd, String exp) throws IOException, InterruptedException
	{
		logger.info("********** Opening URL **********");
		driver.get(configPropObj.getProperty("baseURL"));
		Thread.sleep(5000);
		LoginPage lp=new LoginPage(driver);
		
		logger.info("********** Providing login Data **********");
		lp.setupEmail(user);
		lp.setupPassword(pwd);
		lp.setupClkLogin();
		Thread.sleep(5000);
		
		logger.info("********** Validating login Data **********");
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))
		{
			if(exp.equals("Pass"))
			{
			logger.info("***********TC_LoginTest_002 Passed ***********");
			lp.setupClkLogout();
			Assert.assertTrue(true);
			}
			else if (exp.equals("Fail"))
			{
				
				logger.warn("***********TC_LoginDDT_002 Failed ***********");
				captureScreenshot(driver, "LoginTest");
				lp.setupClkLogout();
				Assert.assertTrue(false);

			}
		}
		else if(!exp_title.equals(act_title))
		{
			if(exp.equals("Pass"))
			{
				
				logger.info("***********TC_LoginDDT_002 Failed ***********");
				captureScreenshot(driver, "LoginTest");
				Assert.assertTrue(false);
			}
			else if(exp.equals("Fail"))
			{
				
				logger.warn("***********TC_LoginDDT_002 Passed ***********");
				
				Assert.assertTrue(true);

			}
		}
		
		logger.info("***********Finished Login ***********");
			
	
		
	}
		
		@DataProvider(name="LoginData")
		public String[][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"/TestData/LoginData.xlsx";
			int rownum= XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
			
			String logindata[][]=new String [rownum][colcount];
			
			for(int r=1; r<=rownum ; r++)
			{
				for(int c=0; c<colcount; c++)
				{
					logindata[r-1][c]=XLUtils.getCellData(path,"Sheet1", r, c);//will store value in 0 row, 1 column index
					
				}
				
			}
			return logindata;
			
					
		}
		
		
		

}
