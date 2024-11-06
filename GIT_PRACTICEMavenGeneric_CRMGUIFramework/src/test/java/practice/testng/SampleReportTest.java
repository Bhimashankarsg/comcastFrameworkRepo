package practice.testng;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		// Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results(Document Title)");
		spark.config().setReportName("CRM Report( Report Name)");
String theme="DARK";
		spark.config().setTheme(Theme.valueOf(theme));
		
		// add Envrionment info and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
		
	}
	
	@AfterSuite
	public void configAS()
	{
		report.flush(); // For taking Backup - To save
	}
	@Test
	public void createContactTest() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.flipkart.com");
		TakesScreenshot ts=(TakesScreenshot) driver;
		String filePAth=ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test=report.createTest("createContTest"); 

		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if ("HDFCd".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filePAth, "ErrorFile");
		}
		
		driver.close();

	}
	
	@Test
	public void createContactWithOrg()
	{
		
		
				ExtentTest test=report.createTest("createContactWithOrg"); 

				test.log(Status.INFO,"login to app");
				test.log(Status.INFO,"navigate to contact page");
				test.log(Status.INFO,"create contact");
				if ("HDFC".equals("HDFC")) {
					test.log(Status.PASS,"createContactWithOrg is created");
				} else {
					test.log(Status.FAIL,"createContactWithOrg is not created");
				}
				
				
	}
	
	@Test
	public void createContactWithPhoneNumber()
	{
		
		
				ExtentTest test=report.createTest("createContactWithPhoneNumber"); 

				test.log(Status.INFO,"login to app");
				test.log(Status.INFO,"navigate to contact page");
				test.log(Status.INFO,"create contact");
				if ("HDFC".equals("HDFC")) {
					test.log(Status.PASS,"createContactWithPhoneNumber is created");
				} else {
					test.log(Status.FAIL,"createContactWithPhoneNumber is not created");
				}
				
				
	}
}
