package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.XLUtils;

public class GetTestData {

	@DataProvider(name="AddCustomerData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/resources/testdata/AddCustomerTestData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String data[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return data;
	}
}
