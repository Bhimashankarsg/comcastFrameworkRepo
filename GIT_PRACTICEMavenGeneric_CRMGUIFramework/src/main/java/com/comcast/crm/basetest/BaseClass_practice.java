package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.assertUtility.assertUtility;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass_practice {

	// Create object
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	public DataBaseUtility dbLib = new DataBaseUtility();

	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public assertUtility assertObj = new assertUtility();

	@BeforeSuite(groups = { "smoketest", "regressiontest" })
	public void configBS() throws SQLException {
		Reporter.log("=== connect to DB , report config  BS ===", true);
		dbLib.getDbconnection();

	}

	// For Cross Browser Testing

	/*
	 * @Parameters("BROWSER")
	 * 
	 * @BeforeClass(groups = { "smoketest", "regressiontest" }) public void
	 * configBC(String browser) throws Throwable {
	 * Reporter.log("=====Launch Browser BC=======");
	 * 
	 * String BROWSER = browser; // fLib.getDataFromPropertiesFile("browser");
	 * driver driver=wLib.launchbrowser(BROWSER); sdriver = driver; }
	 */

	@BeforeClass(groups = { "smoketest", "regressiontest" })
	public void configBC() throws Throwable {
		Reporter.log("=====Launch Browser BC=======");

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		driver = wLib.launchbrowser(BROWSER);
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "smoketest", "regressiontest" })
	public void configBM() throws IOException {
		Reporter.log("=== Login to application BM=====");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smoketest", "regressiontest" })
	public void configAM() {
		Reporter.log("==== Logout AM =====");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smoketest", "regressiontest" })
	public void configAC() {
		Reporter.log("==== close the Browser AC======");
		wLib.quitwindow(driver);
	}

	@AfterSuite(groups = { "smoketest", "regressiontest" })
	public void configAS() throws SQLException {
		Reporter.log("=== close DB, Report Backup AS ====");
		dbLib.closeDbConnection();

	}

}
