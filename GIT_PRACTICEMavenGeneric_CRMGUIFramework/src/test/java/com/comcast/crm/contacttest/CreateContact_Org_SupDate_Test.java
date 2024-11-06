package com.comcast.crm.contacttest;

import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.assertUtility.assertUtility;
import com.comcast.crm.basetest.BaseClass_practice;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrgPopUpPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.crm.generic.baseutility.BaseClass;

public class CreateContact_Org_SupDate_Test extends BaseClass_practice {

	
	
	@Test(groups ="smoketest")
	public void createContactTest() throws IOException, Throwable {
		// read testscript data form ecxelfie

		String LASTNAME = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// step 2 : navigate to organizatin module

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step 3: click on "create " button

		ContactsPage cnp = new ContactsPage(driver);
		cnp.getCreateNewContactBtn().click();

		// step 4: enter all the details & create new organization
		CreatingNewContactsPage cnop = new CreatingNewContactsPage(driver);

		cnop.createContact(LASTNAME);
		// verify header msg expected result
		ContactsInfoPage oip = new ContactsInfoPage(driver);

		String actLastname = oip.getHeaderlstnameMsg().getText();
		System.out.println(actLastname);

		
		assertObj.hardAssert(actLastname, LASTNAME);
		
	//boolean status=actLastname.contains(LASTNAME);
	//	Assert.assertTrue(status);
		
		/*
		 * if (actLastname.equals(LASTNAME)) { System.out.println(LASTNAME +
		 * " (LASTNAME) is verified==Pass"); } else { System.out.println(LASTNAME +
		 * " (LASTNAME) is not verified==Fail");
		 * 
		 * }
		 */

	}
	
	@Test(groups ="regressiontest")
	public void createContactWithOrgTest() throws IOException, Throwable
	{

		// read testscript data form ecxelfie
		String ORGNAME = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String LASTNAME = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3: click on "create organiztion " button

		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4: enter all the details & create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);

		cnop.createOrg(ORGNAME);

		// Verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String actOrgName = oip.getHeaderMsg().getText();
		System.out.println(actOrgName);
		
		assertObj.softAssert(actOrgName, ORGNAME);
//		boolean status=actOrgName.contains(ORGNAME);
//		Assert.assertTrue(status);
		/*
		 * if (actOrgName.contains(ORGNAME)) { System.out.println(ORGNAME +
		 * " (ORGNAME) header  is verified==Pass"); } else { System.out.println(ORGNAME
		 * + " (ORGNAME) header is not verified==Fail"); }
		 */

		// Navigate to contact Module

		hp.getContactLink().click();

		// step 3: click on "create organiztion " button

		ContactsPage cnpage = new ContactsPage(driver);
		cnpage.getCreateNewContactBtn().click();

		// step 4: enter all the details & create new organization
		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);

		cncp.createContactOrg(LASTNAME);

		cncp.getOrgNamePlus().click();
		// driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// switch to child window
		wLib.switchToTabOnURL(driver, "module=Accounts");

		System.out.println("In child" + driver.getCurrentUrl());
		OrgPopUpPage opup = new OrgPopUpPage(driver);
		opup.orgsearchpopup(ORGNAME);
		opup.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();

		// switch to parent window

		wLib.switchToTabOnURL(driver, "Contacts&action");

		// driver.findElement(By.xpath("(//input[@value=' Save '])[2]")).click();
		cncp.getSaveBtn().click();
		// Verify Header msg Expected Result

		ContactsInfoPage cinfop = new ContactsInfoPage(driver);
		String actlastnameInfo = cinfop.getHeaderlstnameMsg().getText();

		System.out.println(actlastnameInfo);
		
		boolean status2=actlastnameInfo.contains(LASTNAME);
		Assert.assertTrue(status2);
		/*
		 * if (actlastnameInfo.contains(LASTNAME)) { System.out.println(LASTNAME +
		 * " (actlastnameInfo)  last name is verified==Pass"); } else {
		 * System.out.println(LASTNAME +
		 * " (actlastnameInfo) lst is not verified==Fail"); }
		 */

		// Verify Header orgName info Expected Result
		String actOrgContactName = cinfop.getOrgnamecontactMsg().getText();

		System.out.println(actOrgContactName);
		
		assertObj.softAssert(actOrgContactName, ORGNAME);
		/*
		 * if (actOrgContactName.trim().equals(ORGNAME)) { System.out.println(ORGNAME +
		 * " (orgname) is verified==Pass"); } else { System.out.println(ORGNAME +
		 * " (orgname) is not verified==Fail"); }
		 */

	}

@Test (groups ="regressiontest")
public void createcontactwithsupportDateTest() throws IOException, Throwable
{

	String LASTNAME = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();


	// step 2 : navigate to organizatin module

	HomePage hp = new HomePage(driver);
	hp.getContactLink().click();

	// step 3: click on "create organiztion " button

	ContactsPage cnp = new ContactsPage(driver);
	cnp.getCreateNewContactBtn().click();

	// System.out.println(dateobj.toString());

	// Get the Date in specific format

	String startDate = jLib.getSystemDateYYYYDDMM();
	System.out.println("Actual Date: " + startDate);

	// For next 30 days

	String endDate = jLib.getRequiredDateYYYYDDMM(30);
	System.out.println("After 30 days:" + endDate);

	// step 4: enter all the details & create new organization
	CreatingNewContactsPage cnop = new CreatingNewContactsPage(driver);

	cnop.createContact(LASTNAME, startDate, endDate);
	// VERIFY LASTNAME INFORMATION

	ContactsInfoPage cip=new ContactsInfoPage(driver);
	
	String actStartDate = cip.getHeaderstartdateMsg().getText();
	System.out.println(actStartDate);
	
	boolean status2=actStartDate.contains(startDate);
	Assert.assertTrue(status2);
	
	/*
	 * if (actStartDate.equals(startDate)) { System.out.println(startDate +
	 * " (startDate) is verified==Pass"); } else { System.out.println(startDate +
	 * " (startDate) is not verified==Fail");
	 * 
	 * }
	 */

	String actEndDate = cip.getHeaderenddateMsg().getText();
	System.out.println(actEndDate);
	
	boolean status3=actEndDate.contains(endDate);
	Assert.assertTrue(status3);
	
	/*
	 * if (actEndDate.equals(endDate)) { System.out.println(endDate +
	 * " (endDate) is verified==Pass"); } else { System.out.println(endDate +
	 * " (endDate) is not verified==Fail");
	 * 
	 * }
	 */

	
}
	

}
