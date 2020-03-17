package com.nopcommerce.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
WebDriver ldriver;

public LoginPage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
	ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@FindBy(id="Email")    WebElement txtUserName;
@FindBy(id="Password") WebElement txtPassword;
@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input") WebElement btnLogin;
@FindBy(linkText="Logout") WebElement ClkLogout;


public void setupEmail(String email)
{
	txtUserName.clear();
	txtUserName.sendKeys(email);
}


public void setupPassword(String pswd)
{
	txtPassword.clear();
	txtPassword.sendKeys(pswd);
}

public void setupClkLogin()
{
	//btnLogin.clear();
	btnLogin.click();
}

public void setupClkLogout()
{
	//ClkLogout.clear();
	ClkLogout.click();
}



}
