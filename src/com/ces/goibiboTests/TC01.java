package com.ces.goibiboTests;

import org.testng.annotations.Test;

import com.ces.driver.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class TC01 extends Driver
{
	  private AppiumDriver<MobileElement> driver;
	  @Test
	  public void f() 
	  {
	  }
	 
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException 
	  {
		  DesiredCapabilities iosCapabilities = new DesiredCapabilities();
			
		  iosCapabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.0");
		  iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		  iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.2.1");
		  iosCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone5s");
		  iosCapabilities.setCapability(MobileCapabilityType.APP, "/Users/cesit/Desktop/goibibiProject/GoibiboTest/src/main/java/com/goibibo/utils/Goibibo.ipa");
		  iosCapabilities.setCapability(MobileCapabilityType.UDID, "54438f7d0f97bff51961114ff91f886f4072bded");
		  iosCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		  
		  driver = new IOSDriver<MobileElement>(new URL(""), iosCapabilities);
		
	  }
	  
	
	  @AfterClass
	  public void afterClass()
	  {
	
	  }

}
