package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass_practice;


@Listeners(com.comcast.crm.listernerUtility.ListImplClass2.class)
public class InvoiceTest3 extends BaseClass_practice {
@Test
public void createTest3() {
	System.out.println("Execute createTest3");
	String actTitle=driver.getTitle();
	Assert.assertEquals(actTitle, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
	System.out.println("Step-1");
	System.out.println("Step-2");
	
}

}
