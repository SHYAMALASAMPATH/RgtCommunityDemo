package com.rgtcommunity.pageobjects;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;

import com.rgtcommunity.commonutils.ExcelReader2;

public class ExcelClass 
{

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelReader2 er=new ExcelReader2(".\\src\\main\\java\\com\\rgtcommunity\\excelutility\\RgtLogin.xlsx");
        Sheet s=er.getSheetFromWorkbook("rgtlogincredentials");
        System.out.println(s.getSheetName());
        System.out.println(s.getLastRowNum());//3
        System.out.println(s.getPhysicalNumberOfRows());
        int latrownumber=s.getLastRowNum();
 
     List<String> rowdata= er.getSingleRowData(s.getSheetName(), 1);
     System.out.println(rowdata.get(0));
     System.out.println(rowdata.get(1));
    
//  	System.out.println("sheetname is..."+sheetname+"---row number is----"+rownumber);
//		ExcelReader2 er=new ExcelReader2("C:\\RGT_WorkSpace\\rgtcommunity\\src\\main\\java\\com\\rgtcommunity\\testdata\\excelfiles\\RgtLogin.xlsx");
//      //Sheet s=er.getSheetFromWorkbook(sheetname);
//     int row= Integer.parseInt(rownumber);
//   List<String> rowdata= er.getSingleRowData(sheetname, row);
//   System.out.println(rowdata.get(0));
//   System.out.println(rowdata.get(1));
//		 ExcelReader2 er1= new ExcelReader2("‪.\\src\\main\\java\\com\\rgtcommunity\\excelutility\\Facebooksignupdata.xlsx");
//
//	     List<String> rowdata1= er.getSingleRowData("Sheet1", 0);
//		    System.out.println(rowdata1.get(0));
	}

}
