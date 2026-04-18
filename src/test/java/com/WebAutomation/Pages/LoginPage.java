package com.WebAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.WebAutomation.Assertions.AllVerifications;
import com.WebAutomation.Utilities.PageActions;
import com.WebAutomation.Utilities.PropertyReader;

public class LoginPage {
	
	WebDriver driver;
	PageActions action;
	SoftAssert sa1=new SoftAssert();

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		action=new PageActions(driver);
	}
	
	public void enterUserName(String Uname)
	{
		action.setFieldValues(driver.findElement(By.xpath
				(PropertyReader.configReader("ITSM_Login_Uname_xpath"))), Uname);
	}
	
	public void enterPassword(String pass)
	{
		action.setFieldValues(driver.findElement(By.xpath
				(PropertyReader.configReader("ITSM_Login_Pass_xpath"))), pass);
	}
	
	public void showPassword()
	{
		action.clickElement(driver.findElement(By.xpath
				(PropertyReader.configReader("ITSM_Login_ShowPass_xpath"))));
	}
	
	public void clickLogin()
	{
		action.clickElement(driver.findElement(By.xpath
				(PropertyReader.configReader("ITSM_Logn_Submit_xpath"))));
	}
	
	public void verifySuccessfulLogin(String Uname, String pass)
	{
		if(Uname.equals("admin")&&pass.equals("63JIezx/Qk+B"))
		{
			sa1.assertEquals(AllVerifications.verifyElementVisibility
					(driver, PropertyReader.configReader("ITSM_Home_Page_xpath")), true);
		}
		else
		{
			sa1.assertEquals(AllVerifications.verifyElementVisibility
					(driver, PropertyReader.configReader("ITSM_Home_Page_xpath")), false);
		}
		sa1.assertAll();
	}
}
