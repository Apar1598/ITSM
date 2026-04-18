package com.WebAutomation.Assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllVerifications {

	public static boolean verifyElementVisibility(WebDriver driver, String xpath)
	{
		try
		{

			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return element.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
