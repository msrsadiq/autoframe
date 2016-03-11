package com.ces.goibiboTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class Test {
	@FindBy(id="sb_ifc0")
	static
	WebElement searchbox;
	
	public static void main(String[] args) 
	{	
	
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.co.in/");
		


	}

}
