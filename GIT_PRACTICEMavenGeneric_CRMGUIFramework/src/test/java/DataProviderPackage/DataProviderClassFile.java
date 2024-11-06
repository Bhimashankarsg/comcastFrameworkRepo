package DataProviderPackage;

import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProviderClassFile {

@DataProvider (name="mobprice")
public Object[][] mobileprice() throws Throwable
{
	
	ExcelUtility eLib=new ExcelUtility();
	int rowcount = eLib.getRowcount("product");
	Object[][] objArr=new Object[rowcount][2];
	System.out.println("I am from DATAPROVIDERCLASS Between PACKAGE");
	for(int i=0;i<rowcount;i++)
	{
		
	objArr[i][0]=eLib.getDataFromExcel("product", i+1, 0);
	objArr[i][1]=eLib.getDataFromExcel("product", i+1, 1);
	
	
	
	
	}

	
	return objArr;
	
}
}
