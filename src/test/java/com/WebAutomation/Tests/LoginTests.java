package com.WebAutomation.Tests;

import org.testng.annotations.Test;

import com.WebAutomation.Base.InitiateDriver;
import com.WebAutomation.Pages.LoginPage;

public class LoginTests extends InitiateDriver {

	@Test(dataProvider="Get Login Data", dataProviderClass=com.WebAutomation.Utilities.DataProviders.class)
	public void tc001_verifyLoginFunctionality(String uname, String pass)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pass);
		login.showPassword();
		login.clickLogin();
		login.verifySuccessfulLogin(uname, pass);
	}
}
