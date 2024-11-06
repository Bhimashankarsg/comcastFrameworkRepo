package practice_Opportunities;

import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass_practice;
import com.comcast.crm.objectrepositoryutility.CreatingNewOppPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OppInfoPage;
import com.comcast.crm.objectrepositoryutility.OppPage;
import com.comcast.crm.objectrepositoryutility.orgPopUpsEditPage;

public class practice_CreateOpportunitiesWithOrgTest_TC5 extends BaseClass_practice {

	@Test(groups ="smoketest")
	public void practice_createOpp_Org_Test() throws IOException, Throwable {

		String ORGNAME = eLib.getDataFromExcel("leads_assignment", 4, 3);
		String OPPNAME = eLib.getDataFromExcel("leads_assignment", 4, 2) + jLib.getRandomNumber();

		// step 2 : navigate to module

		HomePage hp = new HomePage(driver);
		hp.getOppLink().click();

		// step 3: click on "create " button

		OppPage op = new OppPage(driver);
		op.getCreateNewOppPlusBtn().click();

		CreatingNewOppPage cnop = new CreatingNewOppPage(driver);
		cnop.createOpp(OPPNAME);

		// step 4: Enter all the details & create new

		
		cnop.getOrgPlusImg().click();
		// switch to child window

		wLib.switchToTabOnURL(driver, "module=Accounts");
		System.out.println("In child" + driver.getCurrentUrl());

		orgPopUpsEditPage opep = new orgPopUpsEditPage(driver);
		opep.seacrForOrg(ORGNAME);

		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();

		// switch to parent window

		wLib.switchToTabOnURL(driver, "module=Potentials");

		// driver.findElement(By.name("button")).click();
		cnop.getSaveBtn().click();
		OppInfoPage oip = new OppInfoPage(driver);

		String headerInfo = oip.getOppHeaderMsg().getText();
		// Verify Header msg Expected Result
		System.out.println(headerInfo);
		
		
		assertObj.hardAssert(headerInfo, OPPNAME);
		/*
		 * boolean status2=headerInfo.contains(OPPNAME); Assert.assertTrue(status2);
		 */
		/*
		 * if (headerInfo.contains(OPPNAME)) { System.out.println(OPPNAME +
		 * " (msg)  last name is verified==Pass"); } else { System.out.println(OPPNAME +
		 * " (msg) lst is not verified==Fail"); }
		 */

		// Verify Header info Expected Result

		String actOrgName = oip.getOrgHeaderMsg().getText();

		System.out.println(actOrgName);
		
		boolean status3=actOrgName.trim().contains(ORGNAME);
		Assert.assertTrue(status3);
		
		/*
		 * if (actOrgName.trim().equals(ORGNAME)) { System.out.println(ORGNAME +
		 * " (orgname) is verified==Pass"); } else { System.out.println(ORGNAME +
		 * " (orgname) is not verified==Fail"); }
		 */

	}

}
