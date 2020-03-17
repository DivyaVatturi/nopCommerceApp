package com.nopcommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Email_NameVerification 
{
	public WebDriver ldriver;

	public  Email_NameVerification(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
@FindBy(id="SearchEmail")   WebElement txtEmail;
@FindBy(id="SearchFirstName") WebElement txtFirstName;
@FindBy(id="SearchLastName") WebElement txtLastName;
@FindBy(id="search-customers") WebElement txtbtnSearch;
@FindBy(xpath="//table[@id='customers-grid']") WebElement table;
@FindBy(xpath="//table[@id='customers-grid']//tr") List<WebElement> tablerows;
@FindBy(xpath="//table[@id='customers-grid']//tr/td")List <WebElement> tableColms;




public void SetEmail(String email)
{
	txtEmail.sendKeys(email);
}

public void SetFirstName(String Fname)
{
	txtFirstName.sendKeys(Fname);
}

public void SetLastName(String Lname)
{
	txtLastName.sendKeys(Lname);
}

public void clkSearchbtn()
{
	txtbtnSearch.click();
}

public void NumofRows()
{
	    int rows=tablerows.size();
		System.out.println("Number of Rows" +rows);
}

public void NumofColumns()
{
	   int cols=tableColms.size();
		System.out.println("Number of cols" +cols);
}


public boolean ByEmailVerification(String Email)
{
	boolean flag=false;

	for(int i=1; i<=tablerows.size(); i++)
	{
		String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tr["+i+"]/td[2]")).getText();
		System.out.println(emailid);
		if(emailid.equals(Email))
		{
			flag=true;
			break;
		}
	}
	return flag;
}

public boolean ByNameVerification(String Name)
{
	boolean flag=false;

	for(int i=1; i<=tablerows.size(); i++)
	{
		String TableName=table.findElement(By.xpath("//table[@id='customers-grid']//tr["+i+"]/td[3]")).getText();
		System.out.println(TableName);
		if(TableName.equals(Name))
		{
			flag=true;
			break;
		}
	}
	return flag;
}






	
	
}
