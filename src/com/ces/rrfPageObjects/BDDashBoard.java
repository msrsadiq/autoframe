package com.ces.rrfPageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BDDashBoard 
{
	private AppiumDriver<MobileElement> driver;
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[2]")
	MobileElement addRequest;
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[1]")
	MobileElement requestDropdown;
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")
	MobileElement hamburger;
	
	public BDDashBoard(AppiumDriver<MobileElement> driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
