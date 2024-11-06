package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createContactUsingDataProviderTest2 {

	@Test(dataProvider = "getData")
	public void createContactTest(String firstName , String lastName)
	{
		System.out.println("FirstName:"+firstName+",LastNAme:"+lastName);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="Shankar";
		objArr[0][1]="HR";
		
		objArr[1][0]="Sunil";
		objArr[1][1]="AP";
		
		objArr[2][0]="Arun";
		objArr[2][1]="KK";
		
		return objArr;
		
	}
}
