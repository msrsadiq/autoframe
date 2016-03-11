package com.ces.goibiboPageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class BusesHomePage
{

	@FindBy(name="One way")
	MobileElement oneWay;
	
	@FindBy(name="Round trip")
	MobileElement roundTrip;
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[7]")
	MobileElement source;
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[9]")
	MobileElement destination;
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[8]")
	MobileElement swapSrcDest;
	
	@FindBy(name="Depart")
	MobileElement departDate;
	
	@FindBy(name="Return")
	MobileElement returnDate;
	
	@FindBy(name="Today")
	MobileElement todayDate;
	
	@FindBy(name="Tomorrow")
	MobileElement tomDate;
	
	@FindBy(name="ac icn")
	MobileElement acBusType;
	
	@FindBy(name="nonac icn")
	MobileElement nonacBusType;
	
	@FindBy(name="sleeper icn")
	MobileElement sleeperBusType;
	
	@FindBy(name="seat icon")
	MobileElement seatBusType;
	
	@FindBy(name="Search")
	MobileElement search;

	private AppiumDriver<MobileElement> driver;
	
    public BusesHomePage(AppiumDriver<MobileElement> driver)
    {
        this.setDriver(driver);
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
	public AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	public void setDriver(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void selectSource(String srcName)
	{
		source.click();
		driver.findElementByName(srcName).click();
	}
	
	public String getSourceName()
	{
		return source.getText();
	}
	
	public void selectDestination(String destName)
	{
		destination.click();
		driver.findElementByName(destName).click();
	}
	
	public String getDestName()
	{
		return destination.getText();
	}
	public void selectOneWayTrip()
	{
		oneWay.click();
	}
	
	public void selectRoundTrip()
	{
		roundTrip.click();
	}
	
	//Need to implement date selection
	public void selectDepartDate()
	{
		departDate.click();
	}
	
	
	public void swapSrcDest()
	{
		swapSrcDest.click();
	}
	
	//Need to implement date selection
	public void selectReturnDate()
	{
		returnDate.click();
	}
	
	public void selectACBusType()
	{
		acBusType.click();
	}
	
	public void selectnonACBusType()
	{
		nonacBusType.click();
	}
	
	public void selectSleeperBusType()
	{
		sleeperBusType.click();
	}
	
	public void selectSeatBusType()
	{
		seatBusType.click();
	}
	
	public void searchforBuses()
	{
		search.click();
	}
}
