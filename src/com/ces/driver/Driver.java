package com.ces.driver;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver 
{
	private AppiumDriver<MobileElement> driver;
	static String iosAppPath = "";
	static String androidAppPath = "";
	
	public void setDriver(String driverType)
	{
		switch(driverType)
		{
			case "IOS":
			{
				driver = initIOSDriver();
			}
			case "Android":
			{
				driver = initAndroidDriver();
			}	
		}
	}

	private AppiumDriver<MobileElement> initAndroidDriver() 
	{
		System.out.println("Launch app on IOS Device");
		String url = null, platform = null, version = null, deviceName = null, udid = null;
		DesiredCapabilities iosCapabilities = new DesiredCapabilities();
		
		iosCapabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.0");
		iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
		iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
		iosCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		iosCapabilities.setCapability(MobileCapabilityType.APP, "/Users/cesit/Desktop/goibibiProject/GoibiboTest/src/main/java/com/goibibo/utils/Goibibo.ipa");
		iosCapabilities.setCapability(MobileCapabilityType.UDID, udid);
		iosCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
	    try {
			driver = new IOSDriver<MobileElement>(new URL(url), iosCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("App launched");
		return driver;
	}

	private AppiumDriver<MobileElement> initIOSDriver() 
	{
		
		return driver;
	}
}
