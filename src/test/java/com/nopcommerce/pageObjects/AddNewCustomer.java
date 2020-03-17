package com.nopcommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomer
{
	WebDriver ldriver;
	WebElement listitem;
	
public  AddNewCustomer(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

By lnkCustomers_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
By lnkCustmrs_MenuItm=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
By btnaddnew=By.xpath("//a[@class='btn bg-blue']");
By txtEmail=By.id("Email");
By txtPasswd=By.id("Password");
By txtFirstName=By.id("FirstName");
By txtLastName=By.id("LastName");
By radGen_Male=By.id("Gender_Male");
By radGen_Female=By.id("Gender_Female");
By txtDOB=By.id("DateOfBirth");
By btnDatePickr=By.xpath("//span[@class='k-select']");
By PickMonth_Yr=By.xpath("//a[@class='k-link k-nav-fast']");
By Pick_date=By.xpath("//table[@class='k-content']//tbody/tr/td");
By btnNextarw=By.xpath("//span[@class='k-icon k-i-arrow-e']");
By btnarwbfr=By.xpath("//span[@class='k-icon k-i-arrow-w']");
By txtCompany=By.id("Company");
By chkbx_Tax=By.id("IsTaxExempt");
By chkbx_Newsltr1=By.xpath("//input[@value='1']");
By chkbx_Newsltr2=By.xpath("//input[@value='2']");
By txt_Custmrrole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
By listitemregidtrd=By.xpath("//li[@class='k-button']//span[contains(text(),'Registered')]");
By listitem_Administrators=By.xpath("//span[contains(text(),'Administrators')]");
By listitemForumModeratrs=By.xpath("//span[contains(text(),'Forum Moderators')]");
By listitemGuests=By.xpath("//span[contains(text(),'Guests')]");
By listitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
By btndelete=By.xpath("//li[5]//span[2]");
By selVendor=By.xpath("//select[@id='VendorId']");
By selNotVendr=By.xpath("//option[contains(text(),'Not a vendor')]");
By selVendor1=By.xpath("//option[contains(text(),'Vendor 1')]");
By selVendor2=By.xpath("//option[contains(text(),'Vendor 2')]");
By chkbx_Active=By.id("Active");
By txtAddminCmnt=By.id("AdminComment");
By btnsave=By.xpath("//button[@name='save']");
By btnsave_edit=By.xpath("//button[@name='save-continue']");
By txtmsgfailure=By.xpath("//li[contains(text(),'Email is already registered')]");
By txtmsgsuccess=By.xpath("/html/body/div[3]/div[3]/div[1]");

public void ClkCustomersMenu()
{
	ldriver.findElement(lnkCustomers_menu).click();
}

public void ClkCustomersMenuItem()
{
	ldriver.findElement(lnkCustmrs_MenuItm).click();
}

public void ClkAddCustomer()
{
	ldriver.findElement(btnaddnew).click();
}

public void setEmail(String email)
{
	ldriver.findElement(txtEmail).sendKeys(email);
}

public void setPassword(String pswd)
{
	ldriver.findElement(txtPasswd).sendKeys(pswd);
}

public void setFirstName(String Fname)
{
	ldriver.findElement(txtFirstName).sendKeys(Fname);
}

public void setLastName(String Lname)
{
	ldriver.findElement(txtLastName).sendKeys(Lname);
}

public void setGender(String gender)
{
	if(gender.equals("Male"))
	{
		ldriver.findElement(radGen_Male).click();
	}
	else if (gender.equals("Female"))
	{
		ldriver.findElement(radGen_Female).click();
	}
	else
	{
		ldriver.findElement(radGen_Male).click();
	}
	
}

public void setDOB(String DOB)
{
	ldriver.findElement(txtDOB).sendKeys(DOB);
}

public void setDatePick(String Month, String Year, String Date)
{
	ldriver.findElement(btnDatePickr).click();
	while(true)
	{
		String month_Yr=ldriver.findElement(PickMonth_Yr).getText();
		if(month_Yr.equals(Month) && month_Yr.equals(Year))
		{
			break;
		}
		else
		{
			//ldriver.findElement(btnNextarw).click();
			ldriver.findElement(btnarwbfr).click();
		}
			
	}

List<WebElement> avlbldates=ldriver.findElements(Pick_date);
for(WebElement d:avlbldates)
{
	String dt=d.getText();
	if(Date.equals(dt))
	{
		d.click();
		break;
	}
	
}
	
}

public void setCompany(String Cname)
{
	ldriver.findElement(txtCompany).sendKeys(Cname);
}

public void setChkBx_Tax()
{
	ldriver.findElement(chkbx_Tax).click();
}

public void setNewsLtr1()
{
	ldriver.findElement(chkbx_Newsltr1).click();
}

public void setNewsLtr2()
{
	ldriver.findElement(chkbx_Newsltr2).click();
}

public void setCustomerRoles(String role) throws InterruptedException
{
	ldriver.findElement(txt_Custmrrole).click();
	Thread.sleep(5000);
	Actions act=new Actions(ldriver);
			
	if(role.equals("Registered"))
	{
		
		 listitem=ldriver.findElement(listitemregidtrd);
		
	}
	else if(role.equals("Administrators"))
	{
		 listitem=ldriver.findElement(listitem_Administrators);
	}
	else if(role.equals("Forum Moderators"))
	{
		 listitem=ldriver.findElement(listitemForumModeratrs);
	}
	else if(role.equals("Guests"))
	{
		 ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
		 listitem=ldriver.findElement(listitemGuests);
	}
	else if(role.equals("Vendors"))
	{
		 listitem=ldriver.findElement(listitemVendors);
	}
	else 
	{
		listitem=ldriver.findElement(listitemGuests);
	}
	//listitem.click();
	/*JavascriptExecutor js= (JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].click();", listitem);*/
	act.moveToElement(listitem).click().perform();
	
}

public void setVendor(String option)
{
	Select drp=new Select(ldriver.findElement(selVendor));

	drp.selectByVisibleText(option);
	
}

public void setupActiveBox()
{
	ldriver.findElement(chkbx_Active).click();
}

public void setCommentBox(String comment)
{
	ldriver.findElement(txtAddminCmnt).sendKeys(comment);
}

public void ClkSaveBtn()
{
	ldriver.findElement(btnsave).click();
}

public void ClkSaveBtn_Edit()
{
	ldriver.findElement(btnsave_edit).click();
}

public boolean SuccessVerificationMethod()
{
	String msg=ldriver.findElement(txtmsgsuccess).getText();
	if(msg.contains("The new customer has been added successfully."))
	{
		return true;
	}
	else
	{
		return false;
	}
}


public boolean FailureVerificationMethod()
{
	String msg=ldriver.findElement(txtmsgfailure).getText();
	if(msg.contains("Email is already registered"))
	{
		return true;
	}
	else
	{
		return false;
	}
}
	
	
	
	
	

}
