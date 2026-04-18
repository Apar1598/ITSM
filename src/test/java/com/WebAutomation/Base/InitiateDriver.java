package com.WebAutomation.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.WebAutomation.Utilities.CaptureScreenshot;
import com.WebAutomation.Utilities.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitiateDriver {

	public WebDriver driver;
	
	@Parameters({"Browser"})
	@BeforeMethod
	public void setup(String br)
	{
		if(br.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
			WebDriverManager.chromedriver().setup();
		}
		else if(br.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
			WebDriverManager.edgedriver().setup();
		}
		else
		{
			driver=new ChromeDriver();
			WebDriverManager.chromedriver().setup();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.get(PropertyReader.configReader("ITSM_URL"));
	}
	
	@AfterMethod
	public void tearown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			String name=result.getName();
			CaptureScreenshot.screenshot(driver, name);
			driver.quit();
		}
		if(driver!=null)
		{
			driver.quit();
		}
	}
}
