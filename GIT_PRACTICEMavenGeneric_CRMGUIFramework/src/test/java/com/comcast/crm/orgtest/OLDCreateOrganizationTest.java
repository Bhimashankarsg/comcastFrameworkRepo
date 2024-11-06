package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OLDCreateOrganizationTest {

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

		// step 1: login to app
		driver.get(URL);

		wLib.screenrecord();
		wLib.waitForPageToLoad(driver);

		driver.manage().window().maximize();
		// driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		By inputFieldLocator = By.xpath("//input[@name='user_name']");

		wLib.enterText(driver, inputFieldLocator, USERNAME);

		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);

		// step 2 : navigate to orgaization module
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		Thread.sleep(2000);

		// step 3: click on "create organiztion " button

		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		Thread.sleep(2000);

		// step 4: Enter all the details & create new organization
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);

		driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();

		// Verify Header msg Expected Result
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();

		System.out.println(headerInfo);
		if (headerInfo.contains(ORGNAME)) {
			System.out.println(ORGNAME + " (msg)  is verified==Pass");
		} else {
			System.out.println(ORGNAME + " (msg) is not verified==Fail");
		}
		// Verify Header orgName info Expected Result
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		System.out.println(headerInfo);
		if (actOrgName.equals(ORGNAME)) {
			System.out.println(ORGNAME + " (orgname) is verified==Pass");
		} else {
			System.out.println(ORGNAME + " (orgname) is not verified==Fail");
		}

		wLib.quitwindow(driver);

	}

}
