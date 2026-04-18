package com.WebAutomation.Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions {
	
	WebDriver driver;
	WebDriverWait wait;
	public PageActions(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void setFieldValues(WebElement element, String value)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}
	
	public void clickElement(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void selectElement(WebElement element, String value)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		Select s1=new Select(element);
		s1.selectByVisibleText(value);
	}
}
