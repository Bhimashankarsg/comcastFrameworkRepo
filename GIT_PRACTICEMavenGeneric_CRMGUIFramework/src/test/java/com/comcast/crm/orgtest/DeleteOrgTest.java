package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws IOException, Throwable {
		// Create object
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		// generate the random number

		// read testscript data form ecxelfie

		String ORGNAME = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		// POLYMORPHISM- select the browser - cross browser

		WebDriver driver = wLib.launchbrowser(BROWSER);
//wLib.screenrecord();

		// step 1: login to app
		driver.get(URL);

		wLib.waitForPageToLoad(driver);
		wLib.maximizewindow(driver);

		LoginPage lp = new LoginPage(driver);

		lp.loginToApp("admin", "admin");
		// step 2 : navigate to organizatin module

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3: click on "create organization" button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4: enter all the details & create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);

		cnop.createOrg(ORGNAME);
		// verify header msg expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String actOrgName = oip.getHeaderMsg().getText();

		if (actOrgName.contains(ORGNAME)) {
			System.out.println(ORGNAME + " name is verified == Pass");

		} else {
			System.out.println(ORGNAME + " name is verified == Pass");
		}

		// go back to organizations page

		hp.getOrgLink().click();

		// search for organization
		cnp.getSearchEdit().sendKeys(ORGNAME);

		// in dynamic webtable select & delet org
		wLib.select(cnp.getSearchDD(), "Organization Name");
		cnp.getSearchBtn().click();

		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']/../../td[8]/a[text()='del']")).click();

		wLib.switchToAlertAndAccept(driver);

		// step 5: Logout
		hp.logout();

		// wLib.quitwindow(driver);

	}

}
