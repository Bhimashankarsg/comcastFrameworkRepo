package practice_CalendarEvent;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass_practice;
import com.comcast.crm.objectrepositoryutility.CalenderPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.calenderPopUpsPage;

public class practice_CreateCalendarEventTest_TC6 extends BaseClass_practice {

	@Test(groups ="smoketest")
	public void practice_CreateCalendarEvent_Test() throws IOException, Throwable {

		// step 2 : navigate to module
		HomePage hp = new HomePage(driver);

		hp.getCalLink().click();

		WebElement addele = driver.findElement(By.className("calAddButton"));

		wLib.mouseMoveOnElement(driver, addele);

		CalenderPage calp = new CalenderPage(driver);
		calp.getMeetingBtn().click();

		String MEETINGNAME = eLib.getDataFromExcel("cal_meeting", 1, 2) + jLib.getRandomNumber();

		Reporter.log(MEETINGNAME);

		calenderPopUpsPage calpopup = new calenderPopUpsPage(driver);
		calpopup.sendeventname(MEETINGNAME);

		String hour = eLib.getDataFromExcel("cal_meeting", 1, 3); // Get hour with leading zero
		String minute = eLib.getDataFromExcel("cal_meeting", 1, 4); // Get minute with leading zero
		String sttimestamp = eLib.getDataFromExcel("cal_meeting", 1, 5);
		Reporter.log(hour);
		Reporter.log(minute);
		Reporter.log(sttimestamp);

		calpopup.selectstarthour(hour);
		calpopup.selectstartmin(minute);
		calpopup.selectstarttimestmp(sttimestamp);

		String endhour = eLib.getDataFromExcel("cal_meeting", 1, 6); // Get hour with leading zero
		String endmin = eLib.getDataFromExcel("cal_meeting", 1, 7); // Get minute with leading zero

		String endtimestamp = eLib.getDataFromExcel("cal_meeting", 1, 8);

		Reporter.log(endhour);
		Reporter.log(endmin);
		Reporter.log(endtimestamp);
		// Event ends on

		calpopup.selectendhour(endhour);
		calpopup.selectendmin(endmin);
		calpopup.selectendtimestmp(endtimestamp);

		calpopup.getCalEventSave().click();

	}

}
