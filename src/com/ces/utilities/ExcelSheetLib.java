package com.ces.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/**
 * @author Sadiq Shaik
 *
 */

public class ExcelSheetLib 
{

	static Sheet wrksheet;
	static Workbook wrkbook = null;
	static Hashtable<String, Integer> dict = new Hashtable<String, Integer>();
	public static Hashtable<Integer, Object> flaggedMethod = new Hashtable<Integer, Object>();
	
	/**
	 * Constructor to initialize the workbook
	 * @param ExcelSheetPath
	 * @throws BiffException
	 * @throws IOException
	 */
	public ExcelSheetLib(String ExcelSheetPath) throws BiffException, IOException 
	{
		System.out.println(ExcelSheetPath);
		wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));
		wrksheet = wrkbook.getSheet("Sheet 1");
		ColumnDictionary();
	}
	
	/**
	 * Method to return no of rows available in the spreadsheet
	 * @return RowCount
	 */
	public static int RowCount()
	{
		return wrksheet.getRows();
	}

	
	/**
	 * Method to read the data in the cell using below parameters and return the data in the cell
	 * @param column
	 * @param row
	 * @return CellDdata
	 */
	public static String ReadCell(int column, int row) 
	{
		return wrksheet.getCell(column, row).getContents();
	}
	
	public static String ReadCell(String columnName, int rowNumber)
	{
		return ReadCell(GetCell(columnName), rowNumber);
	}

	/**
	 * Method to hold all the column Names
	 */
	public static void ColumnDictionary()
	{
		//Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for(int col=0; col<wrksheet.getColumns(); col++)
		{
			dict.put(ReadCell(col,0), col);
			
		}
	}

	/**
	 * Method to read the Column Names
	 * @param colName
	 * @return
	 */
	@SuppressWarnings("null")
	public static int GetCell(String colName) 
	{
		try 
		{
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} 
		catch (Exception e) 
		{
			System.out.println("No such column name");
			return (Integer) (null);

		}
	}
	
	
	public static Hashtable<Integer, Object> GetFlaggedMethods(String ColumnName) 
	{
		try 
		{
			// Load all the dictionary
			ColumnDictionary();
			int methodcount = 1; // keycount flag will track of
									// method count
			for (int row = 0; row<RowCount(); row++) 
			{
				
				if (ReadCell(ColumnName, row).equals("Y")) 
				{
					// put method keycount and the method name
					flaggedMethod.put(methodcount, ReadCell("MethodName", row) + ";" + ReadCell("ExcelSheetName", row));
					methodcount++;
				}
			}

		} 
		catch (Exception e) 
		{
			System.out.println("error");
			e.printStackTrace();

		}
		return flaggedMethod;
	}

}
