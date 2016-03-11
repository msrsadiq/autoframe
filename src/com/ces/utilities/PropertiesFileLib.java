package com.ces.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesFileLib 
{

		public static void readFromPropperties() 
		{
			try 
			{
				File file = new File("test.properties");
				FileInputStream fileInput = new FileInputStream(file);
				Properties properties = new Properties();
				properties.load(fileInput);
				fileInput.close();

				Enumeration<Object> enuKeys = properties.keys();
				while (enuKeys.hasMoreElements())
				{
					String key = (String) enuKeys.nextElement();
					String value = properties.getProperty(key);
					System.out.println(key + ": " + value);
				}
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
	}
}

