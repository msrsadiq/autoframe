package com.ces.goibiboPageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LandingPage 
{

	/**
	 * All WebElements in Landing page identification using @FindBy annotation
	 */
	
	@FindBy(name="hotels_btn")
	WebElement hotels;
	
	@FindBy(name="flights_btn")
	WebElement flights;
	
	@FindBy(name="buses_btn")
	WebElement buses;
	
	@FindBy(name="gocash_btn")
	WebElement gocash;
	
	@FindBy(name="more_btn")
	WebElement moreOption;
	
	@FindBy(name="referral_profile_mini_icon")
	WebElement refernEarn;
	
	@FindBy(name="You_icon")
	WebElement signInSignUp;
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")
	WebElement loggedUser;
	
	@FindBy(name="Your_trip_icon")
	WebElement yourBookings;
	
	
	private AppiumDriver<MobileElement> driver;
	
	/**
	 * Constructor to initialize the driver
	 * @param driver
	 */
	public LandingPage(AppiumDriver<MobileElement> driver)
	{
		this.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public AppiumDriver<MobileElement> getDriver() 
	{
		return driver;
	}

	public void setDriver(AppiumDriver<MobileElement> driver) 
	{
		this.driver = driver;
	}
	
	public void navigatetoFlightSearch()
	{
		flights.click();
	}
	
	public void navigatetoHotelSearch()
	{
		hotels.click();
	}
	
	public void navigatetoBusSearch()
	{
		buses.click();
	}
	
	public String getLoggedUserName()
	{
		return loggedUser.getText();
	}
	
	public void navigatetoSignInSignUp()
	{
		signInSignUp.click();
	}
	
	public void navigatetoRefernEarn()
	{
		refernEarn.click();
	}
	
	public void navigatetoMyBookings()
	{
		yourBookings.click();
	}
	
	

}
