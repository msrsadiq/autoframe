package com.ces.goibiboPageObjects;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage 
{
	protected AppiumDriver<MobileElement> driver;
	
	@FindBy(name="Menu icon")
	MobileElement hanburgerMenu;
	
	@FindBy(name="recent untapped logo")
	MobileElement recentSearch;
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]")
	MobileElement screenTitle;
	
	@FindBy(name="Cancel")
	MobileElement cancelDateSelection;
	
	@FindBy(tagName="UIACollectionCell")
	List<MobileElement> availableDates;
	
	
	
	public BasePage(AppiumDriver<MobileElement> driver)
	{
		this.driver = driver;
	}
	
	public void selectDate(String day)
	{
		for(MobileElement date : availableDates)
		{
			if(date.getText().equals(day))
				date.click();
			else
				System.out.println("No Such Date Available");
		}
	}
	
}
