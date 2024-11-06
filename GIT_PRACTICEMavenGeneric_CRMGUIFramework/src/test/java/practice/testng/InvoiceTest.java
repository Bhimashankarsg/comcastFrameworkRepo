package practice.testng;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass_practice;



public class InvoiceTest extends BaseClass_practice {
@Test
public void createInvoiceTest() {
	Reporter.log("Execute createInvoiceTest");
	String actTitle=driver.getTitle();
	Assert.assertEquals(actTitle, "Login");
	Reporter.log("Step-1");
	Reporter.log("Step-2");
	Reporter.log("Step-3");
	Reporter.log("Step-4");
}

@Test
public void createInvoiceWithContactTest() {
	Reporter.log("Execute createInvoiceWithContactTest");
	Reporter.log("Step-1");
	Reporter.log("Step-2");
	Reporter.log("Step-3");
	Reporter.log("Step-4");
}
}
