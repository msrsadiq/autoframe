package com.ces.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.TestNG;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author cesit
 *
 */
public class XMLFileLib 
{
	/**
	 * 
	 * @param testType
	 * @throws Exception
	 */
	public void createXml(String testType, String testcasePackage, String suiteName) throws Exception 
	{

		try 
		{
			// Initialization of drivers
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			String xlFilePath = null;
			if (testType == "Regression")
			{
				xlFilePath = "Resources/RegressionSuite.xls";
			}
			else
			{
				xlFilePath = "Resources//smoke.xls";
			}
			
			ExcelSheetLib lib = new ExcelSheetLib(xlFilePath);

			// Get the flagged cells with value = "Y" from excel file
			ExcelSheetLib.GetFlaggedMethods("ExecutionFlag");

			// Get the number of parameter to be created in XML

			int totalnoofelementsflaggedtorun = ExcelSheetLib.flaggedMethod.size();

			// Type the suite tag element in the XML file
			Element rootElementsuite = document.createElement("suite");

			// Type the parameter set of lines in the XML file
			for (int elementcounter = 1; elementcounter< totalnoofelementsflaggedtorun; elementcounter++) 
			{
				Element rootElementparameter = document.createElement("parameter");

				String[] flagElement = ExcelSheetLib.flaggedMethod.get(elementcounter).toString().split(";");
				
				rootElementparameter.setAttribute("name", flagElement[0]);
				rootElementparameter.setAttribute("value", flagElement[1]);
				rootElementsuite.appendChild(rootElementparameter);
			}

			// Type the root elements in the XML file
			Element rootElementtest = document.createElement("test");
			Element rootElementClass = document.createElement("classes");
			Element childelementClass = document.createElement("class");
			
			// Assign attribute to the root elements
			childelementClass.setAttribute("name", testcasePackage);

			Element rootElementgroups = document.createElement("methods");

			// Assign attribute to the root elements
			rootElementsuite.setAttribute("name", suiteName);
			rootElementtest.setAttribute("name", testType);

			// Append values to the root elements
			rootElementsuite.appendChild(rootElementtest);
			rootElementtest.appendChild(rootElementClass);
			rootElementClass.appendChild(childelementClass);
			childelementClass.appendChild(rootElementgroups);
			
			// rootElementgroups.appendChild(rootElementrun);
			document.appendChild(rootElementsuite);

			// Obtain the column value flag = "Y" in a loop
			for (int elementcounter = 1; elementcounter <= totalnoofelementsflaggedtorun; elementcounter++)
			{
				String element = "include";
				Element em = document.createElement(element);
			
				String[] flagElement = ExcelSheetLib.flaggedMethod.get(elementcounter).toString().split(";");

				em.setAttribute("name", flagElement[0]);
				rootElementgroups.appendChild(em);

			}

			// Generate the file.
			FileWriter fstream = new FileWriter("Resources//testng.xml");
			BufferedWriter out = new BufferedWriter(fstream);

			// Generate the required XML output file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);

			// Prints all the Generated Xml code in the File object
			StreamResult result = new StreamResult(fstream);
			transformer.transform(source, result);

			// close the generated file.
			out.close();
		}
		catch (DOMException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * This method runs the XML suite file dynamically
	 * 
	 **/
	public static void autoRunXml() 
	{

		// Create a list
		List<String> files = new ArrayList<String>();

		// Add the required xml files to the list
		files.add("Resource\\testng.xml");

		// create object for TestNG
		TestNG tng = new TestNG();

		// Add the list of files to create a suite
		tng.setTestSuites(files);

		// Run the suite
		tng.run();

	}
}
