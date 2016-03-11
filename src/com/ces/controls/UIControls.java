package com.ces.controls;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ces.utilities.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

/**
 * UIControls - This class contains the common methods to perform actions on mobile and web UI elements
 * @author Sadiq Shaik
 */
public class UIControls 
{
    
    // Wait Time
    public static final int WAITTIMEOUT = 2000;
    public static final int TIMEOUT = 60;

    static AppiumDriver<MobileElement> driver;
	
	public UIControls(AppiumDriver<MobileElement> driver)
	{
		UIControls.driver = driver;	
	}
	
	
	/**
	 *  Method to hide keyboard
	 */
	public void hideKeyboard() 
	{
		((AppiumDriver<MobileElement>) driver).hideKeyboard();
	}
	

	/** 
	 * Method to wait for an element to be visible
	 * @param targetElement element to be visible
	 * @return true if element is visible else throws TimeoutException
	 */
	public boolean waitForVisibility(MobileElement targetElement)
	{
		try
		{
			System.out.println("test");
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.visibilityOf(targetElement));
			return true;
		}
		catch(TimeoutException e)
		{
			System.out.println("Element is not visible: " + targetElement );
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}
	

	/**
	 * Method to tap on the screen on provided coordinates
	 * @param xPosition x coordinate to be tapped
	 * @param yPosition y coordinate to be tapped
	 */
	public void tap(double xPosition, double yPosition)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double>  tapObject = new HashMap<String, Double>();
		tapObject.put("startX", xPosition);
		tapObject.put("startY", yPosition);
		js.executeScript("mobile: tap", tapObject);	
	}
	
	
	/**
	 * Method to get message of alert
	 * @return message text which is displayed
	 */
	public String getAlertText() 
	{ 
		try 
		{
			Alert alert = driver.switchTo().alert(); 
			String alertText = alert.getText(); 
			return alertText; 
		} 
		catch (NoAlertPresentException e)
		{
			throw new NoAlertPresentException();
		}
	}   


	/**
	 * Method to verify if alert is present
	 * @return returns true if alert is present else false
	 */
	public boolean isAlertPresent() 
	{ 
		try 
		{ 
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			return true; 
		}   
		catch (NoAlertPresentException e) 
		{   
			throw new NoAlertPresentException(); 
		}   
	}   
	

	/**
	 *  method to Accept Alert if alert is present
	 */
	public void acceptAlert()
	{
		isAlertPresent();
		driver.switchTo().alert().accept();
	}


	/**
	 *  method to Dismiss Alert if alert is present
	 */
	public void dismissAlert()
	{
		isAlertPresent();
		driver.switchTo().alert().dismiss();
	}
	

	/**
	 * Method to long press on specific element by passing target element
	 * @param locator element to be long pressed
	 */
	public void longPress(MobileElement targetElement)
	{
		try 
		{
			
			TouchAction touch = new TouchAction((AppiumDriver<MobileElement>) driver);
			touch.longPress(targetElement).release().perform();
			Log.info("Long press successful on element: " + targetElement);
		}
		catch (NoSuchElementException e)
		{
			Log.logError(this.getClass().getName(), "findElement", "Element not found" + targetElement);
			throw new NoSuchElementException(e.getMessage());
		}

	}


	/**
	 * Method to long press on specific x,y coordinates
	 * @param x x offset
	 * @param y y offset
	 */
	public void longPress(int x, int y)
	{
		TouchAction touch = new TouchAction((MobileDriver) driver);
		touch.longPress(x, y).release().perform();
		Log.info("Long press successful on coordinates: " + "( " + x + "," + y + " )");

	}

	
	/**
	 * Method to swipe on the screen on provided coordinates
	 * @param startX - start X coordinate to be tapped
	 * @param endX - end X coordinate to be tapped
	 * @param startY - start y coordinate to be tapped
	 * @param endY - end Y coordinate to be tapped
	 * @param duration duration to be tapped
	 */
	public void swipe(double startX, double startY, double endX, double endY, double duration)
	{ 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		// swipeObject.put("touchCount", 1.0);
		swipeObject.put("startX", startX);
		swipeObject.put("startY", startY);
		swipeObject.put("endX", endX);
		swipeObject.put("endY", endY);
		swipeObject.put("duration", duration);
		js.executeScript("mobile: swipe", swipeObject);
	}
	

	/**
	 * Scroll forward to the element which has a description or name which contains the input text.
	 * The scrolling is performed on the first scrollView present on the UI
	 * @param text text of the element text to be found
	 */
	public void scrollTo(String text) 
	{
		try
		{
			((AppiumDriver<MobileElement>) driver).scrollToExact(text); 
			Log.info("Scroll Done for element: " + text);
		}
		catch(NoSuchElementException e)
		{
			Log.logError(this.getClass().getName(), "findElement", "Element not found with Scroll" + text);
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	/**
	 * Method to scroll to an element on the screen
	 * @param element
	 */
    public static void scrollToAnElement(final MobileElement element) 
    {
        try 
        {
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	HashMap<String, String> arguments = new HashMap<String, String>();
        	arguments.put("element", element.getId());
        	js.executeScript("mobile: scrollTo", arguments);
        } 
        catch (Exception e) 
        {

        }
    }
	

    /**
	 *  Method to open notifications on Android
	 */
	public void openNotifications() 
	{
		((AndroidDriver<MobileElement>) driver).openNotifications();
	}


	/**
	 *  Method to launchApp
	 */
	public void launchApp() 
	{
		((AppiumDriver<MobileElement>) driver).launchApp();
	}


	/**
	 *  method to Swipe Left on Element By Locator
	 * @param locator - By locator
	 *  @param duration - Time to swipe
	 */
	public void swipeLeft(MobileElement element , int duration)
	{
		element.swipe(SwipeElementDirection.LEFT, duration);
	}

	/**
	 *  method to Swipe UP on Element By Locator
	 *  @param locator - By locator
	 *  @param duration - Time to swipe
	 */
	public void swipeUP(MobileElement element , int duration)
	{
		element.swipe(SwipeElementDirection.UP, duration);
	}

}
