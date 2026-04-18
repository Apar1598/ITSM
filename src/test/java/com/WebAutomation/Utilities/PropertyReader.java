package com.WebAutomation.Utilities;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropertyReader {

	public static String configReader(String key)
	{
		try
		{
			File f=new File("./src/test/resources/ITSM Properties/ITSM Configuration.properties");
			FileReader fr=new FileReader(f);
			Properties pr=new Properties();
			pr.load(fr);
			return pr.get(key).toString();
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
