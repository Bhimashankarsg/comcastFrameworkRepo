package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass_practice;

public class InvoiceTest_retryanalyser extends BaseClass_practice {
	@Test(retryAnalyzer=com.comcast.crm.listernerUtility.RetryListenerImp.class)
	public void activateSim() {
		System.out.println("Execute createInvoiceTest");
	
		Assert.assertEquals(" ", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

}
