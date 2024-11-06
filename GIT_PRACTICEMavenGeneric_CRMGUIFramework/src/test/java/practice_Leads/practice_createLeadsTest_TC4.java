package practice_Leads;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass_practice;
import com.comcast.crm.objectrepositoryutility.CreatingNewLeadsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadsInfoPage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;

public class practice_createLeadsTest_TC4 extends BaseClass_practice {

	@Test(groups ="smoketest")
	public void practice_createLeads_Test() throws IOException, Throwable {

		// generate the random number
		String LASTNAME = eLib.getDataFromExcel("leads_assignment", 1, 2) + jLib.getRandomNumber();
		String COMPANY = eLib.getDataFromExcel("leads_assignment", 1, 3) + jLib.getRandomNumber();


		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		// step 2 : navigate to module
		LeadsPage lp1 = new LeadsPage(driver);
		lp1.getCreateNewLeadsBtn().click();

		// step 4: Enter all the details & create new

		CreatingNewLeadsPage cnlp = new CreatingNewLeadsPage(driver);
		cnlp.createLeads(LASTNAME, COMPANY);

		// Verify Header msg Expected Result

		LeadsInfoPage lipage = new LeadsInfoPage(driver);
		String headerInfo = lipage.getlastnameMsg().getText();

		System.out.println(headerInfo);
		System.out.println(LASTNAME);
		/*
		 * boolean status3=headerInfo.trim().contains(LASTNAME);
		 * Assert.assertTrue(status3);
		 */
		
		assertObj.hardAssert(headerInfo, LASTNAME);
		/*
		 * if (headerInfo.contains(LASTNAME)) { System.out.println(LASTNAME +
		 * " (msg) LASTNAME is verified==Pass"); } else { System.out.println(LASTNAME +
		 * " (msg)LASTNAME is not verified==Fail"); }
		 */

		// Verify company Expected Result

		String companyInfo = lipage.getcompanyMsg().getText();

		System.out.println(companyInfo);
		System.out.println(COMPANY);
		boolean status4=companyInfo.trim().contains(COMPANY);
		Assert.assertTrue(status4);
		/*
		 * if (companyInfo.contains(COMPANY)) { System.out.println(COMPANY +
		 * " (msg) COMPANY is verified==Pass"); } else { System.out.println(COMPANY +
		 * " (msg)COMPANY is not verified==Fail"); }
		 */

		

	}

}
