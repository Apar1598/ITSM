package com.WebAutomation.Utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {

	public static void screenshot(WebDriver driver, String name)
	{
		try
		{
			TakesScreenshot sc=(TakesScreenshot)driver;
			File src=sc.getScreenshotAs(OutputType.FILE);
			File dest=new File("./src/test/resources/Screenshots/"+name+System.currentTimeMillis()+".png");
			FileHandler.copy(src, dest);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
