
package com.comcast.crm.orgtest;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass_practice;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listernerUtility.ListImplClass.class)
public class CreateOrg_Indu_Phone_Test extends BaseClass_practice {

	@Test(groups = "smoketest")
	public void createorganTest() throws IOException, Throwable {

		// ListImplClass.test.log(Status.INFO,"Read data from excel");
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		// read testscript data form ecxelfie

		String ORGNAME = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Page");

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3: click on "create organization" button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Org Page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4: enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, "create new Org ");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);

		cnop.createOrg(ORGNAME);

		UtilityClassObject.getTest().log(Status.INFO, ORGNAME + "====>new Org ");
		// verify header msg expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String actOrgName = oip.getHeaderMsg().getText();

		assertObj.hardAssert(actOrgName, "hello");

		/*
		 * boolean status = actOrgName.contains(ORGNAME); Assert.assertTrue(status);
		 */
		/*
		 * if (actOrgName.contains(ORGNAME)) { Reporter.log(ORGNAME +
		 * " name is verified == Pass");
		 * 
		 * } else { Reporter.log(ORGNAME + " name is verified == Pass"); }
		 */
		// step 5: Logout

		// wLib.quitwindow(driver);

	}

	@Test(groups = "regressiontest")
	public void createorganWithIndTest() throws IOException, Throwable {

		// read testscript data form ecxelfie
		String ORGNAME = eLib.getDataFromExcel("org", 4, 3) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3: click on "create organization" button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4: Enter all the details & create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);

		cnop.createOrg(ORGNAME, industry, type);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		// Verify the industries info
		String actindustries = oip.getHeaderindMsg().getText();

		Reporter.log(actindustries);
		assertObj.softAssert(actindustries, industry);

		/*
		 * boolean status = actindustries.contains(industry); Assert.assertTrue(status);
		 */

		/*
		 * if (actindustries.equals(industry)) { Reporter.log(industry +
		 * "  industry information is verified==Pass"); } else { Reporter.log(industry +
		 * " industry information is not verified==Fail"); }
		 */
		// Verify the type info

		String actType = oip.getHeaderaccMsg().getText();

		Reporter.log(actType);

		assertObj.softAssert(actType, type);
		/*
		 * boolean status2 = actType.contains(type); Assert.assertTrue(status2);
		 */
		/*
		 * if (actType.equals(type)) { Reporter.log(type +
		 * " account type information  is verified==Pass"); } else { Reporter.log(type +
		 * "  account type information is not verified==Fail"); }
		 */
		// step 5: logout

	}

	@Test(groups = "regressiontest")
	public void createorgwithphonenoTest() throws IOException, Throwable {
		// read testscript data form ecxelfie
		String ORGNAME = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String PHONENO = eLib.getDataFromExcel("org", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3: click on "create organization" button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4: Enter all the details & create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg_phone(ORGNAME, PHONENO);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		// VERIFY PHONE NO INFORMATION
		String actPhoneno = oip.getHeaderphoneMsg().getText();

		Reporter.log("phonenumberDATA");
		Reporter.log(actPhoneno);
		Reporter.log(PHONENO);

		assertObj.softAssert(actPhoneno, PHONENO);

		/*
		 * boolean status2 = actPhoneno.contains(PHONENO); Assert.assertTrue(status2);
		 */

		/*
		 * if (actPhoneno.equals(PHONENO)) { Reporter.log(PHONENO +
		 * " (PHONENO) is verified==Pass"); } else { Reporter.log(PHONENO +
		 * " (PHONENO) is not verified==Fail");
		 * 
		 * }
		 */

		// wLib.quitwindow(driver);

		// step 5: logout

	}

}
