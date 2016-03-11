package com.ces.research;

import com.ces.utilities.XMLFileLib;

public class Caller 
{

	public static void main(String[] args) throws Exception 
	{
		
		XMLFileLib xml = new XMLFileLib();
		
		xml.createXml("Regression", "com.ces.goibiboTests", "CESAutomation");

	}

}
