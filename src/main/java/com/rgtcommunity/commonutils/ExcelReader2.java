package com.rgtcommunity.commonutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader2 {

	private String filePath;
	private FileInputStream fip;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	private String cellValue;
	
	public ExcelReader2(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		this.filePath = filePath;
		fip = new FileInputStream(filePath);
	    workbook = WorkbookFactory.create(fip);
	}
	
	public Sheet getSheetFromWorkbook(int index) {
		sheet = workbook.getSheetAt(index);
		return sheet;
	}
	
    public Sheet getSheetFromWorkbook(String sheetName) {
    	sheet = workbook.getSheet(sheetName);
		return sheet;
	}
	public String getSingleCellData(String sheetName,int rowNum,int cellNum) {
		sheet= getSheetFromWorkbook(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data = "";
		if (cell.getCellType() == CellType.NUMERIC) {
			cellValue = cell.getNumericCellValue()+"";
		}
		else if (cell.getCellType() == CellType.STRING) {
			cellValue = cell.getStringCellValue();
		}
		Optional<String> optional = Optional.ofNullable(cellValue);
		if (optional.isPresent()){
			data = cellValue;
		}
		return data;
	}
	
	public List<String> getSingleRowData(String sheetName,int rowNum) {
		List<String> rowData = new ArrayList<String>();
		sheet = getSheetFromWorkbook(sheetName);
		row = sheet.getRow(rowNum);
		
		for(int i=0;i<row.getLastCellNum();i++){
			cell = row.getCell(i);
			if (cell.getCellType() == CellType.NUMERIC) {
				cellValue = cell.getNumericCellValue()+"";
				rowData.add(cellValue);
			}
			else if (cell.getCellType() == CellType.STRING) {
				cellValue = cell.getStringCellValue();
				rowData.add(cellValue);
			}
		}
		return rowData;
	}
	
	public List<String> getTotalSheetData(String sheetName) {
		List<String> sheetData = new ArrayList<String>();		
		sheet = getSheetFromWorkbook(sheetName);
		for(int i=0;i<=sheet.getLastRowNum();i++){
			row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				cell = row.getCell(j);
				if (cell.getCellType() == CellType.NUMERIC) {
					cellValue = cell.getNumericCellValue()+"";
					sheetData.add(cellValue);
				}
				else if (cell.getCellType() == CellType.STRING) {
					cellValue = cell.getStringCellValue();
					sheetData.add(cellValue);
				}
			}
		}
		return sheetData;
	}
	public Set<String> getTotalUniqueSheetData(String sheetName) {
		List<String> data = getTotalSheetData(sheetName);
		Set<String> uniqueData = new LinkedHashSet<String>();
		return uniqueData;
	}
	
	public List<String> getTCNames(String sheetName) {
		List<String> tcNames = new ArrayList<String>();
		
		sheet = getSheetFromWorkbook(sheetName);
		for(int i=1;i<sheet.getLastRowNum()+1;i++){
			row = sheet.getRow(i);
			for(int j=0;j<=0;j++){
				cell = row.getCell(j);
				if (cell.getCellType() == CellType.NUMERIC) {
					cellValue = cell.getNumericCellValue()+"";
					tcNames.add(cellValue);
				}
				else if (cell.getCellType() == CellType.STRING) {
					cellValue = cell.getStringCellValue();
					tcNames.add(cellValue);
				}	
			}
		}
		return tcNames;
	}
}
