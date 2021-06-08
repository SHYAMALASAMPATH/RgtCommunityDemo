package com.rgtcommunity.commonutils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader3 
{
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	public void excelpath(String path)
	{
	try {
	File file=new File(path);
	FileInputStream fis = new FileInputStream(file);
	wb=new XSSFWorkbook(fis);
	}
	catch (Exception e) {
	System.out.println(e.getMessage() +"unable to read excel");
	}
	}
	public String dataReader(String sheetName,int row,int column)
	{
	sheet=wb.getSheet(sheetName);
	cell =sheet.getRow(row).getCell(column);
	String data=sheet.getRow(row).getCell(column).getStringCellValue();
	return data;
	//int type=cell.getCellType();
	}
	public List<String> getTestCaseId(String path,String sheetName,String flag,String expectflag)
	{
	List<String> testCaseNames=new ArrayList<String>();
	String colValue,flagValue,testCaseName;
	excelpath(path);
	for(int col=0;col<=excelcolunmnumber(sheetName);col++)
	{
	colValue=dataReader(sheetName,0,col);
	if(colValue.equalsIgnoreCase(flag))
	{
	for(int row=1;row<=excelrownumber(sheetName);row++)
	{
	flagValue=dataReader(sheetName,row,col);
	if(flagValue!=null)
	{
	if(flagValue.equalsIgnoreCase(expectflag))
	{
	testCaseName=dataReader(sheetName,row,0);
	testCaseNames.add(testCaseName);
	}
	}
	}
	break;
	}
	}
	System.out.println("testCaseNames : "+testCaseNames);
	return testCaseNames;

	}

	 public int excelrownumber(String sheetName) {
	sheet=wb.getSheet(sheetName);
	int rownumber=sheet.getLastRowNum();
	return rownumber;
	}

	 public int excelcolunmnumber(String sheetName) {
	sheet=wb.getSheet(sheetName);
	row=sheet.getRow(0);
	int totalcolumns=row.getLastCellNum();
	totalcolumns=totalcolumns-1;
	return totalcolumns;
	}
	public Map<String,String> getTestCaseDetails(String path,String sheetName,String testCaseName)
	{
	Map<String,String> testCaseDetails=new LinkedHashMap<String,String>();
	String column,value;
	excelpath(path);
	for(int row=1;row<=excelrownumber(sheetName);row++)
	{
	String testCaseId=dataReader(sheetName, row, 0);
	if(testCaseId.equalsIgnoreCase(testCaseName))
	{
	for(int col=0;col<=excelcolunmnumber(sheetName);col++)
	{
	column=dataReader(sheetName,0,col);
	value=dataReader(sheetName,row,col);
	testCaseDetails.put(column, value);
	}
	break;
	}
	}
	return testCaseDetails;
	}
}
