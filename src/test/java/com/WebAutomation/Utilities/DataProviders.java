package com.WebAutomation.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Get Login Data")
	public Object[][] getLoginData() throws IOException
	{
		FileInputStream fs=new FileInputStream("./src/test/resources/ITSM Test Data/ITSM_Test_Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sh=wb.getSheet("Login Test Data");
		
		int totalRows=sh.getPhysicalNumberOfRows();
		int totalColoumns=sh.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] testData=new Object[totalRows-1][totalColoumns];
		DataFormatter formatter=new DataFormatter();
		
		for(int i=1;i<totalRows;i++)
		{
			for(int j=0;j<totalColoumns;j++)
			{
				testData[i-1][j]=formatter.formatCellValue(sh.getRow(i).getCell(j));
			}
		}
		wb.close();
		fs.close();
		return testData;
	}
}
