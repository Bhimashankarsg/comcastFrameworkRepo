package practice.hometest;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class HomePageSampleTest {
	@Test
	public void homePageTest(Method mtd) {
		SoftAssert assertObj=new SoftAssert();
		Reporter.log(mtd.getName() + " Test Start");
		
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		assertObj.assertEquals("Home", "Home");
		Reporter.log("step-3",true);
		Assert.assertEquals("Home-CRM", "Home-CRM");
		Reporter.log("step-4",true);
		assertObj.assertAll();
		Reporter.log(mtd.getName() + " Test End");
	}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		Reporter.log(mtd.getName() + " Test Start");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Assert.assertTrue(true);
		Reporter.log("step-3",true);

		Reporter.log("step-4",true);

	}
}
