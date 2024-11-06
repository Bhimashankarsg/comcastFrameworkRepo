package practice_TroubleTicket;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass_practice;
import com.comcast.crm.objectrepositoryutility.CreatingNewTroubleTicketsPage;
import com.comcast.crm.objectrepositoryutility.EditNewTroubleTicketsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.TTicketInfoPage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketsPage;
import com.comcast.crm.objectrepositoryutility.contactPopUpsEditroubleTicketsPage;

public class practice_createTroubleTicketTest_TC2_ContactEdit_TC3 extends BaseClass_practice {

	@Test(groups = "smoketest")
	public void practice_createTroubleTickTest() throws IOException, Throwable {

		String TITLE = eLib.getDataFromExcel("product_assignment", 4, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);

		hp.getTTickleLink().click();

		// step 2 : navigate to module
		TroubleTicketsPage ttpage = new TroubleTicketsPage(driver);

		ttpage.getCreateNewTTicketBtn().click();

		// step 4: Enter all the details & create new
		CreatingNewTroubleTicketsPage cnttpage = new CreatingNewTroubleTicketsPage(driver);

		cnttpage.createTTicket(TITLE);

		// Verify Header msg Expected Result
		TTicketInfoPage ttinfo = new TTicketInfoPage(driver);
		String titleinfo = ttinfo.getTTicketHeaderMsg().getText();
		System.out.println(titleinfo);
		System.out.println(TITLE);

		assertObj.hardAssert(titleinfo, TITLE);
		/*
		 * boolean status2 = titleinfo.contains(TITLE); Assert.assertTrue(status2);
		 */
		/*
		 * if (titleinfo.contains(TITLE)) { System.out.println(TITLE +
		 * " (msg)  is verified==Pass"); } else { System.out.println(TITLE +
		 * " (msg) is not verified==Fail"); }
		 */
		// wLib.takescreenshotdriverFULLPAGE(driver, "./photos/TroubleTicket_");

	}

	@Test(groups = "regressiontest")
	public void practice_createTroubleTick_Edit_Test() throws IOException, Throwable {

		String TITLE = eLib.getDataFromExcel("product_assignment", 4, 2) + jLib.getRandomNumber();

		String searchcontact = eLib.getDataFromExcel("product_assignment", 7, 2);

		HomePage hp = new HomePage(driver);

		hp.getTTickleLink().click();
		// step 2 : navigate to module
		TroubleTicketsPage ttpage = new TroubleTicketsPage(driver);

		ttpage.getCreateNewTTicketBtn().click();

		// step 4: Enter all the details & create new
		CreatingNewTroubleTicketsPage cnttpage = new CreatingNewTroubleTicketsPage(driver);

		cnttpage.createTTicket(TITLE);

		// String titleinfo = driver.findElement(By.id("mouseArea_Title")).getText();
		TTicketInfoPage ttinfo = new TTicketInfoPage(driver);
		String titleinfo = ttinfo.getTTicketHeaderMsg().getText();

		System.out.println(titleinfo);
		System.out.println(TITLE);

		assertObj.softAssert(titleinfo, TITLE);
		/*
		 * boolean status2 = titleinfo.contains(TITLE); Assert.assertTrue(status2);
		 */
		// Verify Header msg Expected Result
		/*
		 * if (titleinfo.contains(TITLE)) { System.out.println(TITLE +
		 * " (msg)  is verified==Pass"); } else { System.out.println(TITLE +
		 * " (msg) is not verified==Fail"); }
		 */

		ttinfo.getEditBtn().click();

		// driver.findElement(By.xpath("//input[@id='parentid']/following-sibling::img")).click();

		EditNewTroubleTicketsPage editttpage = new EditNewTroubleTicketsPage(driver);

		editttpage.getTicketNameEditdetails().click();
		
		wLib.switchToTabOnTitle(driver, TITLE);
//		switchToTabOnTitle

		contactPopUpsEditroubleTicketsPage cppettp = new contactPopUpsEditroubleTicketsPage(driver);

		cppettp.seacrForcontact(searchcontact);
		cppettp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()=' " + searchcontact + "']")).click();

		// driver.switchTo().window(p_id);
		wLib.switchToTabOnTitle(driver, TITLE);
		System.out.println(driver.getTitle());
		cnttpage.getSaveBtn().click();

		// wLib.takescreenshotdriverFULLPAGE(driver, "./photos/TroubleTicket_");

	}

}
