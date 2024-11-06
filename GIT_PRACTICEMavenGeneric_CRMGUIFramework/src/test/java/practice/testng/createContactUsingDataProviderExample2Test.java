package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createContactUsingDataProviderExample2Test {

	@Test(dataProvider = "getData")
	public void createContactTest(String firstName , String lastName,long phoneno)
	{
		System.out.println("FirstName:"+firstName+",LastNAme:"+lastName+",PhoneNumber:"+phoneno);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="Shankar";
		objArr[0][1]="HR";
		objArr[0][2]=9898989977l;
		
		objArr[1][0]="Sunil";
		objArr[1][1]="AP";
		objArr[1][2]=7887878324l;
		
		objArr[2][0]="Arun";
		objArr[2][1]="KK";
		objArr[2][2]=78878788973l;
		
		return objArr;
		
	}
}
