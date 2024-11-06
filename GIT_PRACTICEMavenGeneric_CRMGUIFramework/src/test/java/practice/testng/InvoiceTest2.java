package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass_practice;


@Listeners(com.comcast.crm.listernerUtility.ListImplClass2.class)
public class InvoiceTest2 extends BaseClass_practice {
@Test
public void createTest2() {
	System.out.println("Execute createTest2");
	String actTitle=driver.getTitle();
	Assert.assertEquals(actTitle, "Login");
	System.out.println("Step-1");
	System.out.println("Step-2");
	
}

}
